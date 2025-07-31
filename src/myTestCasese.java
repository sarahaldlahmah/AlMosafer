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
 String expectedCurrnecy = "SAR";
 String expectedMobileno = "+966554400000";
 boolean expectedQitafLogo = true;
 
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
 
 @Test 
 public void checkTheCurrncyisSAR () {
	  
	 String theactualDefaultCurrency =driver.findElement(By.cssSelector(".__ds__comp.undefined.MuiBox-root.alm-desktop-16mmnl8")).getText();
	 Assert.assertEquals(theactualDefaultCurrency, expectedCurrnecy);	 
}
 

@Test 
public void checkTheMobileNo () {
  String ActualMobileNo = driver.findElement(By.cssSelector(".__ds__comp.undefined.MuiBox-root.alm-desktop-h0bow9")).getText();
  
  Assert.assertEquals(ActualMobileNo, expectedMobileno);
	}


@Test
public void checkQitafLogo () {
	boolean actualQitafLogo = driver.findElement(By.xpath("//img [@alt = 'qitaf']")).isDisplayed();
	Assert.assertEquals(actualQitafLogo, expectedQitafLogo);
	
		
}




}