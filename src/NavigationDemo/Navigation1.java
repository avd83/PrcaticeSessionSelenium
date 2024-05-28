package NavigationDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigation1 {

	public static void main(String[] args) {
		
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		String str = driver.getCurrentUrl();
		System.out.println(str);
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
				
		driver.quit();
	}
}