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



class register_tanpa_npwp {

	Faker faker = new Faker()
	@Given("user is on the UC Auction registration page without npwp")
	def halaman_register() {
		println ("\n pengguna berada di halaman registrasi UC Auction")

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl('https://auction.lelangmobil.dev/register')

		WebUI.delay(2)

		def autoit_prj = (RunConfiguration.getProjectDir() + '/Data Files/Auth.exe')

		WebUI.comment(autoit_prj)

		Runtime.getRuntime().exec(autoit_prj)

		Thread.sleep(5000)

		WebUI.comment('Auth telah selesai dijalankan')

		WebUI.delay(3)
	}

	@When("user fills in a personal data form without npwp")
	def form_data_diri() {
		println ("\n Data Diri")

		'Input nama depan'
		def nama_depan = faker.name.firstName()

		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Depan'), 10)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Depan'), nama_depan)

		'Input nama belakang'
		def nama_belakang = faker.name.lastName()

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Belakang'), nama_belakang)

		'Input tempat lahir'
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Tempat Lahir'), 'Jakarta')

		'Input tanggal lahir'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/input_Tanggal Lahir'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/tanggal_lahir'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/span_Select'))

		'Input NIK'
		def NIK = faker.number().digits(16)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor KTP'), NIK)

		'Input Upload File KTP'
		String filePath = RunConfiguration.getProjectDir() + '/Data Files/TEST.jpg'

		String pathUpload = filePath.replace('/', '\\')

		WebUI.comment('File path: ' + pathUpload)

		WebUI.delay(2)

		TestObject inputFile = new TestObject('input_FileUpload')

		inputFile.addProperty('xpath', ConditionType.EQUALS, '//input[@type=\'file\']')

		WebUI.uploadFile(inputFile, pathUpload)

		WebUI.delay(2)

		'Klik Berlaku seumur hidup'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/input_Masa Berlaku KTP'))

		'Input Provinsi'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/input_Provinsi'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_DKI Jakarta'))

		'Input Kota'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Kota'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Kota Jakarta Timur'))

		'Input Alamat'
		def AlamatCompany = faker.address.fullAddress()

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/textarea_Alamat Domisili'), AlamatCompany)

		'Input No Handphone'
		def noTlp = faker.number().digits(10)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor Telepon'), noTlp)

		'Input Pekerjaan'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Pilih Pekerjaan'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Pegawai Swasta'))

		'Input Nama Company'
		def nama_perusahaan = faker.company.name()

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Perusahaan'), nama_perusahaan)

		'Input Alamat Company'
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/textarea_Alamat Perusahaan'), AlamatCompany)

		'Input No Telepon Perusahaan'
		def noPerusahaan = faker.number().digits(10)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor Telepon Perusahaan'), noPerusahaan)

		'Input Tidak Ada NPWP'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/button_Tidak Ada'))

		'Input Jenis Kendaraan'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Jenis Kendaraan'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Mobil'))

		'Input Kendaraan yang dicari'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Kendaraan'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Kendaraan Penumpang'))

		'Input Tujuan Pembelian'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Tujuan Pembelian'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Pribadi'))

		'Input Email'
		def email = faker.internet().safeEmailAddress()

		WebUI.setText(findTestObject('Page_Register - UC auction/input_Email_email'), email)

		'Input Password'
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Kata Sandi_new_password'), 'Qwerty123!')

		'Input RePassword'
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Konfirmasi Kata Sandi_confirm_password'),
				'Qwerty123!')

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/button_Selanjutnya'))
	}

	@And("user fills in the payment data form without npwp")
	def form_data_pembayaran() {
		println ("\n Data Pembayaran")

		'Input No Rek'
		def noRek = faker.number().digits(12)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor Rekening'), noRek)

		'Input Bank'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Pilih Bank'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_BANK BCA'))

		'Input Nama Pemilik Bank'
		def nama_depan = faker.name.firstName()

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Pemilik Rekening'), nama_depan)

		'Input Sumber Dana'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Sumber Dana'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_GajiUpah'))

		'Input Metode Pembayaran'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Metode Pembayaran'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Bank Transfer'))

		'Klik button Daftar'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/button_Daftar'))
	}

	@Then("user sees the message New data successfully added without npwp")
	def success_register() {
		println ("\n pengguna melihat pesan Data baru berhasil ditambahkan")

		WebUI.verifyTextPresent('Data baru berhasil ditambahkan', false)

		WebUI.takeScreenshot()

		WebUI.closeBrowser()
	}
}

class register_dengan_npwp {

