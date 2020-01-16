package com.midtrans.pageobjects ;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.midtrans.Initialize.Setup;
import com.midtrans.loggers.MidTransLogger;
import com.midtrans.utils.waitUtils;

public class ShoppingCart{

	
	private waitUtils waitutils;
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='cart-head']/child::span[1]")
	WebElement pagetitle;	
	
	@FindBy(xpath="//div[@class='cart-content buying']//div[@class='cart-checkout']")
	WebElement btnCheckout;
	

	public ShoppingCart(WebDriver driver){
		
		this.driver = driver;
		waitutils = new waitUtils();
		PageFactory.initElements(driver, this);
	}

	public void clickOnButtonCheckout() {
		waitutils.waitForWE(driver, btnCheckout);
		btnCheckout.click();
	}
	






}
