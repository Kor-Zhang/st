package com.st.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.st.PubStatic;

public class PubMail {
	private  MimeMessage mime = null;
	private  Session session = null;
	private  Properties props = null;
	// 主机
	private  String mailHost = null;

	private  String mailSmtpAuth = null;
	// 发件人账户
	private  String username = null;
	// 发件人密码
	private  String password = null;
	// 发件人
	private  String from = null;
	// 收件人
	private  String to = null;
	// 设置抄送
	private  String cc = null;
	// 设置暗送
	private  String bcc = null;
	private  String fileName = "mail.properties";
	

	public PubMail() {
		try {
			props = PubTools.loadProperties(fileName);
			mailHost = props.getProperty("mail.host");
			mailSmtpAuth = props.getProperty("mail.smtp.auth");
			username = props.getProperty("username");
			password = props.getProperty("password");
			from = props.getProperty("from");
			to = props.getProperty("to");
			cc = props.getProperty("cc");
			bcc = props.getProperty("bcc");

			props.setProperty("mail.host", mailHost);
			props.setProperty("mail.smtp.auth", mailSmtpAuth);
			Authenticator auth = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication(username, password);
				}
			};
			session = Session.getInstance(props, auth);
			PubStatic.L.info("链接邮箱" + username + "成功！");
			mime = new MimeMessage(session);
			mime.setFrom(new InternetAddress(from));
			if (to != null && !to.toString().trim().isEmpty()) {
				mime.setRecipients(RecipientType.TO, to);// 设置收件人
			}
			if (cc != null && !cc.toString().trim().isEmpty()) {
				mime.setRecipients(RecipientType.CC, cc);// 设置抄送
			}
			if (bcc != null && !bcc.toString().trim().isEmpty()) {
				mime.setRecipients(RecipientType.BCC, bcc);// 设置暗送
			}

		} catch (Exception e) {
			PubStatic.L.error("Mail#loadProperties方法错误");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取mail配置文件的属性
	 * @param key
	 * @return
	 */
	public  Object getConfig(String key){
		return props.get(key);
	}
	public  void setContent(String content) {
		if (content != null && !content.toString().trim().isEmpty()) {
			try {
				mime.setContent(content, "text/html;charset=utf-8");
			} catch (MessagingException e) {
				e.printStackTrace();
			} // 设置内容
		}

	}

	public  void setSubject(String subject) {
		if (subject != null && !subject.toString().trim().isEmpty()) {
			try {
				mime.setSubject(subject);
			} catch (MessagingException e) {
				e.printStackTrace();
			} // 设置标题
		}
	}

	public  void setTo(String to) {
		if (to != null && !to.toString().trim().isEmpty()) {
			try {
				this.to = to;
				mime.setRecipients(RecipientType.TO, to);// 设置收件人
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

	

	/**
	 * 开启线程发送，并且设置内容和标题
	 * 
	 * @param Subject
	 * @param Content
	 * @throws MessagingException
	 */
	public  void sendMessage(String subject, String content) throws MessagingException {

		setContent(content);
		setSubject(subject);

		PubStatic.L.info(this.to);
		PubStatic.L.info(subject);
		PubStatic.L.info(content);
		Transport.send(mime);
		PubStatic.L.info("发给"+this.to+"的信息成功！");
		
	}

	/**
	 * 开启线程发送，并且制定收件人，内容和标题
	 * 
	 * @param Subject
	 * @param Content
	 * @throws MessagingException 
	 */
	public  void sendMessage(String to, String subject, String content) throws MessagingException {
		setTo(to);
		sendMessage(subject, content);

	}

	public Properties getProps() {
		return props;
	}

	public  void setProps(Properties props) {
		this.props = props;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName =  fileName;
		this.props = PubTools.loadProperties(fileName);
	}
	
	public static void main(String[] args) {
		try {
			new PubMail().sendMessage("1138829222@qq.com","幸福假日官网", "您好!");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
