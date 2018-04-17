package bsiShopRedesignBase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.seleniumhq.jetty9.util.log.Log;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.LogStatus;

import bsiShopRedesignSprint1.MyProfile;
import utilities.CommonHelper;
import utilities.Page;

public class SignInPage extends Page {

	static String pwd;
	static String newPwd;

	// String currentPassword;
	// String newPassword;
	public SignInPage(WebDriver driver) throws Exception {
		super(driver);
		// BaseTest.driver = driver;
	}

	public void login() {

		try {
			Thread.sleep(3000);
			System.out.println("Click on login link");
			Log.info("Click on login link");
			test.log(LogStatus.INFO, "Click on login link");
			CommonHelper.elementToBeVisible("loginLink_xpath");
			CommonHelper.elementToBeClickable("loginLink_xpath");
			click("loginLink_xpath");
			//CommonHelper.clickByJS("loginLink_xpath");
			Thread.sleep(2000);

			System.out.println("Enter Email ID");
			Log.info("Enter Email ID");
			test.log(LogStatus.INFO, "Enter Email ID");
			Thread.sleep(5000);
			// CommonHelper.elementToBeVisible("enterEmail_css");
			// CommonHelper.elementToBeClickable("enterEmail_css");
			// enterText("enterEmail_id", "testUser@tcs.com");
			//driver.findElement(By.id("email")).click();
			driver.findElement(By.id("bsi_email")).sendKeys("autoTest@tcs.com");
			
			/*try {
				JavascriptExecutor myExecutorEmail = ((JavascriptExecutor) driver);
				myExecutorEmail.executeScript("document.getElementById('email').setAttribute('value', 'testUser@tcs.com')");
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			

			Thread.sleep(2000);
			System.out.println("Enter Password");
			Log.info("Enter Password");
			test.log(LogStatus.INFO, "Enter Password");
			try {
				JavascriptExecutor myExecutorPwd = ((JavascriptExecutor) driver);
				myExecutorPwd.executeScript("document.getElementById('bsi_pass').setAttribute('value', 'Test@1234')");
			} catch (Exception e) {
				e.printStackTrace();
			}
			//WebElement pwd1 = driver.findElement(By.xpath("//*[@id='pass']"));
			//pwd = CommonHelper.readPropertiesFile("pwd");
			//pwd1.sendKeys(pwd);
			//System.out.println("The password is: " + pwd);
			

			Thread.sleep(2000);
			System.out.println("Click on SignIn button");
			Log.info("Click on SignIn button");
			test.log(LogStatus.INFO, "Click on SignIn button");
			click("loginButton_xpath");
			// CommonHelper.clickByJS("loginButton_xpath");
			Thread.sleep(3000);

			boolean isEMyprofileVisible = CommonHelper.isVisisble("myProfile_xpath");
			if (isEMyprofileVisible)
				test.log(LogStatus.PASS, "Login Successful");
			else
				CommonHelper.reportFailure("Login UnSuccessful");

		} catch (Exception e) {
			
			CommonHelper.reportFailure("Login UnSuccessful");
			e.printStackTrace();
		}

	}

	public void resetPwd() {

		try {

			Thread.sleep(2000);
			Log.info("Enter Current Password");
			System.out.println("Enter Current Password");
			test.log(LogStatus.INFO, "Enter Current Password");
			driver.findElement(By.id("current_password")).sendKeys(pwd);
			System.out.println("The current password is: " + pwd);

			Thread.sleep(2000);
			Log.info("Enter New Password");
			System.out.println("Enter New Password");
			test.log(LogStatus.INFO, "Enter New Password");
			newPwd = CommonHelper.readPropertiesFile("newPwd");
			driver.findElement(By.id("password")).sendKeys(newPwd);
			System.out.println("The new password is: " + newPwd);
			// newPassword=driver.findElement(By.id("password")).getText();

			Thread.sleep(2000);
			Log.info("Enter Confirm New Password");
			System.out.println("Enter Confirm New Password");
			test.log(LogStatus.INFO, "Enter Confirm New Password");
			driver.findElement(By.id("password_confirmation")).sendKeys(newPwd);
			System.out.println("The confirm password is: " + newPwd);

			Thread.sleep(2000);
			Log.info("Click Change Password");
			System.out.println("Click Change Password");
			test.log(LogStatus.INFO, "Click Change Password");
			CommonHelper.scrolltoview("changePwd_css");
			click("changePwd_css");
			test.log(LogStatus.PASS, "Reset Password was Successful");
			// driver.findElement(By.cssSelector("button[value='change_password']")).click();
			// pwd = newPwd;

			Thread.sleep(3000);
			Log.info("Click Logout");
			System.out.println("Click Logout");
			test.log(LogStatus.INFO, "Click Logout");
			CommonHelper.scrolltoview("logoutButton_xpath");
			driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/div/div[2]/div[1]/div[3]/a[4]"))
					.click();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Logout was Successful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Reset Password was UnSuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void loginTenAddress() {

		try {

			System.out.println("Click on login link");
			Log.info("Click on login link");
			test.log(LogStatus.INFO, "Click on login link");
			click("loginLink_xpath");

			System.out.println("Enter Email ID");
			Log.info("Enter Email ID");
			test.log(LogStatus.INFO, "Enter Email ID");
			enterText("enterEmail_id", "tenAddress@tcs.com");

			System.out.println("Enter Password");
			Log.info("Enter Password");
			test.log(LogStatus.INFO, "Enter Password");
			WebElement pwd1 = driver.findElement(By.xpath("//*[@id='pass']"));
			// pwd=readPropertiesFile("pwd");
			pwd1.sendKeys("Test@1234");
			String currentPassword = pwd1.getText();
			System.out.println("The password is: " + currentPassword);
			Thread.sleep(2000);

			System.out.println("Click on Login button");
			Log.info("Click on Login button");
			test.log(LogStatus.INFO, "Click on Login button");
			WebElement loginButton = driver.findElement(By.xpath("//*[@id='send2']/span"));
			loginButton.click();
			Thread.sleep(3000);

			WebElement myProfile = driver.findElement(By.xpath("//*[@id='profile']"));
			myProfile.isDisplayed();
			test.log(LogStatus.PASS, "Login Successful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Login UnSuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void memberLogin() {

		try {

			System.out.println("Click on login link");
			Log.info("Click on login link");
			test.log(LogStatus.INFO, "Click on login link");
			click("loginLink_xpath");

			System.out.println("Enter Email ID");
			Log.info("Enter Email ID");
			test.log(LogStatus.INFO, "Enter Email ID");
			enterText("enterEmail_id", "subhra_mem@tcs.com");

			System.out.println("Enter Password");
			Log.info("Enter Password");
			test.log(LogStatus.INFO, "Enter Password");
			WebElement pwd1 = driver.findElement(By.id("bsi_pass"));
			pwd = CommonHelper.readPropertiesFile("pwd");
			pwd1.sendKeys(pwd);
			System.out.println("The password is: " + pwd);

			Thread.sleep(2000);
			System.out.println("Click on SignIn button");
			Log.info("Click on SignIn button");
			test.log(LogStatus.INFO, "Click on SignIn button");
			click("loginButton_xpath");
			Thread.sleep(3000);

			CommonHelper.isVisisble("myProfile_xpath");
			test.log(LogStatus.PASS, "Login Successful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Login UnSuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}
	
	public void memberNewLogin() {

		try {

			System.out.println("Click on login link");
			Log.info("Click on login link");
			test.log(LogStatus.INFO, "Click on login link");
			click("loginLink_xpath");

			System.out.println("Enter Email ID");
			Log.info("Enter Email ID");
			test.log(LogStatus.INFO, "Enter Email ID");
			enterText("enterEmail_id", "subhrateja@rediffmail.com");

			System.out.println("Enter Password");
			Log.info("Enter Password");
			test.log(LogStatus.INFO, "Enter Password");
			WebElement pwd1 = driver.findElement(By.xpath("//*[@id='pass']"));
			pwd = CommonHelper.readPropertiesFile("pwd");
			pwd1.sendKeys(pwd);
			System.out.println("The password is: " + pwd);

			Thread.sleep(2000);
			System.out.println("Click on SignIn button");
			Log.info("Click on SignIn button");
			test.log(LogStatus.INFO, "Click on SignIn button");
			click("loginButton_xpath");
			Thread.sleep(3000);

			CommonHelper.isVisisble("myProfile_xpath");
			test.log(LogStatus.PASS, "Login Successful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Login UnSuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

}
