package homeWork_4_hotLine;

import java.util.List;
import java.util.StringTokenizer;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ComparePricesProductPage{

  @FindBy(xpath = "//span[@data-id='prices']/span[@class='value']")
  private WebElement rangePrice;
  
  @FindBys(
    @FindBy(xpath = "//div[not(@*)]/a/span[@class='price-format']/*"))
  private List<WebElement>storePrices;
  
  private final StringBuilder builder=new StringBuilder();
  
  private final float[] range=new float[2];
  
  public ComparePricesProductPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    String stringRange=rangePrice.getText(); int count=0; 
    StringTokenizer limit=new StringTokenizer(stringRange, "–");
    while(limit.hasMoreTokens()){
      range[count++]=parserPrice(limit.nextToken());
    }
  }
  public void checkRangePrice(){
    Assert.assertTrue("Array is empty", !storePrices.isEmpty());
    for(int i=2; i<storePrices.size(); i+=2){
      float price=parserPrice(storePrices.get(i-2).getText());
      float decimal=Float.parseFloat(storePrices.get(i-1).getText().replace(',' , '.'));
      price+=decimal;
      Assert.assertTrue("Price is over range", range[0]<=price || price<=range[1]);
    }
  }
  private float parserPrice(String string){
    builder.setLength(0);
    StringTokenizer tokenizer=new StringTokenizer(string, " "); 
    while(tokenizer.hasMoreTokens()){
        builder.append(tokenizer.nextToken());
    }return Float.parseFloat(builder.toString());
  }
}
