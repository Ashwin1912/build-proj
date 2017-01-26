package com.build.test;

import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import com.build.pages.*;

public class BuildTest extends TestCase {
	@Before	
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.build.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void checkOut() throws InterruptedException{

		//Navigate to Home Page
		HomePage page = new HomePage(driver);
		page.vaildatePageTitle();

		//Enter Suede Kohler K66266U in search box
		page.enterSearch("Suede Kohler K6626U");
		page.enterSearch(Keys.ENTER);

		//Navigate to search page
		SearchResultPage searchPage = new SearchResultPage(driver);
		searchPage.validateSearchTitle("Kohler");

		//Select Suede Kohler from the link in bottom of the page
		searchPage.clickOnKohlerSuede();

		//Add to Cart
		searchPage.clickOnAddToCart();

		//Enter Cashmere Kohler K66266U in search box
		page.enterSearch("Cashmere Kohler K66266U");
		page.enterSearch(Keys.ENTER);

		//Select Cashmere Kohler from the  link in bottom of the page
		searchPage.clickOnKohlerCashmere();

		//Add to Cart
		searchPage.clickOnAddToCart();

		//Enter Kohler K-5180-ST in search box
		page.enterSearch("Kohler K-5180-ST");
		page.enterSearch(Keys.ENTER);
		searchPage.enterStockCount("2");		

		//Add to Cart
		searchPage.clickOnAddToCart();

		//Proceed to check out
		ShoppingCart cart = new ShoppingCart(driver);
		cart.validatePageTitle();
		cart.clickOnProceedCart();

		//Click on Checkout as Guest
		BeginCheckout checkout = new BeginCheckout(driver);
		checkout.validatePageTitle();
		checkout.clickOnCheckOut();

		//Enter the details in Shipping and Payment Information
		ShippingAndPaymentInformation information = new ShippingAndPaymentInformation(driver);
		information.validatePageTitle();

		//Enter Information in Address Details
		information.enterShippingAddress();;

		//Enter Contact Information
		information.enterContactInfo();

		//Enter Card Details
		information.enterCardDetails();

		//Click on Review Order
		information.clickOnReviewButton();

		//Validate the Grand Total
		Assert.assertTrue("Validate the Grand Total", cart.calculateTotal().equals(cart.getGrandTotal()));

		//Validate the Tax
		Assert.assertTrue("Validate Tax", cart.getEstimatedTax().equals("$0.00"));
	}

}
