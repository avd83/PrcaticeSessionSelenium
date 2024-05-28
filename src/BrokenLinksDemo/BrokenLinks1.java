package BrokenLinksDemo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinks1 {

	public static void main(String[] args) throws IOException {

		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30));
		driver.get("https://www.cricbuzz.com/");
		driver.manage().window().maximize();

		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		System.out.println(totalLinks.size());

		//List<String> uralList = new ArrayList<String>();

		for (WebElement e : totalLinks) {
			String url = e.getAttribute("href");
			checkBrokenLinks(url);
		}
		driver.quit();
	}

	public static void checkBrokenLinks(String linkUrl){
		try {
		URL url1 =new URL(linkUrl);
		HttpURLConnection httpUrlconnection = (HttpURLConnection) url1.openConnection();
		httpUrlconnection.setConnectTimeout(6000);
		httpUrlconnection.connect();
		if(httpUrlconnection.getResponseCode()>=400) {
			System.out.println(linkUrl + "--->"+ httpUrlconnection.getResponseMessage()+"is broken link" );
		}else {
			System.out.println(linkUrl + "--->"+ httpUrlconnection.getResponseMessage());
		}
		}catch (Exception e){
			
		}
	}
}