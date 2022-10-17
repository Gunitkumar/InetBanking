package Com.InetBanking.TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;

import Com.InetBanking.Utilities.ReadConfig;
import Com.InetBanking.Utilities.Reporting;

public class BaseClass<ExtentManager> extends Reporting{
	
	
	ReadConfig rc = new ReadConfig();
	public String baseURL= rc.getApplicationURL();
	//public String baseURL= "https://www.demo.guru99.com/v3/index.php";//without using properties file
	public String username= rc.getUserName();
	//public String username= "mngr441774";//without using properties file
	public String Password= rc.getPassword();
	//public String Password= "AvyjApu";//without using properties file
	public static WebDriver driver;
	
	
	public static Logger Logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		Logger = Logger.getLogger("TC_AddNewCust_002");
		 PropertyConfigurator.configure("log4j.properties");
		 
		 
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",rc.getchromepath());
		 driver = new ChromeDriver();
		 
		}
		 else if(br.equals("edge"))
		 {
			 System.setProperty("webdriver.edge.driver",rc.getedgepath());
			 driver = new EdgeDriver();
		 }
		 else if (br.equals("Firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver",rc.getfirefoxpath());
			 driver = new FirefoxDriver(); 
		 }
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(baseURL);
		 
		
		
	}
	
	
	@AfterClass
	
	public void teardown() throws InterruptedException
	{
		
		driver.quit();
	}
	
}
