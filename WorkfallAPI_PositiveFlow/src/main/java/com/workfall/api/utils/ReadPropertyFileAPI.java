package com.workfall.api.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ReadPropertyFileAPI {
	public static String ReadFile(String key){
	Properties prop = new Properties();
	InputStream input = null;
	String Value ="";
	try {
		input = new FileInputStream("applicationData_API.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		
		Value = prop.getProperty(key);
		
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	return Value;
}
}

