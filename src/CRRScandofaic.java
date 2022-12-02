
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.Webdd;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.Chromedd;
import org.openqa.selenium.support.ui.Select;

public class CRRScandofaic {
	static ChromeDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Java\\selenium\\chromedriver.exe"); // driver path
		// webdriver name
		driver.get(
				"https://sbcdev.crmnext.com/crlive/app/crmnextobject/detail/Lead?x=237h8arf3efxbd5h35z62mjrp8m4wk7dpal9apm372rtrdwl88pa");
		driver.manage().window().maximize(); // maximize window

//Login screen
		driver.findElement(By.id("TxtName")).sendKeys("208309"); // loginid
		driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); // password
		driver.findElement(By.name("command")).click();// click enter
		CRRSC(driver);
	}
	static void CRRSC(ChromeDriver driver) throws InterruptedException {


		driver.findElement(By.className("icon-screenflow")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		WebElement risk;
		try {
			risk = driver.findElement(By.name("cust_1520"));
		} catch (NoSuchElementException E) {
			E.printStackTrace();
			System.out.println("THIS IS A non-indi customer");
			risk = driver.findElement(By.name("cust_70"));

		}
		risk.sendKeys("Abuyog");
		Thread.sleep(400);
		risk.sendKeys(Keys.DOWN);
		Thread.sleep(400);

		risk.sendKeys(Keys.ENTER);
		Thread.sleep(200);

		try {
			Select("cust_1169", "Employed");
		} catch (NoSuchElementException E) {
			System.out.println("no section for employment in non-indi CRRSC so skipping it");
		}
		WebElement emrisk = driver.findElement(By.name("cust_2444"));
		emrisk.sendKeys("ADMINISTRATION OF");
		Thread.sleep(500);
		emrisk.sendKeys(Keys.DOWN);
		Thread.sleep(300);
		emrisk.sendKeys(Keys.ENTER);
		Thread.sleep(500);

		Select("cust_1699", "No");
		Select("cust_1700", "No");
		Select("cust_1701", "No");
		Select("cust_1702", "No");
		try {
			Select("cust_1703", "No");
			Select("cust_1706", "No");
			Select("cust_1708", "No");
			Select("cust_1709", "No");
	} catch (NoSuchElementException E) {
		System.out.println("this fields not for non-indi so skipping it");
	}

	Select("cust_2427", "No");

	Select("cust_1717", "Yes");
	Select("cust_1720", "Yes");
	Select("cust_1721", "Yes");
	Select("cust_2032", "Yes");
	Select("cust_1722", "Yes");
	Select("cust_1723", "Yes");

		driver.findElement(By.name("cust_2430")).sendKeys("remarks");

		driver.findElement(By.xpath("//a[@data-autoid='FlowFinish']")).click();

//Edit and fill OFAC
		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/a[1]/i")).click();
		Select("cust_1718", "No Hit");
		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).click();
///OFAC Complete

	}

	static void fillAccountInfo(ChromeDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/a[1]/span")).click();

		Select("cust_1318", "EVERYDAY MASTERCARD DEBIT/ATM CARD");
		Select("cust_497", "Allowance/Allotment/Pension");
		driver.findElement(By.xpath("//input[@data-autoid='cust_92_ctrl']")).sendKeys("2323");
		Select("cust_1185", "Yes");
		Select("cust_74", "Yes");
		Select("cust_85", "Yes");
		Select("cust_107", "Yes");

		driver.findElement(By.xpath("//a[@data-autoid='FlowFinish']")).click();
	}

	static void Select(String Field_name, String value) {

		Select xx = new Select(driver.findElement(By.name(Field_name)));
		xx.selectByVisibleText(value);
	}

}