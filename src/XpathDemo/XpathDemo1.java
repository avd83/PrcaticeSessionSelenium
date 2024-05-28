package XpathDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//parent::preceding-sibling
//parent::following-sibling
//ancestor,ancestor-or-self
//descendant,descendant-or-self
public class XpathDemo1 {

	public static void main(String[] args) {
		System.setProperty("WebDriver.chrome.driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input[@type='password']")).sendKeys("asd");
		String str = driver.findElement(By.xpath("//input[1][@type='password']/parent::div//preceding-sibling::div/label")).getText();
		System.out.println(str);
		
		String str1 = driver.findElement(By.xpath("//input[1][@type='password']/parent::div/following-sibling::div/button")).getText();
		System.out.println(str1);
		
		driver.findElement(By.xpath("//div[@class='buttons']/ancestor-or-self::div"));//return all parent and grandparents include self
		driver.findElement(By.xpath("//div[@class='buttons']/ancestor::div"));//return all parent and grandparents but not include self
		
		driver.findElement(By.xpath("//div[@class='container']/descendant::button"));//return all child and grand child not include self
		driver.findElement(By.xpath("//div[@class='container']/descendant-or-self::button"));//return all child and grand child include self
				
		driver.quit();
	}

}
