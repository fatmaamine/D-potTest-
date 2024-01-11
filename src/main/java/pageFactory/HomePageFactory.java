package pageFactory;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageFactory {
	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(text(), \"Total Balance\")]//following::span[1]")
	WebElement totalBalanceLabelFactoryWE;
	
	@FindBy(xpath = "(//div[@class='balance-value'])[2]")
	WebElement créditAvailableFactoryWE;
	
	@FindBy(xpath ="//div[@class='balance-value danger']")
	WebElement DueTodayFactoryEW;

	@FindBy(xpath ="//h6[contains(text(), \"Your nearest branch closes in: 30m 5s\")]")
	WebElement headerNearestBranchFactoryWE;


	public HomePageFactory(	WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	 public void verifierPresenceHeaderNearestBranch()
	    {
			String headerYourNearset=headerNearestBranchFactoryWE.getText();
			
			Assert.assertEquals(headerYourNearset, "Your nearest branch closes in: 30m 5s", "Not equals");

	    }
	    
	    public void verifierTotalBalance()
	    {
			String balnceText = totalBalanceLabelFactoryWE.getText();
			
			assertEquals(balnceText, "$350","les element ne sont pas égaux");
	    }
	    
	    public void verifierCréditAvailable()
	    {

	    	String créditAvailable=créditAvailableFactoryWE.getText();
			Assert.assertEquals(créditAvailable, "$17,800","not equals");
	    }
	    
	    public void verifierDueToday()
	    {
	    	String dueToday=DueTodayFactoryEW.getText();
	    	Assert.assertEquals(dueToday, "$180","les elements ne sont pas egaux");
	    }
	    
}
