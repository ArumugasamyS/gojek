package com.midtrans.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.midtrans.Initialize.Setup;
import com.midtrans.loggers.MidTransLogger;
import com.midtrans.utils.waitUtils;

public class OrderSummary{
	
	public waitUtils waitutils;
	 WebDriver driver;
	
	 @FindBy(xpath="//span[@class='text-page-title']/child::p[@class='text-page-title-content']")
		WebElement pagetitle;
		
		@FindBy(xpath="//a[@href='#/select-payment']")
		WebElement btnContinue;
		
		
	 public OrderSummary(WebDriver driver){
		this.driver= driver;
		waitutils = new waitUtils();
		PageFactory.initElements(driver, this);
		
	}
	 
	 public String getPageTitle() {
		 waitutils.waitForWE(driver, pagetitle);
			 return pagetitle.getText();
			} 
	 public void clickOnButtonContinue() {
			
			waitutils.waitForWE(driver, btnContinue);
			btnContinue.click();
		}
	
}
