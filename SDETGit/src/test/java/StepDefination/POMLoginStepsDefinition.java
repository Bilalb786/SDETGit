package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;

public class POMLoginStepsDefinition {

WebDriver driver;
	LoginPage login;
	@Given("User is go to login page")
	public void user_is_go_to_login_page() {
	   driver = new ChromeDriver();
//	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   driver.get("https://www.saucedemo.com/v1/");
	   driver.manage().window().maximize();
	}
 
//	@When("User enters valid username and password")
//	public void user_enters_valid_username_and_password() {
	@When("Enter the valid {string} and {string}")
	public void enter_the_valid_and(String username, String password) throws InterruptedException {

		login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
//		driver.findElement(By.id("user-name")).sendKeys(username);
//	    driver.findElement(By.id("password")).sendKeys(password);
//	    Thread.sleep(2000);
	}
 
	@And("clicks on the Login Button")
	public void clicks_on_the_login_button() {
		login.clickLogin();
	}

	@Then("User is navigated to home page")
	public void user_is_navigated_to_home_page() {
	    login.isAppLoginDisplayed();
	}

	@And("User close the browser")
	public void user_close_on_the_browser() {
	    driver.close();
	}
}
