package rozetkaCheckFilter;

import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SamsungFilterPage {
  
  @FindBys(
    @FindBy(xpath="//div[@class=\"g-i-tile-i-title clearfix\"]/a"))
  List<WebElement>samsungItemList;  

  public SamsungFilterPage(final WebDriver driver){
     PageFactory.initElements(driver, this);
  }
  public void verifySearchFunctionlity(List<String>src){
    for(int i=0; i<src.size(); i++){
      String source=src.get(i);
      String result=samsungItemList.get(i).getText();
      Assert.assertTrue(source+" not equals "+result, result.contains(source));
    }
  }
}
