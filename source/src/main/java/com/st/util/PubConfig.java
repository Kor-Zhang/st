package com.st.util;

import java.util.Properties;

public class PubConfig {
	private static String fileName = "config.properties";

	public static Properties getPro() {
		return PubTools.loadProperties(fileName);
	}

	public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		PubConfig.fileName = fileName;
	}
	
	
}
