import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sleniumpractice2 {
	public static void main(String[] args) throws IOException, InterruptedException {


		System.setProperty("webdriver.chrome.driver", "D:\\Java\\selenium\\chromedriver.exe"); // driver path
		ChromeDriver driver = new ChromeDriver(); // webdriver name

		driver.get(
				"https://sbcdev.crmnext.com/sn/app/crmnextobject/edit/Lead?x=kn2avyy3fmqfk3jf4epf68yjhh73ef2pkx64xlkhergabql2p2la");
		driver.manage().window().maximize(); // maximize window
		// Login screen
		driver.findElement(By.id("TxtName")).sendKeys("208309"); // loginid
		driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); // password
		driver.findElement(By.name("command")).click();// click enter

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@data-autoid='cust_1391_srch']")).click();
		driver.findElement(By.id("select-all-checkbox")).click();

		/*
		 * driver.navigate().to(
		 * "https://sbcdev.crmnext.biz/sn/app/CRMNextObject/Home/Lead"); // Login screen
		 * driver.findElement(By.id("TxtName")).sendKeys("208004"); // loginid
		 * driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); // password
		 * driver.findElement(By.name("command")).click();// click enter
		 * 
		 * Select bucket1 = new Select(driver.findElement(By.name("QueryCategoryId")));
		 * bucket1.selectByVisibleText("Trust-Individual");
		 * 
		 * Select bucket3 = new Select(driver.findElement(By.name("QueryViewId")));
		 * 
		 * bucket3.selectByVisibleText("Assigned Leads");
		 * driver.findElement(By.className("filterGroup__button")).click();
		 * Thread.sleep(1000);
		 * 
		 * driver.findElement(By.linkText("7021")).click(); Thread.sleep(1000);
		 * driver.findElement(By.className("icon-Mass-Update")).click();
		 * Thread.sleep(1000);
		 * 
		 * driver.switchTo().alert().getText();
		 */
	}
}
		/*
		 * Thread.sleep(1000); driver.findElement(By.id("2")).click(); Select settleType
		 * = new Select(driver.findElement(By.name("cust_2038")));
		 * settleType.selectByVisibleText("Choose from Existing Account");
		 * driver.findElement(By.className("picker-icon")).click();
		 * 
		 * driver.switchTo().activeElement().click();
		 * 
		 * Thread.sleep(5000); driver.findElement(By.xpath(
		 * "/html/body/div[3]/div/div/div/div/div/div/div/div[3]/div[1]/div/div/div[2]/div/div/div/div/div/div[1]/div/div/span/div"
		 * )) .click();
		 * 
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		 * 
		 * driver.findElement(By.className("icon-screenflow")).click();
		 */
// String leadid =
// driver.findElement(By.xpath("//span[@data-autoid='LE_NUMBER_ctrl']")).getText();
// System.out.println(leadid);
// Integer leadId1 = new Integer(leadid);
// int this1 = leadId1 - 1;
// System.out.println(this1);
// driver.findElement(By.className("icon-edit")).click();
		/*
		 * // quick link and sales journey Actions quick = new Actions(driver);
		 * quick.moveToElement(driver.findElement(By.className("icon-link"))).perform();
		 * 
		 * driver.findElement(By.xpath("//*[@id=\"QuickLinksDiv\"]/ul/li[4]/a")).click()
		 * ;// clicking on sales jopurney
		 * 
		 * // creating individual lead driver.findElement(By.id("1")).click(); // click
		 * on individual leads
		 * driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[1]")).
		 * click(); // search page will open and // then we click next
		 * 
		 * // 1st screenflow Select salutation = new
		 * Select(driver.findElement(By.name("SALUTATION")));
		 * salutation.selectByVisibleText("Salutation");
		 * 
		 * Select suffix = new Select(driver.findElement(By.name("SUFFIX")));
		 * suffix.selectByVisibleText("suffix");
		 * 
		 * driver.findElement(By.name("FIRSTNAME")).sendKeys("TC36"); // enter first
		 * name string value provided on top
		 * driver.findElement(By.name("LASTNAME")).sendKeys("Indi"); // enter last name
		 * ,string value provided on top
		 * driver.findElement(By.name("MIDDLENAME")).sendKeys("Middle name");
		 * driver.findElement(By.name("LE_MOBILE")).sendKeys("97979979"); // enter phone
		 * number , string value provided on // top
		 * driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a")).click
		 * (); // click next
		 * 
		 * // 2nd screen flow providing account type Select product_category = new
		 * Select(driver.findElement(By.name("LE_PRODUCTCATEGORY")));
		 * product_category.selectByVisibleText("Savings"); // account ype
		 * Thread.sleep(100);
		 * 
		 * Select mm = new Select(driver.findElement(By.xpath(
		 * "//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/div/div/div/div[1]/div/select"
		 * ))); mm.selectByValue("1");
		 * 
		 * Select dd = new Select(driver.findElement(By.xpath(
		 * "//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/div/div/div/div[2]/div/select"
		 * ))); dd.selectByValue("1");
		 * 
		 * Select YY = new Select(driver.findElement(By.xpath(
		 * "//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/div/div/div/div[3]/div/select"
		 * ))); YY.selectByValue("1960");
		 * 
		 * Select Product = new Select(driver.findElement(By.name("LE_PRODUCT")));
		 * Product.selectByVisibleText("EASY ACCOUNT"); // account ype
		 * 
		 * driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).
		 * click(); // next Thread.sleep(4000); driver.switchTo().alert().accept();
		 */


