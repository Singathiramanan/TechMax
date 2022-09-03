package org.sdet38.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		//steps 1:use File Input stream to load the property file
		FileInputStream fis=new FileInputStream(".\\Data\\commonDataProperties");
		
		//steps 2: create object of properties and load the file
		Properties prop = new Properties();
		prop.load(fis);
		
		//steps 3: provide the key to read the value
		String URL = prop.getProperty("URL");
		System.out.println(URL);
		
		String username = prop.getProperty("username");
		System.out.println(username);
		
		String pwd =prop.getProperty("password");
		System.out.println(pwd);
		
		String browser=prop.getProperty("Browser");
		System.out.println(browser);
		
		
		

	}

}
