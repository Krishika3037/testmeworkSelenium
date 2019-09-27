package testmeapp.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Drivers {
	static WebDriver driver;
	public static WebDriver getDriver(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
	}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("invalid browser!!");
		}
		return driver;
	
	}}



