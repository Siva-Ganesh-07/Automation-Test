package home;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathdemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chrome_driver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElement(By.id("email"));
		WebElement ele = driver.switchTo().activeElement();
		ele.sendKeys("9443142214",Keys.TAB,"2064820",Keys.ENTER);
		
		driver.findElementByLinkText("Not now").click();
		
	}

}
