package homeWork_3_rozetkaCheckFilter;

import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResultSearchPage {
  
  @FindBys(
    @FindBy(xpath="//div[contains(@class, 'g-i-tile-i-title')]/a"))
  List<WebElement>tabletsList;  
  
  @FindBy(xpath ="//i[@class='filter-parametrs-i-l-i-default-title' and text()='Samsung']")   
  WebElement checkBoxFilter;
   
  private final WebDriver driver;
  
  public ResultSearchPage(final WebDriver driver){
    this.driver=driver;
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
