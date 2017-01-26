package com.build.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {	
	WebElement txtSearch;
	WebDriver driver;
	WebDriverWait wait;
	public CommonPage(WebDriver pdriver){
		driver=pdriver;
		wait=new WebDriverWait(pdriver, 60);
	}

	public void enterSearch(String Value){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_txt"))).sendKeys(Value);;
	}

	public void enterSearch(Keys Value){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_txt"))).sendKeys(Value);;
	}

}
