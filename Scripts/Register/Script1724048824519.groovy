import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.github.javafaker.Faker as Faker

Faker faker = new Faker()

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://auction.lelangmobil.dev/register')

WebUI.delay(2)

autoit_prj = (RunConfiguration.getProjectDir() + '/Data Files/Auth.exe')

WebUI.comment(autoit_prj)

Runtime.getRuntime().exec(autoit_prj)

Thread.sleep(5000)

WebUI.comment('Auth telah selesai dijalankan')

WebUI.delay(3)

'Input nama depan'
nama_depan = faker.name.firstName()

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Depan'), 10)

WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Depan'), nama_depan)

'Input nama belakang'
nama_belakang = faker.name.lastName()

WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Belakang'), nama_belakang)

'Input tempat lahir'
WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Tempat Lahir'), 'Jakarta')

'Input tanggal lahir'
WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/input_Tanggal Lahir'))

WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/tanggal_lahir'))

WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/span_Select'))

'Input NIK'
NIK = faker.number().digits(16)

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
AlamatCompany = faker.address.fullAddress()

WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/textarea_Alamat Domisili'), AlamatCompany)

'Input No Handphone'
noTlp = faker.number().digits(10)

WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor Telepon'), noTlp)

'Input Pekerjaan'
WebUI.click(findTestObject('Page_Register - UC auction/input_Pilih Pekerjaan'))

WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Pegawai Swasta'))

'Input Nama Company'
nama_perusahaan = faker.company.name()

WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Perusahaan'), nama_perusahaan)

'Input Alamat Company'
WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/textarea_Alamat Perusahaan'), AlamatCompany)

'Input No Telepon Perusahaan'
noPerusahaan = faker.number().digits(10)

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
email = faker.internet().safeEmailAddress()

WebUI.setText(findTestObject('Page_Register - UC auction/input_Email_email'), email)

'Input Password'
WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Kata Sandi_new_password'), 'Qwerty123!')

'Input RePassword'
WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Konfirmasi Kata Sandi_confirm_password'), 
    'Qwerty123!')

WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/button_Selanjutnya'))

'Input No Rek'
noRek = faker.number().digits(12)

WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nomor Rekening'), noRek)

'Input Bank'
WebUI.click(findTestObject('Page_Register - UC auction/input_Pilih Bank'))

WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_BANK BCA'))

'Input Nama Pemilik Bank'
WebUI.setText(findTestObject('Object Repository/Page_Register - UC auction/input_Nama Pemilik Rekening'), nama_depan)

'Input Sumber Dana'
WebUI.click(findTestObject('Page_Register - UC auction/input_Sumber Dana'))

WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_GajiUpah'))

'Input Metode Pembayaran'
WebUI.click(findTestObject('Page_Register - UC auction/input_Metode Pembayaran'))

WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/li_Bank Transfer'))

'Klik button Daftar'
WebUI.click(findTestObject('Object Repository/Page_Register - UC auction/button_Daftar'))

WebUI.delay(1)

WebUI.verifyTextPresent('Data baru berhasil ditambahkan', false)

WebUI.takeScreenshot()

WebUI.closeBrowser()

