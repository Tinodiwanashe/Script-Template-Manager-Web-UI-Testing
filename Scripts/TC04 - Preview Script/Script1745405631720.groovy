import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//import com.kms.katalon.core.annotation.Keyword as Keyword
WebUI.comment('Story: Preview a Script Template')

WebUI.comment('Given that the user has logged into their account')

//Delay duration in seconds
boolean isLoggedIn = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ScriptTemplates/span_Account_Name'), 3)

'Login if user us not currently logged in.'
if (isLoggedIn === false) {
    'Login'
    WebUI.callTestCase(findTestCase('Authentication/Login'), [('Username') : findTestData('ScriptTemplateManager/Credentials').getValue(
                1, 1), ('Password') : findTestData('ScriptTemplateManager/Credentials').getValue(2, 1), ('RememberMe') : findTestData(
                'ScriptTemplateManager/Credentials').getValue(3, 1)], FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForPageLoad(GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Script Template Detail/button_Script Template'), 
        0, FailureHandling.STOP_ON_FAILURE)
} else {

	WebUI.click(findTestObject('Object Repository/Page_Script Template Detail/button_Preview'))
	
	WebUI.click(findTestObject('Object Repository/Page_Script Template Detail/div_Json'))
	
	WebUI.setText(findTestObject('Object Repository/Page_Script Template Detail/textarea_Run_b18-TextArea_Json'), Json)
	
	WebUI.click(findTestObject('Object Repository/Page_Script Template Detail/button_Run'))
	
	WebUI.delay(delayDuration)
	
	WebUI.click(findTestObject('Object Repository/Page_Script Template Detail/button_Beautify'))
	
	WebUI.delay(delayDuration)
	
	WebUI.click(findTestObject('Object Repository/Page_Script Template Detail/button_Raw json'))
	
	WebUI.delay(delayDuration)
	
	WebUI.click(findTestObject('Object Repository/Page_Script Template Detail/button_Merge Fields'))
}
