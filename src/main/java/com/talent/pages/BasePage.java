package com.talent.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
	
	public static WebDriver driver;
	public static Actions actions;
	public static JavascriptExecutor javascriptExecutor;
	public static Robot robot;
	
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		actions = new Actions(driver);
		javascriptExecutor = (JavascriptExecutor)driver;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
