package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageFactory.LoginPageFactory;
import PageFactory.homePageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PageFactoryLoginStepsDefinition {

	WebDriver driver;
	LoginPageFactory login;	
	homePageFactory home;
	
	
	@Given("User is on login")
	public void user_is_on_login() {
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   driver.get("https://www.saucedemo.com/v1/");
	   driver.manage().window().maximize();
	}
 
//	@When("User enters valid username and password")
//	public void user_enters_valid_username_and_password() {
	@When("User enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) throws InterruptedException {
	    login =new LoginPageFactory(driver);
	    login.enterUsername(username);
	    login.enterPassword(password);
	    
	}
 
	@And("clicks on Login Button")
	public void clicks_on_login_button() {
		login.clickLogin();
	}

	@Then("User should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {

		home = new homePageFactory(driver);
		home.isCartDisplayed();
//		Assert.assertTrue(driver.findElements(By.xpath("//div[@class='app_logo']")).size()>0,"User should be navigated to home page");
	} 

	@And("Close the browser")
	public void close_the_browser() {
//	    driver.close();
		driver.quit();
	}
}
