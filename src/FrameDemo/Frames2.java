package FrameDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("WebDriver.chome.driver","/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1700)", "");
		
		WebElement frm = driver.findElement(By.id("frm2"));
		driver.switchTo().frame(frm);
		Thread.sleep(30);
		driver.findElement(By.xpath("//input[@id='firstName' and @name='fName']")).sendKeys("astha");
		driver.findElement(By.xpath("//input[@id='firstName' and @name='fName']//following::input[1]")).sendKeys("sharma");
		driver.findElement(By.id("femalerb")).click();
		driver.findElement(By.id("englishchbx")).click();
		driver.findElement(By.id("spanishchbx")).click();
		driver.findElement(By.id("password")).sendKeys("123we");
		driver.findElement(By.xpath("//input[@id='password']/preceding::input[@id='email']")).sendKeys("anc@gmail.com");
		
		driver.switchTo().defaultContent();
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
	}
}