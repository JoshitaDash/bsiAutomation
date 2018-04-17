package bsiShopRedesignBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestApp {

	public static void main(String[] args) throws Exception {
try{
		System.setProperty("webdriver.ie.driver", "D:\\SOFTWARE\\NEW FW SOFTWARE\\IEDriverServer.exe");
		WebDriver web = new InternetExplorerDriver();
		web.get("https://www.google.com");
		System.out.println("Close the browser");
		web.manage().window().maximize();
		web.close();
		System.out.println("Quit the browser");
		web.quit();
		System.out.println("After Quit the browser");
	}catch(Exception e)
{
		System.out.println("Capturing the exception");
		System.out.println(e);
}
	}
}
