/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;*/


/*public class BhomPractice {

		WebDriver driver = new FirefoxDriver();
		@BeforeTest
		
		
		@Test
		
		@AfterTest

		driver.get("http://localhost:100/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		WebElement element = driver.findElement(By.xpath("//select[contains(@name,'login_theme')]"));
		Select select = new Select(element);
		select.selectByValue("orange");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		
		//driver.close();
*/




import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class BhomPractice{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @Parameters("browser")

  @BeforeClass(alwaysRun = true)
  public void setUp(String browser) throws Exception {
	  if(browser.equals("FF"))
		{
	    driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		    driver = new ChromeDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Selenium\\IEDriverServer.exe" );
		    driver = new InternetExplorerDriver();
		}
    baseUrl = "http://localhost:100/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   
  }

  @Test
  public void testAbc() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.name("user_name")).clear();
    driver.findElement(By.name("user_name")).sendKeys("admin");
    driver.findElement(By.name("user_password")).clear();
    driver.findElement(By.name("user_password")).sendKeys("admin");
    new Select(driver.findElement(By.name("login_theme"))).selectByVisibleText("Aqua");
    driver.findElement(By.name("Login")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

