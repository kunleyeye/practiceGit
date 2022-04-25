package pkg1;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class projectConfig {
public static ChromeDriver driver;	
	
	static Properties prop = new Properties();
	//static String rawfilepath = "C:\\Users\\aadeyeye\\Documents\\SeleniumProjects\\genesysrnz\\src\\genesysrnz\\testdata.properties";
		
				
		 			@SuppressWarnings("deprecation")
					public static void launchbrowser() throws IOException, InterruptedException{
							
		 				String browserPath = "C:/eclipse/dependencies/WebDrivers/";
		 				System.setProperty("webdriver.chrome.driver", browserPath+"chromedriver.exe");
					
					ChromeOptions options = new ChromeOptions();

			    	// Disable extensions and hide infobars
			    	options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
					options.setExperimentalOption("useAutomationExtension", false);

			    	Map<String, Object> prefs = new HashMap<>();

			    	// Enable Flash
			    	prefs.put("profile.default_content_setting_values.plugins", 1);
			    	prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
			    	prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);

			    	// Hide save credentials prompt
			    	prefs.put("credentials_enable_service", false);
			    	prefs.put("profile.password_manager_enabled", false);
			    	options.setExperimentalOption("prefs", prefs);
			    	
			    	//Launch Browser
			     driver = new ChromeDriver(options);
			     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					driver.manage().window().maximize();

					driver.get("file:///C:/Users/Adekunle/Desktop/Personal%20Docs/Efe/devskiller-code-U7RA-QQXD-XH-S0F/src/test/resources/__files/index.html");
					//driver.get("https://igrcs-identity.pwcng-rpa.com/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fresponse_type%3Dcode%26client_id%3DOrganizationManagement_App%26state%3DcFEwUmwwX1NmYkQyY1R3WVFYVlZ0VHpnTDFsYUJubi5RaWxWbW1QM0cxU1la%26redirect_uri%3Dhttps%253A%252F%252Figrcs-studio.pwcng-rpa.com%26scope%3Dopenid%2520offline_access%2520OrganizationManagement%2520PRCManagementService%2520EMService%2520TaskManagementService%2520RiskEventManagement%2520ContinuousMonitoringModule%2520CapitalModelling%2520AssuranceManagementService%2520ReportService%26code_challenge%3D0uzf-PNqGy_mfByijg0s-jVKacHOKTAM7TyBNkqbpxs%26code_challenge_method%3DS256%26nonce%3DcFEwUmwwX1NmYkQyY1R3WVFYVlZ0VHpnTDFsYUJubi5RaWxWbW1QM0cxU1la%26culture%3Den%26ui-culture%3Den");
					
					
					Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						       .withTimeout(Duration.ofSeconds(30))
						       .pollingEvery(Duration.ofSeconds(5))
						       .ignoring(NoSuchElementException.class);
					
					
					//Userlogin
				/*	driver.findElement(By.id("LoginInput_UserNameOrEmailAddress")).clear();
					driver.findElement(By.id("LoginInput_UserNameOrEmailAddress")).sendKeys("admin");//.click();
					 driver.findElement(By.id("LoginInput_Password")).clear();
					 driver.findElement(By.id("LoginInput_Password")).sendKeys("1q2w3E*"); //.click();
					 driver.findElement(By.xpath("//div[2]/div/div")).click();
					 driver.findElement(By.name("Action")).click(); 
					
					 //projectConfig.driver.findElement(By.linkText("Home")).click();
					 

					   WebElement homeMen = wait.until(new Function<WebDriver, WebElement>() {
						     public WebElement apply(WebDriver driver) {
						    	 if (driver.findElement(By.linkText("Home")).isDisplayed()){
						    		 return driver.findElement(By.linkText("Home"));
						    	 }else{
						    		 return null;
						    	 }
						    	 
						      
						     }
						   });
					 
					   homeMen.click();
					   Thread.sleep(3000);
					   */
				}

		 			public static void scrollToSpecificDiv(WebElement scrollArea) {
		 			    JavascriptExecutor js = ((JavascriptExecutor) projectConfig.driver);
		 			   // js.executeScript(".scrollDown += 100");
		 			  //  js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)", scrollArea);
		 			    js.executeScript("arguments[0].scrollIntoView();", scrollArea);
		 			}
				 
		 			public static int getcurrentDay(){
		 				  
		 			   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/yyyy");  
		 			   LocalDateTime now = LocalDateTime.now();
		 			   String todayDate = dtf.format(now);
		 			 String[] todayDay = todayDate.split ("/",2);
		 			return Integer.parseInt(todayDay[0]);
		 			  
		 	}

				
}
