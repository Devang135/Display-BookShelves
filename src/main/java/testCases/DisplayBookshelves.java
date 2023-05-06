package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExcelWrite;
import userDefinedLibraries.JsonRead;
import userDefinedLibraries.PropertiesRead;
import userDefinedLibraries.ReportGeneration;
import pageClasses.HomePage;
import pageClasses.BookshelvesPage;
import pageClasses.GiftcardPage;

public class DisplayBookshelves extends DriverSetup {
	
	public static String browser;
	public static String baseUrl;
	public static ExtentReports report;
	
	public HomePage homePage;
	public BookshelvesPage bookShelves;
	public GiftcardPage giftCard;
	public ExtentTest logger;
	
	public static void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@BeforeTest
	public void driverConfig() {
		browser = PropertiesRead.getBrowser();
		baseUrl = PropertiesRead.getUrl();
		driver = DriverSetup.openDriver(browser, baseUrl);
		report = ReportGeneration.setReport();
		JsonRead.readJSONFile();
	}
	
	
	// 1. To verify 'Bookshelves' menu item is displayed
	@Test (priority = 1) 
	public void verifyBookShelvesItem() {
		
		logger = report.createTest("To verify 'Bookshelves' menu item is displayed");
		logger.log(Status.INFO, "To verify 'Bookshelves' menu item is displayed");
		
		homePage = new HomePage(driver,baseUrl);
		homePage.scrollBy();
		DisplayBookshelves.pause(3000);
		boolean found = homePage.findBookshelves();
		if(found) {
			System.out.println("Bookshelves item found");
		}
		
		logger.log(Status.PASS, "PASSED");
	}
	
	
	// 2. To verify 'Bookshelves' page is displayed
	@Test (priority = 2)
	public void verifyBookShelvesPage() {
		
		logger = report.createTest("To verify 'Bookshelves' page is displayed");
		logger.log(Status.INFO, "To verify 'Bookshelves' page is displayed");
		
		bookShelves = homePage.visitBookshelves();
		String subtitle = bookShelves.subTitleBookshelves();
		System.out.println(subtitle);
		Assert.assertEquals(subtitle, "Bookshelves");
		DisplayBookshelves.pause(7000);
		
		logger.log(Status.PASS, "PASSED");
	}
	
	
	// 3. To verify 'Price' menu item is displayed
	@Test (priority = 3)
	public void verifyPriceItem() {
		
		logger = report.createTest("To verify 'Price' menu item is displayed");
		logger.log(Status.INFO, "To verify 'Price' menu item is displayed");
		
		bookShelves.closeSignUp();
		bookShelves.findItemClass();
		boolean found = bookShelves.findPrice();
		if(found) {
			System.out.println("Price Item is found");
		}
		
		logger.log(Status.PASS, "PASSED");
	}
	
	
	// 4. To verify 'Price' field
	@Test (priority = 4)
	public void setPrice() {
		logger = report.createTest("To verify 'Price' field");
		logger.log(Status.INFO, "To verify 'Price' field");
		
		bookShelves.moveSlider();
		DisplayBookshelves.pause(3000);
		
		logger.log(Status.PASS, "PASSED");
	}
	
	
	// 5. To verify 'Storage Type' menu item is displayed
	@Test (priority = 5)
	public void verifyStorageItem() {
		logger = report.createTest("To verify 'Storage Type' menu item is displayed");
		logger.log(Status.INFO, "To verify 'Storage Type' menu item is displayed");
		
		boolean found = bookShelves.clickStorage();
		if(found) {
			System.out.println("Storage Item is found");
		}
		
		logger.log(Status.PASS, "PASSED");
	}
	
	
	// 6. To verify Open Storage type
	@Test (priority = 6)
	public void verifyOpenStorage() {
		logger = report.createTest("To verify Open Storage type");
		logger.log(Status.INFO, "To verify Open Storage type");
		
		bookShelves.selectOpenStorage();
		DisplayBookshelves.pause(3000);
		
		logger.log(Status.PASS, "PASSED");
	}
	
	
	// 7. To verify 'Exclude Out of Stock' checkbox field is displayed
	@Test (priority = 7)
	public void verifyOutOfStockOption() {
		logger = report.createTest("To verify 'Exclude Out of Stock' checkbox field is displayed");
		logger.log(Status.INFO, "To verify 'Exclude Out of Stock' checkbox field is displayed");
		
		String text = bookShelves.findExcludeOutOfStock();
		Assert.assertEquals(text,"Exclude Out Of Stock");
		
		logger.log(Status.PASS, "PASSED");
	}
	
	
	// 8. To verify 'Exclude Out of Stock' checkbox field is enabled
	@Test (priority = 8)
	public void selectOutOfStockOption() {
		logger = report.createTest("To verify 'Exclude Out of Stock' checkbox field is enabled");
		logger.log(Status.INFO, "To verify 'Exclude Out of Stock' checkbox field is enabled");
		
		bookShelves.selectExcludeOutOfStock();
		DisplayBookshelves.pause(3000);
		
		logger.log(Status.PASS, "PASSED");
	}
	
	
	// 9. To verify list of products that are displayed  with appropriate filters
	@Test (priority = 9)
	public void extractProductList()
	{
		logger = report.createTest("To verify 'Exclude Out of Stock' checkbox field is enabled");
		logger.log(Status.INFO, "To verify 'Exclude Out of Stock' checkbox field is enabled");
		
		String[] productNameList = bookShelves.productNames();
		String[] productSellerList = bookShelves.sellerNames();
		String[] productPriceList = bookShelves.priceValues();
		ExcelWrite.below15000BookShelves(productNameList, productSellerList, productPriceList);
		DisplayBookshelves.pause(4000);
		
		logger.log(Status.PASS, "PASSED");
	}

