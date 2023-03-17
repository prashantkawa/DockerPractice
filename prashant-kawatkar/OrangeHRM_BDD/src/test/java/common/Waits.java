package common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits extends WebDriverWait {

	public Waits(WebDriver driver, Duration timeout) {
		super(driver, timeout);
	}
	
	

}
