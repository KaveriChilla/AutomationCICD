package chillakaveri.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import chillakaveri.TestComponents.BaseTest;
import chillakaveri.pageobjects.Cartpage;
import chillakaveri.pageobjects.CheckoutPage;
import chillakaveri.pageobjects.LandingPage;
import chillakaveri.pageobjects.ProductCatalog;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefifnitionsImpl extends BaseTest{
	
	public LandingPage landingPage;
	public ProductCatalog productCatalogue;
	@Given("I landed on Ecommerce Website")
	public void I_landed_on_Ecommerce_Website() throws IOException
	{
		landingPage=launchApplication();
	}
	
	 @Given("^Logged in with username (.+) and passowrd (.+)$")
	  public void logged_in_username_and_password(String usernmae,String password)
	  {
		 landingPage.loginApp(usernmae,password);
		
			
	  }
	 
	 @When("^I add product (.+) from cart$")
	 public void product_add_to_cart(String productname) throws InterruptedException, IOException
	 {
		  productCatalogue=new ProductCatalog(driver);
		 List <WebElement> products=productCatalogue.getProductList();
			productCatalogue.addProductToCart(productname);
			
	 }
	 @Then("^checkout (.+) and submit the order$")
	 public void checkout_and_submitorder(String productname) throws InterruptedException
	 {
		 productCatalogue.goToCartPage();
			Cartpage cartpage=new Cartpage(driver);
			//Boolean match=
					cartpage.verifyProductdisplay(productname);
			//Assert.assertTrue(match);
			//cartpage.verifyProductdisplay(input.get("product"));
			//Assert.asserttrue(match);
			cartpage.goToCheckOut();
			CheckoutPage checkoutpage=new CheckoutPage(driver);
					
			checkoutpage.selectCountry("India");
			 //driver.findElement(By.xpath("")).click();
			//By results1= By.cssSelector(".btnn");
			//cartpage.waitorElementToAppear(results1);
			WebElement element = driver.findElement(By.cssSelector(".btnn"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			driver.close();
			 
	 }
	 //("{string} ansnb sjbjss") for dynamic text
	 
	 @Then("^\"([^\"]*)\" message is displayed$")
	 public void something_message_is_displayed(String strArg1) 
	 {
		 Assert.assertEquals(strArg1, landingPage.getErrorMessage());
		 driver.close();
	 }
	    

}
