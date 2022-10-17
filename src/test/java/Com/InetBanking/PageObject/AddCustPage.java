package Com.InetBanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustPage {
	 WebDriver ldriver;
	 
	 public AddCustPage(WebDriver rdriver)
	 {
		 ldriver= rdriver;
		 PageFactory.initElements(rdriver, this);
	 }
	 @FindBy(xpath= "/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
	 @CacheLookup
	WebElement ClickNewCustomer;
	 
	 @FindBy(name= "name")
	 @CacheLookup
	WebElement EnterName;
	 
	 @FindBy(name= "rad1")
	 @CacheLookup
	WebElement SelectGender;
	 
	 @FindBy(name= "dob")
	 @CacheLookup
	WebElement SelectDob;
	 
	 @FindBy(name= "addr")
	 @CacheLookup
	WebElement EnterAddress;
	 
	 @FindBy(name= "city")
	 @CacheLookup
	WebElement EnterCity;
	 
	 
	 @FindBy(name= "state")
	 @CacheLookup
	WebElement Enterstate;

	 @FindBy(xpath= "//input[@name='pinno']")
	 @CacheLookup
	WebElement EnterPin;
	 
	 
	 @FindBy(name= "telephoneno")
	 @CacheLookup
	WebElement EnterMobile;
	 
	 
	 @FindBy(name= "emailid")
	 @CacheLookup
	WebElement EnterEmailId;
	 
	 @FindBy(name= "password")
	 @CacheLookup
	WebElement EnterPassword;
	 
	 @FindBy(xpath= "//input[@name='sub']")
	 @CacheLookup
	WebElement ClickSubmitBtn;
	 
	 public void ClickNewCustLink()
		{
		 ClickNewCustomer.click();
		}
	 public void SetCustName(String Cname)
		{
		 EnterName.sendKeys(Cname);;
		}
	 public void SetCustGender()
		{
		 SelectGender.click();;
		}
	 
	 public void SetCustDOB(String mm,String dd,String yy)
		{
		 SelectDob.sendKeys(mm);
		 SelectDob.sendKeys(dd);
		 SelectDob.sendKeys(yy);
		}
	 
	 public void SetCustAddress(String CAddress)
		{
		 EnterAddress.sendKeys(CAddress);;
		}
	 
	 public void SetCustCityName(String CCity)
		{
		 EnterCity.sendKeys(CCity);;
		}
	 
	 public void SetCustStateName(String CState)
		{
		 Enterstate.sendKeys(CState);;
		}
	 public void SetCustPINno(String CPinno)
		{
		 EnterPin.sendKeys(String.valueOf(CPinno));
		}
	 
	 public void SetCustMobno(String CMobno)
		{
		 EnterMobile.sendKeys(CMobno);
		 
		}
	 
	 public void SetCustEmail(String CEmail)
		{
		 EnterEmailId.sendKeys(CEmail);
		 
		}
	 public void SetCustPassword(String CPass)
		{
		 EnterPassword.sendKeys(CPass);
		 
		}
	 public void ClickSubmit()
		{
		 ClickSubmitBtn.click();;
		 
		}
}
