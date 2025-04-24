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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Delay duration in seconds
Number delayDuration = 3;

//import com.kms.katalon.core.annotation.Keyword as Keyword
WebUiBuiltInKeywords.comment('Story: Add a Script Template')

WebUiBuiltInKeywords.comment('Given that the user has logged into their account')

boolean isLoggedIn = WebUiBuiltInKeywords.verifyElementNotPresent(findTestObject('Object Repository/Page_Script Template Detail/button_Script Template'), 
    0, FailureHandling.STOP_ON_FAILURE)

'Login if user us not currently logged in.'
if (isLoggedIn === true) {
    'Login'
    WebUiBuiltInKeywords.callTestCase(findTestCase('Authentication/Login'), [('Username') : findTestData('ScriptTemplateManager/Credentials').getValue(
                1, 1), ('Password') : findTestData('ScriptTemplateManager/Credentials').getValue(2, 1), ('RememberMe') : findTestData(
                'ScriptTemplateManager/Credentials').getValue(3, 1)], FailureHandling.STOP_ON_FAILURE)

    WebUiBuiltInKeywords.waitForPageLoad(GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

    WebUiBuiltInKeywords.waitForElementVisible(findTestObject('Object Repository/Page_Script Template Detail/button_Script Template'), 
        0, FailureHandling.STOP_ON_FAILURE)
}

WebUiBuiltInKeywords.click(findTestObject('Object Repository/Page_Script Template Detail/button_Script Template'))

WebUiBuiltInKeywords.waitForPageLoad(GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

WebUiBuiltInKeywords.waitForElementVisible(findTestObject('Object Repository/Page_Script Template Detail/input_Name_TemplateDetail_Name_Input'), 
    0, FailureHandling.STOP_ON_FAILURE)

WebUiBuiltInKeywords.comment('When the user fills in valid information on the Script Template Detail page')

WebUiBuiltInKeywords.setText(findTestObject('Object Repository/Page_Script Template Detail/input_Name_TemplateDetail_Name_Input'), 
    Name)

WebUiBuiltInKeywords.setText(findTestObject('Object Repository/Page_Script Template Detail/textarea_Description_TemplateDetail_aa8ae6'), 
    Description)

WebUiBuiltInKeywords.selectOptionByValue(findTestObject('Object Repository/Page_Script Template Detail/select_Template_Type'), 
    Type, true)

WebUiBuiltInKeywords.selectOptionByValue(findTestObject('Object Repository/Page_Script Template Detail/select_Application_Module'), 
    ApplicationModule, true)

WebUiBuiltInKeywords.setText(findTestObject('Object Repository/Page_Script Template Detail/input_MergeFields_Parenthesis_TemplateDetail_VariablePrefix_Input'), 
    MergeFieldPrefix)

WebUiBuiltInKeywords.setText(findTestObject('Object Repository/Page_Script Template Detail/input_MergeFields_Parenthesis_TemplateDetail_VariableSuffix_Input'), 
    MergeFieldSuffix)

CustomKeywords.'com.components.ckeditor.CKEditorKeywords.setText'(findTestObject('Page_Script Template Detail/iframe_CKEditor_TemplateDetail_TextArea_Script'), 
    TextScript)

WebUI.delay(delayDuration)

WebUiBuiltInKeywords.click(findTestObject('Object Repository/Page_Script Template Detail/button_Generate Merge Fields'))

WebUiBuiltInKeywords.comment('When the user has filled in valid information on the Script Template Detail page')

WebUI.delay(delayDuration)

WebUiBuiltInKeywords.click(findTestObject('Object Repository/Page_Script Template Detail/button_Save'))

WebUiBuiltInKeywords.comment('The the user should be able to create a new Script Template')

WebUI.verifyElementVisible(findTestObject('Page_Script Template Detail/div_Template CV Successfully saved'))

WebUiBuiltInKeywords.click(findTestObject('Object Repository/Page_Script Template Detail/button_Back'))

WebUI.callTestCase(findTestCase('TC02 - Verify Script Template'), [('Name') : Name], FailureHandling.STOP_ON_FAILURE)

