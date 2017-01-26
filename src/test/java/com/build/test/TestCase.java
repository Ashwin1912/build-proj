package com.build.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase {
	WebDriver driver;
	
	public TestCase(){
		getWebDriver();
	}
	public WebDriver getWebDriver(){
		if(driver==null)driver = new FirefoxDriver();
		return driver;
	}

}
