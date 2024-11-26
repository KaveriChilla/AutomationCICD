package chillakaveri.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import chillakaveri.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 public WebDriver driver;
	 public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException
	{
		//properties class read the global properties
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Java Projects\\eclipse\\Chilla2\\src\\main\\java\\Chilla2\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		//String browserName= System.getProperty("browser")!=null ? System.getProperty("browser") : System.getProperty("browserheadless") ;
		if(browserName.contains("chrome")) {
		ChromeOptions options=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless"))
		options.addArguments("headless");
		System.setProperty("webdriver.chrome.driver",  "E:/chromedriver.exe");
	     driver =new ChromeDriver(options);
	     driver.manage().window().setSize(new Dimension(1440,900));
	}
		else if(browserName.equalsIgnoreCase("chrome"))
			{
			    //firefox
			System.setProperty("webdriver.edge.driver",  "E:/edge.exe");
			 driver =new EdgeDriver();
		       
			}
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		 return driver;
			}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		//read json to string
	 String jsoncontent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
			 //System.getProperty("user.dir")+ "\\src\\test\\java\\chillakaveri\\data\\purchaseorder.json"),StandardCharsets.UTF_8);
	 //String to hashmap jackson datbind
	 ObjectMapper mapper=new ObjectMapper();
	 List<HashMap<String, String>> data=mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){});
	 System.out.println("Parsed JSON Data: " + data);
	 return data;
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		
		driver=initializeDriver();
		 landingPage=new LandingPage(driver);
		 landingPage.gotol();
		 return landingPage;
	}
	public String getScreenshot (String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		
		File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
	@AfterMethod(alwaysRun=true)
	public void tearDow()
	{
		driver.close();
	}
	
	
}
