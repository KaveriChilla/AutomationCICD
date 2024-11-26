package chillakaveri.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import chillakaveri.AbstractComponents.Abstracta;

public class Cartpage extends Abstracta{
    WebDriver driver;
	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	//@FindBy(css=".btn.btn-primary")
	@FindBy(xpath="/html/body/app-root/app-profile/div/div[3]/ul/li[3]/button")
	WebElement checkoutfile;
	@FindBy(css="cartSection h3")
	private List<WebElement> cartProducts;
	
	public boolean verifyProductdisplay(String productName)
	{
		Boolean match=cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
		// List <WebElement> carts=driver.findElements(By.cssSelector(".cartSection h3"));
		 //carts.stream().filter(cart->cart.getText().equals(productName));
		 //return true;
		  
	}
	public void goToCheckOut() throws InterruptedException
    {
		Actions actions=new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(checkoutfile));
		//actions.moveToElement(checkoutfile).click().perform();
		Thread.sleep(2000);
		checkoutfile.click();
		System.out.println("Click action performed on the checkout file.");
		//return new CheckoutPage(driver);
    }

}
