package julien.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SeleniumTest{

	private WebDriver driver;
	private String sBrowser = "";
	private String sRemoteAddress = "";

	@BeforeTest
	public void setUp(ITestContext context) throws MalformedURLException {
		
		//See testng_chrome.xml
		String sRemoteAddress = context.getCurrentXmlTest().getParameter("selenium.remoteAddress");
		ChromeOptions browserOptions = new ChromeOptions();
		driver = new RemoteWebDriver(new URL(sRemoteAddress), browserOptions);
	}

	@AfterTest
	public void tearDown() throws Exception {
	    
		if (driver != null) {
		      driver.quit();
		}
		
	}

	@Test(invocationCount=1)
	public void timeoutTest() {

	    for (int i = 0; i < 2000; i++)
	    {
	      System.out.println(i);

	      driver.get("http://www.google.com");
		  driver.getWindowHandle();
	      driver.getCurrentUrl();
	      driver.getTitle();
		  driver.manage().timeouts().getScriptTimeout();
	    }
	}
}
