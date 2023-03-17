package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDriverToTest {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver(String checkDriver) {
		
		switch(checkDriver) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
	    	System.setProperty("webdriver.chrome.silentOutput", "true");
	    	driver=new ChromeDriver();
	    	break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    	break;
	    default:
	    	WebDriverManager.chromedriver().setup();
	    	System.setProperty("webdriver.chrome.silentOutput", "true");
	    	driver=new ChromeDriver();
	    	break;
		}
		
		return driver;
		
	}

}
