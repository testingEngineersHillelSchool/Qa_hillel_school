package pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class RozetkaTestSuite {
  
  WebDriver driver;
  
  @Before
  public void driverSetUp(){
  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://rozetka.com.ua");
  }@Test
  public void verifySearchFunctionality(){
    final RozetkaMainPage mainPage=new RozetkaMainPage(driver);
    mainPage.typeSearchedText("Samsung Galaxy s7");
    final SearchResultPage searchResultPage=mainPage.clickFindButton();
    final List<String>searchResultsText = searchResultPage.getSearchResultsText();
  }@After
  public void driverTeamDown(){
    driver.close();
  }
}
