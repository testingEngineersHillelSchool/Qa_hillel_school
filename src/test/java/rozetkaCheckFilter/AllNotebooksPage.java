package rozetkaCheckFilter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AllNotebooksPage {

  
@FindBy(xpath = "//a[contains(text(), 'Планшеты')]")
  private WebElement tabTablets;
  
  private final WebDriver driver;

  public AllNotebooksPage(final WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver, this);
  }
  public AccessoriesTablesPage doClickOnTablets(){
    tabTablets.click();
    return new AccessoriesTablesPage(driver);
  }
}
