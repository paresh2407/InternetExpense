package com.talent.steps;

import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.talent.pages.InternetExpenseRequestPage;
import com.talent.pages.ServiceCentralHomePage;
import com.talent.pages.TalentHomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TalentHomeStep extends BaseStep {

	private static TalentHomePage talentHomePage;
	private static ServiceCentralHomePage serviceCentralHomePage;
	private static InternetExpenseRequestPage expenseRequestPage;
	private static XSSFSheet sheet = workBook.getSheet("report_data");
	private static XSSFRow row;
//	----------------------- Scenario 1 ------------------------------------

	@Given("user is on talent home page")
	public void user_is_on_talent_home_page() {
		// Write code here that turns the phrase above into concrete actions

		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Inside user_is_on_talent_home_page method");
		talentHomePage = new TalentHomePage(driver);

	}

	@When("user clicks on ServiceCentral link")
	public void user_clicks_on_service_central_link() {
		// Write code here that turns the phrase above into concrete actions

		talentHomePage.navigateToServiceCentral();

	}

	@Then("user is redirected to ServiceCentral page successfully")
	public void user_is_redirected_to_service_central_page_successfully() {

//		switch to child window
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String currentWindowHandle : allWindowHandles) {
			if (!parentWindowHandle.equalsIgnoreCase(currentWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
			}
		}

		serviceCentralHomePage = new ServiceCentralHomePage(driver);
	}

//	----------------------------- Scenario 2 ----------------------------------

	@Given("user is on ServiceCentral page")
	public void user_is_on_service_central_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Given("user clicks on Order button")
	public void user_clicks_on_order_button() {
		// Write code here that turns the phrase above into concrete actions
		serviceCentralHomePage.navigateToServiceCatalog();
	}

	@When("user search Internet Expense Request and clicks on request button")
	public void user_search_internet_expense_request_and_clicks_on_request_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
//	    serviceCentralHomePage.search("Internet Expense Request");
		Thread.sleep(20000);
		serviceCentralHomePage.navigateToInternetRequestPage();

	}

	@Then("user redirected to Internet Expense Request page successfully")
	public void user_redirected_to_internet_expense_request_page_successfully() {

	}

//	---------------------------- Scenario 3 -----------------------------------------------

	@Given("user is on Internet Expense Request page")
	public void user_is_on_internet_expense_request_page() throws InterruptedException {
		Thread.sleep(30000);
		expenseRequestPage = new InternetExpenseRequestPage(driver);

	}

	@Given("user input Report Name {int}")
	public void user_input_report_name(Integer rowNo) {
		row = sheet.getRow((int) rowNo);
		System.out.println("No of rows: " + (sheet.getLastRowNum() - sheet.getFirstRowNum()));
		System.out.println("current row: " + rowNo);
		String reportName = row.getCell(0).getStringCellValue();
		expenseRequestPage.inputReportName(reportName);
	}

	@Given("user input Project Code {int}")
	public void user_input_project_code(Integer rowNo) {
		String projectCode = row.getCell(1).getRawValue();
		String projectTask = row.getCell(2).getRawValue();
		System.out.println("project code: " + projectCode + ", " + "project task: " + projectTask);
		expenseRequestPage.inputProjectCode(projectCode, projectTask);
	}

	@Given("user input Expense Approver {int}")
	public void user_input_expense_approver(Integer rowNo) {
//		expenseApprover will take default value 
//	    expenseRequestPage.inputExpenseApprover("");
	}

	@Given("user input Business Purpose\\/Comment {int}")
	public void user_input_business_purpose_comment(Integer rowNo) {
		String comment = row.getCell(4).getStringCellValue();
		System.out.println("comment: " + comment);
		expenseRequestPage.inputComment(comment);
	}

	@Given("user input Transaction Date {int}")
	public void user_input_transaction_date(Integer rowNo) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String transactionDate = row.getCell(5).getStringCellValue();
		System.out.println("transaction date: "+ transactionDate);
		expenseRequestPage.inputTrasactionDate(transactionDate);
	}

	@Given("user input Vendor Name {int}")
	public void user_input_vendor_name(Integer rowNo) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String vendorName = row.getCell(6).getStringCellValue();
		System.out.println("vendor name: "+vendorName);
		expenseRequestPage.inputVendorName(vendorName);
	}

	@Given("user input Location {int}")
	public void user_input_location(Integer rowNo) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String location = row.getCell(7).getStringCellValue();
		System.out.println("location: "+location);
		expenseRequestPage.inputLocation(location);
	}

	@Given("user uploads Invoice Payment Receipt")
	public void user_uploads_invoice_payment_receipt() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String amount = row.getCell(8).getRawValue();
		System.out.println("amount: "+amount);
		expenseRequestPage.inputAmount(amount);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String receipt = row.getCell(9).getStringCellValue();
		System.out.println("receipt: "+receipt);
		expenseRequestPage.uploadInvoiceReceipt(
				"OneDrive - Capgemini\\Desktop\\Talent\\internetExpense\\src\\test\\resources\\file\\"+receipt);
	}

	@Given("user clicks on Terms and Conditions check box")
	public void user_clicks_on_terms_and_conditions_check_box() {
		expenseRequestPage.selectTermsAndCondition();
	}

	@When("user clicks on Submit button")
	public void user_clicks_on_submit_button() {
//	    expenseRequestPage.clickSubmitButton();
	}

	@Then("user submitted Internet Expense Request successfully")
	public void user_submitted_internet_expense_request_successfully() {

	}

}
