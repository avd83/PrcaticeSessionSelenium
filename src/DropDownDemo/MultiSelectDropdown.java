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

public class MultiSelectDropdown {

	public static void main(String[] args) {
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30));
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");

		WebElement list = driver.findElement(By.xpath("//select[@id='ide']"));
		
		Select s = new Select(list);
		
			s.selectByVisibleText("Eclipse");
			s.selectByIndex(2);
			
			System.out.println(s.getOptions().size());//to list out the drop down selection options count
			
			List<WebElement> list1 = s.getAllSelectedOptions();//print get selected options in drop down
			for(WebElement f : list1) {
				System.out.println(f.getText());
			}			
			System.out.println(s.getFirstSelectedOption().getText());//print only first selected options in dropdown
			s.deselectAll();
		
			driver.quit();		
	}
}