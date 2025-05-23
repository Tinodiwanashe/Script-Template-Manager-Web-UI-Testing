import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys




WebUI.sendKeys(findTestObject('Object Repository/Page_Script Template Detail/input_Search input_Input_SearchKeyword'),Name)
WebUI.delay(3)

WebUI.comment("Number of results returned upon search input")
int numberOfItems = WebUI.getText(findTestObject('Object Repository/Page_ScriptTemplates/span_Number_Of_Items')).toInteger()
WebUI.comment("Number of items: " + numberOfItems)

WebUI.comment("Verify Template if name it is available in the list")
if (numberOfItems >= 1) {

    boolean isFound = WebUI.verifyElementText(findTestObject('Object Repository/Page_ScriptTemplates/span_Template_Name'), Name)
	
	WebUI.comment("Custom assertion to check if the Template name is correct")
	def templateName = WebUI.getText(findTestObject('Object Repository/Page_ScriptTemplates/span_Template_Name'))
	assert templateName == Name : "Template name is incorrect. Expected name should be " + Name
	

} else {
	KeywordUtil.markWarning("Template named '" + Name + "' was not found")
}

