package com.midtrans.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.midtrans.Initialize.Setup;
import com.midtrans.loggers.MidTransLogger;
import com.midtrans.utils.waitUtils;

public class CreditCard{



	public WebDriver driver;
	public WebDriverWait waitutils;

	public CreditCard(WebDriver driver) {	
		this.driver= driver;

		waitutils = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);		
	}


	@FindBy(xpath = "//input[@name='cardnumber']")
	WebElement cardNumberTextBox;

	@FindBy(xpath = "//input[@placeholder='MM / YY']")
	WebElement expiryDateTextBox;

	@FindBy(xpath = "//input[@placeholder='123']")
	WebElement cVVTextBox;

	@FindBy(xpath = "//span[text()='Pay Now']/parent::div/parent::a[@href='#/']")
	WebElement payNowButton;

	@FindBy(xpath = "//*[@id='application']/div[3]/div/div/div/iframe")
	WebElement frame;

	@FindBy(css = "#PaRes")
	WebElement PasswordTextBox;

	@FindBy(name = "ok")
	WebElement oKButton;

	@FindBy(css = "div[class='card-container full']")
	WebElement transactionStatusWindow;

	@FindBy(xpath = "//div[@class='text-success text-bold']")
	WebElement txnSuccessStatusText;

	@FindBy(css = "div[class='card-container full']>div[class='final-panel failed']")
	WebElement txnFailureStatusText;

	@FindBy(xpath = "//div[@class='text-failed text-bold']/following-sibling::div[@class='text-failed']")
	WebElement txtTransactionFailureMessage;

	@FindBy(xpath = "//span[text()='Done']/parent::div/parent::a[@href='#/']")
	WebElement doneButton;




	public void setCardNumberAs(String cardNumber) {
		MidTransLogger.info("Enter Card Number -"+cardNumber);
		waitutils.until(ExpectedConditions.visibilityOf(cardNumberTextBox));
		cardNumberTextBox.sendKeys(cardNumber);
	}


	public void setExpiryDateAs(String expiryDate) {
		MidTransLogger.info("Enter Expiry Date-"+expiryDate);
		waitutils.until(ExpectedConditions.visibilityOf(expiryDateTextBox));
		expiryDateTextBox.sendKeys(expiryDate);
	}


	public void setCVVAs(String cvv) {
		MidTransLogger.info("Enter CVV-"+cvv);
		waitutils.until(ExpectedConditions.visibilityOf(cVVTextBox));
		cVVTextBox.sendKeys(cvv);
	}

	
	public void clickOnButtonPayNow() {
		MidTransLogger.info("Click On Pay Now Button.");
		waitutils.until(ExpectedConditions.visibilityOf(payNowButton));
		payNowButton.click();
	}


	public void setPasswordAs(String password) {
		MidTransLogger.info("Enter Password-"+password);
		waitutils.until(ExpectedConditions.visibilityOf(PasswordTextBox));
		PasswordTextBox.click();
		PasswordTextBox.sendKeys(password);
	}


	public void clickOnButtonOK() {
		MidTransLogger.info("Click on OK Button.");
		waitutils.until(ExpectedConditions.elementToBeClickable(oKButton));
		oKButton.click();
	}


	public boolean getTransactionStatus() {
		waitutils.until(ExpectedConditions.visibilityOf(transactionStatusWindow));
		boolean TransactionStatus=false;
		try {
			if (txnSuccessStatusText.isEnabled()) {
				TransactionStatus=true;
				MidTransLogger.info("Transaction succesfful");
			} else{
				TransactionStatus=false;
			}}catch (Exception e){
				MidTransLogger.info("Transaction is succesfful");
			}		
		return TransactionStatus;
	}

	public String getTransactionFailureMessage() {
		waitutils.until(ExpectedConditions.visibilityOf(transactionStatusWindow));
		waitutils.until(ExpectedConditions.visibilityOf(txtTransactionFailureMessage));
		return txtTransactionFailureMessage.getText();
	}

	public void clickOnButtonDone() {
		waitutils.until(ExpectedConditions.elementToBeClickable(doneButton));
		doneButton.click();
	}
}

