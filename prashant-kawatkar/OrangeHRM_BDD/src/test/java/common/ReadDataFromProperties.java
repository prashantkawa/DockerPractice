package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadDataFromProperties {

	public static String propFilePath = "./src/test/java/config/data.properties";

	public static Properties readPropertiesFile() throws IOException {
		Properties prop = new Properties();
		InputStream input = new FileInputStream(propFilePath);
		prop.load(input);

		return prop;
	}

	public static String getUserName() throws IOException {
		String userName = readPropertiesFile().getProperty("userName");

		return userName;
	}
	
	public static String getPassword() throws IOException {
		String password = readPropertiesFile().getProperty("password");
		
		return password;
	}
}
