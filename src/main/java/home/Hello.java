package home;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Hello {
	@Test
	//public static void main(String[] args) {
	public void main() {
		System.out.println("Hello World");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_new.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/edit");
		driver.findElementById("fullName").sendKeys("Jimmy");
		driver.findElementById("join").sendKeys(" Pattu", Keys.TAB);
		String myValue = driver.findElementById("getMe").getAttribute("value");
		System.out.println(myValue);
		driver.findElementById("clearMe").clear();
		boolean enable = driver.findElementById("noEdit").isEnabled();
		System.out.println(enable);
		String isReadonly = driver.findElementById("dontwrite").getAttribute("readonly");
		System.out.println(isReadonly);
		
		driver.quit();
 	}
}
