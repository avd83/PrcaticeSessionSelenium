package AlertDemo;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert1 {
	
	static Alert a;
	public static void main(String[] args) {
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(30));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		 driver.findElement(By.id("alertbtn")).click();
		 a = driver.switchTo().alert();
		 getMessge();
		 a.dismiss();
		 driver.findElement(By.id("confirmbtn")).click();
		 getMessge();
		 a.accept();
		 
		driver.quit();
	}
	
	public static void getMessge() {
		String message = a.getText();
		 System.out.println(message);
	}

}
