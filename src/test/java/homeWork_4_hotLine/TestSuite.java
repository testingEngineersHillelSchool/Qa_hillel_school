package homeWork_4_hotLine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSuite{
  
  private WebDriver driver;
  private Actions actions;
  
  @Before
  public void driverSetUp(){
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://hotline.ua");
    actions=new Actions(driver);
  }
  @Test
  public void removeProductsFromCompareList(){
    EntrancePage entrancePage=new EntrancePage(driver, actions);
    ProductList app=entrancePage.navigateToProductList();
    List<String> products=new ArrayList(2);
    products.add("Samsung Galaxy S8 64GB Black (SM-G950FZKD)");
    products.add("Apple iPhone X 64GB Space Gray (MQAC2)");
    app.selectProducts(products);
    CompareChosenItemPage ccip=app.clickOnCompareButton();
    app=ccip.clearAllChosenElements();
    app.checkEmptyList();
  }
  @Test
  public void validPricesRangeProduct(){
    EntrancePage entrancePage=new EntrancePage(driver, actions);
    ProductList app=entrancePage.navigateToProductList();
    String product="Xiaomi Redmi Note 5 4/64GB Black";
    ComparePricesProductPage cppp=app.clickOnComparePriceButtonElement(product);
    cppp.checkRangePrice();
  }
  @After
  public void driverTeamDown(){
    driver.close();
  }
}
