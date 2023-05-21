package jenkins.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DemoFindMethod2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://www.letskodeit.com/practice";

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		// maximize the browser
		driver.manage().window().maximize();
		
		driver.get(url);
		
		List<WebElement> textFieldList = driver.findElements(By.xpath("//input[starts-with(@class,'inputs')]"));
		System.out.println("size: " + textFieldList.size());
			
		for(WebElement text : textFieldList) {
			String attrValue = text.getAttribute("placeholder");
			
			System.out.println(attrValue);
			
			if(attrValue.contains("Hide/Show")) {
				text.sendKeys("Java is FUN");
			}
			if(attrValue.contains("Enabled/Disabled")) {
				text.sendKeys("Java is ENABLED");
			}

			Thread.sleep(3000);
		}
				
		Thread.sleep(3000);
		driver.quit();
	}

}
