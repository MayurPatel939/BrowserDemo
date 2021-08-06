package TestScript;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDemo {
	
	@Test
	public void EdgeBrowser() throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		WebElement clickOnLobinBtn = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		

		JavascriptExecutor login = (JavascriptExecutor) driver;
		login.executeScript("arguments[0].click()", clickOnLobinBtn);
		
		
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("8141674582");
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mayur_7765898582");
		
		driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Login')]")).click();
		
		String Actualtitle = driver.getTitle();
		System.out.println("Title of current page is : "+Actualtitle);
		
		String exp_Title = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		
		if(exp_Title.equals(Actualtitle)) {
			
			System.out.println("test is pass");
			
		}
		else {
			System.out.println("test is fail");
		}
		
		Thread.sleep(2000);
		
		driver.close();
		
		
	}
	

}
