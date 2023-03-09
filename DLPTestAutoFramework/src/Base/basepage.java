package Base;

import org.bouncycastle.math.ec.ECFieldElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basepage extends Page{
	JavascriptExecutor js;
	public basepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	     js = (JavascriptExecutor) driver;
	}
	
	//Click Method
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }
    public void click (WebElement element) {
        element.click();
    }
    //Write Text
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }
    public void writeText (WebElement element, String text) {
    	element.sendKeys(text);
    }
    //Read Text
    public String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
    public String readText (WebElement element) {
        return element.getText();
    }
}
