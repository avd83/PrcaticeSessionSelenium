package ShadowDomDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadoDom1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webDriver.chrome.Driver","/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("chrome://settings/downloads");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.cssSelector("settings-ui")).getShadowRoot()
				.findElement(By.cssSelector("settings-main[id='main']")).getShadowRoot()
				.findElement(By.cssSelector("settings-basic-page[class='cr-centered-card-container'")).getShadowRoot()
				.findElement(By.cssSelector("settings-section[page-title='Downloads']"))
				.findElement(By.tagName("settings-downloads-page")).getShadowRoot()
				.findElement(By.cssSelector("controlled-button[id='changeDownloadsPath']")).getShadowRoot()
				.findElement(By.cssSelector("cr-button[role='button']"));
				Thread.sleep(3000);
		element.click();
		Thread.sleep(3000);
				
		driver.quit();
	}
}