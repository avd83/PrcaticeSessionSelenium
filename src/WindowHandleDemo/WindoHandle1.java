package WindowHandleDemo;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindoHandle1{

	static String childId;
	static String childId1;
	static String parentId;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(30));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("a[id='opentab']")).click();
		parentId = driver.getWindowHandle();
		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("a[id='opentab']")).click();
		Set<String> s = driver.getWindowHandles();
		System.out.println(s.size());
		Iterator<String> it = s.iterator();
		if(it.hasNext()) {
			 parentId = it.next();
			 childId =  it.next();
			 childId1 = it.next();
		}
		Thread.sleep(3000);		
		driver.switchTo().window(childId);
		driver.findElement(By.xpath("//a[text()='Access all our Courses']")).click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(childId1);
		driver.findElement(By.xpath("//a[text()='Access all our Courses']")).click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parentId);
		driver.close();
		
		driver.quit();
	}
}