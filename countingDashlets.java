package stepDefinitions;

import java.awt.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class countingDashlets {
	WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    
       
	@Given("^User is on CRM login page$")
	public void userIsOnLoginPage() {
		driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
	}
	
	@When("^user enters username and password$")
	public void Userentersusernameandpassword() {
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
	}
	
	@Then("^counts the dashlets on the homepage and print its title$")
	public void countdashlets() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[starts-with(@id,'dashlet_header')]")));
		String dashlets =  driver.findElement(By.xpath("//*[starts-with(@id,'dashlet_header')]")).getText();
		System.out.println(dashlets);
		
	}
	
	@And("^close the browser$")
	public void closeBrowser() {
    	driver.close();
  }
	
}
