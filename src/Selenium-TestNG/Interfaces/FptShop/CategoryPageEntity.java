package FptShop;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class CategoryPageEntity {
	public static By NEXT_BANNER_BUTTON = QTiumElementDefinition.Xpath("//div[contains(@class,'fs-ctbn')]//div[@class='owl-nav']/div[@class='owl-next']");
	public static By ACTIVATED_BANNER = QTiumElementDefinition.Xpath("//div[contains(@class,'fs-ctbn')]/div/div[@class='owl-stage-outer']/div/div[@class='owl-item active']//img");
}
