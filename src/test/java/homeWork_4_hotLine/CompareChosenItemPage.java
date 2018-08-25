package homeWork_4_hotLine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompareChosenItemPage {
  
  @FindBy(xpath = "//i[@class='delete'][1]")
  private WebElement clearChosenItemButton;
  
  private final WebDriver driver;
  private final Actions actions;
  
  public CompareChosenItemPage(WebDriver driver, Actions actions) {
    this.driver=driver;
    this.actions=actions;
    PageFactory.initElements(driver, this);
    String[] pageReference=driver.getWindowHandles().toArray(new String[0]);
    driver.close();
    driver.switchTo().window(pageReference[1]);
  }
  public ProductList clearAllChosenElements(){
    new Actions(driver).moveToElement(clearChosenItemButton).build().perform();
    clearChosenItemButton.click();
    String locator="//button[@data-confirm]";
    WebElement confirmAction=driver.findElement(By.xpath(locator));
    WebDriverWait driverWait=new WebDriverWait(driver, 10);
    driverWait.until(ExpectedConditions.visibilityOf(confirmAction));
    confirmAction.click();
    return new ProductList(driver, actions);
  }
  
  
}
