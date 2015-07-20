package homePackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import supportPackage.Config;

public class HomPage_Base implements Config{
	public WebDriver driver;
	
	public HomPage_Base(WebDriver driver)
	{
		this.driver = driver;
	}
	public void visit(String urlPath)
	{
		if(urlPath.contains("http"))
		{
			driver.get(urlPath);
		}
		else
		{
			driver.get(baseUrl+urlPath);
		}
	}
	
	public void typeInpute(By locator, String text)
	{
	driver.findElement(locator).sendKeys(text);
	}
	
	public void click_Button(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public boolean isDisplayed(By locator)
	{
		try
		{
			driver.findElement(locator).isDisplayed();
			return true;
		}catch(NoSuchElementException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public void select_from_dropDown(By locator, By locator1, String text)
	{
		WebElement select = driver.findElement(locator);
		List<WebElement> options = select.findElements(locator1);
		for(WebElement option: options)
		{
			if(option.getText().equalsIgnoreCase("male"))
			{
				option.click();
			}
		}
	}

	public void getPageTitle()
	{
		driver.getTitle();
	}
	
	public void wait_for(int seconds)
	{
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}
