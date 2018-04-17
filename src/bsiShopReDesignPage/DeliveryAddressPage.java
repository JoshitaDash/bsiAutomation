package bsiShopReDesignPage;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import bsiShopRedesignBase.BaseTest;
import bsiShopRedesignSprint1.MyProfile;
import utilities.CommonHelper;
import utilities.Page;

public class DeliveryAddressPage extends Page {

	public DeliveryAddressPage(WebDriver driver) throws Exception {
		super(driver);
		// BaseTest.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void addNewDeliveryAddress() {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			// Thread.sleep(3000);
			Log.info("Click on Add new Delivery Address");
			System.out.println("Click on Add new Delivery Address");
			test.log(LogStatus.INFO, "Click on Add new Delivery Address");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("> Add new delivery address")));
			driver.findElement(By.linkText("> Add new delivery address")).click();

			Thread.sleep(2000);
			Log.info("Adding Delivery Address Details");
			System.out.println("Adding Delivery Address Details");

			Thread.sleep(1000);
			System.out.println("Enter Address Name");
			test.log(LogStatus.INFO, "Enter Address Name");
			String randomString = RandomStringUtils.randomAlphabetic(5);
			String uniqueAddressName = "Reg Unique Name" + randomString;
			driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(uniqueAddressName);

			Thread.sleep(1000);
			System.out.println("Enter Title");
			test.log(LogStatus.INFO, "Enter Title");
			Select titleDpdwn = new Select(driver.findElement(By.id("prefix")));
			titleDpdwn.selectByIndex(1);

			Thread.sleep(1000);
			System.out.println("Enter First Name");
			test.log(LogStatus.INFO, "Enter First Name");
			driver.findElement(By.id("register-name"))
					.sendKeys("Reg First Name");

			Thread.sleep(1000);
			System.out.println("Enter Last Name");
			test.log(LogStatus.INFO, "Enter Last Name");
			driver.findElement(By.id("register-last-name")).sendKeys("Reg Last Name");

			/*Thread.sleep(1000);
			System.out.println("Enter Company Name");
			test.log(LogStatus.INFO, "Enter Company Name");
			driver.findElement(By.id("register-company-name")).sendKeys("Reg Company Name");*/

			Thread.sleep(1000);
			System.out.println("Enter Telephone Number");
			test.log(LogStatus.INFO, "Enter Telephone Number");
			driver.findElement(By.id("register-phn-no")).sendKeys("123456790");

			Thread.sleep(1000);
			System.out.println("Enter Fax Number");
			test.log(LogStatus.INFO, "Enter Fax Number");
			driver.findElement(By.id("fax")).sendKeys("0123456789");

			/*Thread.sleep(1000);
			System.out.println("Enter Street Address");
			test.log(LogStatus.INFO, "Enter Street Address");
			driver.findElement(By.id("street-address")).sendKeys("London Street");

			Thread.sleep(1000);
			System.out.println("Enter City");
			test.log(LogStatus.INFO, "Enter City");
			driver.findElement(By.id("city")).sendKeys("London");

			Thread.sleep(1000);
			System.out.println("Enter State");
			test.log(LogStatus.INFO, "Enter State");
			driver.findElement(By.id("region")).sendKeys("England");*/

			Thread.sleep(1000);
			System.out.println("Enter Postal Code");
			test.log(LogStatus.INFO, "Enter Postal Code");
			driver.findElement(By.id("postal-code")).sendKeys("AA11AA");

			Thread.sleep(3000);
			System.out.println("Click Submit");
			test.log(LogStatus.INFO, "Enter Submit");
			driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();
			test.log(LogStatus.PASS, "Adding Delivery Address has been added successfully");

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Add New Delivery address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void makeDefaultDeliveryAddress() {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			boolean makeDefault = CommonHelper
					.checkVisibility(By.xpath("//*[@id='dash-address']/div/div[2]/div/ol/li/div/div[1]/a/span"));

			if (makeDefault) {
				Log.info("Click on Make Default Delivery Address");
				System.out.println("Click on Make Default Delivery Address");
				test.log(LogStatus.INFO, "Click on Make Default Delivery Address");
				driver.findElement(By.xpath("//*[@id='dash-address']/div/div[2]/div/ol/li/div/div[1]/a/span")).click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Make Default Delivery Address was successful");

			} else {
				Log.info("Click on Add new Delivery Address");
				System.out.println("Click on Add new Delivery Address");
				test.log(LogStatus.INFO, "Click on Add new Delivery Address");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("> Add new delivery address")));
				driver.findElement(By.linkText("> Add new delivery address")).click();

				Thread.sleep(2000);
				Log.info("Adding Delivery Address Details");
				System.out.println("Adding Delivery Address Details");

				Thread.sleep(1000);
				System.out.println("Enter Address Name");
				test.log(LogStatus.INFO, "Enter Address Name");
				String randomString = RandomStringUtils.randomAlphabetic(5);
				String uniqueAddressName = "Reg Unique Name" + randomString;
				driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(uniqueAddressName);

				Thread.sleep(1000);
				System.out.println("Enter Title");
				test.log(LogStatus.INFO, "Enter Title");
				Select titleDpdwn = new Select(driver.findElement(By.id("register-select-gender")));
				titleDpdwn.selectByIndex(1);

				Thread.sleep(1000);
				System.out.println("Enter First Name");
				test.log(LogStatus.INFO, "Enter First Name");
				driver.findElement(By.cssSelector("input[id='register-name'][name='firstname']"))
						.sendKeys("Reg First Name");

				Thread.sleep(1000);
				System.out.println("Enter Last Name");
				test.log(LogStatus.INFO, "Enter Last Name");
				driver.findElement(By.id("register-last-name")).sendKeys("Reg Last Name");

				Thread.sleep(1000);
				System.out.println("Enter Company Name");
				test.log(LogStatus.INFO, "Enter Company Name");
				driver.findElement(By.id("register-company-name")).sendKeys("Reg Company Name");

				Thread.sleep(1000);
				System.out.println("Enter Telephone Number");
				test.log(LogStatus.INFO, "Enter Telephone Number");
				driver.findElement(By.id("register-phn-no")).sendKeys("123456790");

				Thread.sleep(1000);
				System.out.println("Enter Fax Number");
				test.log(LogStatus.INFO, "Enter Fax Number");
				driver.findElement(By.id("fax")).sendKeys("0123456789");

				Thread.sleep(1000);
				System.out.println("Enter Street Address");
				test.log(LogStatus.INFO, "Enter Street Address");
				driver.findElement(By.id("street-address")).sendKeys("London Street");

				Thread.sleep(1000);
				System.out.println("Enter City");
				test.log(LogStatus.INFO, "Enter City");
				driver.findElement(By.id("city")).sendKeys("London");

				Thread.sleep(1000);
				System.out.println("Enter State");
				test.log(LogStatus.INFO, "Enter State");
				driver.findElement(By.id("region")).sendKeys("England");

				Thread.sleep(1000);
				System.out.println("Enter Postal Code");
				test.log(LogStatus.INFO, "Enter Postal Code");
				driver.findElement(By.id("postal-code")).sendKeys("456789");

				Thread.sleep(3000);
				System.out.println("Click Submit");
				test.log(LogStatus.INFO, "Click Submit");
				driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();

				Log.info("Click on Make Default Delivery Address");
				System.out.println("Click on Make Default Delivery Address");
				test.log(LogStatus.INFO, "Click on Make Default Delivery Address");
				driver.findElement(By.xpath("//*[@id='dash-address']/div/div[2]/div/ol/li/div/div[1]/a/span")).click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Make Default Delivery Address was successful");

			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Make Default Delivery Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void editDeliveryAddress() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			boolean editDelivery = CommonHelper
					.checkVisibility(By.xpath(".//*[@id='dash-address']/div/div[2]/div/ol/li/div/div[2]/a/span[2]"));
			boolean editDefaultDelivery = CommonHelper.checkVisibility(By.cssSelector(".action.edit>span"));

			if (editDelivery) {

				Log.info("Click on Edit Delivery Address");
				System.out.println("Click on Edit Delivery Address");
				test.log(LogStatus.INFO, "Click on Edit Delivery Address");
				// driver.findElement(By.cssSelector(".pr5p.item.actions>a>span")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='dash-address']/div/div[2]/div/ol/li/div/div[2]/a/span[2]"))).click();

				Thread.sleep(2000);
				Log.info("Editing Delivery Address Details");
				System.out.println("Editing Delivery Address Details");

				Thread.sleep(1000);
				System.out.println("Edit Address Name");
				test.log(LogStatus.INFO, "Edit Address Name");
				wait.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.cssSelector("input[name='unique_name']"))));
				driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Title");
				test.log(LogStatus.INFO, "Edit Title");
				Select titleDpdwn = new Select(driver.findElement(By.cssSelector("select[class*='selectgender']")));
				titleDpdwn.selectByIndex(1);

				Thread.sleep(1000);
				System.out.println("Edit First Name");
				test.log(LogStatus.INFO, "Edit First Name");
				driver.findElement(By.cssSelector("input[id='register-name'][name='firstname']")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Last Name");
				test.log(LogStatus.INFO, "Edit Last Name");
				driver.findElement(By.id("register-last-name")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Company Name");
				test.log(LogStatus.INFO, "Edit Company Name");
				driver.findElement(By.id("register-company-name")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Telephone Number");
				test.log(LogStatus.INFO, "Edit Telephone Number");
				driver.findElement(By.id("register-phn-no")).sendKeys("0123456789");

				Thread.sleep(1000);
				System.out.println("Edit Fax Number");
				test.log(LogStatus.INFO, "Edit Fax Number");
				driver.findElement(By.id("fax")).sendKeys("9874563210");

				Thread.sleep(1000);
				System.out.println("Edit Street Address");
				test.log(LogStatus.INFO, "Edit Street Address");
				driver.findElement(By.id("street-address")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit City");
				test.log(LogStatus.INFO, "Edit City");
				driver.findElement(By.id("city")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit State");
				test.log(LogStatus.INFO, "Edit State");
				driver.findElement(By.id("region")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Postal Code");
				test.log(LogStatus.INFO, "Edit Postal Code");
				driver.findElement(By.id("postal-code")).sendKeys("258852");

				Thread.sleep(3000);
				System.out.println("Click Submit");
				test.log(LogStatus.INFO, "Edit Submit");
				driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();
				test.log(LogStatus.PASS, "Delivery Addresses has been edited successfully");

			}

			else if (editDefaultDelivery) {

				Log.info("Click on Edit Delivery Address");
				System.out.println("Click on Edit Delivery Address");
				test.log(LogStatus.INFO, "Click on Edit Delivery Address");
				wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath(".//*[@id='dash-address']/div/div[1]/div/div[4]/div[2]/div/div[1]/a/span"))).click();

				Thread.sleep(2000);
				Log.info("Editing Default Delivery Address Details");
				test.log(LogStatus.INFO, "Editing Default Delivery Address Details");
				System.out.println("Editing Default Delivery Address Details");

				Thread.sleep(1000);
				System.out.println("Edit Address Name");
				test.log(LogStatus.INFO, "Edit Address Name");
				driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Title");
				test.log(LogStatus.INFO, "Edit Title");
				Select titleDpdwn = new Select(driver.findElement(By.id("register-select-gender")));
				titleDpdwn.selectByIndex(1);

				Thread.sleep(1000);
				System.out.println("Edit First Name");
				test.log(LogStatus.INFO, "Edit First Name");
				driver.findElement(By.cssSelector("input[id='register-name'][name='firstname']")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Last Name");
				test.log(LogStatus.INFO, "Edit Last Name");
				driver.findElement(By.id("register-last-name")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Company Name");
				test.log(LogStatus.INFO, "Edit Company Name");
				driver.findElement(By.id("register-company-name")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Telephone Number");
				test.log(LogStatus.INFO, "Edit Telephone Number");
				driver.findElement(By.id("register-phn-no")).sendKeys("0123456789");

				Thread.sleep(1000);
				System.out.println("Edit Fax Number");
				test.log(LogStatus.INFO, "Edit Fax Number");
				driver.findElement(By.id("fax")).sendKeys("9874563210");

				Thread.sleep(1000);
				System.out.println("Edit Street Address");
				test.log(LogStatus.INFO, "Edit Street Address");
				driver.findElement(By.id("street-address")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit City");
				test.log(LogStatus.INFO, "Edit City");
				driver.findElement(By.id("city")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit State");
				test.log(LogStatus.INFO, "Edit State");
				driver.findElement(By.id("region")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Postal Code");
				test.log(LogStatus.INFO, "Edit Postal Code");
				driver.findElement(By.id("postal-code")).sendKeys("258852");

				Thread.sleep(3000);
				System.out.println("Click Submit");
				test.log(LogStatus.INFO, "Click Submit");
				driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();
				test.log(LogStatus.PASS, "Delivery Addresses has been edited successfully");
			}

			else {
				test.log(LogStatus.INFO, "No Edit option present for Delivery Address");
				System.out.println("No Edit option present for Delivery Address");
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Edit Delivery Address was unsuccessful");
			Assert.fail(e.getMessage());
		}

	}

	public void deleteDeliveryAddress() {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
			Thread.sleep(3000);
			boolean deleteAddress = CommonHelper.checkVisibility(By.cssSelector(".action.delete>span"));

			if (deleteAddress) {
				Log.info("Click on Delete Delivery Address");
				System.out.println("Click on Delete Delivery Address");
				test.log(LogStatus.INFO, "Click on Delete Delivery Address");
				driver.findElement(By.cssSelector(".action.delete>span")).click();

				Thread.sleep(2000);
				Log.info("Click on Confirm Delete Delivery Address");
				System.out.println("Click on Confirm Delete Delivery Address");
				test.log(LogStatus.INFO, "Click on Confirm Delete Delivery Address");
				driver.findElement(By.cssSelector(".action-primary.action-accept")).click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Delivery Address has been deleted successfully");

			} else {

				Thread.sleep(3000);
				Log.info("Click on Add new Delivery Address");
				System.out.println("Click on Add new Delivery  Address");
				test.log(LogStatus.INFO, "Click on Add new Delivery  Address");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("> Add new delivery address")));
				driver.findElement(By.linkText("> Add new delivery address")).click();

				Thread.sleep(2000);
				Log.info("Adding Delivery Address Details");
				System.out.println("Adding Delivery Address Details");

				Thread.sleep(1000);
				System.out.println("Enter Address Name");
				test.log(LogStatus.INFO, "Enter Address Name");
				driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys("Reg Unique Name");

				Thread.sleep(1000);
				System.out.println("Enter Title");
				test.log(LogStatus.INFO, "Enter Title");
				Select titleDpdwn = new Select(driver.findElement(By.id("register-select-gender")));
				titleDpdwn.selectByIndex(1);

				Thread.sleep(1000);
				System.out.println("Enter First Name");
				test.log(LogStatus.INFO, "Enter First Name");
				driver.findElement(By.cssSelector("input[id='register-name'][name='firstname']"))
						.sendKeys("Reg First Name");

				Thread.sleep(1000);
				System.out.println("Enter Last Name");
				test.log(LogStatus.INFO, "Enter Last Name");
				driver.findElement(By.id("register-last-name")).sendKeys("Reg Last Name");

				Thread.sleep(1000);
				System.out.println("Enter Company Name");
				test.log(LogStatus.INFO, "Enter Company Name");
				driver.findElement(By.id("register-company-name")).sendKeys("Reg Company Name");

				Thread.sleep(1000);
				System.out.println("Enter Telephone Number");
				test.log(LogStatus.INFO, "Enter Telephone Number");
				driver.findElement(By.id("register-phn-no")).sendKeys("123456790");

				Thread.sleep(1000);
				System.out.println("Enter Fax Number");
				test.log(LogStatus.INFO, "Enter Fax Number");
				driver.findElement(By.id("fax")).sendKeys("0123456789");

				Thread.sleep(1000);
				System.out.println("Enter Street Address");
				test.log(LogStatus.INFO, "Enter Street Address");
				driver.findElement(By.id("street-address")).sendKeys("London Street");

				Thread.sleep(1000);
				System.out.println("Enter City");
				test.log(LogStatus.INFO, "Enter City");
				driver.findElement(By.id("city")).sendKeys("London");

				Thread.sleep(1000);
				System.out.println("Enter State");
				test.log(LogStatus.INFO, "Enter State");
				driver.findElement(By.id("region")).sendKeys("England");

				Thread.sleep(1000);
				System.out.println("Enter Postal Code");
				test.log(LogStatus.INFO, "Enter Postal Code");
				driver.findElement(By.id("postal-code")).sendKeys("456789");

				Thread.sleep(3000);
				System.out.println("Click Submit");
				test.log(LogStatus.INFO, "Click Submit");
				driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();

				Thread.sleep(3000);
				Log.info("Click on Delete Delivery Address");
				System.out.println("Click on Delete Delivery Address");
				test.log(LogStatus.INFO, "Click on Delete Delivery Address");
				driver.findElement(By.cssSelector(".action.delete>span")).click();

				Thread.sleep(2000);
				Log.info("Click on Confirm Delete Delivery Address");
				System.out.println("Click on Confirm Delete Delivery Address");
				test.log(LogStatus.INFO, "Click on Confirm Delete Delivery Address");
				driver.findElement(By.cssSelector(".action-primary.action-accept")).click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Delivery Address has been deleted successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Delete Delivery Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void addTenNewDeliveryAddress() {
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try {

			for (int i = 1; i <= 9; i++) {
				Thread.sleep(3000);
				Log.info("Click on Add new Delivery Address");
				System.out.println("Click on Add new Delivery Address");
				test.log(LogStatus.INFO, "Click on Add new Delivery Address");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("> Add new delivery address")));
				driver.findElement(By.linkText("> Add new delivery address")).click();

				Thread.sleep(2000);
				Log.info("Adding Delivery Address Details");
				System.out.println("Adding Delivery Address Details");

				Thread.sleep(1000);
				System.out.println("Enter Address Name");
				test.log(LogStatus.INFO, "Enter Address Name");
				String randomString = RandomStringUtils.randomAlphabetic(5);
				String uniqueAddressName = "Reg Unique Name" + randomString;
				driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(uniqueAddressName);

				Thread.sleep(1000);
				System.out.println("Enter Title");
				test.log(LogStatus.INFO, "Enter Title");
				Select titleDpdwn = new Select(driver.findElement(By.id("register-select-gender")));
				titleDpdwn.selectByIndex(1);

				Thread.sleep(1000);
				System.out.println("Enter First Name");
				test.log(LogStatus.INFO, "Enter First Name");
				driver.findElement(By.cssSelector("input[id='register-name'][name='firstname']"))
						.sendKeys("Reg First Name");

				Thread.sleep(1000);
				System.out.println("Enter Last Name");
				test.log(LogStatus.INFO, "Enter Last Name");
				driver.findElement(By.id("register-last-name")).sendKeys("Reg Last Name");

				Thread.sleep(1000);
				System.out.println("Enter Company Name");
				test.log(LogStatus.INFO, "Enter Company Name");
				driver.findElement(By.id("register-company-name")).sendKeys("Reg Company Name");

				Thread.sleep(1000);
				System.out.println("Enter Telephone Number");
				test.log(LogStatus.INFO, "Enter Telephone Number");
				driver.findElement(By.id("register-phn-no")).sendKeys("123456790");

				Thread.sleep(1000);
				System.out.println("Enter Fax Number");
				test.log(LogStatus.INFO, "Enter Fax Number");
				driver.findElement(By.id("fax")).sendKeys("0123456789");

				Thread.sleep(1000);
				System.out.println("Enter Street Address");
				test.log(LogStatus.INFO, "Enter Street Address");
				driver.findElement(By.id("street-address")).sendKeys("London Street");

				Thread.sleep(1000);
				System.out.println("Enter City");
				test.log(LogStatus.INFO, "Enter City");
				driver.findElement(By.id("city")).sendKeys("London");

				Thread.sleep(1000);
				System.out.println("Enter State");
				test.log(LogStatus.INFO, "Enter State");
				driver.findElement(By.id("region")).sendKeys("England");

				Thread.sleep(1000);
				System.out.println("Enter Postal Code");
				test.log(LogStatus.INFO, "Enter Postal Code");
				driver.findElement(By.id("postal-code")).sendKeys("456789");

				Thread.sleep(3000);
				System.out.println("Click Submit");
				test.log(LogStatus.INFO, "Click Submit");
				driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();

			}
			Thread.sleep(1000);
			String tenDeliveryMsg = driver.findElement(By.xpath("//*[@id='dash-address']/div/div[3]/div")).getText();
			System.out.println("The Delivery Address message is: " + tenDeliveryMsg);
			Log.info("The Delivery Address message is: " + tenDeliveryMsg);
			test.log(LogStatus.PASS, tenDeliveryMsg);

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Adding Ten Delivery Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void deleteTenDeliveryAddress() {

		// WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			Thread.sleep(3000);
			boolean deleteAddress = CommonHelper.checkVisibility(By.cssSelector(".action.delete>span"));

			if (deleteAddress) {

				for (int i = 1; i <= 9; i++) {
					Log.info("Click on Delete Delivery Address");
					System.out.println("Click on Delete Delivery Address");
					test.log(LogStatus.INFO, "Click on Delete Delivery Address");
					// driver.findElement(By.cssSelector(".action.delete>span")).click();
					// CommonHelper.clickByJS("deleteDeliveryAddress_css");
					click("deleteDeliveryAddress_css");

					Thread.sleep(2000);
					Log.info("Click on Confirm Delete Delivery Address");
					System.out.println("Click on Confirm Delete Delivery Address");
					test.log(LogStatus.INFO, "Click on Confirm Delete Delivery Address");
					driver.findElement(By.cssSelector(".action-primary.action-accept")).click();
					Thread.sleep(2000);
				}

				test.log(LogStatus.PASS, "Ten Delivery Addresses has been deleted successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Delete Ten Delivery Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

}
