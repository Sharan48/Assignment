package com.qa.friday.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintDropdown {
	public static void main(String[] args) {

		WebDriver driver;
		

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		driver.get("https://www.spinny.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement ele = driver.findElement(By.xpath("(//div[@class='ExploreBy__exploreByContainer']/ul/li)[2]"));
		
		WebElement ele1 = driver.findElement(By.xpath("(//div[@class='ExploreBy__exploreByContainer']/ul/li)[3]"));
		
		WebElement ele2 = driver.findElement(By.xpath("(//div[@class='ExploreBy__exploreByContainer']/ul/li)[4]"));
		
		WebElement ele3 = driver.findElement(By.xpath("(//div[@class='ExploreBy__exploreByContainer']/ul/li)[5]"));
		
		WebElement ele4 = driver.findElement(By.xpath("(//div[@class='ExploreBy__exploreByContainer']/ul/li)[6]"));

		WebElement ele5 = driver.findElement(By.xpath("(//div[@class='ExploreBy__exploreByContainer']/ul/li)[7]"));

		WebElement ele6 = driver.findElement(By.xpath("(//div[@class='ExploreBy__exploreByContainer']/ul/li)[8]"));


		List<WebElement> allele=new ArrayList<WebElement>();
		
		allele.add(ele);
		allele.add(ele1);
		allele.add(ele2);
		allele.add(ele3);
		allele.add(ele4);
		allele.add(ele5);
		allele.add(ele6);
		
		
		List<WebElement> budget = driver.findElements(By.xpath("(//ul[@class='ExploreBy__listWrapper'])[1]"));
		
		List<WebElement> makeandmodel = driver.findElements(By.xpath("//div[@class='ExploreBy__makeListSection']"));
		
		List<WebElement> year = driver.findElements(By.xpath("(//ul[@class='ExploreBy__listWrapper'])[2]"));
		
		List<WebElement> fuel = driver.findElements(By.xpath("(//div[@class='ExploreBy__listSection']/ul[@class='ExploreBy__listWrapper'])[3]"));
		
		List<WebElement> kmdriven= driver.findElements(By.xpath("(//ul[@class='ExploreBy__listWrapper'])[4]"));

		List<WebElement> bodytype = driver.findElements(By.xpath("(//ul[@class='ExploreBy__listWrapper'])[5]"));
		
		List<WebElement> transmission = driver.findElements(By.xpath("(//ul[@class='ExploreBy__listWrapper'])[6]"));

		List<WebElement> allele1=new ArrayList<WebElement>();
		allele1.addAll(budget);
		allele1.addAll(makeandmodel);
		allele1.addAll(year);
		allele1.addAll(fuel);
		allele1.addAll(kmdriven);
		allele1.addAll(bodytype);
		allele1.addAll(transmission);
		
		Actions act=new Actions(driver);

		for(int i=0; i<allele.size();i++) {
			act.moveToElement(allele.get(i)).perform();
			System.out.println("-----------");
			String names = allele1.get(i).getText();
			System.out.println(names);
		}
	
		
		driver.quit();
	}

}
