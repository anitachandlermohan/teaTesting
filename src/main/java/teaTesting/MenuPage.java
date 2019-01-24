package teaTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage {
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div/h1")
	private WebElement header;
	
	public String returnHeaderText() {
		return header.getText();
		
	}
	
}
