package com.talent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceCentralHomePage extends BasePage{
	
	public ServiceCentralHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"x042ebb7bc321bd906c0a581bb001314d\"]/div/div/div/center/a")
	WebElement orderButton;
	
	@FindBy(xpath = "//*[@id=\"s2id_autogen1\"]/a/span[2]/b")
	WebElement catalog_dropDown;
	
	@FindBy(xpath = "//div[contains(text(),'Non Group IT Services')]")
	WebElement dropDownOption_Non_Group_IT_Services;
	
	@FindBy(xpath = "//h2[text()=\"Internet Expense Request\"]")
	WebElement internetExpenseRequest;

	
	
	
	public void navigateToServiceCatalog() {
//		scrolling down by 500px
//		javascriptExecutor.executeScript("scroll(0,500);");
		
//		click on orderButton
		actions
		.moveToElement(orderButton)
		.click()
		.perform();
	}
	
	public void search(String text) throws InterruptedException {
		//This Element is inside 2 nested shadow DOM.
		String cssSelectorForHost1 = ".aisearch";
		String cssSelectorForHost2 = "sn-search-combobox-desktop[placeholder='Search']";
		
		int attempts = 0;
	    while (attempts < 5) {
	        try {
	        	Thread.sleep(1000);
	    		SearchContext shadow0 = driver.findElement(By.cssSelector(".aisearch")).getShadowRoot();
	    		Thread.sleep(1000);
	    		SearchContext shadow1 = shadow0.findElement(By.cssSelector("sn-search-combobox-desktop[placeholder='Search']")).getShadowRoot();
	    		Thread.sleep(1000);
	    		shadow1.findElement(By.cssSelector(".input-container__input")).sendKeys(text + Keys.ENTER);
	            break;
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	        attempts++;
	        System.out.println(attempts);
	    }
		
	}
	
	public void navigateToInternetRequestPage() throws InterruptedException {
		catalog_dropDown.click();
		dropDownOption_Non_Group_IT_Services.click();
		Thread.sleep(2000);
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", internetExpenseRequest);
		Thread.sleep(2000);
		internetExpenseRequest.click();
		
		
	}

}
