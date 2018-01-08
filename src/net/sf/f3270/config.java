package net.sf.f3270;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class config {
	public static String toolBaseLocation = new config().getProperty("toolBaseLocation");
	public static String CodeBaseLocation = new config().getProperty("CodeBaseLocation");
	InputStream inputStream;
	
	public void setProperty(Map<String,String> data) {
		if(data == null || data.size() <= 0){
			return;
		}
		//save
		try {
			Properties prop = new Properties();
			//String propFileName = "resource/config.properties";
			String propFileName = Initializer.toolBaseLocation+"/config.properties";
			
		    inputStream = new FileInputStream(propFileName);
		    
			//inputStream = IDEU.class.getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			for (String key : Arrays.asList(data.keySet().toArray(new String[0]))) {
				prop.setProperty(key.toString(), data.get(key).toString());
			}
			String path=propFileName;//IDEU.class.getClassLoader().getResource(propFileName).toExternalForm();
			prop.store(new FileOutputStream(path.replaceFirst("file:/", "")),null);
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {inputStream.close();} catch (Exception e) {}
		}
	}
	
	public String getProperty(String key) {
		String result = "";
		try {
			Properties prop = new Properties();
			//String propFileName = "resource/config.properties";
			//inputStream = IDEU.class.getClassLoader().getResourceAsStream(propFileName);
			
			String propFileName = Initializer.toolBaseLocation+"/config.properties";
			
		    inputStream = new FileInputStream(propFileName);
		    
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			result = prop.getProperty(key);
		} catch (Exception e) {
			result = "";
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
			}
		}
		return result;
	}
}
