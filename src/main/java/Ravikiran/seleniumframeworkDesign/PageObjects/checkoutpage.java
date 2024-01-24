package Ravikiran.seleniumframeworkDesign.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import raviki.abstractcomponents.AbstractComponents;

public class checkoutpage extends AbstractComponents {
	
	WebDriver driver;
	
	public checkoutpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy (xpath = "//button[@type='button'][2]")
	WebElement countryname;
	@FindBy (css=".btnn.action__submit.ng-star-inserted")
	WebElement submit;
	
	
	//String countr = "Ind";
	
	
	public void selectcountry(String countryi)
	{
		country.sendKeys(countryi);
		//button[@type='button'][2]
		countryname.click();
		
		
	}
	public Confirmationpage confirmationpage() {
		submit.click();
		Confirmationpage confirm = new Confirmationpage(driver);
		return confirm;
	}

}
