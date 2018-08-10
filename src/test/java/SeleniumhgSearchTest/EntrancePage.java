package SeleniumhgSearchTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntrancePage {
  @FindBy(id="menu_download")
  private WebElement tabElement;
  
  private final WebDriver driver;

  public EntrancePage(final WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver, this);
  }
  public ResultPageOnClick doClick(){
    tabElement.click();
    return new ResultPageOnClick(driver);
  }
   
}
