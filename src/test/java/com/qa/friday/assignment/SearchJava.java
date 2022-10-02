package com.qa.friday.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class SearchJava {

	public static void main(String[] args) {
		
		WebDriver driver;
		
		ChromeDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		driver.findElement(By.name("q")).sendKeys("java");
		List<WebElement> lists = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
	
		System.out.println(lists.size());
		
		for(int i=0; i<lists.size(); i++) {
			String listsname = lists.get(i).getText();
			System.out.println(listsname);
			if(lists.get(i).getText().contains("java")) {
				lists.get(i).click();
				break;
			}
		}
		
		driver.quit();

	}

}
