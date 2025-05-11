package home;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draggabledemo {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chrome_driver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		WebElement source = driver.findElementById("draggable");
		int X = source.getLocation().getX();
		int Y = source.getLocation().getY();
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(source, X+50, Y+50).perform();
	}
}
