package seleniumBasics;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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
	
	@Test
	public static void createAccountUseCase() {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+File.separator+"chromedriver");
		WebDriver driver = new ChromeDriver();  //Launch the browser
		driver.get("http://automationpractice.com/index.php");  //This will open the URL mentioned
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement signInLink = driver.findElement(By.xpath("//a[@class='login']"));
		signInLink.click();
		
		WebElement createAccountModule = driver.findElement(By.xpath("//form[@id='create-account_form']"));
		assertTrue(createAccountModule.isDisplayed(), "FAIL -- Create Account Module is not displayed");
		
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("newAccountTest2@test.com");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("NewTester1Firstname");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("NewTester1LastName");
		driver.findElement(By.id("passwd")).sendKeys("567890");
		
		WebElement selectDateDD = driver.findElement(By.xpath("//select[@id='days']"));
		Select dateDropDown = new Select(selectDateDD);
		dateDropDown.selectByIndex(13);
		
		WebElement selectMonthDD = driver.findElement(By.xpath("//select[@id='months']"));
		Select monthDropDown = new Select(selectMonthDD);
		monthDropDown.selectByValue("9");
		
		WebElement selectYearDD = driver.findElement(By.xpath("//select[@id='years']"));
		Select yearDropDown = new Select(selectYearDD);
		yearDropDown.selectByValue("1985");
		
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		driver.findElement(By.xpath("//input[@id='optin']")).click();
		
		
		WebElement addressFirstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		addressFirstName.clear();
		addressFirstName.sendKeys("SeleniumTest1");
		
		WebElement addressLastName = driver.findElement(By.xpath("//input[@id='lastname']"));
		addressLastName.clear();
		addressLastName.sendKeys("newUser");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("123, 4th Avenue");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("California");
		
		/*WebElement selectStateDD = driver.findElement(By.xpath("//select[@id='id_state']"));
		Select stateDropDown = new Select(selectStateDD);
		stateDropDown.selectByValue("5");*/
		
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("90001");
		driver.findElement(By.id("phone_mobile")).sendKeys("6668889990");
		
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		
		String pageName = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
		assertEquals(pageName, "MY ACCOUNT", "FAIL -- Page Name is not displayed properly");
		
	}
	
	
}
