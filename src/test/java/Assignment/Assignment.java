package Assignment;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom_repository.BookingPage;
import pom_repository.HomePage;

public class Assignment {

	@Test
	@Parameters({"City","Place", "Location1", "Location2",})
	public void assignment(String City, String Place, String Location1, String Location2) {

		try {
			System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 25);
			
			driver.get("https://www.nobroker.in/");

			HomePage homePage = new HomePage(driver);
			homePage.buyLink().click();
			homePage.cityDropDown().click();
			homePage.selectCity(City).click();
			homePage.searchPlaceTextfield().sendKeys(Place);
			homePage.selectLocation(Location1).click();
			homePage.searchPlaceTextfield().sendKeys(Place);
			homePage.selectLocation(Location2).click();
			homePage.apartmentTypeDropDown().click();
			homePage.selectApartmentType("2 BHK").click();
			homePage.selectApartmentType("3 BHK").click();
			homePage.searchButton().click();
			
			BookingPage bookingPage = new BookingPage(driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookingPage.getProperty());
			new Actions(driver).moveToElement(bookingPage.getProperty()).perform();
			Thread.sleep(3500);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", bookingPage.getProperty());
			Thread.sleep(2500);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(12000);
			wait.until(ExpectedConditions.visibilityOf(bookingPage.descriptionField()));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookingPage.descriptionField());
			Thread.sleep(500);
			assertEquals(bookingPage.descriptionField().getText().trim(), "Description");
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
