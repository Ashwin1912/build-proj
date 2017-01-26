package com.build.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BeginCheckout extends CommonPage {

	WebElement lblPageTitle; WebElement btnCheckOut;

	public BeginCheckout(WebDriver driver){
		super(driver);
		lblPageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Begin Checkout!')]"));		 
		btnCheckOut = driver.findElement(By.xpath("//button[contains(@name,'guestLoginSubmit')]"));

	}

	public void validatePageTitle(){
		Assert.assertTrue("Validate the CheckOut Page title", lblPageTitle.getText().contains("Begin Checkout!"));
	}

	public void clickOnCheckOut(){
		btnCheckOut.click();
	}
}
