package AlertDemo;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30));
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		
		driver.findElement(By.id("alertBox")).click();
		
		Alert alert = driver.switchTo().alert();
		String messsage = alert.getText();
		System.out.println(messsage);
		alert.accept();
		
		driver.findElement(By.id("confirmBox")).click();
		String messsage1 = alert.getText();
		System.out.println(messsage1);
		Thread.sleep(3000);
		alert.accept();
		
		driver.findElement(By.id("promptBox")).click();
		String messsage2 = alert.getText();
		System.out.println(messsage2);
		Thread.sleep(1000);
		alert.sendKeys("santosh");
		Thread.sleep(4000);
		alert.accept();
		
		String outPut = driver.findElement(By.xpath("//div[@id='output']")).getText();
		System.out.println(outPut);
		
		driver.quit();
	}

}
