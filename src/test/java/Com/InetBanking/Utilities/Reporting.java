package Com.InetBanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter

{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date());
		String repName= "Test-Report-"+timeStamp+"report.html";
		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+repName);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myreport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Enviroment","QA");
		extent.setSystemInfo("user", "Gunit");
		
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Project");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
			public void onTestSucess(ITestResult tr)
			{
				
				logger = extent.createTest(tr.getName());
				logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
				
			}
			
			public void onTestFailure(ITestResult tr)
			{
				logger= extent.createTest(tr.getName());
				logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
				
				String screenshotpath= System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
				File f = new File(screenshotpath);
				if(f.exists())
				{
					try {
						logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenshotpath));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		public void onTestSkipped(ITestResult tr)
		{
			logger= extent.createTest(tr.getName());
			logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
			
		}
		public void onfinish(ITestContext testContext)
		{
			extent.flush();
			
		}
				
	}
	
	
	
