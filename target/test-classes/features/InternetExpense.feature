Feature: Internet reimbursement functionality
  To test/automate internet reimbusement functionality
	
	
  @SanityTesting_TC01
	 Scenario: User redirected to ServiceCentral page successfully
		Given user is on talent home page
		When user clicks on ServiceCentral link
		Then user is redirected to ServiceCentral page successfully
		
  @SanityTesting_TC02
     Scenario: User redirected to Internet Expense Request page successfully
        Given user is on ServiceCentral page
        And user clicks on Order button
        When user search Internet Expense Request and clicks on request button
        Then user redirected to Internet Expense Request page successfully
        
  @SanityTesting_TC03
  	 Scenario Outline: User submitted Internet Expense Request successfully
  	    Given user is on Internet Expense Request page
  	    And user input Report Name <reportName_index>
  	    And user input Project Code <projectCode_index>
  	    And user input Expense Approver <expense_index>
  	    And user input Business Purpose/Comment <comment_index>
  	    And user input Transaction Date <transactionDate_index>
  	    And user input Vendor Name <vendorName_index>
  	    And user input Location <loaction_index>
  	    And user uploads Invoice Payment Receipt
  	    And user clicks on Terms and Conditions check box
  	    When user clicks on Submit button
  	    Then user submitted Internet Expense Request successfully
  	    Examples:
        | reportName_index | projectCode_index | expense_index | comment_index | transactionDate_index | vendorName_index | loaction_index |
        | 1                | 1                 | 1             | 1             | 1                     | 1                | 1              |
  	    
        
