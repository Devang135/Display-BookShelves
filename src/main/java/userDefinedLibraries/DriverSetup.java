package userDefinedLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	public static WebDriver driver;
	public static String exePath;
	public static String browserName;
	public static String baseUrl1;
	
	 @SuppressWarnings("deprecation")
	public static WebDriver openDriver(String browser, String baseUrl) {
		
		 browserName = browser;
		 baseUrl1 = baseUrl;

		if (browserName.equalsIgnoreCase("Edge")) {
			
			exePath = "./Drivers/msedgedriver.exe";
			System.setProperty("webdriver.edge.driver",exePath);
			driver = new EdgeDriver();
			
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			
			exePath = "./Drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			
			exePath = "./Drivers/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
			driver = new FirefoxDriver();
			
		} else {
			
			System.out.println("Not a valid browser");
			
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl1);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
		
		}
	 
	 public static void closeDriver() {
		 
		 driver.close();
		 
	 }
}