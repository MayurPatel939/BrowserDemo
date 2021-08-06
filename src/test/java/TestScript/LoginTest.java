package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class LoginTest {
	
	public void ValidateTextBox() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebElement userName = driver.findElement(By.id("email"));
		
		WebElement password = driver.findElement(By.id("pass"));
		
		//validating username and password text field
		if(userName.isDisplayed() && userName.isEnabled()) // if both condition is true then enter the username
		{
			userName.sendKeys("mayur@gmail.com");
		}
		
		if(password.isDisplayed() && password.isEnabled())
		{
			password.sendKeys("mayur@123");
		}
		else
		{
			System.out.println("not selected or visible");
		}
		
		Thread.sleep(3000);
		
		//isSelected mathod used to validate the radio button
		
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
		
		//male
		WebElement male= driver.findElement(By.id("male"));
		
		System.out.println(male.isSelected());
		
		//female
		WebElement femail = driver.findElement(By.id("female"));
		
		System.out.println(femail.isSelected());
		
		if(male.isSelected()==false)
		{
			male.click();
		}
		
		
		

		driver.close();
	}
	}


