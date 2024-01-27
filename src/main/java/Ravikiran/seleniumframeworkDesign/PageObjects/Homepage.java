package Ravikiran.seleniumframeworkDesign.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import raviki.abstractcomponents.AbstractComponents;

public class Homepage extends AbstractComponents {
	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}
	
	@FindBy(id="userEmail")
	WebElement mail;

	@FindBy(id="userPassword")
	WebElement password;
	
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormess;
	
	public Products login(String keys, String pass)
	{
		  mail.sendKeys(keys);
		  password.sendKeys(pass);
		  submit.click();
		  Products prodc = new Products(driver);
		  return prodc;
	}
	
	public void seturl(String Url)
	{
		driver.get(Url);
	}
	 public String errorvalidation()
	 {
		 waittillvisibleElement(errormess);
		 return errormess.getText();
	 }

	
	
	
	

}
