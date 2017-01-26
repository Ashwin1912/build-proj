package com.build.pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCart extends CommonPage {

	WebElement lblPageTitle;WebElement btnContinueShopping;
	WebElement lnkHome; WebElement btnProceedToCart; WebElement lblGrandTotal;
	WebElement lblEstimatedTax;

	public ShoppingCart(WebDriver pdriver) {
		super(pdriver);
		lblPageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
		btnProceedToCart = driver.findElement(By.xpath("(//span[contains(text(),'Checkout')])[1]"));
		lblGrandTotal = driver.findElement(By.xpath("//div[@id='grandtotalamount']"));
		lblEstimatedTax = driver.findElement(By.xpath("//div[@id='taxAmount']"));
	}
	public void validatePageTitle(){
		Assert.assertTrue("Validate the Shooping Cart title", lblPageTitle.getText().contains("Shopping Cart"));
	}


	public void clickOnProceedCart(){
		btnProceedToCart.click();
	}

	public Double calculateTotal(){
		Double count =0.00;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='cart']/tbody/tr/td[4]")));
		int purchasedItem=  driver.findElements(By.xpath("//table[@id='cart']/tbody/tr/td[4]")).size();

		for(int i=1;i<=purchasedItem;i++){
			String result=driver.findElement(By.xpath("//table[@id='cart']/tbody/tr["+i+"]/td[4]")).getText();

			count = count+Double.parseDouble(result.substring(1));
		}
		return count;

	}
	public Double getGrandTotal(){
		String result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='grandtotalamount']"))).getText().replace(",", "");
		Double total =	Double.parseDouble(result.substring(1));
		return total;
	}

	public String  getEstimatedTax(){
		String tax=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='taxAmount']"))).getText();
		return tax;
	}
}