package ScreenShortDemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScreenShortDemo1 {
	 
	public static void main(String[] args) throws IOException {
		
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement confirmBtn1 = driver.findElement(By.id("confirmbtn"));
		getScreenShort(confirmBtn1,"newFileName");	
		driver.quit();
	}
	
	public static void getScreenShort(WebElement confirmBtn , String fileName) throws IOException {
		File srcfile = confirmBtn.getScreenshotAs(OutputType.FILE);
		Files.copy(srcfile, new File ("./screenshort/"+fileName+".png"));		
	}
}