	Faker faker = new Faker()
	@Given("user is on the UC Auction registration page there is npwp")
	def halaman_register() {
		println ("\n pengguna berada di halaman registrasi UC Auction")

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl('https://auction.lelangmobil.dev/register')

		WebUI.delay(2)

		def autoit_prj = (RunConfiguration.getProjectDir() + '/Data Files/Auth.exe')

		WebUI.comment(autoit_prj)

		Runtime.getRuntime().exec(autoit_prj)

		Thread.sleep(5000)

		WebUI.comment('Auth telah selesai dijalankan')

		WebUI.delay(3)
	}

	@When("user fills in the personal data form with npwp")
	def form_data_diri() {
		println ("\n Data Diri")

		'Input nama depan'
		def nama_depan = faker.name.firstName()

		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Depan'), 10)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Depan'), nama_depan)

		'Input nama belakang'
		def nama_belakang = faker.name.lastName()

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Belakang'), nama_belakang)

		'Input tempat lahir'
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Tempat Lahir'), 'Jakarta')

		'Input tanggal lahir'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/input_Tanggal Lahir'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/tanggal_lahir'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/span_Select'))

		'Input NIK'
		def NIK = faker.number().digits(16)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor KTP'), NIK)

		'Input Upload File KTP'
		String filePath = RunConfiguration.getProjectDir() + '/Data Files/TEST.jpg'

		String pathUpload = filePath.replace('/', '\\')

		WebUI.comment('File path: ' + pathUpload)

		WebUI.delay(2)

		TestObject inputFile = new TestObject('input_FileUpload')

		inputFile.addProperty('xpath', ConditionType.EQUALS, '//input[@type=\'file\']')

		WebUI.uploadFile(inputFile, pathUpload)

		WebUI.delay(2)

		'Klik Berlaku seumur hidup'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/input_Masa Berlaku KTP'))

		'Input Provinsi'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/input_Provinsi'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_DKI Jakarta'))

		'Input Kota'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Kota'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Kota Jakarta Timur'))

		'Input Alamat'
		def AlamatCompany = faker.address.fullAddress()

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/textarea_Alamat Domisili'), AlamatCompany)

		'Input No Handphone'
		def noTlp = faker.number().digits(10)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor Telepon'), noTlp)

		'Input Pekerjaan'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Pilih Pekerjaan'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Pegawai Swasta'))

		'Input Nama Company'
		def nama_perusahaan = faker.company.name()

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Perusahaan'), nama_perusahaan)

		'Input Alamat Company'
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/textarea_Alamat Perusahaan'), AlamatCompany)

		'Input No Telepon Perusahaan'
		def noPerusahaan = faker.number().digits(10)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor Telepon Perusahaan'), noPerusahaan)

		'Input Ada NPWP'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/button_Ada NPWP'))

		def NPWP = faker.number().digits(15)
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor NPWP'), NPWP)

		'Input Jenis Kendaraan'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Jenis Kendaraan'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Mobil'))

		'Input Kendaraan yang dicari'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Kendaraan'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Kendaraan Penumpang'))

		'Input Tujuan Pembelian'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Tujuan Pembelian'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Pribadi'))

		'Input Email'
		def email = faker.internet().safeEmailAddress()

		WebUI.setText(findTestObject('Page_Register - UC auction/input_Email_email'), email)

		'Input Password'
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Kata Sandi_new_password'), 'Qwerty123!')

		'Input RePassword'
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Konfirmasi Kata Sandi_confirm_password'),
				'Qwerty123!')

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/button_Selanjutnya'))
	}

	@And("user fills in the payment data form with npwp")
	def form_data_pembayaran() {
		println ("\n Data Pembayaran")

		'Input No Rek'
		def noRek = faker.number().digits(12)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor Rekening'), noRek)

		'Input Bank'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Pilih Bank'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_BANK BCA'))

		'Input Nama Pemilik Bank'
		def nama_depan = faker.name.firstName()

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Pemilik Rekening'), nama_depan)

		'Input Sumber Dana'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Sumber Dana'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_GajiUpah'))

		'Input Metode Pembayaran'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Metode Pembayaran'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Bank Transfer'))

		'Klik button Daftar'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/button_Daftar'))
	}

	@Then("user sees the message New data successfully added with npwp")
	def success_register() {
		println ("\n pengguna melihat pesan Data baru berhasil ditambahkan")

		WebUI.verifyTextPresent('Data baru berhasil ditambahkan', false)

		WebUI.takeScreenshot()

		WebUI.closeBrowser()
	}
}

class register_dengan_nik {

