package chillakaveri.pageobjects;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import chillakaveri.AbstractComponents.Abstracta;

public class ProductCatalog extends Abstracta{
	WebDriver driver;
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	//List <WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("div[aria-label='Product Added To Cart']");
	By spi=By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductList() throws InterruptedException, IOException
	{
		//for(WebElement product:products)
			//System.out.println(product.getText());
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		int elementCount = ((Long) js.executeScript(
		        "return document.querySelectorAll('.mb-3').length;")).intValue();
		    System.out.println("Number of .mb-3 elements: " + elementCount);*/
		    try {
		        waitorElementToAppear(By.cssSelector(".mb-3"));
		    } catch (TimeoutException e) {
		        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        Files.copy(screenshot.toPath(), Paths.get("error-screenshot.png"));
		        throw e;
		    }


		waitorElementToAppear(productBy);
		
		return products;
	}
	public WebElement getProductByame(String productName) throws InterruptedException, IOException
	{
		WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		System.out.println(prod.getText());
		return prod;
	}
	public void addProductToCart(String productName) throws InterruptedException, IOException
	{
		/*WebElement prod=getProductByame(productName);
		prod.findElement(addToCart).click();
		waitorElementToAppear(toastMessage);
		waitorElementTodisAppear(spi);*/
		 WebElement prod = getProductByame(productName);
		    if (prod == null) {
		        throw new RuntimeException("Product not found: " + productName);
		    }
		    prod.findElement(addToCart).click();
		    System.out.println("Clicked Add to Cart for: " + productName);
		    try {
		        waitorElementToAppear(toastMessage);
		        System.out.println("Toast message appeared.");
		    } catch (TimeoutException e) {
		        System.out.println("Toast message did not appear for: " + productName);
		    }
		    waitorElementTodisAppear(spi);
		
	}
	
	

}
