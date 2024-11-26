package chillakaveri.AbstractComponents;
//import chillakaveri.pageobjects.OderPage;
import chillakaveri.pageobjects.OrderPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import chillakaveri.pageobjects.Cartpage;
//import chillakaveri.pageobjects.OderPage;

public class Abstracta {

	WebDriver driver;

	public Abstracta(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;


	public void waitorElementToAppear(By findBy) {
	 WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
	 w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(findBy));
	 w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	 
	}
	public void waitforWebElementToAppear(WebElement findBy) {
		 WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		 w.until(ExpectedConditions.visibilityOf(findBy));
		 
		}
	
	public void waitorElementTodisAppear(By findBy) throws InterruptedException {
		Thread.sleep(1000);
		 //WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		 //w.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		}
     public void goToCartPage() throws InterruptedException
     {
    	Thread.sleep(1000);
    	cartHeader.click();
    	 
     }
     public OrderPage goToOrderPage() 
     {
    	
    	 orderHeader.click();
    	 OrderPage orderpage=new OrderPage(driver);
    	 return orderpage;
    	 
     }
}
