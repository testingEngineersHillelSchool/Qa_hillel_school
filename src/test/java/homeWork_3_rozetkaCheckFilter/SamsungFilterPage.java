package homeWork_3_rozetkaCheckFilter;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SamsungFilterPage {
  
  @FindBys(
    @FindBy(xpath="//div[@class='g-i-tile-i-title clearfix']/a"))
  List<WebElement>samsungItemList;  

  public SamsungFilterPage(final WebDriver driver){
     driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
     WebDriverWait driverWait=new WebDriverWait(driver, 5);
     driverWait.until(ExpectedConditions.numberOfElementsToBe( 
     By.xpath("//div[@class='g-i-tile-i-title clearfix']/a"), 12));
     PageFactory.initElements(driver, this);
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  public void verifySearchFunctionlity(List<String>src){
    List<String>elementsList=samsungItemList.stream().map(WebElement :: 
                                                          getText).collect(Collectors.toList());
    Assert.assertEquals("Arrays are not equals ", elementsList.subList(0, src.size()), src);
  }
}
