import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

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


@Test (priority = 1,enabled = false)
public void ChecktheDepartureDateisCorrect () {  //Wed, 6 Aug
	
	LocalDate today = LocalDate.now();
	int expectedDepartureDate = today.plusDays(1).getDayOfMonth();
	String dateandDay = driver.findElement(By.id("testIdPickerPrefix__DatePicker__DepartureDate")).getAttribute("value");
	String []SplitDate = dateandDay.split(",");
	String datewithMonth = SplitDate[1].trim();
	String[] datewithoutMonth = datewithMonth.split(" ");
	String Day = datewithoutMonth[0];
	//System.out.print(Day);
	int actualfinalDay = Integer.parseInt(Day);
	assertEquals(actualfinalDay,expectedDepartureDate);	
}

@Test  (priority = 2,enabled = false)
public void CheckTheReturnDateisCorrect () {
	
	LocalDate today2 = LocalDate.now();
	int expectedReturnDate = today2.plusDays(2).getDayOfMonth();
	
	String ReturnFullDate = driver.findElement(By.id("testIdPickerPrefix__DatePicker__ArrivalDate")).getAttribute("value");
	String []ReturnDatesplit = ReturnFullDate.split(",");
	String DatewithoutDay = ReturnDatesplit[1].trim();
	String [] Datenumber = DatewithoutDay.split(" ");
	String date = Datenumber[0];
	//System.out.print(date);
    int actualReturnDate = Integer.parseInt(date);
    Assert.assertEquals(actualReturnDate, expectedReturnDate);
}

@Test (priority =3, invocationCount = 5)
public void CheckLangisSelectedRandomly () {
	
String AR_URL = "https://www.almosafer.com/ar?ncr=1";
String EN_URL = "https://www.almosafer.com/en?ncr=1";
String expectedARlang = "ar";
String expectedENlang = "en";
Random rand = new Random();
int randomeIndex = rand.nextInt(2);
if (randomeIndex==1 ) {
	driver.get(AR_URL);
String ActualAR = driver.findElement(By.tagName("html")).getAttribute("lang");
Assert.assertEquals(ActualAR, expectedARlang);
}

else {
	driver.get(EN_URL);
    String ActualEN = driver.findElement(By.tagName("html")).getAttribute("lang");
    Assert.assertEquals(ActualEN,expectedENlang );	
}

}}