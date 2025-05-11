package home;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Cricket {
	public static void main(String args[]) {
		System.getProperty("webdriver.chrome.driver", "./drivers/chromedriver_new.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/search?q=cricket&oq=cricket&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIGCAEQRRhBMgYIAhBFGD0yBggDEEUYPTIGCAQQLhhA0gEIMzI2NGowajGoAgCwAgA&sourceid=chrome&ie=UTF-8#cobssid=s");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}
}
