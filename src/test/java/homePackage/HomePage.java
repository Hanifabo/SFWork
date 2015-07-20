package homePackage;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import supportPackage.Config;

public class HomePage extends HomPage_Base{
	By ResgistorLocator =By.xpath("//a[contains(.,'Register')]");
	By First_name =	By.id("customer.firstName");
	By Last_Name=	By.id("customer.lastName");
	By Address=	By.id("customer.address.street");	
	By City=	By.id("customer.address.city");	
	By State=	By.id("customer.address.state");		
	By Zip_Code=By.id("customer.address.zipCode");		
	By Phone=	By.id("customer.phoneNumber");		
	By SSN=	By.id("customer.ssn");	 
	By Username=	By.id("customer.username");		
	By Password=	By.id("customer.password");	
	By Confirm=	By.id("repeatedPassword");
	By Register = By.xpath("//input[contains(@value,'Register')]");;
	
	By userLocator = By.xpath("//input[@name='username']");
	By passwordLocator = By.xpath("//input[@name='password']");
	By submitLocator = By.xpath("//input[@class='button']");
	By messageLocator = By.id("");
	String passmessage = "";
	String failedLocator = "";
	By pageTitle = By.xpath("//p[@class='caption']");
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		visit("/parabank/index.htm");
		driver.manage().window().maximize();
		wait_for(5);
	}
	public void successful_Registration()
	{
		click_Button(ResgistorLocator);
		typeInpute(First_name,"Hanifa");
		typeInpute(Last_Name,"Booba");
		typeInpute(Address,"6525 Beadnell Way #apt 13");
		typeInpute(City, "San Diego");
		typeInpute(State, "California");
		typeInpute(Zip_Code, "CA 92117");
		typeInpute(Phone,"858-543-8734");
		typeInpute(SSN,"233 23 262565");
		typeInpute(Username, "hanifabo");
		typeInpute(Password," ananga");
		typeInpute(Confirm, "ananga");	
		click_Button(Register);
		wait_for(5);
		
	}
	
	public void successful_sign_in()
	{
		typeInpute(userLocator, "hanifa");
		wait_for(3);
		typeInpute(passwordLocator, "booba");
		wait_for(3);
		click_Button(submitLocator);
		
	}
	
	public void failed_sign_in()
	{
		typeInpute(userLocator, "hanifa");
		typeInpute(passwordLocator, "booba");
		click_Button(submitLocator);
	}
	

}
