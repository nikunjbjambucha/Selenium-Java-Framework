import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.chrome.ChromeOptions;
import Base.*;
import dataProvider.ConfigFileReader;
import pageObjects.*;

public class TestRunner extends baseclass{

	static ConfigFileReader configFileReader= new ConfigFileReader();;	
	public static String url = configFileReader.getPropertyvalue("url");
	public static String chromePath = configFileReader.getPropertyvalue("chromedriverPath");
	
	@BeforeClass
	public static void TestInitialize() {
		ExtentManager();
	}
	
	public static void OpenBrowser(BrowserType browserType) {
		switch (browserType) {
			
			case Chrome:
				// declaration and chromedriver
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
				System.setProperty("webdriver.chrome.driver",chromePath);
				driver = new ChromeDriver(option);
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		        System.out.println("Browser has been opened");
		        test.log(LogStatus.PASS, "Open Browser", "Browser has been opened ");
		}
		
	}
	
	@Test
	public void test1() 
	{
		try
		{
			test = extent.startTest("Test case 1");
			OpenBrowser(BrowserType.Chrome);
            GotoUrl(url);     
            currentpage.GetInstance(DLPHomePage.class).Search_collection();
            
            System.out.println("Test Completed successfully");
    		test.log(LogStatus.PASS, "Test case 1", "Pass");
            
		}
		
		catch(Exception ex) 
		{
			ex.toString();
            System.out.println("Test case got failed as: "+ex);
            test.log(LogStatus.FAIL, "Test case got fail", ex);
		}
		
		
	}
	
	@Test
	public void test2() 
	{
		try
		{
			test = extent.startTest("Test case 2");
			OpenBrowser(BrowserType.Chrome);
            GotoUrl(url);     
            currentpage.GetInstance(DLPHomePage.class).Search_collection();
            
            System.out.println("Test Completed successfully");
    		test.log(LogStatus.PASS, "Test case 2", "Pass");
            
		}
		
		catch(Exception ex) 
		{
			ex.toString();
            System.out.println("Test case got failed as: "+ex);
            test.log(LogStatus.FAIL, "Test case got fail", ex);
		}
		
		
	}

	
	@After
	public void TeardownTest() {	
		//Close the driver
		driver.close();
		driver.quit();
		extent.endTest(test);
	}
	
	@AfterClass
	public static void ClassCleanup() {	
		extent.flush();
		extent.close();
	}
}
