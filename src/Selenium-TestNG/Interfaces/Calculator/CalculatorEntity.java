package Calculator;
import org.openqa.selenium.By;
import com.logigear.selenium.QTiumElementDefinition;
public class CalculatorEntity {
	public static By Button_One = QTiumElementDefinition.Name("1");
	public static By Button_Two = QTiumElementDefinition.Name("2");
	public static By Button_Three = QTiumElementDefinition.Name("3");
	public static By Button_Four = QTiumElementDefinition.Name("4");
	public static By Button_Five = QTiumElementDefinition.Name("5");
	public static By Button_Six = QTiumElementDefinition.Name("6");
	public static By Button_Seven = QTiumElementDefinition.Name("7");
	public static By Button_Eight = QTiumElementDefinition.Name("8");
	public static By Button_Nine = QTiumElementDefinition.Name("9");
	public static By Button_Zero = QTiumElementDefinition.Name("0");
	public static By Button_C = QTiumElementDefinition.Name("C");
	public static By Button_MC = QTiumElementDefinition.Name("MC");
	public static By Button_M_Plus = QTiumElementDefinition.Name("M+");
	public static By Button_M_Minus = QTiumElementDefinition.Name("M-");
	public static By Button_MR = QTiumElementDefinition.Name("MR");
	public static By Button_Multi = QTiumElementDefinition.Name("×");
	public static By Button_Minus = QTiumElementDefinition.Name("−");
	public static By Button_Plus = QTiumElementDefinition.Name("+");
	public static By Button_Division = QTiumElementDefinition.Name("÷");
	public static By Button_Equal = QTiumElementDefinition.Name("=");
	public static By Button_Sign = QTiumElementDefinition.Name("±");
	public static By Button_Dot = QTiumElementDefinition.Name(".");
	public static By Label_MainResult = QTiumElementDefinition.Xpath("//AXStaticText[@AXDescription='main display']");
	
}
