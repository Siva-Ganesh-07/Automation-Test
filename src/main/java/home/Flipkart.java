package home;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utils.DataUtils;

public class Flipkart {
	ChromeDriver driver;
	WebElement account;
		
	@BeforeMethod
	public void Get() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_new.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(groups = "positive", priority = 1, dataProvider = "getData", dataProviderClass = DataUtils.class)
	public void Login(String[] data) throws InterruptedException{
			
		String url = "https://www.flipkart.com/";
		String currentUrl =  driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		if(url.equals(currentUrl)) {
			System.out.println("Page routed successfully"+currentUrl);
		}
		else {
			System.out.println("Wrong window");
		}
		driver.findElementByXPath("//a[@title = \"Login\" and @aria-haspopup = \"true\"]").click();
		driver.findElementByXPath("//input[contains(@class, \"r4vIwl \")]").sendKeys(data[0]);
		Thread.sleep(3000);
		driver.findElementByXPath("//button[text() = \"Request OTP\"]").click();
		
		List<WebElement> errMsgList = driver.findElements(By.xpath("//span[contains(text(), 'Please enter valid Email')]"));

		if (!errMsgList.isEmpty() && errMsgList.get(0).isDisplayed()) {
		    System.out.println("Invalid UserID message displayed");
		    driver.quit(); 
		    return; 
		}

		
		System.out.println("Waiting for manual OTP entry...");
		Thread.sleep(6000); 
		    
	    System.out.println("Continuing after manual OTP entry");
	    
	    driver.findElement(By.xpath("//input[contains(@title, 'Search for Products')]")).sendKeys("ZEBRONICS ZEB-BRO");
	    driver.findElement(By.xpath("//button[contains(@title, 'Search for Products')]")).click();
	    
	    String title = driver.getTitle();
	    System.out.println(title);
	    if(title.toLowerCase().contains("Headphone")) {
	        System.out.println("Correct page:" +title);
	    }
	    else {
	        System.out.println("Wrong page");
	    }

	    // Sort High to Low
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'Price -- Low to High')]"))).click();
	    

	    // Click product
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[contains(text(),'ZEBRONICS ZEB-BRO, With In-Line MiC') and contains(@href, '/zebronics-zeb-bro-in-line-mic-3-5mm-jack-10mm-drivers-compatible-phone-tablet-wired/p/itm2')]")).click();

	    // Switch to new tab if opened
	    for(String handle : driver.getWindowHandles()) {
	        driver.switchTo().window(handle);
	    }

	    String currentTitle = driver.getTitle();
	    System.out.println(currentTitle);

	    if(currentTitle.contains("ZEBRONICS ZEB-BRO")) {
	        System.out.println("Correct product page" +currentTitle);
	    }
	    else {
	        System.out.println("Wrong product page");
	    }

	    // Add to cart
	    WebElement addToCartBtn = driver.findElement(By.xpath("//button[contains(text(), 'cart') or contains(text(), 'CART')]"));
	    addToCartBtn.click();
	    
	    // Place Order
	    Thread.sleep(3000);
	    String Total = driver.findElement(By.xpath("//div[contains(@class, 'PWd9A7 xvz6eC')]//div[@class = '_1Y9Lgu']/span")).getText();
	    System.out.println(Total);
	    driver.findElement(By.xpath("//img[@title = 'Flipkart']//..")).click();
	    WebElement Fashion = driver.findElement(By.xpath("//span[text() = \"Fashion\"]"));
		String currentPageUrl =  driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		if(url.equals(currentPageUrl)) {
			System.out.println("Page routed successfully"+currentPageUrl);
		}
		else {
			System.out.println("Wrong window");
		}
		
		Actions builder = new Actions(driver);
		builder.moveToElement(Fashion).perform();
		
		WebElement Top = driver.findElement(By.xpath("//a[contains(text(), 'Top Wear')]"));
		builder.moveToElement(Top);
		driver.findElement(By.xpath("//a[contains(text(), 'T-Shirts')]")).click();
		
		
		Thread.sleep(3000);

		// Capture current window handle before closing
		String closedTab = driver.getWindowHandle();

		// Close current tab (T-Shirts page)
		driver.close();

		// Switch back to remaining (parent) tab
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(closedTab)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}

		// Optional: wait until homepage element is visible again
		driver.findElement(By.xpath("//img[@title = 'Flipkart']//..")).click();

	}
	
	
	@AfterMethod
	public void finished() {
		System.out.println("Completed");
		driver.quit();
	}
	
}
