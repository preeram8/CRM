package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatingProduct {

	WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Actions actions = new Actions(driver);
       
	@Given("^User is on CRM login page4$")
	public void userIsOnLoginPage() {
		driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
	}
	
	@When("^user enters username and password4$")
	public void Userentersusernameandpassword() {
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
	}
	
	@Then("^Navigate to All -> Products-> Create Product$")
	public void createProduct() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_5")));
		driver.findElement(By.id("grouptab_5")).click();	
			
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"toolbar\\\"]/ul/li[8]/span[2]/ul/li[25]/a")));
		//WebElement products = driver.findElement(By.xpath("//*[@id=\"toolbar\"]/ul/li[8]/span[2]/ul/li[25]/a"));
		//actions.moveToElement(products).click().perform();
		
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='actionMenuSidebar']/ul/li[1]/a/div[2]")));
	    driver.findElement(By.xpath("//*[@id='actionMenuSidebar']/ul/li[1]/a/div[2]")).click();
	   
	    
	}
	
	@And("^User enters \"(.*)\" and \"(.*)\"$")
	public void addProducts(String Productname, String Price) throws Throwable {
		driver.findElement(By.id("name")).sendKeys(Productname);
		driver.findElement(By.id("price")).sendKeys(Price);
		driver.findElement(By.id("SAVE")).click();
		
	}

	@And("^close the browser4$")
	public void closeBrowser() {
    	driver.close();
}
	
}
