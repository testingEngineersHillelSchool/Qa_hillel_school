package rozetkaCheckFilter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessoriesTablesPage {
  
  @FindBy(xpath = "(//span[@class='arrow-link-inner' and contains(text(), 'планшеты')])[1]")
  private WebElement tabAllTablets;
  
  private final WebDriver driver;

  public AccessoriesTablesPage(final WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver, this);
  }
  public AllTabletsPage doClickOnAllTablets(){
    tabAllTablets.click();
    return new AllTabletsPage(driver);
  }
}