	// 10. To verify 'By@Home' sub-menu item is under 'Brand' menu item.
	@Test (priority = 10)
	public void selectBrand() {
		logger = report.createTest("To verify 'By@Home' sub-menu item is under 'Brand' menu item.");
		logger.log(Status.INFO, "To verify 'By@Home' sub-menu item is under 'Brand' menu item.");
		
		bookShelves.clickBrand();
		bookShelves.selectHomeBrand();
		DisplayBookshelves.pause(2000);
		
		logger.log(Status.PASS, "PASSED");
	}
	
	// 11. List of products that are with the appropriate filter should be displayed.
	@Test (priority = 11)
	public void extractHomeProductList()
	{
		logger = report.createTest(" List of products that are with the appropriate filter should be displayed.");
		logger.log(Status.INFO, " List of products that are with the appropriate filter should be displayed.");
		
		String[] productNameList = bookShelves.productNames();
		String[] productSellerList = bookShelves.sellerNames();
		String[] productPriceList = bookShelves.priceValues();
		ExcelWrite.byAtHomeBookshelves(productNameList, productSellerList, productPriceList,productNameList.length);
		DisplayBookshelves.pause(4000);
		
		logger.log(Status.PASS, "PASSED");
	}

	// 12. To verify the 'Gift Card' menu item displayed
	@Test (priority = 12)
	public void verifyGiftCardItem() {
		logger = report.createTest("To verify the 'Gift Card' menu item displayed");
		logger.log(Status.INFO, "To verify the 'Gift Card' menu item displayed");
		
		giftCard = homePage.vistGiftCards(bookShelves.driver);
		
		logger.log(Status.PASS, "PASSED");
	}
	
	
	// 13. To verify 'Gift Card' page is displayed
	@Test (priority = 13)
	public void verifyGiftCardPage() {
		logger = report.createTest("To verify 'Gift Card' page is displayed");
		logger.log(Status.INFO, "To verify 'Gift Card' page is displayed");
		
		String subTitle =  giftCard.subTitleGiftcard();
		Assert.assertEquals(subTitle, "Gift Cards");
	}
	
