package ExampleTests;


import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserSearchTest{
  
  private final int timeWaiting=4;
  private final WebDriver driver=new ChromeDriver();
  
  static{System.setProperty("webdriver.chrome.driver", "chromedriver.exe");}
  
  @Test
  public void verifyWikipediaSearchFunctionlity(){
    driver.manage().window().maximize();
    driver.get("https://www.wikipedia.org/");
    driver.manage().timeouts().implicitlyWait(timeWaiting, TimeUnit.SECONDS);
    WebElement searchInput=driver.findElement(By.id("searchInput"));
    String pattern="java";
    searchInput.sendKeys(pattern);
    searchInput.submit();
    WebElement headLabel=driver.findElement(By.id("firstHeading"));
    String text=headLabel.getText();
    Assert.assertTrue(String.format(pattern+" is not equal %s ", text), text.equalsIgnoreCase(pattern));
    driver.close();
  }
   @Test
  public void verifySeleniumhgSearchFunctionlity(){
    String[] values={"Java","C#","Ruby","Python","Javascript (Node)"};
    driver.manage().window().maximize();
    driver.get("https://www.seleniumhq.org/");
    driver.manage().timeouts().implicitlyWait(timeWaiting, TimeUnit.SECONDS);
    WebElement tab=driver.findElement(By.id("menu_download"));
    tab.click();
    /*Check out click tab*/
    String locatorSectionPage="//body[contains(@class, 'sectionDownload')]";
    List<WebElement>pageName=driver.findElements(By.xpath(locatorSectionPage));
    Assert.assertTrue("sectionDownload was not pushed", !pageName.isEmpty());
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    String locatorTdsElements="//div[@id='mainContent']/table[1]/tbody/tr/td[1]";
    List<WebElement>tds=driver.findElements(By.xpath(locatorTdsElements));
    List<String> strings=tds.stream().map(WebElement::getText).collect(Collectors.toList());
    Assert.assertArrayEquals(values, strings.toArray());
    driver.close();
  }
}
