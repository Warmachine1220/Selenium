import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RohitsCode {
	public static void main(String[] args) throws InterruptedException {
		// declaration and instantiation of objects/variables
		// comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver", "D:\\\\Java\\\\selenium\\\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		ChromeDriver driver = new ChromeDriver();
		String baseUrl = "https://sbcdev.crmnext.com/sn/app/login/login";
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";
		// launch Fire fox and direct it to the Base URL
		driver.get(baseUrl);
		Thread.sleep(1600);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='TxtName']")).sendKeys("109840");
		driver.findElement(By.xpath("//input[@id='TxtPassword']")).sendKeys("acid_qa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2800);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//i[@class='icon icon-link']"));
		action.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[@title='Sales Journey']")).click();
		driver.findElement(By.xpath("(//a[@class='screenFlowJnry__item-link'])[1]")).click();
		String BBN = "10000000537";
		driver.findElement(By.xpath("//input[@data-autoid='100000012_ctrl']")).sendKeys(BBN);
		Thread.sleep(600);
		driver.findElement(By.xpath("//a[@data-autoid='FlowNext']/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText(BBN)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@class='icon icon icon-screenflow']")).click();
		String mainjourneyWindow = driver.getWindowHandle();
		System.out.println("Main Window:" + mainjourneyWindow);
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> i = allwindows.iterator();
		while (i.hasNext()) {
			String childWindow = i.next();
			if (!(childWindow).equalsIgnoreCase(mainjourneyWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println("Successfully switch to:" + childWindow);
				WebElement childwin = driver.findElement(By.xpath("/html/body/div/div[3]/div/div[1]"));
				childwin.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]")).click();

			}
		}

	}

}