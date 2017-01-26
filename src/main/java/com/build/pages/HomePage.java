package com.build.pages;

import junit.framework.Assert;
import org.openqa.selenium.*;


public class HomePage extends CommonPage {
	WebElement lblPageTitle;
	public HomePage(WebDriver driver){
		super(driver);
		lblPageTitle=driver.findElement(By.xpath("(//img[contains(@alt,'Build.com Smarter Home Improvement')])[1]"));
	}
	public void vaildatePageTitle(){
		Assert.assertTrue("Validate the home page", lblPageTitle.isDisplayed());
	}
}
