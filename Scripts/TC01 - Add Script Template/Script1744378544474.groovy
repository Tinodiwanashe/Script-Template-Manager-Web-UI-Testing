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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

//Delay duration in seconds
Number delayDuration = 3

//import com.kms.katalon.core.annotation.Keyword as Keyword
WebUI.comment('Story: Add a Script Template')

WebUI.comment('Given that the user has logged into their account')

boolean isLoggedIn = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ScriptTemplates/span_Account_Name'), 
    3)

'Login if user us not currently logged in.'
if (isLoggedIn === false) {
    'Login'
    WebUI.callTestCase(findTestCase('Authentication/Login'), [('Username') : findTestData('ScriptTemplateManager/Credentials').getValue(
                1, 1), ('Password') : findTestData('ScriptTemplateManager/Credentials').getValue(2, 1), ('RememberMe') : findTestData(
                'ScriptTemplateManager/Credentials').getValue(3, 1)], FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForPageLoad(GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Script Template Detail/button_Script Template'), 
        0, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('Object Repository/Page_Script Template Detail/button_Script Template'))

WebUI.comment('Navigate to Script Template Detail')

WebUI.waitForPageLoad(GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Script Template Detail/input_Name_TemplateDetail_Name_Input'), 
    0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Page_Script Template Detail/iframe_CKEditor_TemplateDetail_TextArea_Script'), 
    0, FailureHandling.STOP_ON_FAILURE)

WebUI.comment('When the user fills in valid information on the Script Template Detail page')

WebUI.setText(findTestObject('Object Repository/Page_Script Template Detail/input_Name_TemplateDetail_Name_Input'), Name)

WebUI.setText(findTestObject('Object Repository/Page_Script Template Detail/textarea_Description_TemplateDetail_aa8ae6'), 
    Description)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Script Template Detail/select_Template_Type'), Type, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Script Template Detail/select_Application_Module'), ApplicationModule, 
    true)

WebUI.setText(findTestObject('Object Repository/Page_Script Template Detail/input_MergeFields_Parenthesis_TemplateDetail_VariablePrefix_Input'), 
    MergeFieldPrefix)

WebUI.setText(findTestObject('Object Repository/Page_Script Template Detail/input_MergeFields_Parenthesis_TemplateDetail_VariableSuffix_Input'), 
    MergeFieldSuffix)

WebUI.scrollToElement(findTestObject('Page_Script Template Detail/iframe_CKEditor_TemplateDetail_TextArea_Script'), 0)

CustomKeywords.'com.components.ckeditor.CKEditorKeywords.setText'(findTestObject('Page_Script Template Detail/iframe_CKEditor_TemplateDetail_TextArea_Script'), 
    TextScript)

WebUI.delay(delayDuration)

WebUI.click(findTestObject('Object Repository/Page_Script Template Detail/button_Generate Merge Fields'))

WebUI.comment('When the user has filled in valid information on the Script Template Detail page')

WebUI.delay(delayDuration)

WebUI.click(findTestObject('Object Repository/Page_Script Template Detail/button_Save'))

WebUI.comment('The the user should be able to create a new Script Template')

WebUI.verifyElementVisible(findTestObject('Page_Script Template Detail/div_Template CV Successfully saved'))

WebUI.scrollToElement(findTestObject('Page_Script Template Detail/button_Back'), 0)

WebUI.click(findTestObject('Object Repository/Page_Script Template Detail/button_Back'))

