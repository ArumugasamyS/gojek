package com.midtrans.utils;

import org.openqa.selenium.WebDriver;

public class IframeHandling {
	
	
	public void switchtoiFrameByIndex(int index,WebDriver driver) {
		driver.switchTo().frame(index);
	}
	
	public void switchtoDefaultContent(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

}
