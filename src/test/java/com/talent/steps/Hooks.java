package com.talent.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends BaseStep{
	
	@BeforeAll
	public static void setUpWebDriver() {
		String browserName = "Chrome";
		System.out.println("Inside setUpWebDriver method");
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			// to maximize the screen
			options.addArguments("--start-maximized");
			// to disable the notifications by browser
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
//			scenario 1
//			driver.get("https://talent.capgemini.com/in");
//			scenario 3
			driver.get("https://servicecentral.capgemini.com/sc?id=sc_cat_item&sys_id=d82ad3a81b0689d4a06533bd8b4bcb6a");
			String testDataPath = System.getProperty("user.dir") + "/testData/TestData.xlsx";
			File file = new File(testDataPath);
			try 
			{
				FileInputStream fileInputStream = new FileInputStream(file);
				workBook = new XSSFWorkbook(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
