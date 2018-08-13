package homeWork_3_rozetkaCheckFilter;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEngine {
  
  WebDriver driver;
  
  private static final String SEARCH_RESULT_PARTICAL_LINK=
                                                                            "tablets/c130309/filter/";
  
  @Before
  public void driverSetUp(){
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.get("https://www.rozetka.com.ua/");
  }@Test
  public void verifySearchFunctionality(){
    final EntrancePage mainPage=new EntrancePage(driver);
    ResultSearchPage resultSearchPage=mainPage.navigeteByParcialLink(
                                                      SEARCH_RESULT_PARTICAL_LINK);
    String brendName="samsung";
    List<String>brendItems=resultSearchPage.getItemsList(brendName);
    SamsungFilterPage samsungFilterPage=resultSearchPage.doClickOnFilter();
    samsungFilterPage.verifySearchFunctionlity(brendItems);
  }@After
  public void driverTeamDown(){
    driver.close();
  }
}
