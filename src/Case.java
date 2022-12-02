//case

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Case {
	public static void main(String[] args) throws InterruptedException {
		
		String BBN = "37400000324";
		String detail_of_concern = "deatils";
		String remarks = "remarkss";		
		
		   
		System.setProperty("webdriver.chrome.driver","D:\\Java\\selenium\\chromedriver.exe"); // driver path // driver path
		ChromeDriver driver = new ChromeDriver();// webdriver name

		driver.get("https://sbcdev.crmnext.com/sag7/app/login/login"); // url
		driver.manage().window().maximize(); // maximize window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		//Login screen
		driver.findElement(By.id("TxtName")).sendKeys("109840"); //loginid
		driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
		driver.findElement(By.name("command")).click();// click enter
		
		//quick link and customer search
		
		Actions quick = new Actions(driver);
		quick.moveToElement(driver.findElement(By.className("icon-link"))).perform();
		//quick.
		// driver.findElem
		driver.findElement(By.xpath("//*[@id=\"QuickLinksDiv\"]/ul/li[1]/a/span[1]")).click();
		
		driver.findElement(By.name("100000012")).sendKeys(BBN);
		driver.findElement(By.linkText("Fetch")).click();
		
		driver.findElement(By.linkText(BBN)).click();
		driver.findElement(By.linkText("Start Your Journey")).click();
		
		Set <String> windows = driver.getWindowHandles();
		System.out.println(windows);
		
		Iterator <String> pc = windows.iterator();
		String PW = pc.next();
		String CW = pc.next();
		driver.switchTo().window(CW);
		
		driver.findElement(By.id("2")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.name("CASE_SUBCATEGORY1")).sendKeys("Customer Initiated Info Maintenance");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name=\"CASE_SUBCATEGORY1\"]")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name=\"CASE_SUBCATEGORY1\"]")).sendKeys(Keys.ENTER);
Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a")).click();
	
	driver.findElement(By.name("cust_878")).sendKeys(detail_of_concern);   
	driver.findElement(By.name("cust_471")).sendKeys(remarks);       
	
	Select employ = new Select (driver.findElement(By.name("cust_723")));
	employ.selectByValue("2");
	
	Select address = new Select (driver.findElement(By.name("cust_1673")));
	address.selectByValue("Contact Creation");
	

	driver.findElement(By.name("cust_1817")).sendKeys("pakist");
	Thread.sleep(1000);
	driver.findElement(By.name("cust_1817")).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.name("cust_1817")).sendKeys(Keys.ENTER);
	driver.findElement(By.name("cust_1674")).sendKeys("house");
	driver.findElement(By.name("cust_1675")).sendKeys("street");
	driver.findElement(By.name("cust_1687")).sendKeys("4354435434");
	
	driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).click();
System.out.println(driver.findElement(By.className("f13")).getText());
	
	driver.switchTo().window(PW);
	driver.findElement(By.name("ProfileImage_header")).click();
	driver.findElement(By.linkText("Logout")).click();
	// driver.close();
	driver.findElement(By.id("TxtName")).sendKeys("120047"); //loginid
	driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
	driver.findElement(By.name("command")).click();// click enter
	
	Actions quick1 = new Actions(driver);
	quick1.moveToElement(driver.findElement(By.className("icon-service"))).perform();
	driver.findElement(By.cssSelector("span[title='cases']")).click();//
	
	Select bucket1 = new Select(driver.findElement(By.name("QueryCategoryId")));
	bucket1.selectByVisibleText("Case");
	
	Select bucket2 = new Select(driver.findElement(By.name("QueryViewId")));
	bucket2.selectByVisibleText("Assigned to Department");
	driver.findElement(By.xpath("//*[@id=\"objectWrapper\"]/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/a")).click();
	driver.findElement(By.name("checkbox0")).click();
	
	
	int[][] arr = { { 32, 4, 12 }, { 21, 43, 23, 123, 123 } };
	}

}
