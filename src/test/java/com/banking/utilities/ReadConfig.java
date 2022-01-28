package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties props;
	
	//CONSTRUCTOR
	public ReadConfig () {
		
		File src = new File("./Configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			props = new Properties();
			props.load(fis);
		} 
		catch (Exception e) {
			System.out.println("Exceeption is: "+e.getMessage());
		}
	}
	
	
	public String getSiteURL() {
		
		String url = props.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		
		String username = props.getProperty("username");
		return username;
	}

	public String getPassword() {
	
	String password = props.getProperty("password");
	return password;
	}
	
	public String getChromePath() {
		
		String chromePath = props.getProperty("chromePath");
		return chromePath;
	}
	
	public String getFirefoxPath() {
		
		String firefoxPath = props.getProperty("firefoxPath");
		return firefoxPath;
	}
	
	public String getEdgePath() {
		
		String edgePath = props.getProperty("edgePath");
		return edgePath;
	}

}
