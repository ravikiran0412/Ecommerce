package Ravikiran.seleniumframeworkDesign.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import raviki.abstractcomponents.AbstractComponents;



public class Confirmationpage extends AbstractComponents {
	WebDriver driver;

	public Confirmationpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	
	
	@FindBy (css=".hero-primary")
	WebElement text;
	
	
	
	public String confirmationcheck()
	{
		String textassert = text.getText();
		return textassert;
	}
	

}
