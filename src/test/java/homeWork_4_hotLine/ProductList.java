package homeWork_4_hotLine;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductList{
  
  private final WebDriver driver;
  private final Actions actions;
  private final WebDriverWait driverWait;
  
  private final String BLOCK_PRODUCT="//a[contains(text(), '%s')]/ancestor::li%s";
  
  private final String CHECK_BOX="//input";
  
  private final String COMPARE_PRICE_BUTTON=  
                                                            "//a[@data-tracking-id='catalog-13']";
  
  private final String WINDOW_CONFIRM=
                  "//div[@data-dropdown-id='compare']";  
  
  private final String CONFIRM_BUTTON=WINDOW_CONFIRM+"//a[@target]";
  
  private final String EMPTY_LIST=WINDOW_CONFIRM+
                                "//p[contains(text(), 'Ваш список \"Сравнения\" пуст.')]";
  
  
  @FindBy(xpath = "//div[@class='item-compare']")
  private WebElement compareButton;
  

  public ProductList(WebDriver driver, Actions actions) {
    this.driver=driver;
    this.actions=actions;
    this.driverWait=new WebDriverWait(driver, 5);
    PageFactory.initElements(driver, this);
  }
  public void selectProducts(List<String>elements) {
    for(String product : elements){ 
      clickOnElement(null, String.format(BLOCK_PRODUCT, product, CHECK_BOX));
    }
  }
  public CompareChosenItemPage clickOnCompareButton(){
    ((JavascriptExecutor) driver).executeScript("scroll(255, 0)");
    driverWait.until(ExpectedConditions.elementToBeClickable(compareButton));
    clickOnElement(compareButton, null);
    driverWait.until(ExpectedConditions.attributeContains(
                                          By.xpath(WINDOW_CONFIRM), "class", "active"));
    WebElement confirmButton=driver.findElement(By.xpath(CONFIRM_BUTTON));
    clickOnElement(confirmButton, null);
    return new CompareChosenItemPage(driver, actions);
  }
  public ComparePricesProductPage clickOnComparePriceButtonElement(
  String product){clickOnElement(null, String.format(BLOCK_PRODUCT, 
    product, COMPARE_PRICE_BUTTON));
    return new ComparePricesProductPage(driver);
  } 
  
  public void checkEmptyList(){
    clickOnElement(compareButton, null);
    driverWait.until(ExpectedConditions.numberOfElementsToBe(
                                                          By.xpath(WINDOW_CONFIRM), 1));
    driver.findElement(By.xpath(EMPTY_LIST));
  }
  private void clickOnElement(WebElement element, String xpath){
    if(element==null){element=driver.findElement(By.xpath(xpath));}
    actions.moveToElement(element).click().perform();
  }
  
}
