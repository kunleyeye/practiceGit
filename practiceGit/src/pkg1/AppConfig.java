package pkg1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppConfig {
	public static ChromeDriver driver;
	
	public static void launchBrowser(String webDriverPath, String driverName, String URL){
		//String browserPath = "C:/eclipse/dependencies/WebDrivers/";
		//System.setProperty("webdriver.chrome.driver", webDriverPath+"chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", webDriverPath+driverName+".exe");
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.get("file:///C:/Users/Adekunle/Desktop/Personal%20Docs/Efe/devskiller-code-U7RA-QQXD-XH-S0F/src/test/resources/__files/index.html");
		driver.get(URL);
	}
}
