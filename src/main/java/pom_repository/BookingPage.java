package pom_repository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BookingPage  {

	WebDriver driver;

	public BookingPage(WebDriver driver) {
		this.driver = driver;	//throws null pointer exception
	}
	
	public WebElement getProperty() {
		return driver.findElement(By.xpath("(//h2[@class='heading-6 flex items-center font-semi-bold m-0']//span)[4]"));
	}

	public WebElement descriptionField() {
		return driver.findElement(By.xpath("//div[.='Description']"));
	}

}
