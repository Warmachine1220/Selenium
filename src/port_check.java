import org.openqa.selenium.chrome.ChromeDriver;

public class port_check {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Java\\selenium\\chromedriver.exe"); // driver path
		ChromeDriver driver = new ChromeDriver(); // webdriver name
		driver.get("https://sbcdev.crmnext.com/sn/app/login/login"); // url
		driver.manage().window().maximize(); // maximize window

		while (1 + 2 == 3) {
			Thread.sleep(20000);
			driver.navigate().refresh();
		}

	}

}
