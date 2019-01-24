package teaTesting;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberParameterTesting.TestRunner;
import teaTesting.Constants;

public class TeaSteps {
	ChromeDriver driver;
	ExtentReports extent;
	ExtentTest test;
	WebDriverWait wait;
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_URL);
		driver = new ChromeDriver();
		extent = TestRunner.extent;
		test = extent.startTest("first test");
		test.log(LogStatus.INFO, "Browser started");
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		
	}
	
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		driver.manage().window().maximize();
		driver.get(Constants.LANDING_URL);
	    
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
	    TeaHomePage homePage = PageFactory.initElements(driver, TeaHomePage.class);
	    homePage.clickMenu();
	    test.log(LogStatus.INFO, "on menu page");
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products()  {
	  MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
	  assertEquals("not menu page", "Menu", menu.returnHeaderText());
	  test.log(LogStatus.PASS, "can browse!");
	    
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		TeaHomePage homePage = PageFactory.initElements(driver, TeaHomePage.class);
	    homePage.clickCheckout();
	   test.log(LogStatus.INFO, "clicked checkout");
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page()  {
		
		
	   CheckOutPage checkout = PageFactory.initElements(driver, CheckOutPage.class);
	   assertEquals("wrong page", checkout.returnURL(), driver.getCurrentUrl());
	   test.log(LogStatus.PASS, "on checkout page");

	}

}
