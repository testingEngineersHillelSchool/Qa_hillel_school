package rozetkaCheckFilter;

import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AllTabletsPage {
  
  @FindBys(
    @FindBy(xpath="//div[contains(@class, 'g-i-tile-i-title')]/a"))
  List<WebElement>tabletsList;  
  
  @FindBy(xpath ="//i[@class='filter-parametrs-i-l-i-default-title' and text()='Samsung']")   
  WebElement checkBoxFilter;
   
  private final WebDriver driver;
  
  public AllTabletsPage(final WebDriver driver){
    this.driver=driver;
//    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//    WebDriverWait driverWait=new WebDriverWait(driver, 10);
//    driverWait.until(ExpectedConditions.elementToBeClickable(
//    By.xpath("//i[@class='filter-parametrs-i-l-i-default-title' and text()='Samsung']")));
//    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    PageFactory.initElements(driver, this);
  }
  public List<String>getItemsList(String pattern){
    List<String>result=new ArrayList();
    for(WebElement element : tabletsList){
      String string=element.getText().trim().toLowerCase();
      if(string.equals(pattern)){result.add(string);}
    }return result;
  }
  public SamsungFilterPage doClickOnFilter(){
    checkBoxFilter.click();
    return new SamsungFilterPage(driver);
  }
}
