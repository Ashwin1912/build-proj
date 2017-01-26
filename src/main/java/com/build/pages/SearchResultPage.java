package com.build.pages;

import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends CommonPage{
	WebElement lblPageTitle;WebElement btnAddToCart; WebElement txtStockCount; 
	WebElement lnkKohlerSuede; WebElement lnkKohlerCashmere;

	public SearchResultPage(WebDriver driver){
		super(driver);
		lblPageTitle = driver.findElement(By.id("heading"));
		btnAddToCart = driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]"));
		txtStockCount = driver.findElement(By.xpath("//input[contains(@class,'qtyselected form-control')]"));
		lnkKohlerSuede = driver.findElement(By.linkText("Kohler K-6626-6U-20"));
		lnkKohlerCashmere = driver.findElement(By.linkText("Kohler k-6626-6U-K4"));
	}

	public void validateSearchTitle(String title){
		wait.until(ExpectedConditions.visibilityOf(lblPageTitle));
		Assert.assertTrue("Validate the home page", lblPageTitle.getText().contains(title));
	}

	public void clickOnAddToCart(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Add to Cart')]"))).click();;
	}

	public void enterStockCount(String count) throws InterruptedException{
		Thread.sleep(7000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@class,'qtyselected form-control')]"))).sendKeys(Keys.ARROW_UP);
	}
	public void clickOnKohlerSuede(){
		lnkKohlerSuede.click();
	}

	public void clickOnKohlerCashmere(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Kohler k-6626-6U-K4"))).click();;
	}
}
