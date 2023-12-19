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
/*
boolean hospital_readmission = true

String facility = 'Seoul CURA Healthcare Center'

String visit_date = '30/07/2024'

String comment = 'comment like and subscribe'

String healthcare_program = 'Medicaid'
*/
WebUI.callTestCase(findTestCase('Login/Block Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Appointment/Page_CURA Healthcare Service/Drop_facility'), facility, false)

if (hospital_readmission == true) {
    WebUI.check(findTestObject('Appointment/Page_CURA Healthcare Service/inpt_Apply'))
}

def select_radio = healthcare_program

switch (select_radio) {
    case select_radio = 'Medicare':
        println(select_radio)

        WebUI.click(findTestObject('Appointment/Page_CURA Healthcare Service/inpt_Medicare_programs'))

        break
    case select_radio = 'Medicaid':
        println(select_radio)

        WebUI.click(findTestObject('Appointment/Page_CURA Healthcare Service/inpt_Medicaid_programs'))

        break
    case select_radio = 'None':
        println(select_radio)

        WebUI.click(findTestObject('Appointment/Page_CURA Healthcare Service/inpt_None_program'))

        break
    default:
        println(select_radio)

        WebUI.click(findTestObject('Appointment/Page_CURA Healthcare Service/inpt_None_program'))

        break
}

WebUI.setText(findTestObject('Appointment/Page_CURA Healthcare Service/inpt_Visit Date (Required)_visit_date'), visit_date)

WebUI.setText(findTestObject('Appointment/Page_CURA Healthcare Service/Text_Comment'), comment)

WebUI.click(findTestObject('Appointment/Page_CURA Healthcare Service/btn_BookAppointment'))

WebUI.comment('confirmation')

WebUI.waitForElementVisible(findTestObject('Appointment/Page_CURA Healthcare Service/Header_Appointment Confirmation'), 
    0)
WebUI.comment('verify')

WebUI.verifyElementText(findTestObject('Result/Page_CURA Healthcare Service/txt_Facility'), facility)
WebUI.comment('verify')
if (hospital_readmission == true) {   
	WebUI.verifyElementText(findTestObject('Result/Page_CURA Healthcare Service/text_Apply'), 'Yes')
	} else {   
		WebUI.verifyElementText(findTestObject('Result/Page_CURA Healthcare Service/text_Apply'), 'No')
		}
		
WebUI.comment('verify')
/*untuk def berbeda*/
def path_text_program = findTestObject('Result/Page_CURA Healthcare Service/text_HealthcareProgram')

switch (select_radio) {
	case select_radio = 'Medicare':
	       println(select_radio)       
		   WebUI.verifyElementText(path_text_program, 'Medicare')
		   break
		   case select_radio = 'Medicaid':
		          println(select_radio)       
				  WebUI.verifyElementText(path_text_program, 'Medicaid')
				  break
				  case select_radio = 'None':
				         println(select_radio)       
						 WebUI.verifyElementText(findTestObject('Result/Page_CURA Healthcare Service/text_HealthcareProgram'), 'None')
						 break
						 default:       
						 println(select_radio)       
						 WebUI.verifyElementText(findTestObject('Result/Page_CURA Healthcare Service/text_HealthcareProgram'), 'None')
						 break
						 }
						 
/*konsep compare value, get text*/
String result_program= WebUI.getText(path_text_program)
switch (result_program) {
	case result_program = 'Medicare':
		   println(result_program)
		   WebUI.verifyMatch(result_program, healthcare_program,true)
		   break
		   case result_program = 'Medicaid':
				  println(result_program)
				  WebUI.verifyMatch(result_program, healthcare_program,true)
				  break
				  case result_program = 'None':
						 println(result_program)
						 WebUI.verifyMatch(result_program, healthcare_program,true)
						 break
						 default:
						 println(result_program)
						 WebUI.verifyMatch(result_program, healthcare_program,true)
						 break
						 }
						 
