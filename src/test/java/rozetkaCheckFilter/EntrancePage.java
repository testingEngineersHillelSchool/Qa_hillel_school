package rozetkaCheckFilter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntrancePage {
  
  @FindBy(xpath = "//a[contains(@data-title, 'Ноутбуки')]")
  private WebElement tabNotebook;
  
  private final WebDriver driver;

  public EntrancePage(final WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver, this);
  }
  public AllNotebooksPage doClickOnNotebook(){
    tabNotebook.click();
    return new AllNotebooksPage(driver);
  }
}

