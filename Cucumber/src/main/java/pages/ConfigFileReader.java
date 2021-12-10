package pages;

public class ConfigFileReader {
	
	public String getReportConfigPath(){
		String reportConfigPath = EnvironmentUtils.getConfig().getProperty("reportConfigPath");
		if(reportConfigPath!= null) 
			return reportConfigPath;
		else 
			throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}

}
