import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.github.javafaker.Faker as Faker


import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import groovy.json.JsonSlurper as JsonSlurper



class verify {

	@Given("I open the browser")
	def browser() {
		println ("\n open browser")
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
	}

	@When("I navigate to the URL")
	def URL() {
		println ("\n URL https://ucauction.co.id/ ")
		WebUI.navigateToUrl('https://ucauction.co.id/')
	}

	@And("I wait for 2 seconds")
	def delay() {
		println ("\n Delay 2s")
		WebUI.delay(2)
	}
	
	@And("I click close on the image on the homepage")
	def click_close() {
		println ("\n click close")
		WebUI.click(findTestObject('Object Repository/Page_Perusahaan Jasa Lelang Mobil dan Motor/img'))
	}
	
	@And("I click on the copyright text on the homepage")
	def copy_right() {
		println ("\n click copyright")
		WebUI.click(findTestObject('Object Repository/Page_Perusahaan Jasa Lelang Mobil dan Motor/Copyright'))

	}

	@Then("I should see the text Copyright © 2022 UC auction - All rights reserved")
	def success_register() {
		println ("\n verify copyright")
		WebUI.verifyElementText(findTestObject('Page_Perusahaan Jasa Lelang Mobil dan Motor/Copyright'), 'Copyright © 2022 UC auction - All rights reserved')
		
		WebUI.closeBrowser()

	}
}

