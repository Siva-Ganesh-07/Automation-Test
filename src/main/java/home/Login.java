package home;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Login {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chrome_driver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Simple
//		driver.findElementById("user-name").sendKeys("standard_user");
//		driver.findElementById("password").sendKeys("secret_sauce");
//		File simple = driver.getScreenshotAs(OutputType.FILE);
//		File out = new File("./snaps/simple.png");
//		FileHandler.copy(simple, out);
		
		//invalid username
//		driver.findElement(By.name("user-name")).sendKeys("Jimmy");
//		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
//		invalid password
//		driver.findElementById("user-name").sendKeys("standard_user");
//		driver.findElementById("password").sendKeys("123456");
//		driver.findElementById("login-button").click();
//		File simple = driver.getScreenshotAs(OutputType.FILE);
//		File out = new File("./snaps/simple2.png");
//		FileHandler.copy(simple, out);
		
//		invalid username and password
//		driver.findElementById("user-name").sendKeys("user");
//		driver.findElementById("password").sendKeys("123456");
//		driver.findElementById("login-button").click();
//		File simple = driver.getScreenshotAs(OutputType.FILE);
//		File out = new File("./snaps/simple3.png");
//		FileHandler.copy(simple, out);
		
		//Empty field
		driver.findElementById("user-name");
		driver.findElementById("password");
		driver.findElementById("login-button").click();
		File simple = driver.getScreenshotAs(OutputType.FILE);
		File out = new File("./snaps/simple4.png");
		FileHandler.copy(simple, out);
		
	}

}
