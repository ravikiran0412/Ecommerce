package Ravikiran.seleniumframeworkDesign.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;

import raviki.abstractcomponents.AbstractComponents;

public class cartpage extends AbstractComponents {
	WebDriver driver;
	
	public cartpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}
	//List<WebElement> product = driver.findElements(By.className("mb-3"));
	
	@FindBy(css=".cartSection h3")
	List <WebElement> CartElement;
	@FindBy (css=".totalRow button")
	WebElement cbutton;
	
		
		
		
	
	public boolean checkcartitems(String Name) {
		
		boolean match = CartElement.stream().anyMatch(s->s.getText().equalsIgnoreCase(Name));
		return match;
		
	}
	public checkoutpage checkout()
	{
		cbutton.click();
		checkoutpage chck = new checkoutpage(driver);
		return chck;
	}
	
    
	
	
	
	

}
