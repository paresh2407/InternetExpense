package com.talent.internetExpense;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
				 glue = "com.talent.steps",
				 dryRun  = false,
				 tags = "@SanityTesting_TC03")
public class TestRunner extends AbstractTestNGCucumberTests{

}
