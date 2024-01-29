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
import org.testng.annotations.Test;

import Ravikiran.seleniumframeworkDesign.PageObjects.Confirmationpage;
import Ravikiran.seleniumframeworkDesign.PageObjects.Homepage;
import Ravikiran.seleniumframeworkDesign.PageObjects.Products;
import Ravikiran.seleniumframeworkDesign.PageObjects.cartpage;
import Ravikiran.seleniumframeworkDesign.PageObjects.checkoutpage;
import Ravikiran.seleniumframeworkDesign.Test.BaseTest;
//import Ravikiran.seleniumframeworkDesign.PageObjects.landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class errorvalidation extends BaseTest {

	@Test(enabled=false)

	public void submitorder() throws IOException, InterruptedException {

		
		// Adding comments

		Products prodc = home.login("tt@mailsac.com", "Testuser123@");
		String text = home.errorvalidation();
		System.out.print(text);
		Assert.assertEquals(text, "Incorrect email or password.");
		

	}

}
