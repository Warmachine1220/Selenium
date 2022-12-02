import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ETB_individual {

	public static void main(String[] args) {
		
		String BBN = "46800000432";
		
		
		System.setProperty("webdriver.chrome.driver","D:\\Java\\selenium\\chromedriver.exe"); // driver path
		ChromeDriver driver = new ChromeDriver();  // webdriver name

		driver.get("https://sbcdev.crmnext.com/sn/app/login/login"); //url
		driver.manage().window().maximize(); // maximize window

		//Login screen
		driver.findElement(By.id("TxtName")).sendKeys("109840"); //loginid
		driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
		driver.findElement(By.name("command")).click();// click enter


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));



		//quick link and sales journey
		Actions quick = new Actions(driver);
		quick.moveToElement(driver.findElement(By.className("icon-link"))).perform();

		driver.findElement(By.xpath("//*[@id=\"QuickLinksDiv\"]/ul/li[1]/a/span[1]")).click();//clicking on sales jopurney
		driver.findElement(By.name("100000012")).sendKeys(BBN);
		driver.findElement(By.className("button-icon-text")).click();
		driver.findElement(By.linkText(BBN)).click();
		driver.findElement(By.className("icon-screenflow")).click();
		
	    Set<String> windows = driver.getWindowHandles();
	    Iterator<String> iterat = windows.iterator();
	    String H1 = iterat.next();
        String H2 = iterat.next();		
        driver.switchTo().window(H2);
        List <WebElement> elementName =  driver.findElements(By.className("screenFlowJnry__item"));  //click on non-individual leads
       // System.out.println(elementName);
        elementName.get(1).click();
        
	}

}
