package com.components.dropdown
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.common.WebUiCommonHelper

import internal.GlobalVariable

import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.testng.Assert

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class VerifyExpectedAndActualOptionsInDropdown {
	
	@Keyword
	public static void VerifyExpectedAndActual(TestObject objectto, List<String> listOfOptions) {
		try {
			WebElement element = WebUiCommonHelper.findWebElement(objectto, 20);
			Select ele = new Select(element);
			List<String> expectedOptions = listOfOptions;
			List<String> actualOptions = new ArrayList<String>();
			for (WebElement option : ele.getOptions()) {
				//System.out.println("Dropdown options are: " + option.getText());
				actualOptions.add(option.getText());
			}

			Assert.assertEquals(expectedOptions.toArray(), actualOptions.toArray());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}