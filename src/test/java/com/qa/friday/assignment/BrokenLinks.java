package com.qa.friday.assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.spinny.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		
		System.out.println(links.size());
		
		List<WebElement> activelinks=new ArrayList<WebElement>();
		
		for(int i=0; i<links.size(); i++) {
			if(links.get(i).getAttribute("href")!=null)
			activelinks.add(links.get(i));
		}
		
		//active links size
		System.out.println(activelinks.size());
		
		for(int j=0; j<activelinks.size(); j++) {
			
			
			HttpURLConnection connection = (HttpURLConnection)	new URL(activelinks.get(j). getAttribute("href")).openConnection();
			
			connection.connect();
			int responsecode = connection.getResponseCode();
			if(responsecode>=400) {
				System.out.println(activelinks.get(j).getAttribute("href")+"-->"+responsecode);
			}else {
			
			System.out.println(activelinks.get(j).getAttribute("href")+"-->"+ responsecode);
                   
			
		}
		
		}
		driver.quit();
	}

}
