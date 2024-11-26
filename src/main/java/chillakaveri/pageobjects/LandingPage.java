package chillakaveri.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import chillakaveri.AbstractComponents.Abstracta;

public class LandingPage extends Abstracta{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	//
	
	public void loginApp(String userEmails,String passwords)
	{
		userEmail.sendKeys(userEmails);
		password.sendKeys(passwords);
		submit.click();
	}
	public void gotol()
	{
		driver.get("https://rahulshettyacademy.com/client");
		 driver.manage().window().maximize();
	}
	public String getErrorMessage()
	{
		waitforWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	

}
