package ActionDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		
		Actions a = new Actions(driver);
		
		WebElement moreLink = driver.findElement(By.xpath("//div[text()='More']"));
		WebElement wtc = driver.findElement(By.xpath("//a[text()='World Test Championship']"));
		WebElement homePage = driver.findElement(By.xpath("//nav/a/img[@title='Cricbuzz Logo']"));
		
		a.moveToElement(moreLink).click().keyDown(wtc, Keys.SHIFT).build().perform();
		Thread.sleep(3000);
		a.moveToElement(homePage).click();
		//driver.findElement(By.xpath("//nav/a/img[@title='Cricbuzz Logo']")).click();
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}
