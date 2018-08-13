package homeWork_3_rozetkaCompareItems;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ResultSearchPage {
  
  @FindBy(xpath = "//a[contains(@class, 'hub-i-comparison-link-count')]")
  private WebElement compareButton;
  
  private final static String PRODACT_COMPARE="//div[contains(@class,"
  +" 'g-i-tile-i-title' )]/a[contains(text(), '%s')]/parent::div/following-sibling::"
  +"div[contains(@class,'g-tools-container')]//div[@name='comparison_new_catalog']";
  private final static String PARENT_PRODACT_COMPARE="//div[contains("
  +"@class, 'g-i-tile-i-title' )]/a[contains(text(), '%s')]/ancestor::div["
  +"@data-view_type='catalog_with_hover']";

  private final WebDriver driver;

  public ResultSearchPage(final WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver, this);
  }
  public ResultComparePage getResultComparePage(List<String>goodsList){
    Actions actions = new Actions(driver);
    for(String prodact : goodsList){
      actions.moveToElement(driver.findElement(By.xpath(
      String.format(PARENT_PRODACT_COMPARE, prodact)))).build().perform();
      WebElement element=driver.findElement(By.xpath(
                                            String.format(PRODACT_COMPARE, prodact)));
      element.click();
      try{
        Thread.sleep(2000);
      }catch (InterruptedException ex) {ex.printStackTrace();}
    }
    compareButton.click();      
    String buttonLocator="(//span[@class='btn-link-i'])[2]";
    driver.findElement(By.xpath(buttonLocator)).click();
    return new ResultComparePage(driver);
  }
}
