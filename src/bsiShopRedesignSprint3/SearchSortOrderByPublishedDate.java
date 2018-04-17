package bsiShopRedesignSprint3;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import bsiShopReDesignPage.SearchPage;
import bsiShopRedesignBase.BaseTest;
import bsiShopRedesignBase.HomePage;

public class SearchSortOrderByPublishedDate extends BaseTest {

	public SearchSortOrderByPublishedDate() throws Exception {
		// TODO Auto-generated constructor stub
	}

	@Test(priority = 1, enabled = true)
	public void checkSortingOrderQuality() {

		test = extent.startTest("Sprint 3 - Verify Sorting order for Products by Published Date in Search List");
		try {

			System.out.println("Search ASTM Product");
			Log.info("Search ASTM Product");
			test.log(LogStatus.INFO, "Search ASTM Product");
			HomePage home = new HomePage(driver);
			home.searchASTMProduct();

			System.out.println("Select maximum items");
			Log.info("Select maximum items");
			SearchPage search = new SearchPage(driver);
			search.selectMaxItems();

			System.out.println("Select Published Date and Verify Sorting");
			Log.info("Select Published Date and Verify Sorting");
			test.log(LogStatus.INFO, "Select Published Date and Verify Sorting");
			search.checkSortingByPublishedDate();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Select Published Date and Verify Sorting was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
