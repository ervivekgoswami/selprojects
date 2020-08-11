package DemoDay1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoClass {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONAVI\\Downloads\\Compressed\\Selenium All Setup\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://stackoverflow.com");
		driver.findElement(By.name("q")).sendKeys("Vivek");
		driver.findElement(By.id("q")).sendKeys("Vivek");
		driver.findElement(By.className("q")).click();	
		

	}

}
