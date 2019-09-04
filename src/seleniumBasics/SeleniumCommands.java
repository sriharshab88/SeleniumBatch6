package seleniumBasics;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumCommands {

	@Test
	public static void seleniumBasicCommands() {
		WebDriver driver = new FirefoxDriver();  //Launch the browser
		driver.get("http://automationpractice.com/index.php");  //This will open the URL mentioned
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement signInLink = driver.findElement(By.xpath("//a[@class='login']"));
		signInLink.click();
		String signInPageTitle = driver.getTitle();
		System.out.println(signInPageTitle);
		assertEquals(signInPageTitle, "Login - My Store", "FAIL -- Signin page title did not match");
		driver.close();
	}
	
	@Test
	public static void loginUseCase() {
		WebDriver driver = new FirefoxDriver();  //Launch the browser
		driver.get("http://automationpractice.com/index.php");  //This will open the URL mentioned
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement signInLink = driver.findElement(By.xpath("//a[@class='login']"));
		signInLink.click();
		
		WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='email']"));
		emailTextBox.sendKeys("testbatch6@test.com");
		
		driver.findElement(By.id("passwd")).sendKeys("123456");
		
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		
		String userAccountName = driver.findElement(By.xpath("//a[@class='account']/span")).getText();
		System.out.println(userAccountName);
		assertEquals(userAccountName, "Tester Harsha", "FAIL -- User Account name did not match");
		
		driver.quit();
	}
	
	
}
