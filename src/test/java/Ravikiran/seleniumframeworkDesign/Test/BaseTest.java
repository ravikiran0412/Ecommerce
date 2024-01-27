package Ravikiran.seleniumframeworkDesign.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Ravikiran.seleniumframeworkDesign.PageObjects.Homepage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Homepage home;

	@SuppressWarnings("deprecation")
	public WebDriver intializeDriver() throws IOException {

		Properties pro = new Properties();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//Ravikiran//seleniumframeworkDesign//resources//GlobalData.properties");
		pro.load(fis);

		String browseri = pro.getProperty("browser");
		if (browseri.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		return driver;

	}
	@BeforeTest

	public Homepage LaunchApplication() throws IOException {
		driver = intializeDriver();
		 home = new Homepage(driver);
		home.seturl("https://rahulshettyacademy.com/client");
		return home;
		
	}
	
	@AfterTest
	
	public void Closetabs()
	{
		driver.close();
	}

}