	// 14. To verify 'Birthday/Anniversary' sub-menu item is displayed
	@Test (priority = 14)
	public void selectBirthday() {
		logger = report.createTest("To verify 'Birthday/Anniversary' sub-menu item is displayed");
		logger.log(Status.INFO, "To verify 'Birthday/Anniversary' sub-menu item is displayed");
		
		giftCard.clickBirthday();
		DisplayBookshelves.pause(2000);
		
		logger.log(Status.PASS, "PASSED");
	}
	
	
	// 15. To verify 'Now, customize your gift card' page is displayed
	@Test (priority = 15)
	public void fillGiftcard() {
		logger = report.createTest("To verify 'Gift Card' page is displayed");
		logger.log(Status.INFO, "To verify 'Gift Card' page is displayed");
		
		giftCard.enterAmount(JsonRead.amount);
		
		logger.log(Status.PASS, "PASSED");
	}
	
	
	// 16. To verify 'NEXT' button functionality by providing valid inputs for all the mandatory fields.
	@Test (priority = 16)
	public void clickNext() {
		logger = report.createTest("To verify 'NEXT' button functionality by providing valid inputs for all the mandatory fields.");
		logger.log(Status.INFO, "To verify 'NEXT' button functionality by providing valid inputs for all the mandatory fields.");
		
		giftCard.clickNext();
		
		logger.log(Status.PASS, "PASSED");
	}
	
	// 17. To verify 'CONFIRM' button functionality by providing null inputs for all the mandatory fields.
	@Test (priority = 17)
	public void nullForm() {
		logger = report.createTest("To verify 'CONFIRM' button functionality by providing null inputs for all the mandatory fields.");
		logger.log(Status.INFO, "To verify 'CONFIRM' button functionality by providing null inputs for all the mandatory fields.");
		
		giftCard.clickConfirm();
		DisplayBookshelves.pause(4000);
		
		logger.log(Status.PASS, "PASSED");
	}
	
	
	// 18. To verify error message of 'Recipient's Email' field by providing invalid email input format.
	@Test (priority = 18)
	public void errorRecipientEmail() {
		logger = report.createTest("To verify error message of 'Recipient's Email' field by providing invalid email input format.");
		logger.log(Status.INFO, "To verify error message of 'Recipient's Email' field by providing invalid email input format.");
		
		giftCard.recepientsName(JsonRead.recipientName);
		giftCard.recepientsEmail(JsonRead.recipientErrorEmail);
		giftCard.customerName(JsonRead.customerName);
		giftCard.customerEmail(JsonRead.customerEmail);
		giftCard.customerMobile(JsonRead.customerMobile);
		giftCard.clickConfirm();
		DisplayBookshelves.pause(4000);
		giftCard.clearForm();
		
		logger.log(Status.PASS, "PASSED");
	}
	
	// 19. To verify error message of 'Your Email' field by providing invalid email input format.
	@Test (priority = 19)
	public void errorCustomerEmail() {
		logger = report.createTest("To verify error message of 'Your Email' field by providing invalid email input format.");
		logger.log(Status.INFO, "To verify error message of 'Your Email' field by providing invalid email input format.");
		
		giftCard.recepientsName(JsonRead.recipientName);
		giftCard.recepientsEmail(JsonRead.recipientEmail);
		giftCard.customerName(JsonRead.customerName);
		giftCard.customerEmail(JsonRead.customerErrorEmail);
		giftCard.customerMobile(JsonRead.customerMobile);
		giftCard.clickConfirm();
		DisplayBookshelves.pause(4000);
		giftCard.clearForm();
		
		logger.log(Status.PASS, "PASSED");
	}
	
	// 20. To verify 'CONFIRM' button functionality by providing correct inputs for all the mandatory fields.
	@Test (priority = 20)
	public void fillForm() {
		logger = report.createTest("To verify 'CONFIRM' button functionality by providing correct inputs for all the mandatory fields");
		logger.log(Status.INFO, "To verify 'CONFIRM' button functionality by providing correct inputs for all the mandatory fields");
		
		giftCard.recepientsName(JsonRead.recipientName);
		giftCard.recepientsEmail(JsonRead.recipientEmail);
		giftCard.customerName(JsonRead.customerName);
		giftCard.customerEmail(JsonRead.customerEmail);
		giftCard.customerMobile(JsonRead.customerMobile);
		DisplayBookshelves.pause(3000);
		giftCard.clickConfirm();
		DisplayBookshelves.pause(5000);
		
		logger.log(Status.PASS, "PASSED");
	}

	@AfterTest
	public void closingBrowser() {
		report.flush();
		DriverSetup.closeDriver();
	}
}
