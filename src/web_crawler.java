import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// create WebCrawlerExample to understand the working of it and how we can implement it in Java  
public class web_crawler {

	public static void main(String[] args) throws IOException {

		String URL = "https://www.osc.ca/en/investors/investor-warnings-and-alerts";
		System.setProperty("webdriver.chrome.driver", "D:\\Java\\selenium\\chromedriver.exe"); // driver path

		// ChromeOptions option = new ChromeOptions();
		// option.addArguments("headless");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);

		JSONObject jObj = new JSONObject();

      //Getting all the additional info
		List<WebElement> AdditionalInformation = driver.findElements(By.xpath("//p[@style='margin-bottom:11px']"));
		for (int i = 0; i < AdditionalInformation.size(); i++) {

			jObj.put("otherInfo", AdditionalInformation.get(i).getText());
		}

		
		
		List<WebElement> allURLs = driver.findElements(By.tagName("a"));

		// We will iterate through the list and will check the elements in the list.
		Iterator<WebElement> iterator = allURLs.iterator();
		while (iterator.hasNext()) {
			String url = iterator.next().getAttribute("href");
			jObj.put("externalSources", url);
		}

		
		//getting all dates
		WebElement table = driver.findElement(By.xpath("//time[@class='datetime']"));

		List<WebElement> rows = driver.findElements(By.xpath("//time[@class='datetime']"));

		for (int i = 0; i < rows.size(); i++) {

			jObj.put("term", rows.get(i).getAttribute("datetime"));

		}

		
		//getting all company names
		List<WebElement> company_name = driver.findElements(By.className("field--label-hidden"));
		for (int i = 0; i < company_name.size(); i++) {
			jObj.put("fullName", company_name.get(i).getText());
		}

		FileWriter file = new FileWriter("C:\\Users\\Vishal Singh\\eclipse-workspace\\Selenium\\src\\json\\test.json",
				false);
		file.write(jObj.toJSONString());
		file.close();

		System.out.println("file creatwd");


	}



	}






