package com.midtrans.Initialize;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.midtrans.loggers.MidTransLogger;
import com.midtrans.pageobjects.HomeScreen;
import com.midtrans.utils.Readprop;


public class Setup {

	public MidTransLogger log ;
	public  WebDriver driver;
	static String targetBrowser;
	static String url;
	protected static Readprop readprop;
	protected HomeScreen home;

	@BeforeSuite
	public void launchBrowser() throws IOException {
		readprop = new Readprop();		
		targetBrowser=readprop.fetchproperty("browser");
		url = readprop.fetchproperty("url");

		MidTransLogger.info("Browser is "+targetBrowser);
		if(targetBrowser.contains("chrome")){
			MidTransLogger.info(" Chrome driver");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chrome\\win32\\chromedriver.exe");

			driver = new ChromeDriver();
			MidTransLogger.info("Path to  chrome file: "+System.getProperty("user.dir"));
		}
		else if (targetBrowser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\FireFox\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
			
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			driver.get(url);
			MidTransLogger.info("Target URL "+url);


			
			MidTransLogger.info("Validate URL");
			String actualUrl = driver.getCurrentUrl();
			MidTransLogger.info("Current URl is " + actualUrl);
			Assert.assertTrue(actualUrl.contains(url));
				
		}
	
	@AfterSuite
	public void postExecution(){
		MidTransLogger.info("shutting down browser");
		driver.quit();

	}

}