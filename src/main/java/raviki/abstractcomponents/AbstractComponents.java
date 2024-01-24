package raviki.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ravikiran.seleniumframeworkDesign.PageObjects.cartpage;

public class AbstractComponents {
	WebDriver driver;
	
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this );
	}
	
	
	
	public void waittillvisible(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf(driver.findElement(findby)));
	}
	
	
	public void waittillinvisible(WebElement ele) throws InterruptedException
	{
		Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 //wait.until(ExpectedConditions.invisibilityOf(ele));
	}
   

}
