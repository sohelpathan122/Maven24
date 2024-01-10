package Maven_Script;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Maven_FirstTest 
{
	  WebDriver driver;
  @BeforeTest
  public void LaunchBrowser() 
  {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions co=new ChromeOptions();
	  co.addArguments("--remote-allow-origins=*");
	  driver=new ChromeDriver(co);
	  driver.manage().window().maximize();
	  
  }
 @Test
  public void dropdown() throws InterruptedException
  {
	  driver.get("https://blazedemo.com/");
	  WebElement list=driver.findElement(By.name("fromPort"));
	  Select s=new Select(list);
	  Thread.sleep(2000);
	  List<WebElement> options=s.getOptions();
	  System.out.println(options.size());
	  
	  for(int i=0; i<options.size(); i++)
	  {
		  System.out.println(options.get(i).getText());
	  }
	  
  }
  @AfterTest
  public void closebrowser()
  {
	  driver.close();
  }
  
		  
  
}
