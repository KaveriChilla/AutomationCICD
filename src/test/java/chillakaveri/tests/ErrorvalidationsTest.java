package chillakaveri.tests;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import chillakaveri.TestComponents.BaseTest;
import chillakaveri.TestComponents.Retry;
import chillakaveri.pageobjects.Cartpage;
import chillakaveri.pageobjects.CheckoutPage;
import chillakaveri.pageobjects.LandingPage;
import chillakaveri.pageobjects.ProductCatalog;

//import dev.failsafe.internal.util.Assert;
import org.testng.Assert; 

public class ErrorvalidationsTest extends BaseTest{
	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{
	//String m="IPHONE 13 PRO";
	
    landingPage.loginApp("anshika@gmail.com","Iamkin@000");
    Thread.sleep(1000);
    System.out.print(landingPage.getErrorMessage());
    Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	/*@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
	String m="IPHONE 133 PRO";
	ProductCatalog productCatalogue=new ProductCatalog(driver);
	 landingPage.loginApp("anshika@gmail.com","Iamking@000");
	List <WebElement> products=productCatalogue.getProductList();
	productCatalogue.addProductToCart(m);
	Cartpage cartpage=new Cartpage(driver);
	cartpage.goToCartPage();
	Boolean match =cartpage.verifyProductdisplay(m);
	Assert.assertFalse(match);*/
	
	}

	




