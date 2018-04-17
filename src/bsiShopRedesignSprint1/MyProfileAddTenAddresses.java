package bsiShopRedesignSprint1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import bsiShopReDesignPage.BillingAddressPage;
import bsiShopReDesignPage.DeliveryAddressPage;
import bsiShopRedesignBase.BaseTest;
import bsiShopRedesignBase.SignInPage;

public class MyProfileAddTenAddresses extends BaseTest {

	public MyProfileAddTenAddresses() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signIn() {

		try {
			test = extent.startTest("Sprint 1 - Registered User Sign In");
			System.out.println("User Signing In");
			Log.info("User Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.loginTenAddress();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Login unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void addTenBillingAddress() {

		try {
			test = extent.startTest("Sprint 1 - Add Ten Billing Address");
			System.out.println("Add Ten Billing Address");
			Log.info("Add Ten Billing Address");
			BillingAddressPage billTen = new BillingAddressPage(driver);
			billTen.addTenNewBillingAddress();

		}

		catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FATAL, "Billing Address addition was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = true)
	public void deleteTenBillingAddress() {

		try {
			test = extent.startTest("Sprint 1 - Delete Ten Billing Address");
			System.out.println("Delete Ten Billing Address");
			Log.info("Delete Ten Billing Address");
			BillingAddressPage billTen = new BillingAddressPage(driver);
			billTen.deleteTenBillingAddress();

		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FATAL, "Delete Ten Billing Address was unsuccessful");
			Assert.fail(e.getMessage());
		}

	}

	@Test(priority = 4, enabled = true)
	public void addTenDeliveryAddress() {

		try {
			test = extent.startTest("Sprint 1 - Add Ten Delivery Address");
			System.out.println("Add Ten Delivery Address");
			Log.info("Add Ten Delivery Address");
			DeliveryAddressPage deliveryTen = new DeliveryAddressPage(driver);
			deliveryTen.addTenNewDeliveryAddress();

		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Delviery Address addition was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 5, enabled = true)
	public void deleteTenDeliveryAddress() {

		try {
			test = extent.startTest("Sprint 1 - Delete Ten Delivery Address");
			System.out.println("Delete Ten Delivery Address");
			Log.info("Delete Ten Delivery Address");
			DeliveryAddressPage deliveryTen = new DeliveryAddressPage(driver);
			deliveryTen.deleteTenDeliveryAddress();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Delviery Address deletion was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
