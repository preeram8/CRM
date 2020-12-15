package stepDefinitions;
import java.awt.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeads {

	WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    
       
	@Given("^User is on CRM login page2$")
	public void userIsOnLoginPage() {
		driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
	}
	
	@When("^user enters username and password2$")
	public void Userentersusernameandpassword() {
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
	}
	
	@Then("^Navigate to Sales -> Leads -> Create Lead$")
	public void createLead() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_0")));
		WebElement sales = driver.findElement(By.id("grouptab_0"));	
		sales.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("moduleTab_9_Leads")));
        WebElement leads = driver.findElement(By.id("moduleTab_9_Leads"));
	    leads.click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[1]/a/div[2]")));
	    WebElement createlead= driver.findElement(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[1]/a/div[2]"));
	    createlead.click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.name("salutation")));
	    Select drpdown = new Select(driver.findElement(By.name("salutation")));
	    drpdown.selectByVisibleText("Mr.");
	    driver.findElement(By.id("first_name")).sendKeys("Peter");
	    driver.findElement(By.id("last_name")).sendKeys("Pan");
	    driver.findElement(By.id("Leads0emailAddress0")).sendKeys("perterpan.email.com");
	    driver.findElement(By.id("SAVE")).click();
	    WebElement viewLeads = driver.findElement(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[3]/a/div[2]"));
	    viewLeads.click();
	}
	
	@And("^close the browser2$")
	public void closeBrowser() {
    	driver.close();
  }
}
