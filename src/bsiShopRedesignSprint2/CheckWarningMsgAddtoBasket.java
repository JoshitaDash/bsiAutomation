package bsiShopRedesignSprint2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import bsiShopReDesignPage.ProductPage;
import bsiShopRedesignBase.BaseTest;
import utilities.CommonHelper;

public class CheckWarningMsgAddtoBasket extends BaseTest {

	public CheckWarningMsgAddtoBasket() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority = 1, enabled = true)
	public void checkWarningMsgPDF() {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try {

			test = extent.startTest("Sprint 2 - Add PDF Product twice to check warning message");
			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			test.log(LogStatus.INFO, "Enter product name in Search textbox");
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
			search.clear();
			search.sendKeys("BS 6070-1:1981");
			// search.sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			CommonHelper.elementToBeClickable("searchButton_id");
			click("searchButton_id");

			Log.info("Select the Product");
			System.out.println("Select the Product");
			test.log(LogStatus.INFO, "Select the Product");
			WebElement product = driver.findElement(By.linkText("BS 6070-1:1981"));
			String name = product.toString();
			CommonHelper.elementToBeClickable(name);
			product.click();

			// test = extent.startTest("Select PDF Format and Add to Basket
			// twice");
			test.log(LogStatus.INFO, "Select PDF Format and Add to Basket twice");
			Log.info("Select PDF Format and Add to Basket twice ");
			System.out.println("Select PDF Format and Add to Basket twice");
			ProductPage prod = new ProductPage(driver);
			prod.addPDFProductToBasket();

			// test = extent.startTest("Check warning message");
			test.log(LogStatus.INFO, "Check warning message");
			Log.info("Check warning message");
			System.out.println("Check warning message");
			prod.checkWarningMsg();

		} catch (Exception e) {
			CommonHelper.reportFailure("Adding same Product to Basket and checking warning message was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}