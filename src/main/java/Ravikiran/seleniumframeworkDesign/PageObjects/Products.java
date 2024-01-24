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

public class Products extends AbstractComponents {
	WebDriver driver;
	
	public Products(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}
	//List<WebElement> product = driver.findElements(By.className("mb-3"));
	
	@FindBy(css=".mb-3")
	List <WebElement> products;
	By productss = By.cssSelector(".mb-3");
	By button = By.cssSelector(".btn.w-10.rounded");
	By Toast= By.id("toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement load;
	@FindBy(css="[routerlink*='cart']")
	WebElement cartheader;
	
	
	
	public List<WebElement> getProductslist()
	{
		waittillvisible(productss);
		return products;
	}
    
	public WebElement getPoductname(String productname)
	{
		 WebElement elem = products.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		   return elem;
	}
	
	public void addtocart(String productname) throws InterruptedException
	{
		WebElement pro= getPoductname( productname);
		pro.findElement(button).click();
		waittillvisible(Toast);
		waittillinvisible(load);
		
		
		
		
	}
	public cartpage gotocart()
	   {
		   cartheader.click();
		   cartpage cart = new cartpage(driver);
		   return cart;
		   
	   }
	
    
	
	
	
	

}
