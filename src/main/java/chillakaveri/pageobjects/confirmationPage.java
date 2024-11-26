package chillakaveri.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import chillakaveri.AbstractComponents.Abstracta;

public class confirmationPage extends Abstracta{

	WebDriver driver;
	public confirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
