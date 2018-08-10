package wikipediaSearchTest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEngine {
  
  WebDriver driver;
  
  @Before
  public void driverSetUp(){
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://www.wikipedia.org/");
  }@Test
  public void verifySearchFunctionality(){
    final EntrancePage mainPage=new EntrancePage(driver);
    String inputText="java";
    mainPage.inputPattern(inputText);
    final ResultPageOnInput resultPageOnInput=mainPage.confirmInputedText();
    resultPageOnInput.verifySearchFunctionlity(inputText);
  }@After
  public void driverTeamDown(){
    driver.close();
  }
}
