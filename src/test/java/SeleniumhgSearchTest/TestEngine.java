package SeleniumhgSearchTest;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEngine {

  WebDriver driver;
  
  @Before
  public void driverSetUp(){
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://www.seleniumhq.org/");
  }@Test
  public void verifySearchFunctionality(){
    final EntrancePage mainPage=new EntrancePage(driver);
    ResultPageOnClick resultPageOnClick=mainPage.doClick();
    resultPageOnClick.isProperPage();
    String[] values={"Java","C#","Ruby","Python","Javascript (Node)"};
    resultPageOnClick.verifySearchFunctionlity(values);
  }@After
  public void driverTeamDown(){
    driver.close();
  }
  
}
