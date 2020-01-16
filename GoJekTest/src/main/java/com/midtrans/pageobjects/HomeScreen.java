package com.midtrans.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.midtrans.Initialize.Setup;
import com.midtrans.loggers.MidTransLogger;
import com.midtrans.utils.waitUtils;

public class HomeScreen {

		
	public waitUtils waitutils;
	 WebDriver driver;
	
	@FindBy(xpath="//div[@class='desc']/following-sibling::a[@class='btn buy']")
	private WebElement buyNowButton;

	@FindBy(xpath="//div[@class='cart-head']/child::span[1]")
	private WebElement pageTitle;
	
	public HomeScreen(WebDriver driver)
	{
		this.driver = driver;
		waitutils = new waitUtils();
		PageFactory.initElements(driver, this);
		}
	 
	public String getPageTitle()
	 {
		 waitutils.waitForWE(driver, pageTitle);
		 return pageTitle.getText();
	 }
	
	public void clickBuyButton() {
		waitutils.waitForWE(driver, buyNowButton);
		buyNowButton.click();
	}
}