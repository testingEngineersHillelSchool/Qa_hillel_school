package homeWork_3_rozetkaCompareItems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ResultComparePage {

  
  @FindBys(
    @FindBy(xpath="//div[@class='comparison-t-row']"))
  private List<WebElement> compareItemsList;
  
  private final Map<String, List<WebElement>>mapElements=new HashMap();
  
  
  public ResultComparePage(final WebDriver driver){
    PageFactory.initElements(driver, this);
    prepareMapElements();
  }
  public void compareByType(String type){
    List<WebElement>elements=mapElements.get(type);
    Assert.assertNotNull("Not exist such type", elements);
    for(int i=1; i<elements.size(); i++){
      String currentValue=elements.get(i).getText().trim();
      String previousValue=elements.get(i-1).getText().trim();
      Assert.assertEquals("values are not equal", currentValue, previousValue);
    }
  }
  private void prepareMapElements(){
    String locatorType=".//div[contains(@class,'comparison-t-cell-first')]";
    String locatorValue=".//span[contains(@class,'chars-value-inner')]";
    for(WebElement row : compareItemsList){
      String type=row.findElement(By.xpath(locatorType)).getText().trim();
      mapElements.put(type, row.findElements(By.xpath(locatorValue)));
    }
  }
}
