package chillakaveri.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import chillakaveri.AbstractComponents.Abstracta;
//import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends Abstracta {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".action__submit")
	 private WebElement submit;

	@FindBy(css = "[placeholder='Select Country']")
	private WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement selectCountry;

	private By results = By.cssSelector(".ta-results");


		public void selectCountry(String countryName) {
			Actions actions = new Actions(driver);
			try{
		
		/*a.sendKeys(country, countryName).build().perform();
		waitorElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();*/
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement countryElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[placeholder='Select Country']")));     
		/*actions.moveToElement(country).perform(); // Step 1: Move to the element
	    actions.click().perform(); // Step 2: Click the element
	    actions.sendKeys(country,"India").perform();*/
	    ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + countryName + "';", country);

		
			}
		catch(Exception e)
		{
			System.out.println(e.getMessage());	}
	}
	
	
	public void submitOrder()
	{
		submit.click();
		
		
	}

}
