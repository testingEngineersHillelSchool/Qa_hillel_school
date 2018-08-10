package ExampleTests;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearchTest {
  
  @Test
  public void verifyGoogleSearchFunctionlity() throws InterruptedException{
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://google.com");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement searchInput=driver.findElement(By.id("lst-ib"));
    searchInput.sendKeys("qa");
    List<WebElement>predictiveSearchElements=driver.findElements(By.xpath("//li[contains(@class, 'gb_T')]"));
    for(WebElement element : predictiveSearchElements){
      String text=element.getText();
      Assert.assertTrue(String.format("There is incorrect value %s", text) , text.contains("qa"));
    }
    Thread.sleep(10000);
    driver.close();
  }
  

}