	Faker faker = new Faker()
	@Given("user is on the UC Auction registration page with nik")
	def halaman_register() {
		println ("\n pengguna berada di halaman registrasi UC Auction")

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl('https://auction.lelangmobil.dev/register')

		WebUI.delay(2)

		def autoit_prj = (RunConfiguration.getProjectDir() + '/Data Files/Auth.exe')

		WebUI.comment(autoit_prj)

		Runtime.getRuntime().exec(autoit_prj)

		Thread.sleep(5000)

		WebUI.comment('Auth telah selesai dijalankan')

		WebUI.delay(3)
	}

	@When("user fills in the personal data form with nik")
	def form_data_diri() {
		println ("\n Data Diri")

		'Input nama depan'
		def nama_depan = faker.name.firstName()

		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Depan'), 10)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Depan'), nama_depan)

		'Input nama belakang'
		def nama_belakang = faker.name.lastName()

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Belakang'), nama_belakang)

		'Input tempat lahir'
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Tempat Lahir'), 'Jakarta')

		'Input tanggal lahir'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/input_Tanggal Lahir'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/tanggal_lahir'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/span_Select'))

		'Input NIK'
		def NIK = faker.number().digits(16)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor KTP'), NIK)

		'Input Upload File KTP'
		String filePath = RunConfiguration.getProjectDir() + '/Data Files/TEST.jpg'

		String pathUpload = filePath.replace('/', '\\')

		WebUI.comment('File path: ' + pathUpload)

		WebUI.delay(2)

		TestObject inputFile = new TestObject('input_FileUpload')

		inputFile.addProperty('xpath', ConditionType.EQUALS, '//input[@type=\'file\']')

		WebUI.uploadFile(inputFile, pathUpload)

		WebUI.delay(2)

		'Klik Berlaku seumur hidup'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/input_Masa Berlaku KTP'))

		'Input Provinsi'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/input_Provinsi'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_DKI Jakarta'))

		'Input Kota'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Kota'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Kota Jakarta Timur'))

		'Input Alamat'
		def AlamatCompany = faker.address.fullAddress()

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/textarea_Alamat Domisili'), AlamatCompany)

		'Input No Handphone'
		def noTlp = faker.number().digits(10)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor Telepon'), noTlp)

		'Input Pekerjaan'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Pilih Pekerjaan'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Pegawai Swasta'))

		'Input Nama Company'
		def nama_perusahaan = faker.company.name()

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Perusahaan'), nama_perusahaan)

		'Input Alamat Company'
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/textarea_Alamat Perusahaan'), AlamatCompany)

		'Input No Telepon Perusahaan'
		def noPerusahaan = faker.number().digits(10)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor Telepon Perusahaan'), noPerusahaan)

		'Input Ada NPWP'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/button_NPWP NIK'))

		'Input Jenis Kendaraan'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Jenis Kendaraan'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Mobil'))

		'Input Kendaraan yang dicari'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Kendaraan'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Kendaraan Penumpang'))

		'Input Tujuan Pembelian'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Tujuan Pembelian'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Pribadi'))

		'Input Email'
		def email = faker.internet().safeEmailAddress()

		WebUI.setText(findTestObject('Page_Register - UC auction/input_Email_email'), email)

		'Input Password'
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Kata Sandi_new_password'), 'Qwerty123!')

		'Input RePassword'
		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Konfirmasi Kata Sandi_confirm_password'),
				'Qwerty123!')

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/button_Selanjutnya'))
	}

	@And("user fills in the payment data form with nik")
	def form_data_pembayaran() {
		println ("\n Data Pembayaran")

		'Input No Rek'
		def noRek = faker.number().digits(12)

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor Rekening'), noRek)

		'Input Bank'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Pilih Bank'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_BANK BCA'))

		'Input Nama Pemilik Bank'
		def nama_depan = faker.name.firstName()

		WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Pemilik Rekening'), nama_depan)

		'Input Sumber Dana'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Sumber Dana'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_GajiUpah'))

		'Input Metode Pembayaran'
		WebUI.click(findTestObject('Page_Register - UC auction/input_Metode Pembayaran'))

		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Bank Transfer'))

		'Klik button Daftar'
		WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/button_Daftar'))
	}

	@Then("user sees the message New data successfully added with nik")
	def success_register() {
		println ("\n pengguna melihat pesan Data baru berhasil ditambahkan")

		WebUI.verifyTextPresent('Data baru berhasil ditambahkan', false)

		WebUI.takeScreenshot()

		WebUI.closeBrowser()
	}
}