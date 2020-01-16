package com.midtrans.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.midtrans.Initialize.Setup;
import com.midtrans.loggers.MidTransLogger;
import com.midtrans.utils.waitUtils;

public class SelectPayment{
	private waitUtils waitutils;
	public WebDriver driver;
	private WebDriverWait wait;
	
	
	
	@FindBy(xpath="//span[@class='text-page-title']/child::p[@class='text-page-title-content']")
	WebElement pagetitle;	
	
	@FindBy(xpath="//div[@id='payment-list']//div[starts-with(text(),'Credit Card')]")
	WebElement creditCardPayment;
	
	public SelectPayment(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		wait= new WebDriverWait(driver,10);
		waitutils= new waitUtils();	
		
	}
	public void clickOnCreditCardPayment() {
		
		waitutils.waitForWE(driver, creditCardPayment);
		creditCardPayment.click();
	}
	
	
	
}
