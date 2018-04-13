package ScrumBoard;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class ItemDetailPageEntity {
	public static By BUYNOW_BUTTON = QTiumElementDefinition.Xpath("//a[@class='fs-dti-oder dts-addtocart']/p");
	public static By INSTALLMENT_BUYING_BUTTON = QTiumElementDefinition.Xpath("//a[@class='fs-dti-tgop']");
}
