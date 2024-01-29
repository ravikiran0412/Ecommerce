package Ravikiran.seleniumframeworkDesign;

import java.io.IOException;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ravikiran.seleniumframeworkDesign.PageObjects.Confirmationpage;
import Ravikiran.seleniumframeworkDesign.PageObjects.Homepage;
import Ravikiran.seleniumframeworkDesign.PageObjects.Products;
import Ravikiran.seleniumframeworkDesign.PageObjects.cartpage;
import Ravikiran.seleniumframeworkDesign.PageObjects.checkoutpage;
import Ravikiran.seleniumframeworkDesign.PageObjects.orderpage;
import Ravikiran.seleniumframeworkDesign.Test.BaseTest;
//import Ravikiran.seleniumframeworkDesign.PageObjects.landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Addcart extends BaseTest {
	public String name = "ADIDAS ORIGINAL";

	@Test (dataProvider="datainput")

	public void submitorder(String mail,String password,String name) throws IOException, InterruptedException {

		// TODO Auto-generated method stub
		//String name = "ADIDAS ORIGINAL";
		String finalconfirmation = "THANKYOU FOR THE ORDER.";
		
		// Adding comments

		Products prodc = home.login(mail, password);
		List<WebElement> product = prodc.getProductslist();
		prodc.getProductslist();
		prodc.getPoductname(name);
		prodc.addtocart(name);
		cartpage cart = prodc.gotocart();
		boolean val = cart.checkcartitems(name);
		Assert.assertTrue(val);
		checkoutpage chck = cart.checkout();
		chck.selectcountry("ind");
		Confirmationpage confirm = chck.confirmationpage();
		String tect = confirm.confirmationcheck();
		System.out.print(tect);
		Assert.assertEquals(finalconfirmation, tect);
		driver.findElement(By.xpath("//button[normalize-space()='Sign Out']")).click();
		
		

	}
	
	@Test(dependsOnMethods = "submitorder")
	public void oderHistory()
	{
		Products prodc = home.login("test@mailsac.com", "Testuser123@");
		//prodc.orderspage();
		orderpage order=prodc.orderheader();
		//order.verifyorderdisplay(name);
		Assert.assertTrue(order.verifyorderdisplay(name));
		
		
		
	}
	
   @DataProvider
	public Object[][] datainput()
	{
		
		return new Object[][] {{"test@mailsac.com", "Testuser123@","ADIDAS ORIGINAL"},{"ravi@mailsaac.com", "Test123@","ZARA COAT 3"}};
	
	}
	
	
}
	