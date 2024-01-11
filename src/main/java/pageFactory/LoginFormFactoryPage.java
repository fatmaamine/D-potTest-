package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageFactory.*;


public class LoginFormFactoryPage {	
	
	WebDriver driver;	
	
	@FindBy(xpath = "//h4[contains(text(), \"Login Form\")]")
	WebElement loginHeaderFactoryWE;
	
	@FindBy(xpath="//input[contains(@id, \"username\")]")
	WebElement usernameInputFactoryWE;
	
	@FindBy(xpath="//input[contains(@id, \"password\")]")
	WebElement passwordInputFactoryWE;	

	@FindBy(xpath="//label[contains(text(), \"Remember Me\")]//child::input")
	WebElement RememberCheckboxFactoryWE;
	
	@FindBy(xpath="//a[contains(text(), \"Sign in\")]")
	WebElement signinButtonFactoryWE;

	public LoginFormFactoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
			
	public void verifierPresenceHeader()
	{
		
		String headerName =loginHeaderFactoryWE.getText();
		Assert.assertEquals(headerName, "Login Form", "les element ne sont pas égaux");
		
	}
	
	public void saisirLoginPassword(String username,String mp)
	{
		usernameInputFactoryWE.sendKeys(username);
		
		passwordInputFactoryWE.sendKeys(mp);
	}
	
	public void cocherRememberME()
	{

		RememberCheckboxFactoryWE.click();
	}
	public HomePageFactory clickSingIn()
	{	
		signinButtonFactoryWE.click();
		return new HomePageFactory(driver);
	}

}
