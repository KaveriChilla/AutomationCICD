package chillakaveri.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;

public class AppTest {
	public static void main(String[] args) throws InterruptedException {
	String m="IPHONE 13 PRO";
	String m1="ZARA COAT 3";
	System.setProperty("webdriver.chrome.driver",  "E:/chromedriver.exe");
    WebDriver driver =new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
    driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/client");
	 WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
	driver.findElement(By.id("login")).click();
	List <WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	//WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(m)).findFirst().orElse(null);
	//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	List<String> itemsToAdd = Arrays.asList(m,m1); // Replace with your item names or identifiers

	for (String itemName : itemsToAdd) {
		 
	   WebElement itemElement = products.stream()
	        .filter(k -> k.findElement(By.cssSelector("b")).getText().equals(itemName))
	        .findFirst()
	        .orElse(null);

	    if (itemElement != null) {
	    	itemElement.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	    	//Thread.sleep(5000);
	    	 w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		        w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	    	}
	  
	}
	  driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	  List <WebElement> carts=driver.findElements(By.cssSelector(".cartSection h3"));
	  carts.stream().filter(cart->cart.getText().equals(m));
	  carts.stream().filter(cart->cart.getText().equals(m1));
	  driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	}
}



