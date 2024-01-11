package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;

public class LoginFormPage {
	
	WebDriver driver;
	By loginHeaderBy= By.xpath("//h4[contains(text(), \"Login Form\")]");
	WebElement loginHeaderWE;
	
	By usernameInputBy= By.xpath("//input[contains(@id, \"username\")]");
	WebElement usernameInputWE;
	
	By passwordInputBy= By.xpath("//input[contains(@id, \"password\")]");
	WebElement passwordInputWE;	

	By RememberCheckboxBy= By.xpath("//label[contains(text(), \"Remember Me\")]//child::input");
	WebElement RememberCheckboxWE;
	
	By signinButtonBy= By.xpath("//a[contains(text(), \"Sign in\")]");
	WebElement signinButtonWE;
	
		
	public LoginFormPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
		
	public void verifierPresenceHeader()
	{
		loginHeaderWE = driver.findElement(loginHeaderBy);
		String headerName =loginHeaderWE.getText();
		Assert.assertEquals(headerName, "Login Form", "les element ne sont pas égaux");
		
	}
	
	public void saisirLoginPassword(String username,String mp)
	{
		usernameInputWE = driver.findElement(usernameInputBy);
		usernameInputWE.sendKeys(username);
		
		passwordInputWE = driver.findElement(passwordInputBy);
		passwordInputWE.sendKeys(mp);
	}
	
	public void cocherRememberME()
	{

		RememberCheckboxWE = driver.findElement(RememberCheckboxBy);
		RememberCheckboxWE.click();
	}
	public HomePage clickSingIn()
	{	
		signinButtonWE = driver.findElement(signinButtonBy);
		signinButtonWE.click();
		return new HomePage(driver);
	}
  

}
