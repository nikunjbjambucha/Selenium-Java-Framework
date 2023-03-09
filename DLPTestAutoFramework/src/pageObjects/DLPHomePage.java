package pageObjects;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Base.basepage;
import junit.framework.Assert;

public class DLPHomePage extends basepage{
	
	public DLPHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.ID, using = "navbarDropdown") 
	private WebElement MordernUploadMethods;
	
	
	public void Search_collection() {	
		Assert.assertTrue(MordernUploadMethods.isDisplayed());
		MordernUploadMethods.click();	
	}
}
