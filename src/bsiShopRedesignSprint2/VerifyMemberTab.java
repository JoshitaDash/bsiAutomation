package bsiShopRedesignSprint2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import bsiShopReDesignPage.MyProfileMemberPage;
import bsiShopRedesignBase.BaseTest;
import bsiShopRedesignBase.SignInPage;

public class VerifyMemberTab extends BaseTest {

	public VerifyMemberTab() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signInMember() {

		try {
			test = extent.startTest("Sprint 2 - Member User Sign In");
			System.out.println("Member Signing In");
			Log.info("Member Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.memberLogin();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Member Signing in was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void verifyStatus() {

		test = extent.startTest("Sprint 2 - Verify Member Member Status");
		try {
			//test = extent.startTest("Click on Member Tab");
			System.out.println("Click on Member Tab");
			Log.info("Click on Member Tab");
			MyProfileMemberPage mem = new MyProfileMemberPage(driver);
			mem.clickMemberTab();
					
			System.out.println("Verify Member Status");
			Log.info("Verify Member Status");
			mem.verifyMemberStatus();	
			
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
