package SeleniumhgSearchTest;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ResultPageOnClick{
  
  @FindBys(
    @FindBy(xpath="//div[@id='mainContent']/table[1]/tbody/tr/td[1]"))
  private List<WebElement>webElements;
  
  @FindBys(
    @FindBy(xpath="//body[contains(@class, 'sectionDownload')]"))
  private List<WebElement>identifierNeededPage;

  public ResultPageOnClick(final WebDriver driver){
    PageFactory.initElements(driver, this);
  }
  public void isProperPage(){
    Assert.assertTrue("sectionDownload was not pushed", 
                                                              !identifierNeededPage.isEmpty());
  }
  public void verifySearchFunctionlity(String[] pattern){
    List<String> strings=webElements.stream().map(WebElement::getText).
                                                                        collect(Collectors.toList());
    Assert.assertArrayEquals(pattern, strings.toArray());
  }
  
}
