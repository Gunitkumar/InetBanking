package Com.InetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
					prop = new Properties();
					prop.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		
		}
	}
	
	public String getApplicationURL()
	{
		String url= prop.getProperty("baseURL");
		return url;
	}
	
	public String getUserName()
	{
		String Username= prop.getProperty("username");
		return Username;
	}
	
	public String getPassword()
	{
		String Password = prop.getProperty("Password");
		return Password;
	}
	
	public String getchromepath()
	{
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getedgepath()
	{
		String edgepath = prop.getProperty("edgepath");
		return edgepath;
	}
	public String getfirefoxpath()
	{
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}

}
