package Calculator;
import org.openqa.selenium.By;

import com.logigear.qtium.QTiumAutomationManager;
import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;
import com.logigear.selenium.QTiumElementDefinition;
public class Function {
	private static Function instance = null;
	public static synchronized Function getFunction()
	{
		if(instance == null)
			instance = new Function();
		return instance;
	}
	public void plusTwoNumber(String numberA, String numberB){
		char[] charArrayA = numberA.toCharArray();
		for (char c : charArrayA) {
			QTiumAutomation.click(QTiumElementDefinition.Name(Character.toString(c)));
		}
		QTiumAutomation.click(CalculatorEntity.Button_Plus);
		char[] charArrayB = numberB.toCharArray();
		for (char c : charArrayB) {
			QTiumAutomation.click(QTiumElementDefinition.Name(Character.toString(c)));
			
		}
		QTiumAutomation.click(CalculatorEntity.Button_Equal);
	}
	public void minusTwoNumber(String numberA, String numberB){
		char[] charArrayA = numberA.toCharArray();
		for (char c : charArrayA) {
			QTiumAutomation.click(QTiumElementDefinition.Name(Character.toString(c)));
		}
		QTiumAutomation.click(CalculatorEntity.Button_Minus);
		char[] charArrayB = numberB.toCharArray();
		for (char c : charArrayB) {
			QTiumAutomation.click(QTiumElementDefinition.Name(Character.toString(c)));
			
		}
		QTiumAutomation.click(CalculatorEntity.Button_Equal);
	}
	public void multiTwoNumber(String numberA, String numberB){
		char[] charArrayA = numberA.toCharArray();
		for (char c : charArrayA) {
			QTiumAutomation.click(QTiumElementDefinition.Name(Character.toString(c)));
		}
		QTiumAutomation.click(CalculatorEntity.Button_Multi);
		char[] charArrayB = numberB.toCharArray();
		for (char c : charArrayB) {
			QTiumAutomation.click(QTiumElementDefinition.Name(Character.toString(c)));
			
		}
		QTiumAutomation.click(CalculatorEntity.Button_Equal);
	}
	public void divisionTwoNumber(String numberA, String numberB){
		char[] charArrayA = numberA.toCharArray();
		for (char c : charArrayA) {
			QTiumAutomation.click(QTiumElementDefinition.Name(Character.toString(c)));
		}
		QTiumAutomation.click(CalculatorEntity.Button_Division);
		char[] charArrayB = numberB.toCharArray();
		for (char c : charArrayB) {
			QTiumAutomation.click(QTiumElementDefinition.Name(Character.toString(c)));
			
		}
		QTiumAutomation.click(CalculatorEntity.Button_Equal);
	}
	public void CheckResultDisplayed(By element, String result){
		String text = QTiumAutomation.getText(element);
		QTiumAssert.verifyEquals(text, result);
		
	}
}
