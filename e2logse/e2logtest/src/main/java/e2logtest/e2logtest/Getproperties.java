package e2logtest.e2logtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Getproperties {
	static String fetchdata;

	public static String fetchProp(String value) {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("./test.properties");

			// load a properties file
			prop.load(input);

			fetchdata = prop.getProperty(value);
			// get the property value and print it out
			/*
			 * System.out.println(prop.getProperty("database"));
			 * System.out.println(prop.getProperty("dbuser"));
			 * System.out.println(prop.getProperty("dbpassword"));
			 */

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
		return fetchdata;
	}
	public static void main(String[] args) {
System.out.println(Getproperties.fetchProp("chromepath"));
	}
}
