package homeWork_4_hotLine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntrancePage {
  
  private final WebDriver driver;
  private final Actions actions;

  public EntrancePage(WebDriver driver, Actions actions) {
    this.driver = driver;
    this.actions = actions;
  }
  
  public ProductList navigateToProductList(){
    String smartPhoneTagLocator="//a[@href='/mobile/']";
    WebElement smartPhoneTag=driver.findElement(By.xpath(smartPhoneTagLocator));
    actions.moveToElement(smartPhoneTag).build().perform();
    String[] trackTo={"//span[@class='telefony-i-garnitury']",
                          "//a[contains(text(), 'Смартфоны и мобильные телефоны')]"};
    WebDriverWait driverWait=new WebDriverWait(driver, 10);
    for(String path : trackTo){
      WebElement item=driver.findElement(By.xpath(path));
      driverWait.until(ExpectedConditions.visibilityOf(item));
      actions.moveToElement(item).click().build().perform();
    }return new ProductList(driver, actions);
  }
}
