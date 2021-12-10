package pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Properties;

public class EnvironmentUtils {
	
	public static Properties getConfig() {
		String configPath = System.getProperty("user.dir") + "/Drivers/config.properties";
		Properties config = null;
		try {
			config = new Properties();
			FileInputStream fi = new FileInputStream(configPath);
			config.load(fi);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return config;
	}
	
	public static void setProperty(String key,String value) {
	    String configPath = System.getProperty("user.dir") + "/drivers/config.properties";
	     try {
	            
	               FileInputStream fstream = new FileInputStream(configPath);
	               BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	               String strLine;
	               StringBuilder fileContent = new StringBuilder();
	               while ((strLine = br.readLine()) != null) {
	                   String tokens[] = strLine.split(" ");
	                   if (tokens.length > 0) {
	                       if (tokens[0].contains(key)
	) {
	                           String newLine = key+"="+value;
	                           fileContent.append(newLine);
	                           fileContent.append("\r\n");
	                        
	                       } else {
	                           fileContent.append(strLine);
	                           fileContent.append("\r\n");
	                       }
	                   }
	                   
	               }
	               // Now fileContent will have updated content , which you can override into file
	               FileWriter fstreamWrite = new FileWriter(configPath);
	               BufferedWriter out = new BufferedWriter(fstreamWrite);
	               out.write(fileContent.toString());
	               out.close();
	               fstream.close();
	           } catch (Exception e) {
	               System.err.println("Error: " + e.getMessage());
	           }
 }
}


