package WindowHandleDemo;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenNewWindowHandle2 {
	static String  parentId;
	static String childId;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(30));
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)", "");
		
		driver.findElement(By.id("newWindowBtn")).click();
		
		Set<String> list = driver.getWindowHandles();
		System.out.println(list.size());
		
		Iterator<String>it = list.iterator();		
		if(it.hasNext()) {
			 parentId = it.next();
			childId = it.next();	
		}
		driver.switchTo().window(childId);
		driver.close();
		driver.switchTo().window(parentId);
		Thread.sleep(2000);
		driver.quit();
	}

}
