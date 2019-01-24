package teaTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form")
	private WebElement checkoutForm;
	

	private String checkOutURL = "http://www.practiceselenium.com/check-out.html";
	
	public String returnURL() {
		return checkOutURL;
	}

}
