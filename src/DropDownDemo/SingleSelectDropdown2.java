package DropDownDemo;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleSelectDropdown2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30));
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		
		WebElement list = driver.findElement(By.xpath("//select[@id='course']"));
		Select s = new Select(list);
		s.selectByIndex(1);
		Thread.sleep(4000);
		
		List<WebElement> list1 = driver.findElements(By.xpath("//select[@id='course']//child::option"));
		System.out.println(list1.size());
		
		for(WebElement e : list1) {			
			if(e.getText().contains("Dot Net")){
				e.click();
			}
		}
		driver.quit();
	}
}
