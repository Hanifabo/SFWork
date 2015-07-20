package homePackage;




import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import supportPackage.DriverManager;

public class HomePage_Test extends DriverManager
{
	//protected WebDriver driver;
	HomePage hp;
	
	@Before
	public void setUp()
	{
		
		//driver = new FirefoxDriver();
		 hp = new HomePage(driver);
		
	}

	@Test
	public void should_Resgister_user_successfully()
	{
		hp.successful_Registration();
	}
	
	@Test
	public void testing_successful_sign_in()
	{
		hp.successful_sign_in();
		//assertSame(hp.getPageTitle(), "Welcome Hanifa");
	}
	
	
	@Test
	public void testing_failed_sign_in()
	{
		hp.successful_sign_in();
		//Assert( "", hp.getPageTitle());
	}
	//@After
	public void cleanUp()
	{
		//driver.quit();
	}

}
