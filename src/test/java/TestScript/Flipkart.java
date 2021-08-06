package TestScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class Flipkart {
	
	public void FlipkartDemo() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		
		//lunck flipkart application
		driver.get("https://www.flipkart.com/");
		
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		//search samsung galaxy s10
		driver.findElement(By.name("q")).sendKeys("Samsung Galaxy S10");
		
		//click on search button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//click in mobiles from catagories
		driver.findElement(By.xpath("//a[@title='Mobiles & Accessories']|//a[@class='_1jJQdf _2Mji8F']")).click();
		
		driver.findElement(By.xpath("(//a[@title='Mobiles']|//a[@class='_2SqgSY'])[1]")).click();

		//apply filter for Select Flipkart assured
		WebElement clickOnflipkartAssured = driver.findElement(By.xpath("//div[@class='_24_Dny _3tCU7L']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clickOnflipkartAssured);
		
		//apply filter for brand samsung
		WebElement clickOnSamsung = driver.findElement(By.xpath("//div[@class='_3879cV'][normalize-space()='SAMSUNG']"));
		js.executeScript("arguments[0].click()", clickOnSamsung);
		
		
		try {
			//Sort the entries with Price -> High to Low.
			driver.findElement(By.xpath("//div[contains(text(),'Price -- High to Low')]")).click();
		} catch (StaleElementReferenceException e) {
			
			driver.findElement(By.xpath("//div[contains(text(),'Price -- High to Low')]")).click();
		}
		
		//Read the set of results that show up on page 1.
		List <WebElement> productName = driver.findElements(By.xpath("//div[contains(@class,'_4rR01T')]"));
		
		for (int i=0;i<productName.size();i++) {
			
			try {
				String nameOfProduct = productName.get(i).getText();
				
				System.out.println(" \n Product name is : " +nameOfProduct);
			} catch (StaleElementReferenceException e) {
				
				productName = driver.findElements(By.xpath("//div[contains(@class,'_4rR01T')]"));
						
			}
		}
		//Price of product
		List <WebElement> productPrice = driver.findElements(By.xpath("//div[contains(@class,'_30jeq3 _1_WHN1')]"));
		for (int i=0;i<productPrice.size();i++) {
			
			String priceProduct = productPrice.get(i).getText();
			System.out.println(" \n Price of product is : " +priceProduct);
		}
		
		//Link to Product Details Page
		String pageURL = driver.getCurrentUrl();
		
		System.out.println(" \n Product Page URL : " +pageURL);
		
		
		driver.quit();

		
		
	}

}
