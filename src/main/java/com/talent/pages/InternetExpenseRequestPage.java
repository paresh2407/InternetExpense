package com.talent.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InternetExpenseRequestPage extends BasePage{

	public InternetExpenseRequestPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"sp_formfield_report_name\"]")
	WebElement reportName;
	
	@FindBy(xpath = "//*[@id=\"sp_formfield_project_code_text\"]")
	WebElement projectCode;
	
	@FindBy(xpath = "//*[@id=\"s2id_autogen26_search\"]")
	WebElement projectCodeTask;
	
	@FindBy(xpath = "//*[@id=\"s2id_sp_formfield_expense_approver\"]/a")
	WebElement expenseApprover;
	
	@FindBy(xpath = "//*[@id=\"sp_formfield_comment\"]")
	WebElement comment;
	
	@FindBy(xpath = "//*[@id=\"sp_formfield_transaction_date\"]")
	WebElement transactionDate;
	
	@FindBy(xpath = "//*[@id=\"sp_formfield_vendor_name\"]")
	WebElement vendorName;
	
	@FindBy(xpath = "//*[@id=\"s2id_autogen6_search\"]")
	WebElement location;
	
	@FindBy(xpath = "//*[@id=\"sp_formfield_amount\"]")
	WebElement amount;
	
	@FindBy(xpath = "//*[@id=\"sp_formfield_payment_receipt\"]/button")
	WebElement uploadButton;
	
	@FindBy(xpath = "//*[@id=\"label_contract_accepted\"]")
	WebElement checkBox;
	
	@FindBy(xpath = "//button[@class='btn btn-primary bottom-button-width text-overflow-ellipsis ng-binding ng-scope']")
	WebElement submitButton;
	
	public void inputReportName(String report) {
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", reportName);
		reportName.sendKeys(report);
	}
	
	public void inputProjectCode(String project,String task) {
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", projectCode);
		projectCode.sendKeys(project);
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", projectCodeTask);
		driver.findElement(By.xpath("//*[@id=\"project_name\"]/div/div[1]/label/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"s2id_sp_formfield_project_code_task\"]/a/span[2]/b")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		projectCodeTask.sendKeys(task+Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		projectCodeTask.sendKeys(Keys.ENTER);
	}
	
	public void inputExpenseApprover(String approver) {
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", expenseApprover);
//		expenseApprover.sendKeys(approver);
	}
	
	public void inputComment(String businessPurpose) {
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", comment);
		comment.sendKeys(businessPurpose);
	}
	
	public void inputTrasactionDate(String date) {
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", transactionDate);
		transactionDate.sendKeys(date);
	}
	
	public void inputVendorName(String vendor) {
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", vendorName);
		vendorName.sendKeys(vendor);
	}
	
	public void inputLocation(String reportingLocation) {
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", location);
		driver.findElement(By.xpath("//*[@id=\"s2id_sp_formfield_location\"]/a/span[2]/b")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		location.sendKeys(reportingLocation);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		location.sendKeys(Keys.DOWN +""+ Keys.ENTER);
	}
	
	public void inputAmount(String maxAmount) {
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", amount);
		amount.sendKeys(maxAmount);
	}
	
	public void uploadInvoiceReceipt(String filePath) {
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", uploadButton);
		uploadButton.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(filePath), null);
		 
	     // press Contol+V for pasting
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void selectTermsAndCondition() {
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(checkBox)).click();
	}
	
	public void clickSubmitButton() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", submitButton);
		submitButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		submitButton.click();
	}
	
	

}
