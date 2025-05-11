package home;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Facebook {
	@Test
	//public static void main(String[] args) throws InterruptedException {
	public void main() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_new.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("email").sendKeys("9443142214");
		driver.findElementById("pass").sendKeys("2064820"); 
		
		Thread.sleep(30000);
		WebElement profile = driver.findElementByXPath("//div[@aria-label='Your profile']");
			
		if(profile.isDisplayed() ) {
			System.out.println("Login successfull");
		}
		else {
			System.out.println("Check your login credentials");
			driver.quit();
		}
		
		WebElement firstStory = driver.findElementByXPath("(//a[@aria-label='Create story']/../../../div[contains(@class, 'x1c4vz4f')])[2]//a");
		firstStory.click();
		System.out.println("Story opened");
		Thread.sleep(5000);
		WebElement next = driver.findElementByXPath("//div[contains(@aria-label,'Next') and @role='button' and not(@aria-disabled)]");
		next.click();
		System.out.println("Next button clicked");
		Thread.sleep(5000);
		WebElement close = driver.findElement(By.xpath("//div[@aria-label='Close' and @role='button']"));
		close.click();
		WebElement like  =driver.findElementByXPath("(//div[@aria-label='Like'])[1]");
		like.click();
		System.out.println("Liked the first post");
		Thread.sleep(2000);
		List<WebElement> reels = driver.findElements(By.cssSelector("a[aria-label='reel']"));
		WebElement reel =  reels.get(1);
		reel.click();
		System.out.println("Second reels is opened");
		System.out.println("First reel opened");
		Thread.sleep(5000);
		WebElement nextReel = driver.findElementByCssSelector("div[aria-label='Next card']");
		nextReel.click();
		System.out.println("Next reel opened");
		Thread.sleep(5000);
		WebElement reelClose = driver.findElementByXPath("//div[@aria-label='Close' and @aria-hidden='false']");
		reelClose.click();
		System.out.println("Reel closed");

	}
}
