package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginFormPage;

public class TestCompagne {
	WebDriver driver;
	String siteDemo="https://demo.applitools.com/";

	@BeforeTest
	public void Setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\Formation Testeur Logiciel\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();  
	}
	
	@Test
	public void testSteps() throws InterruptedException
	{
		driver.get(siteDemo);
		
		LoginFormPage loginFormPage= new LoginFormPage(driver);		
		
		
		loginFormPage.verifierPresenceHeader();
		loginFormPage.saisirLoginPassword("Fatma","Fatma");
		Thread.sleep(2000);
		loginFormPage.cocherRememberME();
		Thread.sleep(2000);
		//loginFormPage.clickSingIn();
		Thread.sleep(2000);
		HomePage homePage= new HomePage(driver);
		homePage.verifierPresenceHeaderNearestBranch();
		Thread.sleep(2000);
		homePage.verifierTotalBalance();
		homePage.verifierCréditAvailable();
		homePage.verifierDueToday();
		
		
	}
		
	@AfterTest
	  public void teardown() throws Exception   {

			Thread.sleep(2000);
			driver.close();
		}

}
