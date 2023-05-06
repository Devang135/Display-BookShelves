package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

public class HomePage {
	
	public WebDriver driver;
	public String homePageUrl;
	
	public HomePage(WebDriver driver, String url) {
		this.driver = driver;
		homePageUrl = url;
	}
	
	public void setDriver(WebDriver Driver) {
		driver = Driver;
	}
	
	public void scrollBy() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
	}
	
	public boolean findBookshelves() {
		try {
			driver.findElement(By.xpath("//h4[contains(.,'Bookshelves')]"));
		} 
		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public BookshelvesPage visitBookshelves() {
		
		BookshelvesPage bookShelves;
		
		try {
			driver.findElement(By.xpath("//h4[contains(.,'Bookshelves')]")).click();
			Thread.sleep(3000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		bookShelves = new BookshelvesPage(driver);
		return bookShelves;
	}
	
	
	public GiftcardPage vistGiftCards(WebDriver driver2) {
		driver2.get(homePageUrl);
		GiftcardPage giftCard ;
		try {
			driver2.findElement(By.linkText("Gift Cards")).click();
			Thread.sleep(3000);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		giftCard = new GiftcardPage(driver2);
		return giftCard;
	}
	
}

