
import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Individual_joint {

	public static void main(String[] args) throws InterruptedException {
		
		String DOB = "12-12-1996";	//DD-MM-YYYY  provide d & m so that both can use parent & child 
		String[] splittedStrings = DOB.split("-");
		String Emplytype = "Unemployed";
		String Emplytypejoint = "Employed";
		String Occupation1 = "Rank And File";
		String For_Employment = "Yes";
		String TIN = "523174322";
		
			
			System.setProperty("webdriver.chrome.driver","D:\\Java\\selenium\\chromedriver.exe"); // driver path
			ChromeDriver driver = new ChromeDriver();  // webdriver name
			driver.manage().window().maximize(); // maximize window
			
			
			driver.get("https://sbcdev.crmnext.com/sn/app/login/login");//url
			
			
			driver.findElement(By.id("TxtName")).sendKeys("109840"); //loginid
			driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
			driver.findElement(By.name("command")).click();// click enter

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			Actions hower = new Actions(driver);
			hower.moveToElement(driver.findElement(By.className("icon-link"))).perform();
			
			driver.findElement(By.xpath("//span[text() = 'Sales Journey']")).click();
			driver.findElement(By.id("1")).click();
			
			driver.findElement(By.className("button-icon-text")).click();
			
			/////////////////////////////////////////////////////////////////////////////
			Select salutation = new Select (driver.findElement(By.name("SALUTATION")));
			salutation.selectByVisibleText("Mr.");
            Select suffix = new Select (driver.findElement(By.name("SUFFIX")));
			suffix.selectByVisibleText("Jr.");
			

			driver.findElement(By.name("FIRSTNAME")).sendKeys("rsdam"); // enter first name string value provided on top
			driver.findElement(By.name("LASTNAME")).sendKeys("laksdhan"); 
			driver.findElement(By.name("MIDDLENAME")).sendKeys("mifddsdle101");
			driver.findElement(By.name("LE_MOBILE")).sendKeys("66663436");
			
			driver.findElement(By.className("button-icon-text")).click();
			
			Select product_category = new Select(driver.findElement(By.name("LE_PRODUCTCATEGORY")));
			product_category.selectByVisibleText("Savings");  //account ype
			
			//DOB
			Select mm =new Select (driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/div/div/div/div[1]/div/select")));
			mm.selectByValue(splittedStrings[1]);  

			Select dd =new Select(driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/div/div/div/div[2]/div/select")));
			dd.selectByValue(splittedStrings[0]);

			Select YY =new Select(driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/div/div/div/div[3]/div/select")));
			YY.selectByValue(splittedStrings[2]);
			
			Select Product = new Select(driver.findElement(By.name("LE_PRODUCT")));
			Product.selectByVisibleText("EASY ACCOUNT");  //account ype
			///////////////////////////////////////////////////////////////////////
			
			List<WebElement> button = driver.findElements(By.className("button-icon-text"));
			System.out.println(button);
			button.get(1).click();
			driver.findElement(By.xpath("//a[@title = 'Edit']")).click();
			driver.findElement(By.id("2")).click();
			
			
			/////////////////////////////////////////////////////////////////////////
			//Key information
			driver.findElement(By.name("LE_EMAIL")).sendKeys(""); //Email
			driver.findElement(By.name("cust_47")).sendKeys("Minato"); //Place of birth
			driver.findElement(By.name("cust_212")).sendKeys("Mumma"); //Mother maiden

			

			Select gender = new Select(driver.findElement(By.name("LE_GENDER")));  //Gender
			gender.selectByVisibleText("Male");

			Select cust_type = new Select(driver.findElement(By.name("cust_50"))); //Customer type
			cust_type.selectByVisibleText("INDIVIDUAL");

			Select cust_contact = new Select(driver.findElement(By.name("cust_920"))); //Customer contact
			cust_contact.selectByVisibleText("Tele Outbound");

			Select civil =new Select(driver.findElement(By.name("cust_66")));  //Civil status
			civil.selectByVisibleText("Single");
			
			Select sole =new Select(driver.findElement(By.name("cust_162"))); //Sole owner
			sole.selectByVisibleText("No");

			//Select business_Segment = new Select(driver.findElement(By.name("cust_2592"))); //Segment type autofilling right now
			//business_Segment.selectByValue("");

			WebElement clients =  driver.findElement(By.name("cust_2593"));    //VIP STATUS
			clients.sendKeys("Business banking");
			Thread.sleep(1000);
			clients.sendKeys(Keys.ARROW_DOWN);
			clients.sendKeys(Keys.ENTER);
            
			Select relationship = new Select(driver.findElement(By.name("cust_1960")));
			relationship.selectByVisibleText("Or");
			
			Select onlybbn =new Select(driver.findElement(By.name("cust_898"))); //Sole owner
			onlybbn.selectByVisibleText("No");
			
			

			//Employment section


			Select empt = new Select(driver.findElement(By.name("cust_63")));
			empt.selectByVisibleText(Emplytype);
				
				Select Stated_Income_Range = new Select( driver.findElement(By.name("cust_2597")));
				Stated_Income_Range.selectByVisibleText("Above 5M");
				
				
				if (Emplytype != "Unemployed")
				{
					WebElement Industry_Classification  = driver.findElement(By.name("cust_1563")); 
					Industry_Classification.sendKeys("CAFETERIAS");
					Thread.sleep(1000);
					Industry_Classification.sendKeys(Keys.DOWN);
					Industry_Classification.sendKeys(Keys.ENTER);
					
					WebElement Nature_work  = driver.findElement(By.name("cust_57")); 
					Nature_work.sendKeys("Airlines");
					Thread.sleep(1000);
					Nature_work.sendKeys(Keys.DOWN);
					Nature_work.sendKeys(Keys.ENTER);
					
					Select occupation = new Select( driver.findElement(By.name("cust_77")));
					occupation.selectByVisibleText(Occupation1);
					Thread.sleep(1000);
					
					if (Occupation1 == "Others") {
						driver.findElement(By.name("cust_80")).sendKeys("hihello");
						
					}
					
					Select for_Employment = new Select( driver.findElement(By.name("cust_2353")));
					for_Employment.selectByVisibleText(For_Employment);
					
					if (For_Employment == "No")
					{
						Thread.sleep(1000);
						driver.findElement(By.name("cust_86")).sendKeys(TIN);
					}

					if (Emplytype == "Employed") {
						driver.findElement(By.name("cust_48")).sendKeys("employer1f");
						
						

						Select Working_Since_m = new Select( driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[7]/div[1]/div/div/div/div[1]/div/select")));
						Working_Since_m.selectByVisibleText("April");
						
						Select Working_Since_y = new Select( driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[7]/div[1]/div/div/div/div[2]/div/select")));
						Working_Since_y.selectByVisibleText("2007");
					
					}
				    else if (  Emplytype == "Self-Employed") {
				    	driver.findElement(By.name("cust_494")).sendKeys("businessman");
						
				    	Select source = new Select (driver.findElement(By.name("cust_61")));
				    	source.selectByVisibleText("Business");
						
					}
				}
					
			else {
				    	Select source = new Select (driver.findElement(By.name("cust_61")));
				    	source.selectByVisibleText("Pension");
				    	
				    }
					
					    



			//ID
			WebElement ID =  driver.findElement(By.name("cust_467"));
			ID.sendKeys("Driver's License");
			Thread.sleep(1000);
			ID.sendKeys(Keys.DOWN);
			ID.sendKeys(Keys.ENTER);

			driver.findElement(By.name("cust_90")).sendKeys("qwert"); //id no


			//AOCODE
			Select AO = new Select(driver.findElement(By.name("cust_2624")));
			AO.selectByVisibleText("Rocky");




			//Address section
			driver.findElement(By.xpath("//span[@title='Address']")).click(); //click on address tab
            driver.findElement(By.name("LE_LOCALITY")).sendKeys("Street"); //street field

          //ZIPCODE
			WebElement zip = driver.findElement(By.name("LE_ZIP_CODE"));
			zip.sendKeys("manila");
			Thread.sleep(1000);
			zip.sendKeys(Keys.DOWN);
			zip.sendKeys(Keys.ENTER);
			
			Select mail = new Select(driver.findElement(By.name("cust_1812"))); //mailing address
			mail.selectByVisibleText("Present");


			
			
			driver.findElement(By.className("icon-flownext")).click();
			/////// Documentation stage completed
			
///////////////////////////////////////////////////////////////////////////////////////			
			
		///// CRRS START

			CRRScandofaic call = new CRRScandofaic();
			call.CRRSC(driver);
		
          driver.findElement(By.className("icon-screenflow")).click();
          
          Set<String> handles = driver.getWindowHandles();
          java.util.Iterator<String> H = handles.iterator();
          String H1 = H.next();
          String H2 = H.next();
          driver.switchTo().window(H2);
          
          
         ///Joint start
          
          Select salutation1 = new Select (driver.findElement(By.name("SALUTATION")));
		  salutation1.selectByVisibleText("Mr.");
          Select suffix1 = new Select (driver.findElement(By.name("SUFFIX")));
		   suffix1.selectByVisibleText("Jr.");
			

			driver.findElement(By.name("FIRSTNAME")).sendKeys("ramwerff"+1); // enter first name string value provided on top
			driver.findElement(By.name("LASTNAME")).sendKeys("lakhweran"+1); 
			driver.findElement(By.name("MIDDLENAME")).sendKeys("middle101"+1);
			driver.findElement(By.name("LE_MOBILE")).sendKeys("66666341"+1);
			
			
			//DOB
			 Select mm1 =new Select (driver.findElement(By.xpath("(//select[@class = 'selectbox selectbox--ba'])[1]")));
		        mm1.selectByValue("2");
		        
		        Select mm2 =new Select (driver.findElement(By.xpath("(//select[@class = 'selectbox selectbox--ba'])[2]")));
		        mm2.selectByValue("2");
		        
		        Select mm3 =new Select (driver.findElement(By.xpath("(//select[@class = 'selectbox selectbox--ba'])[3]")));
		        mm3.selectByVisibleText("1940");
			
		        driver.findElement(By.className("button-icon-text")).click();
		        driver.manage().window().maximize();
			
			///////////////////////////////////////////////////////////////////////
			
			
			driver.findElement(By.xpath("//a[@title = 'Edit']")).click();
			driver.findElement(By.id("2")).click();
			
			
			/////////////////////////////////////////////////////////////////////////
			//Key information
			driver.findElement(By.name("LE_EMAIL")).sendKeys(""); //Email
			driver.findElement(By.name("cust_47")).sendKeys("Minato"); //Place of birth
			driver.findElement(By.name("cust_212")).sendKeys("Mumma"); //Mother maiden

			

		    Select gender1 = new Select(driver.findElement(By.name("LE_GENDER")));  //Gender
			gender1.selectByVisibleText("Male");

			Select cust_type1 = new Select(driver.findElement(By.name("cust_50"))); //Customer type
			cust_type1.selectByVisibleText("INDIVIDUAL");

			Select cust_contact1 = new Select(driver.findElement(By.name("cust_920"))); //Customer contact
			cust_contact1.selectByVisibleText("Tele Outbound");

			Select civil1 =new Select(driver.findElement(By.name("cust_66")));  //Civil status
			civil1.selectByVisibleText("Single");
			
			

			//Select business_Segment1 = new Select(driver.findElement(By.name("cust_2592"))); //Segment type autofilling right now
			//business_Segment1.selectByValue("");

			WebElement clients1 =  driver.findElement(By.name("cust_2593"));    //VIP STATUS
			clients1.sendKeys("Business banking");
			Thread.sleep(1000);
			clients1.sendKeys(Keys.ARROW_DOWN);
			clients1.sendKeys(Keys.ENTER);
			
			

			//Employment section

			Select empt1 = new Select(driver.findElement(By.name("cust_63")));
			empt1.selectByVisibleText(Emplytypejoint);
				
				Select Stated_Income_Range1 = new Select( driver.findElement(By.name("cust_2597")));
				Stated_Income_Range1.selectByVisibleText("Above 5M");
				
				
				if (Emplytypejoint != "Unemployed")
				{
					WebElement Industry_Classification  = driver.findElement(By.name("cust_1563")); 
					Industry_Classification.sendKeys("CAFETERIAS");
					Thread.sleep(1000);
					Industry_Classification.sendKeys(Keys.DOWN);
					Industry_Classification.sendKeys(Keys.ENTER);
					
					WebElement Nature_work  = driver.findElement(By.name("cust_57")); 
					Nature_work.sendKeys("Airlines");
					Thread.sleep(1000);
					Nature_work.sendKeys(Keys.DOWN);
					Nature_work.sendKeys(Keys.ENTER);
					
					Select occupation = new Select( driver.findElement(By.name("cust_77")));
					occupation.selectByVisibleText(Occupation1);
					Thread.sleep(1000);
					
					if (Occupation1 == "Others") {
						driver.findElement(By.name("cust_80")).sendKeys("hihello");
						
					}
					
					Select for_Employment = new Select( driver.findElement(By.name("cust_2353")));
					for_Employment.selectByVisibleText(For_Employment);
					
					if (For_Employment == "No")
					{
						Thread.sleep(1000);
						driver.findElement(By.name("cust_86")).sendKeys(TIN);
					}

					if (Emplytypejoint == "Employed") {
						driver.findElement(By.name("cust_48")).sendKeys("employer1f");
						Select source = new Select (driver.findElement(By.name("cust_61")));
				    	source.selectByVisibleText("Salary");

						Select Working_Since_m = new Select( driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[7]/div[1]/div/div/div/div[1]/div/select")));
						Working_Since_m.selectByVisibleText("April");
						
						Select Working_Since_y = new Select( driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[7]/div[1]/div/div/div/div[2]/div/select")));
						Working_Since_y.selectByVisibleText("2007");
					
					}
				    else if (  Emplytypejoint == "Self-Employed") {
				    	driver.findElement(By.name("cust_494")).sendKeys("businessman");
						
				    	Select source = new Select (driver.findElement(By.name("cust_61")));
				    	source.selectByVisibleText("Business");
						
					}
				}
					
			else {
				    	Select source = new Select (driver.findElement(By.name("cust_61")));
				    	source.selectByVisibleText("Pension");
				    	
				    }
					
					    



			//ID
			WebElement ID1 =  driver.findElement(By.name("cust_467"));
			ID1.sendKeys("Driver's License");
			Thread.sleep(1000);
			ID1.sendKeys(Keys.DOWN);
			ID1.sendKeys(Keys.ENTER);

			driver.findElement(By.name("cust_90")).sendKeys("qwert12"); //id no


			//AOCODE
			Select AO1 = new Select(driver.findElement(By.name("cust_2624")));
			AO1.selectByVisibleText("Rocky");




			//Address section
			driver.findElement(By.xpath("//span[@title='Address']")).click(); //click on address tab
          driver.findElement(By.name("LE_LOCALITY")).sendKeys("Street"); //street field

        //ZIPCODE
			WebElement zip1 = driver.findElement(By.name("LE_ZIP_CODE"));
			zip1.sendKeys("manila");
			Thread.sleep(1000);
			zip1.sendKeys(Keys.DOWN);
			zip1.sendKeys(Keys.ENTER);
			
			
			driver.findElement(By.className("icon-flownext")).click();
			/////// Documentation stage completed
			
///////////////////////////////////////////////////////////////////////////////////////			
			
		///// CRRS START

			driver.findElement(By.className("icon-screenflow")).click();


			WebElement risk1 =  driver.findElement(By.name("cust_1520"));
			risk1.sendKeys("abu");
			Thread.sleep(1000);
			risk1.sendKeys(Keys.DOWN);
			risk1.sendKeys(Keys.ENTER);

			Select EM_TYPE1 = new Select(driver.findElement(By.name("cust_1169")));
			EM_TYPE1.selectByVisibleText("Employed");
			WebElement emrisk =  driver.findElement(By.name("cust_2444"));
			emrisk.sendKeys("ADMINISTRATION OF FINANCIAL MARKETS");
			Thread.sleep(1000);
			emrisk.sendKeys(Keys.DOWN);
			emrisk.sendKeys(Keys.ENTER);

			Select ee1e1 = new Select(driver.findElement(By.name("cust_1699")));
			ee1e1.selectByVisibleText("No");

			Select ee21 = new Select(driver.findElement(By.name("cust_1700")));
			ee21.selectByVisibleText("No");

			Select ee31 = new Select(driver.findElement(By.name("cust_1701")));
			ee31.selectByVisibleText("No");

			Select ee41 = new Select(driver.findElement(By.name("cust_1702")));
			ee41.selectByVisibleText("No");

			Select ee51 = new Select(driver.findElement(By.name("cust_1703")));
			ee51.selectByVisibleText("No");

			Select ee61 = new Select(driver.findElement(By.name("cust_2427")));
			ee61.selectByVisibleText("No");

			Select ee71 = new Select(driver.findElement(By.name("cust_1706")));
			ee71.selectByVisibleText("No");

			Select ee81 = new Select(driver.findElement(By.name("cust_1708")));
			ee81.selectByVisibleText("No");

			Select ee91 = new Select(driver.findElement(By.name("cust_1709")));
			ee91.selectByVisibleText("No");

			Select ee01 = new Select(driver.findElement(By.name("cust_1717")));
			ee01.selectByVisibleText("Yes");

			Select ee111 = new Select(driver.findElement(By.name("cust_1720")));
			ee111.selectByVisibleText("Yes");

			Select ee121 = new Select(driver.findElement(By.name("cust_1721")));
			ee121.selectByVisibleText("Yes");

			Select ee131 = new Select(driver.findElement(By.name("cust_2032")));
			ee131.selectByVisibleText("Yes");

			Select ee141 = new Select(driver.findElement(By.name("cust_1722")));
			ee141.selectByVisibleText("Yes");

			Select ee151 = new Select(driver.findElement(By.name("cust_1723")));
			ee151.selectByVisibleText("Yes");



			driver.findElement(By.name("cust_2430")).sendKeys("remarks");
			driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a")).click();
			///CRRSC complete

				

			//Edit and fill ofac
			driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/a[1]/i")).click();
			Select ofac1 = new Select(driver.findElement(By.name("cust_1718")));
			ofac1.selectByValue("No Hit");
			driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).click();
			///ofac completeee
			
			driver.findElement(By.className("icon-Mass-Update")).click();  //process aplication
			  String status = driver.findElement(By.xpath("//span[@data-autoid = 'LE_STATUSCODE_ctrl']")).getText();
			while (status.length() == 19) //status.equalsIgnoreCase("sent for processing")
	        {
				
	        	status = driver.findElement(By.xpath("//span[@data-autoid = 'LE_STATUSCODE_ctrl']")).getText();
	        	driver.navigate().refresh();
	        	
	        }
			
			
	}

}
