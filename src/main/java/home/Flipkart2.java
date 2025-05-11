package home;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart2 {
	public static void main(String args[]){
		ChromeDriver driver;
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_new.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "https://www.flipkart.com/";
		String currentUrl =  driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		if(url.equals(currentUrl)) {
			System.out.println("Page routed successfully");
		}
		else {
			System.out.println("Wrong window");
		}
		
		WebElement Fashion = driver.findElement(By.xpath("//span[text() = 'Fashion']"));
		boolean visible = Fashion.isDisplayed();
		System.out.println(visible);
		Actions builder = new Actions(driver);
		builder.moveToElement(Fashion).perform();
		
		WebElement Top = driver.findElement(By.xpath("//a[contains(text(), \"Top Wear\")]"));
		builder.moveToElement(Top);
		WebElement Tshirts = driver.findElement(By.xpath("//a[contains(text(), \"T-Shirts\")]"));
		Tshirts.click();
	}
}
