package bsiShopRedesignSprint4and5;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import bsiShopReDesignPage.MyProfileMemberPage;
import bsiShopRedesignBase.BaseTest;
import bsiShopRedesignBase.SignInPage;

public class VerifyMemberProfile extends BaseTest{

	public VerifyMemberProfile() throws Exception{
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signInMember() {

		try {
			test = extent.startTest("Sprint 4&5 - Member User Sign In");
			System.out.println("Member Signing In");
			Log.info("Member Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.memberNewLogin();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Member Signing in was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void verifyMemberTab() {

		test = extent.startTest("Sprint 4&5 - Verify Member Member Tab");
		try {
			//test = extent.startTest("Click on Member Tab");
			System.out.println("Click on Member Tab");
			Log.info("Click on Member Tab");
			MyProfileMemberPage mem = new MyProfileMemberPage(driver);
			mem.clickMemberTab();
			
			System.out.println("Verify Member Number");
			Log.info("Verify Member Number");
			mem.verifyMemberNumber();
			
			System.out.println("Verify Member Expiry Date");
			Log.info("Verify Member Expiry Date");
			mem.verifyMemberExpDate();

			//test = extent.startTest("Verify Member Account");
			System.out.println("Verify Member Status");
			Log.info("Verify Member Status");
			mem.verifyMemberStatus();
			
			System.out.println("Verify Member Credit Amount");
			Log.info("Verify Member Credit Amount");
			mem.verifyMemberCreditAmnt();

			//test = extent.startTest("Click Logout");
			System.out.println("Click Logout");
			Log.info("Click Logout");
			mem.clickLogout();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify Member tab was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
