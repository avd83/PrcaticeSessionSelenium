package ScreenShortDemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class OldScreenShortDemo {

	public static void main(String[] args) throws IOException {
		String FileName = "oldFileName";
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement alertbtn = driver.findElement(By.id("alertbtn"));
		
		TakesScreenshot t = ((TakesScreenshot)alertbtn);
		File srcFile = t.getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile,new File("./screenshort/"+FileName+".png"));
		
		driver.quit();
	}
}
