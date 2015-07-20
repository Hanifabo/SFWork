package supportPackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.saucelabs.saucerest.SauceREST;

public class DriverManager implements Config{
	
	protected WebDriver driver;
	private String testName;
	private String sessionId;
	private SauceREST sauceClient;

	@Rule
	public ExternalResource resource = new ExternalResource()
	{
		@Override
		protected void before() throws Throwable
		{
			if(host.equalsIgnoreCase("saucelabs")) 
			{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setBrowserName(browser);
			caps.setCapability("version", browser_Version);
			caps.setCapability("platform", platform);
			caps.setCapability("name", testName);
			String sauceUrl = String.format("http://"+sauceuser+":"+sauceKey+"@ondemand.saucelabs.com:80/wd/hub");
			//String sauceUrl = String.format("http://hanifabo:e6ad8357-452f-4088-8bbe-7eba55ae0e3e@ondemand.saucelabs.com:80/wd/hub");		
			  driver = new RemoteWebDriver(new URL(sauceUrl), caps);
              sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
              sauceClient = new SauceREST(sauceuser, sauceKey);
			}
			else if(host.equalsIgnoreCase("localhost"))
			{
				
					driver = new FirefoxDriver();
					
			}
			
		};
		
		@Override
		protected void after()
		{
			driver.quit();
		};
		
	};
	
	@Rule
	public TestRule watch = new TestWatcher()
	{
		protected void starting(Description description)
		{
			testName = description.getDisplayName();
		}
		
		@Override
		public void succeeded(Description description)
		{
			sauceClient.jobPassed(sessionId);
		}
		
		@Override
		public void failed(Throwable throwabl, Description description)
		{
			if(host.equalsIgnoreCase("saucelabs"))
			{
				sauceClient.jobFailed(sessionId);
				System.out.println("https://saucelabs.com/tests");
			}
		}
	};
	
	
}
