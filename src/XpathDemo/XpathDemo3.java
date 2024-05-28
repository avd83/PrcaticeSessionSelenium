package XpathDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//starts-with()
//ends-with()
public class XpathDemo3 {

	public static void main(String[] args) {
		System.setProperty("WebDriver.chrome.driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//input[starts-with(@name,'enter-')]")).sendKeys("abhay");
		//driver.findElement(By.xpath("//input[ends-with(@name,'-name')]")).sendKeys("abc");
	}
}