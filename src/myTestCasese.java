import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCasese {

WebDriver driver = new ChromeDriver();
 String URL = "https://global.almosafer.com/en";
 String expectedLang = "en";
 
 
 @BeforeTest
 public void setup () {
	 driver.get(URL); 
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 driver.findElement(By.id("mui-3")).click();	 
 }
 
 @Test 
 public void checkTheLangaueisEn () {
	WebElement lang = driver.findElement(By.tagName("html"));
	String actualLang = lang.getAttribute("lang");
	 Assert.assertEquals(actualLang, expectedLang);
 }
 
 

	

	
	
	
	
}
