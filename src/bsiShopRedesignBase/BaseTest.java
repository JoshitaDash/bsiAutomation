package bsiShopRedesignBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.LogStatus;

import utilities.Page;
import utilities.Xls_Reader;

public class BaseTest extends Page {

	public BaseTest() throws Exception {
		super(driver);
	}

	public static String browser;
	String url = "https://qa4-5rxefly-7redg7uykvdko.eu.magentosite.cloud/";
	//String url = "https://staging-standards.bsigroup.com/";
	public Xls_Reader xls = new Xls_Reader(
			"D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls");

	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	// *** Passing Browser parameter from TestNG xml
	public void launchBrowser(String browser) throws InterruptedException, IOException {

		try {
			DOMConfigurator.configure("log4j.xml");

			if (browser.equalsIgnoreCase("Chrome")) {

				Log.info("Launching Chrome browser");
				System.out.println("Launching Chrome browser");

				// **** setting up the path for my ChromeDriver
				String projectPath = System.getProperty("user.dir");
				System.setProperty("webdriver.chrome.driver", projectPath + "\\lib\\chromedriver.exe");		
				driver = new ChromeDriver();
				// driver.manage().deleteAllCookies();
				Thread.sleep(1000);
				driver.manage().window().maximize();

				extent.addSystemInfo("User Name", "TCS").addSystemInfo("Host Name", "TCS")
						.addSystemInfo("Selenium Version", "3.8.0").addSystemInfo("Environment", url)
						.addSystemInfo("Browser", "Chrome 63.0.3");

			}

			else if (browser.equalsIgnoreCase("IE")) {

				DesiredCapabilities cap = null;
				System.setProperty("webdriver.ie.driver",
						"D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\lib\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
				cap = DesiredCapabilities.internetExplorer();
				cap.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
				cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
				cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability("allow-blocked-content", true);
				cap.setCapability("allowBlockedContent", true);
				driver = new InternetExplorerDriver(cap);
				driver.manage().window().maximize();

				extent.addSystemInfo("User Name", "TCS").addSystemInfo("Host Name", "TCS")
						.addSystemInfo("Selenium Version", "3.8.0").addSystemInfo("Environment", url)
						.addSystemInfo("Browser", "Internet Explorer 11");

			} else if (browser.equalsIgnoreCase("Firefox")) {

				Log.info("Launching Firefox browser");
				System.out.println("Launching Firefox browser");

				// ****** setting up the path for my FirefoxDriver
				String projectPath = System.getProperty("user.dir");
				System.setProperty("webdriver.gecko.driver", projectPath + "\\lib\\geckodriver.exe");
				driver = new FirefoxDriver();
				Thread.sleep(2000);
				driver.manage().window().maximize();

				extent.addSystemInfo("User Name", "TCS").addSystemInfo("Host Name", "TCS")
						.addSystemInfo("Selenium Version", "3.8.0").addSystemInfo("Environment", url)
						.addSystemInfo("Browser", "Mozilla Firefox 57.0.1");

			} else if (driver == null) {
				System.out.println("The tescase is skipped");
				test.log(LogStatus.SKIP, "The tescase is skipped");
			}

			// ****** Doesn't the browser type, launch the Website
			System.out.println("Fetching the URL");
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@AfterClass
	// @AfterSuite
	public void extentQuit() {
		if (extent != null) {
			extent.endTest(test);
			System.out.println("Extent Report test ended");
			extent.flush();
		}
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		if (driver != null) {
			Log.info("Close Browser");
			System.out.println("Close Browser");
			driver.close();
			// driver.quit();
		}
		try {
			Thread.sleep(2000);
			if (driver.toString().contains("InternetExplorerDriver")) {
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			}
			if (driver.toString().contains("geckodriver")) {
				Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void quit() throws InterruptedException {
		if (driver != null) {
			Log.info("Quit Browser");
			System.out.println("Quit Driver");
			driver.quit();
		}

	}

	@BeforeSuite
	public WebDriver getDriverInstance() {
		return driver;
	}

}