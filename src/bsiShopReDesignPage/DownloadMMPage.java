package bsiShopReDesignPage;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utilities.CommonHelper;
import utilities.Page;

public class DownloadMMPage extends Page {

	public DownloadMMPage(WebDriver driver) throws Exception {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickDownloadNow() {

		try {
			Log.info("Click on Download Now");
			System.out.println("Click on Download Now");
			test.log(LogStatus.INFO, "Click on Download Now");
			CommonHelper.elementToBeClickable("downloadNow_xpath");	
			//click("downloadNow_xpath");
			CommonHelper.clickByJS("downloadNow_xpath");

			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));	
			//CommonHelper.windowHandle();
			Thread.sleep(5000);
			System.out.println("Switched to 2nd tab");
			System.out.println("Switch iFrame");
			Thread.sleep(10000);
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			System.out.println("iframe switched");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click on Download Now was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void enterGRPardotDetails() {

		try {
			/*
			 * if (CommonHelper.element("clickHere_xpath").isDisplayed() ||
			 * CommonHelper.element("clickHere_xpath") != null) {
			 * test.log(LogStatus.INFO, "Click on the Click Here link");
			 * System.out.println("Click on the Click Here link"); Log.info(
			 * "Click on the Click Here link"); click("clickHere_xpath");
			 * CommonHelper.isVisisble("titlePAS_xpath");
			 * CommonHelper.elementToBeClickable("titlePAS_xpath");
			 * 
			 * test.log(LogStatus.INFO, "Enter PAS Pardot Form Details");
			 * System.out.println("Enter PAS Pardot Form Details"); Log.info(
			 * "Enter PAS Pardot Form Details"); enterPASPardotFormDetails();
			 */

			// } else {}
			test.log(LogStatus.INFO, "Enter Pardot Form Details");
			System.out.println("Enter Pardot Form Details");
			Log.info("Enter Pardot Form Details");
			// CommonHelper.isVisisble("titlePAS_xpath");
			// CommonHelper.elementToBeClickable("titlePAS_xpath");
			enterPardotFormDetails();

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter PAS Pardot details was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

	public void enterPardotFormDetails() {

		try {

			/*
			 * test.log(LogStatus.INFO, "Select title"); System.out.println(
			 * "Select title"); Log.info("Select title");
			 * selectFirstOption("titlePAS_xpath");
			 */

			test.log(LogStatus.INFO, "Enter First Name");
			System.out.println("Enter First Name");
			Log.info("Enter First Name");
			enterText("firstNameGR_xpath", "GR First Name");

			test.log(LogStatus.INFO, "Enter Last Name");
			System.out.println("Enter Last Name");
			Log.info("Enter Last Name");
			enterText("lastNameGR_xpath", "GR Last Name");

			test.log(LogStatus.INFO, "Enter Email");
			System.out.println("Enter Email");
			Log.info("Enter Email");
			enterText("emailGR_xpath", "grPardot@tcs.com");

			test.log(LogStatus.INFO, "Select Country");
			System.out.println("Select Country");
			Log.info("Select Country");
			enterText("countryGR_xpath", "England");
			// selectFirstOption("countryGR_xpath");

			test.log(LogStatus.INFO, "Enter Company");
			System.out.println("Enter Company");
			Log.info("Enter Company");
			enterText("companyGR_xpath", "GR Company");

			test.log(LogStatus.INFO, "Enter Job Title");
			System.out.println("Enter Job Title");
			Log.info("Enter Job Title");
			enterText("jobtitleGR_xpath", "GR Job Title");

			test.log(LogStatus.INFO, "Click on Submit");
			System.out.println("Click on Submit");
			Log.info("Click on Submit");
			click("submitGR_css");

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter PAS Pardot Form details was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void verifyPdf() {
		try {
			test.log(LogStatus.INFO, "Verify Governance Resilience Pdf");
			System.out.println("Verify Governance Resilience Pdf");
			Log.info("Verify Governance Resilience Pdf");

			String getURL = driver.getCurrentUrl();
			if (getURL.contains(".pdf")) {
				String urlText = getURL.toString();
				Thread.sleep(1000);
				System.out.println(urlText);
				test.log(LogStatus.PASS, urlText);
			}
			driver.close();
			System.out.println("Switch back to 1st tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));
			

		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Governance Resilience Pdf was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*
	 * public boolean verifyPDFContent(String strURL, String reqTextInPDF) {
	 * 
	 * PDFTextStripper stripper = new PDFTextStripper();
	 * pdfStripper.setStartPage(1); pdfStripper.setEndPage(2);
	 * 
	 * boolean flag = false;
	 * 
	 * PDFTextStripper pdfStripper = null; PDDocument pdDoc = null; COSDocument
	 * cosDoc = null; String parsedText = null;
	 * 
	 * try { URL url = new URL(strURL); BufferedInputStream file = new
	 * BufferedInputStream(url.openStream()); PDFParser parser = new
	 * PDFParser(file);
	 * 
	 * parser.parse(); cosDoc = parser.getDocument(); pdfStripper = new
	 * PDFTextStripper(); pdfStripper.setStartPage(1);
	 * pdfStripper.setEndPage(1);
	 * 
	 * pdDoc = new PDDocument(cosDoc); parsedText = pdfStripper.getText(pdDoc);
	 * } catch (MalformedURLException e2) { System.err.println(
	 * "URL string could not be parsed "+e2.getMessage()); } catch (IOException
	 * e) { System.err.println("Unable to open PDF Parser. " + e.getMessage());
	 * try { if (cosDoc != null) cosDoc.close(); if (pdDoc != null)
	 * pdDoc.close(); } catch (Exception e1) { e.printStackTrace(); } }
	 * 
	 * System.out.println("+++++++++++++++++"); System.out.println(parsedText);
	 * System.out.println("+++++++++++++++++");
	 * 
	 * if(parsedText.contains(reqTextInPDF)) { flag=true; }
	 * 
	 * return flag; }
	 */
}
