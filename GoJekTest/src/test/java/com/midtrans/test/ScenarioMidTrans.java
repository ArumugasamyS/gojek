package com.midtrans.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.midtrans.Initialize.Setup;
import com.midtrans.loggers.MidTransLogger;
import com.midtrans.pageobjects.HomeScreen;
import com.midtrans.pageobjects.OrderSummary;
import com.midtrans.pageobjects.SelectPayment;
import com.midtrans.pageobjects.ShoppingCart;
import com.midtrans.pageobjects.CreditCard;
import com.midtrans.utils.IframeHandling;
import com.midtrans.utils.Readprop;


public class ScenarioMidTrans extends Setup {

	
	

	public Readprop readprop;
	public  HomeScreen home;
	public CreditCard card;
	public OrderSummary os;
	public SelectPayment sp;
	public ShoppingCart sc;
	public IframeHandling ih;
	
	
	public void initialiseRef(){
		MidTransLogger.info("Executing flow by creating instance members of all page objects");
		home = new HomeScreen(driver);
		card = new CreditCard(driver);
		os = new OrderSummary(driver);
		sp = new SelectPayment(driver);
		sc = new ShoppingCart(driver);
		ih = new IframeHandling();
		readprop = new Readprop();
	}

	//Test with valid creds
	@Test()
	public void buyWithValidCard() throws IOException {
		initialiseRef();
		MidTransLogger.info("Click on Buy Now Button.");  
		  home.clickBuyButton();
		 
		  MidTransLogger.info("Click on Checkout Button.");
		  sc.clickOnButtonCheckout();
		 
		  ih.switchtoiFrameByIndex(0,driver);
		  MidTransLogger.info("Click on Continue Button.");	  
		  os.clickOnButtonContinue();
		  
		  MidTransLogger.info("Select Credit Card Payment.");
		  sp.clickOnCreditCardPayment();
		 
		 
		  MidTransLogger.info("Enter Card Number -"+readprop.fetchproperty("vCardNumber"));
		  card.setCardNumberAs(readprop.fetchproperty("vCardNumber"));
		  
		 
		  MidTransLogger.info("Enter Expiry Date-"+readprop.fetchproperty("expiryDate"));
		  card.setExpiryDateAs(readprop.fetchproperty("expiryDate"));
		  
		 
		  MidTransLogger.info("Enter CVV-"+readprop.fetchproperty("cVV"));
		  card.setCVVAs(readprop.fetchproperty("cVV"));
		  
		 
		  MidTransLogger.info("Click On Pay Now Button.");
		  card.clickOnButtonPayNow();
		  ih.switchtoiFrameByIndex(0,driver);
		  
		  MidTransLogger.info("Enter Password-"+readprop.fetchproperty("password"));
		  card.setPasswordAs(readprop.fetchproperty("password"));
		  
		  MidTransLogger.info("Click on OK Button.");
		  card.clickOnButtonOK();
		  ih.switchtoDefaultContent(driver);
		  MidTransLogger.info("Verify Transaction Status.");
		  Assert.assertEquals(card.getTransactionStatus(), true, "Actual Result does not match the expected");
		
		
	}

	@Test(dependsOnMethods= {"buyWithValidCard"})
	public void buyWithInValidCard() throws IOException {
		initialiseRef();
		MidTransLogger.info("Click on Buy Now Button.");  
		  home.clickBuyButton();
		 
		  MidTransLogger.info("Click on Checkout Button.");
		  sc.clickOnButtonCheckout();
		 
		  ih.switchtoiFrameByIndex(0,driver);
		  MidTransLogger.info("Click on Continue Button.");	  
		  os.clickOnButtonContinue();
		  
		  MidTransLogger.info("Select Credit Card Payment.");
		  sp.clickOnCreditCardPayment();
		 
		 
		  MidTransLogger.info("Enter Card Number -"+readprop.fetchproperty("iCardNumber"));
		  card.setCardNumberAs(readprop.fetchproperty("iCardNumber"));
		  
		 
		  MidTransLogger.info("Enter Expiry Date-"+readprop.fetchproperty("expiryDate"));
		  card.setExpiryDateAs(readprop.fetchproperty("expiryDate"));
		  
		 
		  MidTransLogger.info("Enter CVV-"+readprop.fetchproperty("cVV"));
		  card.setCVVAs(readprop.fetchproperty("cVV"));
		  
		 
		  MidTransLogger.info("Click On Pay Now Button.");
		  card.clickOnButtonPayNow();
		  ih.switchtoiFrameByIndex(0,driver);
		  
		  MidTransLogger.info("Enter Password-"+readprop.fetchproperty("password"));
		  card.setPasswordAs(readprop.fetchproperty("password"));
		  
		  MidTransLogger.info("Click on OK Button.");
		  card.clickOnButtonOK();
		  ih.switchtoDefaultContent(driver);
		  MidTransLogger.info("Verify Transaction Status.");
		  Assert.assertEquals(card.getTransactionStatus(), false, "Actual Result does not match the expected");
		
		
	}
	

}
