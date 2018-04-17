package bsiShopRedesignSprint2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import bsiShopReDesignPage.BasketPage;
import bsiShopReDesignPage.EventPage;
import bsiShopReDesignPage.ProductPage;
import bsiShopRedesignBase.BaseTest;
import bsiShopRedesignBase.HomePage;
import bsiShopRedesignBase.SignInPage;
import utilities.CommonHelper;

public class StandardProductAndEventRemoveBasket extends BaseTest {

	public StandardProductAndEventRemoveBasket() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority = 1, enabled = true)
	public void signIn() {

		try {
			test = extent.startTest("Sprint 2 - Registered User Sign In");
			System.out.println("User Signing In");
			Log.info("User Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.login();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Signing in was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void BookPaidEventAndStandardProduct() {
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try {
			test = extent.startTest("Sprint 2 - Add Paid Event to Basket");
			// test = extent.startTest("Search Paid Event and Click Book Now");
			System.out.println("Search Paid Event");
			Log.info("Search Paid Event");
			EventPage event = new EventPage(driver);
			event.searchPaidEvent();

			// test = extent.startTest("Click Book Now for Paid Event");
			System.out.println("Click Book Now for Paid Event");
			Log.info("Click Book Now for Paid Event");
			event.bookPaidEvent();

			// test = extent.startTest("Add Delegate to Event");
			System.out.println("Add Delegate to Event");
			Log.info("Add Delegate to Event");
			event.clickAddDelegate();

			System.out.println("Add Delegate details to Event");
			Log.info("Add Delegate details to Event");
			event.addDelegateDetails();

			System.out.println("Add Event to Basket and View Basket");
			Log.info("Add Event to Basket and View Basket");
			event.addEventToBasket();

			Thread.sleep(3000);
			test = extent.startTest("Sprint 2 - Add Standard Product to Basket");
			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			test.log(LogStatus.INFO, "Enter product name in Search textbox");
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
			CommonHelper.elementToBeClickable("searchBox_id");
			search.clear();
			search.sendKeys("ASD-STAN prEN 9110:2016");

			Log.info("Click on Search");
			System.out.println("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			test.log(LogStatus.INFO, "Select the Product");
			WebElement product = driver.findElement(By.linkText("ASD-STAN prEN 9110:2016"));
			Thread.sleep(1000);
			product.click();

			Log.info("Select the Format");
			System.out.println("Select the Format");
			test.log(LogStatus.INFO, "Select the Format");
			ProductPage prod = new ProductPage(driver);
			prod.selectDefaultFormatAndAddToBasket();

			// test = extent.startTest("Remove Standard Product and Paid Event
			// from Basket");
			System.out.println("Remove Product and Event from Basket");
			test.log(LogStatus.INFO, "Remove Product and Event from Basket");
			Log.info("Remove Event from Basket");
			BasketPage basket = new BasketPage(driver);
			basket.removeProductAndEvent();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage reg = new HomePage(driver);
			reg.clickLogout();

		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Add and Remove Paid Event or Standard Product to Basket was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
