package yummly;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ReceipePageTest {

	 WebDriver driver;
	  

	    @BeforeTest
	    public void setUp() throws MalformedURLException {
	      
	        System.setProperty("webdriver.chrome.driver", "C://development//sqa//automation//lib//chromedriver.exe");
	       
	        driver = new ChromeDriver();
	    }	

  @Test
  public void SearchRecipe(){
	  driver.get("https://www.yummly.com/");
	  driver.manage().timeouts().implicitlyWait(5,  TimeUnit.SECONDS);
	
	  //driver.findElement(By.xpath(".//*[@id='searchbox-input']")).sendKeys("chocolate");
	//  driver.findElement(By.xpath("//section/form/span[1]/div/input[@id='searchbox-input']"));
	  
	 // driver.findElement(By.cssSelector("section.nav-section.search-section")).sendKeys("mala");
	//System.out.println(col.findElements(By.tagName("a")).size());
	  
	  //WebElement recipecontainer= driver.findElement(By.className("RecipeContainer"));
	  WebElement recipecontainer= driver.findElement(By.xpath(".//*[@id='mainApp']/div/div[1]/div[1]/div[2]/div/div[1]/a"));
			
		String Beforeclicking = null;
		String Afterclicking;
		for(int i=0;i<recipecontainer.findElements(By.tagName("a")).size();i++)
		{
		
			
			if(recipecontainer.findElements(By.tagName("a")).get(0).getText().contains("chocolatecake"))
			{
				Beforeclicking = driver.getTitle();
			
				recipecontainer.findElements(By.tagName("a")).get(0).click();
				break;
				}
		}
		Afterclicking =driver.getTitle();
		if(Beforeclicking!=Afterclicking)
		{
			//if(driver.getPageSource().contains("chocolatecake"))
		
				Assert.assertTrue(driver.getPageSource().contains("chocolatecake"));
		
			
	}
  }
	
}

