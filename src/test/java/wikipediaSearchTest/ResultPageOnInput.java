package wikipediaSearchTest;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPageOnInput {
  
  @FindBy(id="firstHeading")
  private WebElement headLabel;
  
  public ResultPageOnInput(final WebDriver driver){
    PageFactory.initElements(driver, this);
  }
  public void verifySearchFunctionlity(String pattern){
    String text=headLabel.getText();
    Assert.assertTrue(String.format(pattern+" is not equal %s ", text), 
                                                                  text.equalsIgnoreCase(pattern));
  }
}
