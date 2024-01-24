package Ravikiran.seleniumframeworkDesign.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}
	
	@FindBy(id="userEmail")
	WebElement mail;

	@FindBy(id="userPassword")
	WebElement password;
	
	
	@FindBy(id="login")
	WebElement submit;
	
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
	

	
	
	
	

}
