package XpathDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//preceding
//following
public class XpathDemo {

	public static void main(String[] args) {
		System.setProperty("WebDriver.chrome.driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

		driver.findElement(By.xpath("//label[text()='Email']//following::input[1][@type='text']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//label[text()='Email']//preceding::input[1][@type='text']")).sendKeys("sharma");
		driver.findElement(By.xpath("//label[text()='Email']//preceding::input[1][@type='text']//preceding::input[@type='text']")).sendKeys("amar");
		driver.findElement(By.xpath("//label[text()='Password']//following::input[@type='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//label[text()='Password']//following::input[@type='password']//following::input[1][@type='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@type='submit' and @class='btn']")).click();

		driver.quit();
	}
}