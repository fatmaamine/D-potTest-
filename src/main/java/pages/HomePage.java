package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	By totalBalanceLabelBy= By.xpath("//div[contains(text(), \"Total Balance\")]//following::span[1]");
	WebElement totalBalanceLabelWE;
	
	By créditAvailableBy= By.xpath("(//div[@class='balance-value'])[2]");
	WebElement créditAvailableWE;
	
	By DueTodayBy= By.xpath("//div[@class='balance-value danger']");
	WebElement DueTodayEW;

	By headerNearestBranchBy= By.xpath("//h6[contains(text(), \"Your nearest branch closes in: 30m 5s\")]");
	WebElement headerNearestBranchWE;
	
	public HomePage(WebDriver driver ) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}
	
    public void verifierPresenceHeaderNearestBranch()
    {
		headerNearestBranchWE = driver.findElement(headerNearestBranchBy);
		String headerYourNearset=headerNearestBranchWE.getText();
		
		Assert.assertEquals(headerYourNearset, "Your nearest branch closes in: 30m 5s", "Not equals");

    }
    
    public void verifierTotalBalance()
    {
    	totalBalanceLabelWE = driver.findElement(totalBalanceLabelBy);
		String balnceText = totalBalanceLabelWE.getText();
		
		assertEquals(balnceText, "$350","les element ne sont pas égaux");
    }
    
    public void verifierCréditAvailable()
    {
    	créditAvailableWE = driver.findElement(créditAvailableBy);

    	String créditAvailable=créditAvailableWE.getText();
		Assert.assertEquals(créditAvailable, "$17,800","not equals");
    }
    
    public void verifierDueToday()
    {
    	DueTodayEW= driver.findElement(DueTodayBy);
    	String dueToday=DueTodayEW.getText();
    	Assert.assertEquals(dueToday, "$180","les elements ne sont pas egaux");
    }
    
    
}
