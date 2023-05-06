package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BookshelvesPage {
	
	public WebDriver driver;
	public List<WebElement> itemClass;
	
	public BookshelvesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String subTitleBookshelves() {
		String subtitle = "";
		subtitle = driver.findElement(By.className("withsubtext")).getText();
		return subtitle;
	}
	
	
	public void closeSignUp( ) {
			if( driver.findElements(By.id("authentication_popup")).size() != 0 )
			{
				System.out.println("this ran");
				driver.findElement(By.xpath("//a[contains(.,'Close')]")).click();
			}
	}
	
	public void findItemClass() {
		itemClass = driver.findElements(By.className("item"));
	}
	
	public boolean findPrice() {
		for(int i=0;i<itemClass.size();i++)
		{
			 if(itemClass.get(i).getAttribute("data-group").equals("price"))
			 {
				 itemClass.get(i).click();
				 return true;
			 }
		}
		return false;
	}
	
	public void moveSlider() {
		WebElement slider = driver.findElement(By.xpath("//div[@class='noUi-handle noUi-handle-upper']"));
		Actions action = new Actions(driver);
		action.moveToElement(slider).dragAndDropBy(slider, -237, 0).perform();
		
	}
	
	public boolean clickStorage() {
		for(int i=0;i<itemClass.size();i++)
		{
			 if(itemClass.get(i).getAttribute("data-group").equals("storage type"))
			 {
				 itemClass.get(i).click();
				 return true;
			 }
		}
		return false;
	}
	
	
	public void selectOpenStorage() {
		driver.findElement(By.id("filters_storage_type_Open")).click();
	}
	
	public String findExcludeOutOfStock() {
		String text = "";
		try {
			text = driver.findElement(By.xpath("//label[contains(.,'Exclude Out Of Stock')]")).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}
	
	public void selectExcludeOutOfStock() {
		driver.findElement(By.id("filters_availability_In_Stock_Only")).click();
	}
	
	public void clickBrand() {
		for(int i=0;i<itemClass.size();i++)
		{
			 if(itemClass.get(i).getAttribute("data-group").equals("brand"))
			 {
				 itemClass.get(i).click();
				 break;
			 }
		}
	}
	
	public String[] productNames() {
		List<WebElement> productNameElements = driver.findElements(By.cssSelector(".product-title.product-title-sofa-mattresses>span"));
		int listSize = productNameElements.size();
		String[] productNameList = new String[listSize];
		for(int i = 0;i<listSize;i++)
		{
			productNameList[i] = productNameElements.get(i).getText();
		}
		return productNameList;
	}
	
	public String[] sellerNames() {
		List<WebElement> productSellerElements = driver.findElements(By.cssSelector(".product_brand_name>div"));
		int listSize = productSellerElements.size();
		String[] productSellerList = new String[listSize];
		for(int i = 0;i<listSize;i++)
		{
			productSellerList[i] = productSellerElements.get(i).getText();
		}
		return productSellerList;
	}
	
	public String[] priceValues() {
		List<WebElement> productPriceElements = driver.findElements(By.cssSelector(".price-number>span"));
		int listSize = productPriceElements.size();
		String[] productPriceList = new String[listSize];
		for(int i = 0;i<listSize;i++)
		{
			productPriceList[i] = productPriceElements.get(i).getText();
		}
		return productPriceList;
	}
	
	public void selectHomeBrand() {
		driver.findElement(By.id("filters_brand_name_By_home")).click();
	}
}
