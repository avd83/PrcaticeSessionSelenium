package XpathDemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//parent
//child

public class XpathDemo2 {

	public static void main(String[] args) {
		System.setProperty("WebDriver.chrome.driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
		
		String str = driver.findElement(By.xpath("//table/child::tbody/tr[2]/td[3]")).getText();
		System.out.print(str);
		driver.findElement(By.xpath("//td[text()='5000']/parent::tr/td/a")).click();
		
		driver.quit();
	}
}
