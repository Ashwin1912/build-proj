package com.build.pages;

import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ShippingAndPaymentInformation extends CommonPage {

	WebElement lblPageTitle; WebElement txtFirstName;WebElement txtLastName;
	WebElement txtAddress;WebElement txtZip;WebElement txtCity;WebElement lstState;
	WebElement txtPhoneNumber; WebElement txtEmailId; WebElement txtCardNumber;
	WebElement lstExpiresMonth ;WebElement lsEexpiresYear;WebElement txtCardName; WebElement txtSecurityCode;
	WebElement btnReviewOrder;
	public ShippingAndPaymentInformation(WebDriver driver) {
		super(driver);
		lblPageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Shipping and Payment Information')]"));
		
		/***********Shipping Address********************************/
		txtFirstName = driver.findElement(By.id("shippingfirstname"));
		txtLastName = driver.findElement(By.id("shippinglastname"));
		txtAddress = driver.findElement(By.id("shippingaddress1"));
		txtZip = driver.findElement(By.id("shippingpostalcode"));
		txtCity = driver.findElement(By.id("shippingcity"));
		lstState = driver.findElement(By.id("shippingstate_1"));
		txtPhoneNumber = driver.findElement(By.id("shippingphonenumber"));
		
		/***************Contact Information *****************/
		txtEmailId = driver.findElement(By.id("emailAddress"));
		
		/****************Card Details*******************/
		txtCardNumber = driver.findElement(By.id("creditCardNumber"));
		lstExpiresMonth = driver.findElement(By.id("creditCardMonth"));
		lsEexpiresYear = driver.findElement(By.id("creditCardYear"));
		txtCardName = driver.findElement(By.id("creditcardname"));
		txtSecurityCode = driver.findElement(By.id("creditCardCVV2"));
		
		/**********Review Order*****************/
		btnReviewOrder = driver.findElement(By.xpath("//input[contains(@value,'Review Order')]"));

	}
	
	public void validatePageTitle(){
		Assert.assertTrue("Validate the Shipping Page title", lblPageTitle.getText().contains("Shipping and Payment Information"));
	}
	
	public void enterShippingAddress() throws InterruptedException{
		txtFirstName.sendKeys("Ash");
		txtLastName.sendKeys("Win");
		txtAddress.sendKeys("587");
		txtZip.sendKeys("12204");
		txtCity.sendKeys("Menands");
		new Select(lstState).selectByVisibleText("New York");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("shippingphonenumber"))).sendKeys("6092160658");
	}
	
	public void enterContactInfo(){
		txtEmailId.sendKeys("aa@gmail.com");
	}
	
	public void enterCardDetails(){
		txtCardNumber.sendKeys("4111111111111111");
		new Select(lstExpiresMonth).selectByVisibleText("01");
		new Select(lsEexpiresYear).selectByVisibleText("2020");
		txtCardName.sendKeys("Ash");
		txtSecurityCode.sendKeys("431");
	}
	
	public void clickOnReviewButton(){
		btnReviewOrder.click();
	}
	
	}

