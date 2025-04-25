package com.components.ckeditor

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory

import groovy.transform.CompileStatic

import internal.GlobalVariable

public class CKEditorKeywords {
	static Integer TIMEOUT = 60

	/**
	 * Set the content of entire input area. It will replaces editor data by the new text.
	 *
	 * @param iFrame The iFrame object that contains the text editor body.
	 * @param body The body object that needs to set text.
	 * @param text The text needs to set.
	 */
	@CompileStatic
	@Keyword
	static void setText(TestObject iFrame, String text) throws IOException {
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.switchToFrame(iFrame, TIMEOUT)
		WebElement body = driver.findElement(By.tagName("body"))
		body.click()
		body.clear()
		//body.sendKeys(Keys.HOME)
		
		body.sendKeys("_")
		body.sendKeys(Keys.ARROW_RIGHT)
		WebUI.delay(3)
		body.sendKeys(text)
		driver.switchTo().defaultContent()
	}

	/** 
	 * Set the content to input area. It keeps the existing editor data.
	 *
	 * @param iFrame The iFrame object that contains the text editor body.
	 * @param body The body object that needs to set text.
	 * @param text The text needs to set.
	 */
	@CompileStatic
	@Keyword
	static void sendKeys(TestObject iFrame, String text) throws IOException {
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.switchToFrame(iFrame, TIMEOUT)
		WebElement body = driver.findElement(By.tagName("body"))
		body.click()
		body.sendKeys(Keys.ENTER)
		body.sendKeys(text)
		driver.switchTo().defaultContent()
	}

	/**
	 * Clear all the content of the text editor.
	 *
	 * @param iFrame The iFrame object that contains the text editor body.
	 * @param body The body object that needs to clear text.
	 */
	@CompileStatic
	@Keyword
	static void clearAll(TestObject iFrame) throws IOException {
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.switchToFrame(iFrame, TIMEOUT)
		WebElement body = driver.findElement(By.tagName("body"))
		body.clear()
		driver.switchTo().defaultContent()
	}

	/**
	 * Select all the content of the text editor.
	 *
	 * @param iFrame The iframe object that contains the text editor body.
	 * @param body The body object that needs to select the text.
	 */
	@CompileStatic
	@Keyword
	static void selectAll(TestObject iFrame) throws IOException {
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.switchToFrame(iFrame, TIMEOUT)
		WebElement body = driver.findElement(By.tagName("body"))
		Actions actions = new Actions(driver)
		actions.click(body).keyDown(Keys.LEFT_CONTROL).sendKeys("a").keyUp(Keys.LEFT_CONTROL).perform()
		driver.switchTo().defaultContent()
	}
}