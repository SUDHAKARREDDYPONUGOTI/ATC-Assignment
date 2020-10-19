package com.atc.assignment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class Test   {

	WebDriver driver;

	/* 
	 * @Sudhakar 
	 * 
	 * */
	
	// Navigate into application URL
	
	@org.testng.annotations.Test(priority = 1)
	public void Login() {

		System.setProperty("webdriver.chrome.driver", "BrowserFile\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	
	// Login into the application with proper credentials
	
	@org.testng.annotations.Test(priority = 2)
	public void LoginPage() throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ponugotisudhakar@gmail.com");

		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Sudhakar@1");

		driver.findElement(By.xpath("//button[@name='SubmitLogin']")).click();
	}

	
	// Create the New Address
	
	@org.testng.annotations.Test(priority = 3)
	public void addNewAddress() {

		driver.findElement(By.xpath("//span[contains(text(),'My addresses')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add a new address')]")).click();

		WebElement Fname = driver.findElement(By.xpath("//input[@id='firstname']"));
		Fname.clear();
		Fname.sendKeys("Jhon");

		WebElement Lname = driver.findElement(By.xpath("//input[@id='lastname']"));
		Lname.clear();
		Lname.sendKeys("Killer");

		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("JhoneTestLabs");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Church Street Main Road");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Near Fire Station");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("California");

		Select select = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		select.selectByVisibleText("California");

		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("50001");

		Select selectCountry = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		selectCountry.selectByVisibleText("United States");

		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1122334455");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("9966332255");

		WebElement addInfo = driver.findElement(By.xpath("//textarea[@id='other']"));
		addInfo.clear();
		addInfo.sendKeys("This is My new address");

		WebElement address = driver.findElement(By.xpath("//input[@id='alias']"));
		address.clear();
		address.sendKeys("Test address");

		driver.findElement(By.xpath("//button[@id='submitAddress']")).click();

	}

	
	// select woman --> summery dresses options
	
	@org.testng.annotations.Test(priority = 4)
	public void selectWoman() throws InterruptedException {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Women')]"))).perform();
		Thread.sleep(2000);

		WebElement selectdress = driver.findElement(By.xpath("//a[contains(text(),'Summer Dresses')]"));
		selectdress.click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(text(),'List')]")).click();

	}


	
	
	 // select Add to cart 
	
	@org.testng.annotations.Test(priority = 5)
	public void addCartItem() throws InterruptedException {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='product-image-container']"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='product-image-container']")).click();

		driver.switchTo().frame(0);

		Thread.sleep(5000);

		WebElement quantity = driver.findElement(By.xpath("//p[@id='quantity_wanted_p']/input[@name='qty']"));

		quantity.click();
		quantity.clear();
		quantity.sendKeys("5");

		Thread.sleep(3000);

		Select selectSize = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
		selectSize.selectByVisibleText("L");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@name='Blue']")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		
		Thread.sleep(5000);
		

	    WebElement continueshop = driver.findElement(By.xpath("//span[@title='Continue shopping']"));
	    
	    continueshop.click();
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
	    
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//a[@title='Proceed to checkout']/span")).click();
	    
	}
	
	
	// generate Payment methods options
	
	@org.testng.annotations.Test(priority = 6)
	public void paymentCheckout() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='processAddress']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='checker']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Pay by bank wire']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='View my customer account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Order history and details')]")).click();

	}
	
	
	// take history record and signout
	@org.testng.annotations.Test(priority = 7)
	public void takeScreenshotandSignOut() throws InterruptedException {
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			
		FileUtils.copyFile(src, new File("\\Screenshots\\order.png"));
		
		}
		 
		catch (Exception e)
		 {
		  System.out.println(e.getMessage());
		 
		 }
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Log me out']")).click();
		
	}


}
