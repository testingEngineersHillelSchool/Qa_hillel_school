package homeWork_3_rozetkaCompareItems;

import java.util.ArrayList;
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
                                                  "tablets/c130309/filter/producer=samsung/";
  
  @Before
  public void driverSetUp(){
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    driver.get("https://www.rozetka.com.ua/");
  }
  
  @Test
  public void verifySearchFunctionality(){
    MainPage mainPage=new MainPage(driver);
    ResultSearchPage searchPage=mainPage.navigeteByParcialLink(
                                                      SEARCH_RESULT_PARTICAL_LINK);
    List<String>comparisonProducts=new ArrayList();
    comparisonProducts.add("Планшет Samsung Galaxy Tab S2 9.7\" 2016 32GB "
                                                                +"Black (SM-T813NZKESEK)");
    comparisonProducts.add("Планшет Samsung Galaxy Tab S3 9.7\" 32GB LTE "
                                                                + "Black (SM-T825NZKASEK)");
    ResultComparePage comparePage=searchPage.getResultComparePage(
                                                                                comparisonProducts);
    comparePage.compareByType("Вид экрана");
    comparePage.compareByType("Диагональ экрана");
    comparePage.compareByType("Оперативная память");
  }
  
  @After
  public void driverTeamDown(){
    driver.close();
  }
}