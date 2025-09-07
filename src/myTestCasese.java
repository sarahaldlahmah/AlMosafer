import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

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

@Test (priority =3, invocationCount = 4, enabled = false)
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
}
@Test (priority =4, invocationCount = 4, enabled = false)
public void CheckLangisSelectedRandomly2 () {
	
	String expectedAR = "ar";
	String expectedEN= "en";
	
	Random rand = new Random();
	int randomIndex = rand.nextInt(2);
	String URL_AR = "https://www.almosafer.com/ar?ncr=1";
	String URL_EN = "https://www.almosafer.com/en?ncr=1";
      if (randomIndex == 0) {
    	  driver.get(URL_AR);
    String ActalARLang= driver.findElement(By.tagName("html")).getAttribute("lang");
    Assert.assertEquals(ActalARLang, expectedAR); }
    else {
     driver.get(URL_EN);
     String ActalEnLang = driver.findElement(By.tagName("html")).getAttribute("lang");
     Assert.assertEquals(ActalEnLang, expectedEN);
    	
    }
        	  
      }	

@Test (priority =4, invocationCount = 1, enabled = true)
public void checkTheHotelTab () {
 //driver.findElement(By.id("tab-hotels")).click();
 
 String []cityinEn =  {"Dubai","Jeddah","Riyadh"};
 String []cityinAR = {"دبي","جدة","رياض"};
 Random rand2 = new Random();
 int randomIndexforEn = rand2.nextInt(cityinEn.length);
 int randomIndexforAR = rand2.nextInt(cityinAR.length);
 
 
//driver.get("https://www.almosafer.com/ar?ncr=1");
driver.findElement(By.id("tab-hotels")).click();

 String currentLang = driver.findElement(By.tagName("html")).getAttribute("lang");
// System.out.println("************"+ currentLang);
 if (currentLang.contains("en")) {
	driver.findElement(By.id("DesktopSearchWidget_Destination_InputField_Test_Id")).sendKeys(cityinEn[randomIndexforEn]);
 }
 else {
		driver.findElement(By.id("DesktopSearchWidget_Destination_InputField_Test_Id")).sendKeys(cityinAR[randomIndexforAR]);
 }		
List <WebElement> suggestions = driver.findElements(By.cssSelector(".__ds__comp.undefined.MuiBox-root.alm-desktop-j7qwjs"));
//System.out.println(suggestions.size()+"***********");
suggestions.get(0).click();
}
 
 @Test (priority =5, invocationCount = 1, enabled = true)
 public void ChecknumberOfPeopleIsCorrect() {
	driver.findElement(By.cssSelector(".__ds__comp.undefined.MuiBox-root.alm-desktop-itulbq")).click();
	List <WebElement> options = driver.findElements(By.cssSelector(".__ds__comp.undefined.MuiBox-root.alm-desktop-16wwg55"));
	
	Random rand4= new Random();
	int index = rand4.nextInt(options.size());
	if (index == 0)
		options.get(index).click();
	else if  (index == 1)
		options.get(index).click();	
}
 
 @Test (priority = 6)
 public void checkTheSearchResult () {
  /*   driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiLoadingButton-root.MuiButton-contained.MuiButton-containedCoral100.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-root.MuiLoadingButton-root.MuiButton-contained.MuiButton-containedCoral100.MuiButton-sizeMedium.MuiButton-containedSizeMedium.__ds__comp.alm-desktop-r5xm0l")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	 WebElement searchElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".MuiTypography-root.MuiTypography-heading4SemBld.__ds__comp.undefined.muiltr-13ipltw"))); 
	 Assert.assertEquals(searchElement.getText().contains("found") || searchElement.getText().contains("وجدنا"), true);  	  	 
	*/
	 driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiLoadingButton-root.MuiButton-contained.MuiButton-containedCoral100.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-root.MuiLoadingButton-root.MuiButton-contained.MuiButton-containedCoral100.MuiButton-sizeMedium.MuiButton-containedSizeMedium.__ds__comp.alm-desktop-r5xm0l")).click(); 
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	 WebElement searchResult = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".MuiTypography-root.MuiTypography-heading4SemBld.__ds__comp.undefined.muiltr-13ipltw")));
	 Assert.assertEquals(searchResult.getText().contains("found") || searchResult.getText().contains("وجدنا"),true);  
	 
 }
 
 @Test (priority = 7, enabled = true)
 public void checkSortingLtoH () {
	driver.findElement(By.xpath("//div [@data-testid = 'srp_sort_LOWEST_PRICE']")).click();
	List <WebElement> listofPrices = driver.findElements(By.cssSelector(".MuiTypography-root.MuiTypography-heading3SemBld.__ds__comp.undefined.muiltr-18vmb2l"));
	List <Double> thePricesasNumbers = new ArrayList<Double>();
	for (int i = 0; i<listofPrices.size(); i++)
	{
		if (listofPrices.get(i).getText().contains("Search"))
			continue;
		String number = listofPrices.get(i).getText().replace("⃀","").trim();
		Double numbers = (Double) Double.parseDouble(number) ;
		thePricesasNumbers.add(numbers);	
	}
	
	System.out.println(thePricesasNumbers);
	List <Double> sortedList = new ArrayList<Double>(thePricesasNumbers);
	Collections.sort(sortedList);
	Assert.assertEquals(thePricesasNumbers,sortedList);
	
	
 }
 
 
}