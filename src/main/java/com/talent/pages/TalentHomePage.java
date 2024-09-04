package com.talent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalentHomePage extends BasePage{
	
	
	
	public TalentHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"tools\"]/div[2]/ul/li[2]/a")
	WebElement ServiceCentral;
	
	@FindBy(xpath = "//*[@id=\"cookie_info\"]/div[2]/a")
	WebElement cookies;
	
	public void navigateToServiceCentral() {
//		accepting cookies on home page
		cookies.click();
		
//		scrolling 100px in y axis
		javascriptExecutor.executeScript("scroll(0,100);");
		
//		navigating to ServiceCentral page
		actions
		.moveToElement(ServiceCentral)
		.click()
		.perform();
	}
	
	public static void main(String[] args) {
		
	}
	
	
	
	

	
}
