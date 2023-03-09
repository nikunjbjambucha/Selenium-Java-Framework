package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.microsoft.schemas.office.visio.x2012.main.TpType;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.meta.When;


public class baseclass {	
	public static WebDriver driver;
	
	public static String HTMLReportPath;
	public static ExtentReports extent;
    public static ExtentTest test;
    
	public static String datetime()
    {   Date date = new Date();
        String formattedTime = date.toString();
        String formattedTime1 = formattedTime.replace(" ", "_");
        formattedTime = formattedTime1.replace(":", "_");
        return formattedTime;
    }
	
	public static void ExtentManager() {
		String currentdatetime = datetime();
		
		HTMLReportPath = ".\\Reports\\AutomationTestReport" + "_" + currentdatetime + ".html";
		extent = new ExtentReports(HTMLReportPath, true, DisplayOrder.OLDEST_FIRST);
		extent.addSystemInfo("Host Name", "DLP Test Site").addSystemInfo("Environment", "BETA");
	}
	
	public Page currentpage;
	
	public void GotoUrl(String url) throws InterruptedException {
		Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(5000);
        currentpage = new Page(driver);
	}
	
	public enum BrowserType
	{
	    Chrome
	}
	
}
