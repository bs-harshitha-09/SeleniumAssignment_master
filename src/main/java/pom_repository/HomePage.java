package pom_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {


	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement buyLink() {
		return driver.findElement(By.xpath("//div[@class='nb__3JaWD']//div[.='Buy']"));
	}

	public WebElement cityDropDown() {
		return driver.findElement(By.xpath("//div[contains(@class,'search-city')]//div[contains(@class,'value-container')]"));
	}

	public WebElement selectCity(String City) {
		return driver.findElement(By.xpath("//div[contains(@class,'select__menu-list')]/div[text()='"+City+"']"));
	}

	public WebElement searchPlaceTextfield() {
		return driver.findElement(By.id("listPageSearchLocality"));
	}

	public WebElement selectLocation(String Location) {
		return driver.findElement(By.xpath("//div[@id='autocomplete-dropdown-container']//span[contains(normalize-space(),'"+Location+"')]"));
	}

	public WebElement apartmentTypeDropDown() {
		return driver.findElement(By.xpath("//div[.='Apartment Type' and @class='nb-select__placeholder']"));
	}

	public WebElement selectApartmentType(String ApartmentType) {
		return driver.findElement(By.xpath("//span[.='"+ApartmentType+"']"));
	}

	public WebElement searchButton() {
		return driver.findElement(By.xpath("//button[.='Search']"));
	}





}
