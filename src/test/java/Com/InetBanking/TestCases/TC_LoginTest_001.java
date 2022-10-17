package Com.InetBanking.TestCases;



import org.testng.Assert;
import org.testng.annotations.Test;


import Com.InetBanking.PageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException
	
	{
		
		Logger.info("Page is Open");
		
		LoginPage lp = new LoginPage(driver);
		lp.SetUserName(username);
		lp.SetPassWord(Password);
		lp.ClickloginBtn();
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))

      {
			Assert.assertTrue(true);
			Logger.info(" Test is  Passed");
      }
		
		else
		{
			Assert.assertTrue(false);
			Logger.info("Failed");
		}
		


	}
}
	
	
	


