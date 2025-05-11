package home;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Screenshot {
	//public static void main(String args[]) throws IOException
	@Test
	public void main() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chrome_driver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/buttons");
		
		//Full screen screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/img.png");
		FileHandler.copy(src,dst);
		
		//Element screenshot
		WebElement ele = driver.findElementById("color");
		File elesrc = ele.getScreenshotAs(OutputType.FILE);
		File eledst = new File("./snaps/img2.png");
		FileHandler.copy(elesrc, eledst);
		
		//Section screenshot
		WebElement sec = driver.findElementByClassName("card");
		File secsrc = sec.getScreenshotAs(OutputType.FILE);
		File secdst = new File("./snaps/img3.png");
		FileHandler.copy(secsrc, secdst);
		
		driver.quit();
	}
}
