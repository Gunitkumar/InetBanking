package Com.InetBanking.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import Com.InetBanking.PageObject.AddCustPage;
import Com.InetBanking.PageObject.LoginPage;

public class TC_AddNewCust_002 extends BaseClass 
{
	@Test
	public void AddNewCustomer() throws InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		driver.manage().window().maximize();
		lp.SetUserName(username);
		Logger.info("UserName is provided");
		lp.SetPassWord(Password);
		Logger.info("Password is provided");
		lp.ClickloginBtn();
		
		//Thread.sleep(1000);
		
		AddCustPage ac = new AddCustPage(driver);
		
		Logger.info("Provide the Customer Data");
		ac.ClickNewCustLink();
		ac.SetCustName("Gunit");
		ac.SetCustGender();
		ac.SetCustDOB("10","5","1985");
		//Thread.sleep(3000);
		ac.SetCustAddress("telhara");
		ac.SetCustCityName("Akola");
		ac.SetCustStateName("MH");
		ac.SetCustPINno("444103");
		ac.SetCustMobno("9960273630");
		String email = randomstring()+"@gmail.com ";
		 ac.SetCustEmail(email);
		ac.SetCustPassword("gyyyt");
		ac.ClickSubmit();
		
		Thread.sleep(3000);
		
		Logger.info("Validattion is Started");
	boolean result = 	driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		 if(result==true)
		 {
			 Assert.assertTrue(true);
			 Logger.info("Test Case is Passed");
		 }
		 else
		 {
			 Assert.assertTrue(false);
			 Logger.info("Test Case is Failed");
		 }
		 
	}
	
	public String randomstring()
	{
		String generaterdstring = RandomStringUtils.randomAlphabetic(8);
		return(generaterdstring);
	}
	
	
	
	
	
	
}
