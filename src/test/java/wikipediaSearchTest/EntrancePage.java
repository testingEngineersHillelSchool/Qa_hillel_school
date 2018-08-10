package wikipediaSearchTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntrancePage {
  @FindBy(id="searchInput")
  private WebElement searchInput;
  
  private final WebDriver driver;

  public EntrancePage(final WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver, this);
  }
  public void inputPattern(String pattern){
    searchInput.sendKeys(pattern);
  }
  public ResultPageOnInput confirmInputedText(){
    searchInput.submit();
    return new ResultPageOnInput(driver);
  } 
}
