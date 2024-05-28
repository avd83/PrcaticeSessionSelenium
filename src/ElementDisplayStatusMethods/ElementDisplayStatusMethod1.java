package ElementDisplayStatusMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementDisplayStatusMethod1 {

	public static void main(String[] args) {

		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		checkBox.click();
		boolean b =  checkBox.isSelected();
		boolean c = checkBox.isDisplayed();
		boolean d = checkBox.isEnabled();
		
		System.out.println("conrol is selected ?:" + b);
		System.out.println("conrol is displayed ?:" + c);
		System.out.println("conrol is enabled ?:" + d);
		
		driver.quit();
	}
}