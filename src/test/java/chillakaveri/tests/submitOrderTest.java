package chillakaveri.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import chillakaveri.TestComponents.BaseTest;
import chillakaveri.pageobjects.Cartpage;
import chillakaveri.pageobjects.CheckoutPage;
import chillakaveri.pageobjects.LandingPage;
//import chillakaveri.pageobjects.OderPage;
import chillakaveri.pageobjects.OrderPage;
import chillakaveri.pageobjects.ProductCatalog;

import org.testng.Assert;
//import dev.failsafe.internal.util.Assert;
import org.testng.annotations.*;

public class submitOrderTest extends BaseTest{
   String m="IPHONE 13 PRO";
	String m1="ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"Purchase"})
	//public void submitOrder(String mail,String pass,String product) throws IOException, InterruptedException
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException{
	//String m="IPHONE 13 PRO";
	//launchApplication();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 System.out.println("Input Data: " + input);
    landingPage.loginApp(input.get("mail"),input.get("pass"));
	ProductCatalog productCatalogue=new ProductCatalog(driver);
	List <WebElement> products=productCatalogue.getProductList();
	productCatalogue.addProductToCart(input.get("product"));
	

	productCatalogue.goToCartPage();
	Cartpage cartpage=new Cartpage(driver);
	//Boolean match=
			cartpage.verifyProductdisplay(input.get("product"));
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
	 //driver.findElement(By.cssSelector(".btnn")).click();
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderhist() {
		 landingPage.loginApp("shetty@gmail.com","Iamking@000");
		ProductCatalog productCatalogue=new ProductCatalog(driver);
		OrderPage orderpage=productCatalogue.goToOrderPage();
		Assert.assertTrue(orderpage.verifyOrderDisplay(m1));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		/*HashMap<Object,Object> map=new HashMap<Object,Object>();
		map.put("mail", "anshika@gmail.com");
		map.put("pass", "Iamking@000");
		map.put("product", "IPHONE 13 PRO");
		
		HashMap<Object,Object> map1=new HashMap<Object,Object>();
		map1.put("mail", "shetty@gmail.com");
		map1.put("pass", "Iamking@000");
		map1.put("product", "ZARA COAT 3");
		return new Object[][] {{map},{map1}};*/
		List<HashMap<String,String>> data= getJsonDataToMap("D:\\Java Projects\\eclipse\\Chilla2\\src\\test\\java\\chillakaveri\\data\\purchaseorder.json");
		//List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+ "\\src\\test\\java\\chillakaveri\\data\\purchaseorder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		//return new Object[][] {{"anshika@gmail.com","Iamking@000","IPHONE 13 PRO"},{"shetty@gmail.com","Iamking@000","ZARA COAT 3"}};
	}
	
}



