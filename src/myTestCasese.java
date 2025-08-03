import static org.testng.Assert.assertFalse;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
 String expectedHotelsTabnotSelected = "false";
 
 @BeforeTest
 public void setup () {
	 driver.get(URL); 
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 driver.findElement(By.id("mui-3")).click();	 
 }
 
 @Test (enabled = false)
 public void checkTheLangaueisEn () {
	WebElement lang = driver.findElement(By.tagName("html"));
	String actualLang = lang.getAttribute("lang");
	 Assert.assertEquals(actualLang, expectedLang);
 }
 
 @Test (enabled = false)
 public void checkTheCurrncyisSAR () {
	  
	 String theactualDefaultCurrency =driver.findElement(By.cssSelector(".__ds__comp.undefined.MuiBox-root.alm-desktop-16mmnl8")).getText();
	 Assert.assertEquals(theactualDefaultCurrency, expectedCurrnecy);	 
}
 

@Test (enabled = false)
public void checkTheMobileNo () {
  String ActualMobileNo = driver.findElement(By.cssSelector(".__ds__comp.undefined.MuiBox-root.alm-desktop-h0bow9")).getText();
  
  Assert.assertEquals(ActualMobileNo, expectedMobileno);
	}


@Test(enabled = false)
public void checkQitafLogo () {
	boolean actualQitafLogo = driver.findElement(By.xpath("//img [@alt = 'qitaf']")).isDisplayed();
	Assert.assertEquals(actualQitafLogo, expectedQitafLogo);
	
}

@Test (enabled = false)
public void checkStaysTabnotSelected () {
	 String hotelstabisHidden= driver.findElement(By.id("tab-hotels")).getAttribute("aria-selected");
	 Assert.assertEquals(hotelstabisHidden, expectedHotelsTabnotSelected);
	}

@Test (priority = 1)
public void checkDepartureDate () {
	
	
	LocalDate today = LocalDate.now();  //Wed, 6 Aug
	int expectedDepartureDate = today.plusDays(1).getDayOfMonth();
	String DepartureDate = driver.findElement(By.id("testIdPickerPrefix__DatePicker__DepartureDate")).getAttribute("value");
	String [] parts = DepartureDate.split(",");
	String dateOnly = parts[1].trim();
	String []part2 = dateOnly.split(" ");
	String dateonly2= part2[0];
	int ActualReturnDate = Integer.parseInt(dateonly2);
	Assert.assertEquals(ActualReturnDate, expectedDepartureDate);
	
}
@Test (priority = 2)
public void checkReturneDate () {
	LocalDate today = LocalDate.now(); //Wed, 6 Aug
	int expectedReturnDate = today.plusDays(2).getDayOfMonth();
	
	String fullReturnDate = driver.findElement(By.id("testIdPickerPrefix__DatePicker__ArrivalDate")).getAttribute("value");
	String []dateParts = fullReturnDate.split(","); 
	String Daydate = dateParts[1].trim();
	String []datewithoutDay = Daydate.split(" ");
	String finalDate = datewithoutDay[0];
    int ActualReturnDate = Integer.parseInt(finalDate);
    Assert.assertEquals(ActualReturnDate, expectedReturnDate);
	
	
	
	
	
}



}