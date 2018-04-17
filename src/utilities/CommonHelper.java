package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import bsiShopRedesignBase.BaseTest;

public class CommonHelper extends Page {

	public CommonHelper() throws Exception {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static boolean checkVisibility(By by) {
		try {
			driver.findElement((by)).isDisplayed();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void takeScreenShot() {

		String userDir = System.getProperty("user.dir");
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = userDir + "//reports//screenshots//" + screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	}

	public static void reportFailure(String failureMessage) {
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
	}

	public static boolean isNull(String var) {

		try {
			if (var.equals(null)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return true;
		}
	}

	public static String readPropertiesFile(String value) throws IOException {
		String result = null;
		try {
			FileReader reader;
			// String userdir = System.getProperty("user.dir");
			// reader = new FileReader(userdir +
			// "\\TestData\\TestData.properties");
			reader = new FileReader("C:\\Users\\529373\\Desktop\\BSI Automation Demo\\TestData.properties");
			Properties p = new Properties();
			p.load(reader);

			result = p.getProperty(value);

		} catch (FileNotFoundException e) {
			reportFailure("Test Data path not found");
			e.printStackTrace();

		}
		return result;
	}

	public static WebElement element(String locator) {
		WebElement e = null;
		if (locator.endsWith("_xpath"))
			e = driver.findElement(By.xpath(prop.getProperty(locator)));
		else if (locator.endsWith("_id"))
			e = driver.findElement(By.id(prop.getProperty(locator)));
		else if (locator.endsWith("_css"))
			e = driver.findElement(By.cssSelector(prop.getProperty(locator)));
		else if (locator.endsWith("_linkText"))
			e = driver.findElement(By.linkText(prop.getProperty(locator)));

		return e;

	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static List<WebElement> getElements(String locator) {

		List<WebElement> elementList = null;

		if (locator.endsWith("_xpath"))
			elementList = (driver.findElements(By.xpath(prop.getProperty(locator))));
		else if (locator.endsWith("_id"))
			elementList = driver.findElements(By.id(prop.getProperty(locator)));
		else if (locator.endsWith("_css"))
			elementList = driver.findElements(By.cssSelector(prop.getProperty(locator)));
		else if (locator.endsWith("_linkText"))
			elementList = driver.findElements(By.linkText(prop.getProperty(locator)));

		return elementList;
	}

	public static int getElementsSize(String locator) {

		List<WebElement> elementList = null;
		if (locator.endsWith("_xpath"))
			elementList = (driver.findElements(By.xpath(prop.getProperty(locator))));
		else if (locator.endsWith("_id"))
			elementList = driver.findElements(By.id(prop.getProperty(locator)));
		else if (locator.endsWith("_css"))
			elementList = driver.findElements(By.cssSelector(prop.getProperty(locator)));
		else if (locator.endsWith("_linkText"))
			elementList = driver.findElements(By.linkText(prop.getProperty(locator)));
		int noOfElements = elementList.size();

		return noOfElements;
	}

	public static void scrolltoview(String locator) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", element(locator));
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, locator + " Unable to perform scroll to view");
		}

	}

	public static void clickJS(WebElement webElement) {
		try {
			if (webElement.isDisplayed() && webElement.isEnabled()) {
				// WebElement element = driver.findElement((By) (webElement));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", webElement);
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, webElement + " WebElement not found for ClickByJS");
		}
	}

	public static void clickByJS(String locator) {
		try {
			clickJS(element(locator));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, locator + " Unable to perform ClickByJS");
			e.printStackTrace();
		}
	}

	public static void explicitWaitClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void elementToBeClickable(String locator) {
		try {
			explicitWaitClickable(element(locator));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, locator + " Element not Clickable");
			e.printStackTrace();
		}
	}

	public static void explicitWaitVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			// wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.visibilityOfElementLocated((By)element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void elementToBeVisible(String locator) {
		try {
			explicitWaitVisible(element(locator));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, locator + " Element not Visible after Wait");
			e.printStackTrace();
		}
	}

	public static void visibilityOfElement(WebElement element) throws Exception {
		element.isDisplayed();
		element.isEnabled();
	}

	public static boolean isVisisble(String locator) {
		try {
			visibilityOfElement(element(locator));
			return true;
		} catch (Exception e) {
			// test.log(LogStatus.FAIL, locator + " Element is not Visible");
			e.printStackTrace();
			return false;
		}

	}
	
	public static String windowHandle()
	{
		try{

			String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;

			Set<String> handles = driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
			    subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler); // switch to pop-up window
			driver.manage().window().maximize();
			

		}catch(Exception e){

			return null;
		}
		return null;
	} 
}
