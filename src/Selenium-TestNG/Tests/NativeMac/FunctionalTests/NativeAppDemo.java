package NativeMac.FunctionalTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Calculator.CalculatorEntity;
import Calculator.Function;
import Common.Common;

import com.logigear.selenium.QTiumAutomation;

public class NativeAppDemo {
	@BeforeClass
	public void set_up() throws Exception {
		Common.config();
		//if(_driver==null)
		//System.out.println("Start Calculator");
		QTiumAutomation.open();
		QTiumAutomation.openURL("Calculator");
		//QTiumAutomation.close();
	}

	@AfterMethod()
	public void after_test_case_execution() throws Exception {
		//QTiumAutomation.closeBrowser();
		
	}

	@Test(description = "Plus Function")
	public void TC001_Plus_Function() throws Exception {
		System.out.println("Start Test");
		Function.getFunction().plusTwoNumber("3.21", "2");
		Function.getFunction().CheckResultDisplayed(CalculatorEntity.Label_MainResult, "5.21");
	}
	@Test(description = "Minus Function")
	public void TC002_Minus_Function() throws Exception {
		System.out.println("Minus Function");
		Function.getFunction().minusTwoNumber("5.32", "2");
		Function.getFunction().CheckResultDisplayed(CalculatorEntity.Label_MainResult, "3.32");
	}
	@Test(description = "Multi Function")
	public void TC003_Multi_Function() throws Exception {
		System.out.println("Start Test");
		Function.getFunction().multiTwoNumber("3", "2");
		Function.getFunction().CheckResultDisplayed(CalculatorEntity.Label_MainResult, "6");
	}
	@Test(description = "Division Function")
	public void TC004_Division_Function() throws Exception {
		System.out.println("Start Test");
		Function.getFunction().divisionTwoNumber("10", "2");
		Function.getFunction().CheckResultDisplayed(CalculatorEntity.Label_MainResult, "5");
	}

	@AfterClass
	public void tear_down() {
		
		//QTiumAutomation.closeBrowser();
		QTiumAutomation.close();
		System.out.println("Finised Test");
	}

}
