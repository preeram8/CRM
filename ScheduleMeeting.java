package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScheduleMeeting {

	WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 25);
    
       
	@Given("^User is on CRM login page3$")
	public void userIsOnLoginPage() {
		driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
	}
	
	@When("^user enters username and password3$")
	public void Userentersusernameandpassword() {
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
	}
	
	@Then("^Navigate to Activities -> Meetings -> Schedule a Meeting$")
	public void createLead() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_3")));
		WebElement activities = driver.findElement(By.id("grouptab_3"));	
		activities.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("moduleTab_9_Meetings")));
        WebElement meetings = driver.findElement(By.id("moduleTab_9_Meetings"));
	    meetings.click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[1]/a/div[2]")));
	    WebElement scheduleMeeting= driver.findElement(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[1]/a/div[2]"));
	    scheduleMeeting.click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
	    driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Test Meeting");
	    driver.findElement(By.xpath("//input[@id='invitees_search']")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='invitees_add_2']")));
	    driver.findElement(By.xpath("//input[@id='invitees_add_2']")).click();
	    driver.findElement(By.xpath("//input[@id='invitees_add_3']")).click();
	    driver.findElement(By.xpath("//input[@id='invitees_add_4']")).click();
	    WebElement save = driver.findElement(By.id("SAVE_HEADER"));
	    save.click();
	    driver.findElement(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[2]/a/div[2]")).click();
	    
	}
	
	@And("^close the browser3$")
	public void closeBrowser() {
    	driver.close();
}
	
}
