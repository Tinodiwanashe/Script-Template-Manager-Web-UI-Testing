package com.components.webtable

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

import internal.GlobalVariable

import org.openqa.selenium.JavascriptExecutor;
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


class WebTable {

	@Keyword
	public int Edit_Delete_Update_Anchor_actions(String ExpectedRowName, int Column, int AchorLink) throws InterruptedException {
		
		WebDriver driver = DriverFactory.getWebDriver();
		int Row;
		String ActualRowName = null;
		boolean page = true;
		int TestData=1;
		String celtext=null;

		table: while (page) {
			WebElement UsersTable = driver.findElement(By.xpath("//table/tbody"));

			List<WebElement> rows_UsersTable = UsersTable.findElements(By
					.tagName("tr"));

			int rows_count = rows_UsersTable.size();
			println ("Toatl rows is  " +rows_count)

			for (int row = 0; row < rows_count; row++) {

				List<WebElement> Columns_row = rows_UsersTable.get(row)
						.findElements(By.tagName("td"));
				Row = row+1 ;

				int columns_count = Columns_row.size();
				System.out.println("Number of cells In Row " + row + " are "
						+ columns_count);
				boolean a = true;

				for (int column = 0; column < columns_count; column++) {

				celtext = Columns_row.get(column).getText();
					System.out.println("Cell Value Of row number " + row
									+ " and column number " + column + " Is "
									+ celtext);

					if (celtext.matches(ExpectedRowName)) {
						ActualRowName = celtext;

						WebElement common = driver.findElement(By
								.xpath("//table/tbody/tr["+Row+"]/td["+Column+"]/a["+AchorLink+"]"));

						JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("arguments[0].click();", common);

						Thread.sleep(5000);
						a = false;
						page = false;
						TestData=1;
						break table;

					}

				}
				if (a == false) {
					break;
				}
				if(row==rows_count-1){
					System.out.println("Test Data is incorrect or Value is Missing");
					TestData=0;
					break table;
				}
			}

		}
		return TestData;
	}
	
	@Keyword
	public String GetText_From_WebTable_Organisation(String ExpectedRowName, int Column) throws InterruptedException {
		
		WebDriver driver = DriverFactory.getWebDriver();
		int Row;
		String ActualRowName = null;
		boolean page = true;
		int TestData=1;
		String Str;

		table: while (page) {
			WebElement UsersTable = driver.findElement(By.xpath("//table/tbody"));

			List<WebElement> rows_UsersTable = UsersTable.findElements(By
					.tagName("tr"));

			int rows_count = rows_UsersTable.size();
			println ("Toatl rows is  " +rows_count)

			for (int row = 0; row < rows_count; row++) {

				List<WebElement> Columns_row = rows_UsersTable.get(row)
						.findElements(By.tagName("td"));
				Row = row+1 ;

				int columns_count = Columns_row.size();
				System.out.println("Number of cells In Row " + row + " are "
						+ columns_count);
				boolean a = true;

				for (int column = 0; column < columns_count; column++) {

					String celtext = Columns_row.get(column).getText();
					System.out.println("Cell Value Of row number " + row
									+ " and column number " + column + " Is "
									+ celtext);

					if (celtext.matches(ExpectedRowName)) {
						ActualRowName = celtext;

						WebElement common = driver.findElement(By
								.xpath("//table/tbody/tr["+Row+"]/td["+Column+"]"));

					 Str=common.getText();

						Thread.sleep(5000);
						a = false;
						page = false;
						TestData=1;
						break table;

					}

				}
				if (a == false) {
					break;
				}
				if(row==rows_count-1){
					System.out.println("Test Data is incorrect or Value is Missing");
					TestData=0;
					break table;
					

				}
			}

		}
		return Str;
	}
	
	@Keyword
	public String Selecting_CheckBox_From_WebTable(String ExpectedRowName, int Column) throws InterruptedException {
		
		WebDriver driver = DriverFactory.getWebDriver();
		int Row;
		String ActualRowName = null;
		boolean page = true;
		int TestData=1;
		String Str;

		table: while (page) {
			WebElement UsersTable = driver.findElement(By.xpath("//table/tbody"));

			List<WebElement> rows_UsersTable = UsersTable.findElements(By
					.tagName("tr"));

			int rows_count = rows_UsersTable.size();
			println ("Toatl rows is  " +rows_count)

			for (int row = 0; row < rows_count; row++) {

				List<WebElement> Columns_row = rows_UsersTable.get(row)
						.findElements(By.tagName("td"));
				Row = row+1 ;

				int columns_count = Columns_row.size();
				System.out.println("Number of cells In Row " + row + " are "
						+ columns_count);
				boolean a = true;

				for (int column = 0; column < columns_count; column++) {

					String celtext = Columns_row.get(column).getText();
					System.out.println("Cell Value Of row number " + row
									+ " and column number " + column + " Is "
									+ celtext);

					if (celtext.matches(ExpectedRowName)) {
						ActualRowName = celtext;

						WebElement common = driver.findElement(By
								.xpath("//table/tbody/tr["+Row+"]/td["+Column+"]/input"));

						common.click();
							
					 Str=common.getText();

						Thread.sleep(5000);
						a = false;
						page = false;
						TestData=1;
						break table;

					}

				}
				if (a == false) {
					break;
				}
				if(row==rows_count-1){
					System.out.println("Test Data is incorrect or Value is Missing");
					TestData=0;
					break table;
					

				}
			}

		}
		return Str;
	
		

	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
}