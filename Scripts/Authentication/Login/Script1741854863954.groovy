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


WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Login/input_Username_Input_UsernameVal'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Page_Login/input_Username_Input_UsernameVal'), Username)

WebUI.sendKeys(findTestObject('Object Repository/Page_Login/input_Password_Input_PasswordVal'), Password)

if (RememberMe) {
	WebUI.check(findTestObject('Object Repository/Page_Login/input_Password_Checkbox'))
}

WebUI.click(findTestObject('Object Repository/Page_Login/button_Login'))
WebUI.waitForPageLoad(GlobalVariable.TimeOut)

WebUI.click(findTestObject('Object Repository/Page_ScriptTemplates/icon_Account_Options'))
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ScriptTemplates/div_Logout'), 0, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Page_ScriptTemplates/div_Script TemplatesScript Template'))

