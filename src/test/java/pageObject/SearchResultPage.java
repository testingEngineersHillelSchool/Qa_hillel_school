package pageObject;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage{
  
  @FindBys(
    @FindBy(xpath="//div[@data-location='SearchResults']"))
  private List<WebElement>searchWebResult; 

  public SearchResultPage(final WebDriver driver){
    PageFactory.initElements(driver, this);
  }
  public List<String>getSearchResultsText(){
    final List<String>searchResult=new ArrayList();
    for(final WebElement searchResultItem : searchWebResult){
      searchResult.add(searchResultItem.getText());
    }return searchResult;
  }
}
