package Ravikiran.seleniumframeworkDesign.Tests;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Ravikiran.seleniumframeworkDesign.PageObjects.Confirmationpage;
import Ravikiran.seleniumframeworkDesign.PageObjects.Homepage;
import Ravikiran.seleniumframeworkDesign.PageObjects.Products;
import Ravikiran.seleniumframeworkDesign.PageObjects.cartpage;
import Ravikiran.seleniumframeworkDesign.PageObjects.checkoutpage;
//import Ravikiran.seleniumframeworkDesign.PageObjects.landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Addcart {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "ADIDAS ORIGINAL";
		String finalconfirmation="THANKYOU FOR THE ORDER.";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		Homepage home = new Homepage(driver);
		home.seturl("https://rahulshettyacademy.com/client");
		Products prodc =home.login("test@mailsac.com", "Testuser123@");
		//Products prodc = new Products(driver);
		List<WebElement> product = prodc.getProductslist();
		
		
		//List<WebElement> product = driver.findElements(By.className("mb-3"));
		 prodc.getProductslist();
		prodc.getPoductname(name);
	   // prodc.getProductslist();
		prodc.addtocart(name);
		cartpage cart =prodc.gotocart();
		//cartpage cart = new cartpage(driver);
		boolean val = cart.checkcartitems(name);
		Assert.assertTrue(val);
		checkoutpage chck=cart.checkout();
		chck.selectcountry("ind");
		Confirmationpage confirm =chck.confirmationpage();
		String tect = confirm.confirmationcheck();
		System.out.print(tect);
		Assert.assertEquals(finalconfirmation, tect);
		driver.quit();
				
		
		
		
	    
		
	    
	     
	     
	    
	    
	    
	}

}
