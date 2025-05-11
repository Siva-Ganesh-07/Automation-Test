package home;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Simplealert {
	public static void main (String args[]) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chrome_driver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		
		//Simple Alert
		driver.findElementById("accept").click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		
		//Confirm Alert
		driver.findElementById("confirm").click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.dismiss();
		
		//Prompt Alert
		driver.findElementById("prompt").click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println(alert3.getText());
		alert3.sendKeys("Jimmy");
		alert3.accept();
		System.out.println(driver.findElementById("myName").getText());
		
		
	}

}
