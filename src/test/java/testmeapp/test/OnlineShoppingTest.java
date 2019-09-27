package testmeapp.test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import testmeapp.test.Drivers;

public class OnlineShoppingTest {
	
	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	@BeforeTest
	public void startReportBeforeTest()
	{
		driver=Drivers.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		System.out.println("chrome open");
	}
	
	@Test(priority=1)
	public void testRegistration()
	{
		Assert.assertEquals(driver.getTitle(),"Home");
		driver.findElement(By.linkText("SignUp")).click();
		Assert.assertEquals(driver.getTitle(),"Sign Up");
		driver.findElement(By.name("userName")).sendKeys("Minii3019");
		driver.findElement(By.name("firstName")).sendKeys("Minii");
		driver.findElement(By.name("lastName")).sendKeys("Mouse");
		driver.findElement(By.name("password")).sendKeys("Cheesey309");
		driver.findElement(By.name("confirmPassword")).sendKeys("Cheesey309");
		driver.findElement(By.xpath("//input[@type='radio'and @value='Female']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("miniimouse309@gmail.com");
		driver.findElement(By.name("mobileNumber")).sendKeys("9841095095");
		driver.findElement(By.name("dob")).sendKeys("09/03/1996");
		driver.findElement(By.name("address")).sendKeys("DisneyLand");
		driver.findElement(By.name("answer")).sendKeys("neverland");
		WebElement k = driver.findElement(By.id("userName")); 
		String texte = k.getAttribute("value"); 
		if(texte.isEmpty())
		{ 
			System.out.println("input box is empty");
			driver.findElement(By.name("userName")).sendKeys("Minii369");
			
			}
		System.out.println(texte);
		driver.findElement(By.name("Submit")).click();
		Assert.assertEquals(driver.getTitle(),"Login");
		System.out.println("you have registered successfully");
		
		
	}
	@Test(priority=2)
	public void testLogin()
	{
		Assert.assertEquals(driver.getTitle(),"Login");
		driver.findElement(By.name("userName")).sendKeys("lalitha");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
		Assert.assertEquals(driver.getTitle(),"Home");
	}
	@Test(priority=3)
	public void textcart()
	{
	/*Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span"))).build().perform();
	driver.findElement(By.linkText("Electronics")).click();
	wait=new WebDriverWait(driver,100);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span")));
	
	driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/ul/li[1]/ul/li[1]/a/span")).click();
	Assert.assertEquals(driver.getTitle(),"Search");
	driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
	Assert.assertEquals(driver.getTitle(),"View Cart");
	driver.findElement(By.linkText("Checkout")).click();
	Assert.assertEquals(driver.getTitle(),"Cart Checkout");*/
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span"))).build().perform();
		driver.findElement(By.linkText("Electronics")).click();
		wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Travel Kit")));
		driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[2]/a/span")).click();
		Assert.assertEquals(driver.getTitle(),"Search");
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
		Assert.assertEquals(driver.getTitle(),"View Cart");
		driver.findElement(By.linkText("Checkout")).click();
		Assert.assertEquals(driver.getTitle(),"Cart Checkout");
		driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
	}
	@Test(priority=4)
	public void testPayment()
	{
		//Assert.assertEquals(driver.getTitle(),"Cart Checkout");
		//driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//Assert.assertEquals(driver.getTitle(), "Payment Gateway");
		WebElement b=driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i"));
		b.click();
		WebElement c=driver.findElement(By.xpath("//*[@id=\"btn\"]"));
		c.click();
		driver.findElement(By.name("username")).sendKeys("123456");
		driver.findElement(By.name("password")).sendKeys("Pass@456");
		driver.findElement(By.xpath("//input[@type='submit'and @value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
		driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[2]/input")).click();
		Assert.assertEquals(driver.getTitle(),"Order Details");
		driver.findElement(By.linkText("Home")).click();
		
	}
	@AfterMethod
	public void getResultAfterMethod(ITestResult result)throws IOException
	{
		
	}
	@AfterTest
	public void endReportAfterTest()
	{
		
	}
	
	}
	
	
	
	


