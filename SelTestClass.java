package seltest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SelTestClass {
	
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	//	ChromeDriver driver = new ChromeDriver(options);
		
		System.setProperty("webdriver.chrome.driver","/opt/homebrew/bin/chromedriver");
		WebDriver driver = new ChromeDriver(options);
    	
		String baseUrl = "http://www.facebook.com";
        String expectedTitle = "Facebook – log in or sign up";
        String expectedTamilTitle = "Facebook - உள்நுழையவும் அல்லது பதிவுசெய்யவும்";
        String expectedHindiTitle = "Facebook - लॉग इन या साइन अप करें";
        String tagName = "";
        
        driver.get(baseUrl);
        tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);
       // driver.findElement(By.cssSelector("div#login_link a")).click();
        driver.findElement(By.id("pass")).click();
        checkTitle(driver, expectedTitle);
        
        driver.findElement(By.xpath("//a[@href='https://ta-in.facebook.com/']")).click();
        checkTitle(driver, expectedTamilTitle);
        
        driver.findElement(By.xpath("//a[@href='https://hi-in.facebook.com/']")).click();
        checkTitle(driver, expectedHindiTitle);
        
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//a[@title='English (UK)']")).click();
       
        driver.close();
        System.exit(0);
    }
	
	static void checkTitle(WebDriver driver, String expectedTitle) {
		String actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
            System.out.println(actualTitle);
        } else {
            System.out.println("Test Failed");
        }
	}

}
