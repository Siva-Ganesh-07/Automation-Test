package home;

import org.openqa.selenium.chrome.ChromeDriver;

public class Framedemo {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chrome_driver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/frame");
		
		driver.switchTo().frame("firstFr");
		driver.findElementByName("fname").sendKeys("Jimmy");
		driver.findElementByName("lname").sendKeys("Pappa");
		
		driver.switchTo().frame(0);
		driver.findElementByName("email").sendKeys("jimmypappa@gmail.com");
	}

}
