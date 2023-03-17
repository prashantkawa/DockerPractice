package common;

import java.util.List;

import org.openqa.selenium.WebElement;

public class Helper {
	
	public WebElement getListElementToClick(List<WebElement> elementsList, String elementToFind) {
		
		WebElement requiredElement = null;
		
		for(WebElement reqEle : elementsList) {
			if(reqEle.getText().contains(elementToFind)) {
				requiredElement = reqEle;
				break;
			}
		}
		
		return requiredElement;
	}

}
