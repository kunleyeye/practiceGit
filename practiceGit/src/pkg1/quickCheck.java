package pkg1;
import pkg1.projectConfig;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;



public class quickCheck {

	public static void main(String[] args) throws Exception {
	//	projectConfig.launchbrowser();
		//iGRCS.riskManagement.testCreateRiskEvent();
		//getcurrentDay();
		//getcurrentTime();
		//todayplusndays(0,"MMM dd yyyy");
		//todayday();
	//	splitstring("Infrequent Exercising & Testing | RSK-000164");
		//switchtest("risk-control2");
//refreshpage();
		//slider();
		//sendmail();
		
		getRandom();
		
		//switchtabs();
		
		//substringrange();
	}
	
	public static void substringrange(){
		String pagination = "1 of 4";
		int totalquestions = Integer.parseInt(pagination.substring(5));
		System.out.println(totalquestions);
		
	}
	
	public static void switchtabs() throws InterruptedException{
		
		AppConfig.launchBrowser("C:/eclipse/dependencies/WebDrivers/", "chromedriver", "http://the-internet.herokuapp.com/windows");
		Thread.sleep(3000);
		AppConfig.driver.findElement(By.xpath("//*[@id='content']/div/a')]")).click();
		ArrayList<String> tabs2 = new ArrayList<String> (AppConfig.driver.getWindowHandles());
		AppConfig.driver.switchTo().window(tabs2.get(1));
		AppConfig.driver.close();
		AppConfig.driver.switchTo().window(tabs2.get(0));
	}
	
	public static void getRandom() {
		String array[] = {"Transfer","Accept","Reduce","Avoid"};
	    int rnd = new Random().nextInt(array.length);
	    System.out.println(array[rnd]);
	}
	private static void sendmail() throws InterruptedException {
		AppConfig.launchBrowser("C:/eclipse/dependencies/WebDrivers/", "chromedriver", "https://www.google.com/intl/en-GB/gmail/about/");
		
		waitAndClickElement("/html/body/header/div/div/div/a[2]");
		String emailbox = "//*[@id='identifierId']";
		waitForMyElementXpath(emailbox);
		sendtext("rdtfyguhijk","adeyeye.suzan@");
		
	}

	public static void waitAndClickElement(String xpathtolookup) throws InterruptedException {
		
			WebElement xpathWebelement = waitForMyElementXpath(xpathtolookup);
			 
			xpathWebelement.click();

		
	}
	public static void sendtext(String xpathtolookup, String textvalue) throws InterruptedException {
		
		WebElement xpathWebelement = waitForMyElementXpath(xpathtolookup);
		 
		xpathWebelement.sendKeys(textvalue);

	
}
	
	public static WebElement waitForMyElementXpath(String elementToFind) throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(AppConfig.driver)
			       .withTimeout(Duration.ofSeconds(100))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class)
			       .withMessage("Element Not Found after several trial");
		
		 WebElement foundElement = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		    	 if (driver.findElement(By.xpath(elementToFind)).isDisplayed()){
		    		 return driver.findElement(By.xpath(elementToFind));
		    	 }else{
		    		 return null;
		    	 }
		    	 
		      
		     }
		   });
		 
		return foundElement;
		
	}
	public static void slider(){
		AppConfig.launchBrowser("C:/eclipse/dependencies/WebDrivers/", "chromedriver", "http://jqueryui.com/slider/");
		
		
		AppConfig.driver.switchTo().frame(0); //need to switch to this frame before clicking the slider
        WebElement slider = AppConfig.driver.findElement(By.xpath("//div[@id='slider']/span"));
        Actions move = new Actions(AppConfig.driver);
        Action action = (Action) move.dragAndDropBy(slider, 80, 0).build();
        action.perform();
	}
	
	public static void refreshpage() throws InterruptedException{
		AppConfig.launchBrowser("C:/eclipse/dependencies/WebDrivers/", "chromedriver", "http://demo.guru99.com/selenium/guru99home/");
		Thread.sleep(5000);
		AppConfig.driver.navigate().refresh();
		
	}
	public static void getcurrentDay(){
		  
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/yyyy");  
		   LocalDateTime now = LocalDateTime.now();
		   String todayDate = dtf.format(now);
		 String[] todayDay = todayDate.split ("/",2);
		// System.out.println(todayDate);
		 
		   System.out.println(Integer.parseInt(todayDay[0])-1);
		 //  System.out.println(todayDate);
		  
}
	public static void getcurrentTime(){
		  
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		  
		   System.out.println(timeStamp);
		  
}
	
	public static void todayplusndays(int n, String dtformat) throws InterruptedException{
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime tomorrow = today.plusDays(n);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(dtformat);
	    String formattedDatetomorrow = tomorrow.format(myFormatObj);   
	    System.out.println(formattedDatetomorrow);
	}
	
	public static void todayday() throws InterruptedException {
		LocalDateTime today = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/d/yyyy");
	    String formattedDatetoday = today.format(myFormatObj);
	    String datess[] =  formattedDatetoday.split("/");
	    int kk = Integer.parseInt(datess[1]);
	    System.out.println(kk);
	    
	}
	
	public static void splitstring(String string){
		String kkk = string.replace("|", "@");
		String[] sr = kkk.split("@");
		String risknameonly = sr[0].trim();
		String riskid = sr[1].trim();
		System.out.println("Name=> "+ risknameonly);
			System.out.println("ID=> "+ riskid);
	}
	
	public static void switchtest(String value){
		switch (value) {
		case "risk":
		    System.out.println("It is risky");
		    break;
		case "control":
		    System.out.println("It is controlled");
		    break;
		case "risk-control":
		    System.out.println("It is a controlled risk");
		    break;
		}
	}
	
	
}
