package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaMainPage {
  
  @FindBy(xpath="//input[contains(@class, 'rz-header-search-input-text')]")
  private WebElement searchInput;
  
  @FindBy(xpath="//button[text()='Найти']")
  private  WebElement serchButton;

   private final WebDriver driver; 
  
  public RozetkaMainPage(final WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver, this);
  }
  public void typeSearchedText(final String textSearch){
    searchInput.sendKeys(textSearch);
  }
  public SearchResultPage clickFindButton(){
    serchButton.click();
    return new SearchResultPage(driver);
  }
  
}
