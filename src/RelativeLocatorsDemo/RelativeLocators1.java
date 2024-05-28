package RelativeLocatorsDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators1 {

	public static void main(String[] args) {
		
		System.setProperty("WebDriver.chrome.Driver","/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		WebElement alertBtn = driver.findElement(By.id("alertbtn"));		
		WebElement text = driver.findElement(RelativeLocator.with(By.name("enter-name")).above(alertBtn));
		text.sendKeys("abhay");
		//WebElement confirmBtn = driver.findElement(RelativeLocator.with(By.id("confirmbtn")).below(text));
		WebElement confirmBtn = driver.findElement(RelativeLocator.with(By.id("confirmbtn")).toRightOf(alertBtn));
		confirmBtn.click();
		
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		driver.quit();
	}

}
