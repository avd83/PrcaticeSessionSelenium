package SelectClassDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Select1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(30));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement options = driver.findElement(By.cssSelector("select[id='dropdown-class-example']"));
		
		Select s = new Select(options);
		System.out.println(s.isMultiple());
		List<WebElement> r = s.getOptions();//getting how many option available in dropdown selection
		System.out.println(r.size());
		
		if(s.isMultiple()==false) {// this option get checked that is dropdown having multiple selection options.
		//s.selectByVisibleText("Option1");
		//s.selectByIndex(2);
		s.selectByValue("option3");
		Thread.sleep(3000);
		}else {
			System.out.println("this is not multi selcted dropdown ");
		}		
		driver .quit();
	}
}