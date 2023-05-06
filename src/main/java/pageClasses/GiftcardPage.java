package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftcardPage {
	
	public WebDriver driver;
	
	public GiftcardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String subTitleGiftcard() {
		String subtitle = "";
		subtitle = driver.findElement(By.className("_1bluI")).getText();
		return subtitle;
	}
	
	public void clickBirthday() {
		WebElement birthday = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]/div/h3"));
        birthday.click();
	}
	
	public void enterAmount(String amount) {
		WebElement amounts = driver.findElement(By.id("ip_2251506436"));
        amounts.sendKeys(amount);
	}
	
	public void clickNext() {
		  WebElement nxtbtn = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button"));
	      nxtbtn.click();

	}
	
	public void recepientsName(String rName) {
		WebElement rcpnt = driver.findElement(By.id("ip_4036288348"));
        rcpnt.sendKeys(rName);

	}
	
	public void recepientsEmail(String rEmail) {
		WebElement remail = driver.findElement(By.id("ip_137656023"));
        remail.sendKeys(rEmail);
	}
	
	public void customerName(String cName) {
		 WebElement yourname = driver.findElement(By.id("ip_1082986083"));
	     yourname.sendKeys(cName);
	}
	
	public void customerEmail(String cEmail) {
		 WebElement youremail = driver.findElement(By.id("ip_4081352456"));
	     youremail.sendKeys(cEmail);
	}
	
	public void customerMobile(String cMobile) {
		WebElement phone = driver.findElement(By.id("ip_2121573464"));
        phone.sendKeys(cMobile);
	}
	
	public void clickConfirm() {
		WebElement confirm = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[3]/form/button"));
        confirm.click();
	}
	
	public void clearForm() {
		driver.findElement(By.id("ip_4036288348")).clear();
		driver.findElement(By.id("ip_137656023")).clear();
		driver.findElement(By.id("ip_1082986083")).clear();
		driver.findElement(By.id("ip_4081352456")).clear();
		driver.findElement(By.id("ip_2121573464")).clear();
	}
}
