import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import org.junit.After
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class TC_Listener_01 {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def logBeforeTestCase(TestCaseContext testCaseContext) {
		WebUI.comment("Initialize setup for Test Case Execution")
		
		KeywordUtil.markWarning("Test Case Name : " + testCaseContext.getTestCaseId())
		KeywordUtil.markWarning("Test Case Variables : " + testCaseContext.getTestCaseVariables()) 
		println "Initializing test data for case " + testCaseContext.getTestCaseId()
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def logAfterTestCase(TestCaseContext testCaseContext) {
		WebUI.switchToDefaultContent()
		//WebUI.closeWindowIndex(1)
		//WebUI.switchToWindowIndex(0)
		WebUI.comment("Test Case Execution Completed")
		KeywordUtil.markWarning("Test Case Name : " + testCaseContext.getTestCaseId())
		KeywordUtil.markWarning("Test Case Status : " + testCaseContext.getTestCaseStatus())
		
		if(testCaseContext.getTestCaseStatus().equals("FAILED")){
			String screenshotPath = "Screenshots/" + testCaseContext.getTestCaseId() + ".png";
			WebUI.takeScreenshot(screenshotPath);
			println "Screenshot saved at: " + screenshotPath;
		}
		
		//if there are any test-specific changes made, reset them
		println "Reseting test configuration settings..."
		
		println "Cleaning up resources for case " + testCaseContext.getTestCaseId()
	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def logBeforeTestSuite(TestSuiteContext testSuiteContext) {
		WebUI.comment("Preparing Environment for Test Suite Execution")
		CustomKeywords.'com.helper.utilities.Utils.openWebApp'(GlobalVariable.SiteUrl, GlobalVariable.TimeOut)
		KeywordUtil.markWarning("Before Test Suite Listener : " + testSuiteContext.getTestSuiteId())
		println "Loading environment configurations for suite" + testSuiteContext.getTestSuiteId()
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def logAfterTestSuite(TestSuiteContext testSuiteContext) {
		WebUI.comment("Finalizing Test Suite Execution")
		WebUI.closeBrowser()
		KeywordUtil.markWarning("After Test Suite Listener : " + testSuiteContext.getTestSuiteId())
		println "Generating and saving Test Suite Report for suite " + testSuiteContext.getTestSuiteId()
	}
}