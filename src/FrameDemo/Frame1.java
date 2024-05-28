package FrameDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frame1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(30));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)", "");
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='courses-iframe']"));
		driver.switchTo().frame(frame);		
		driver.findElement(By.xpath("//div/a/span[@class='icon fa fa-user']")).click();
		Thread.sleep(3000);
	//	driver.switchTo().defaultContent();//to shift original default web page
		driver.switchTo().parentFrame();//to shift original default web page
		driver.findElement(By.cssSelector("a[id='opentab']")).click();
		driver.quit();
	}
}