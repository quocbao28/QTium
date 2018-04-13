package FptShop.FunctionalTests;

import java.io.File;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.logigear.selenium.QTiumAutomation;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Common.Common;
import Common.Constants;
import FptShop.PageFactory;

public class QTiumDemo {

	String validItem, validClientName, validClientPhone, validClientEmail, validInstallmentMethod, validCategory,
			validBrand;

	// ---------------------Installment Buying Info
	String validClientId, validClientBirthDay, validClientBirthMonth, validClientBirthYear, validClientAddress,
			validClientGuarantorPhone;
	int validClientCity, validClientDistrict, validBanner;

	@BeforeClass
	public void setUp() throws Exception {
		Common.config();
		validCategory = Constants.ITEM_CATEGORY;
		validBrand = Constants.ITEM_BRAND;
		validItem = Constants.ITEM_NAME;
		validClientName = Constants.CLIENT_NAME;
		validClientPhone = Constants.CLIENT_PHONE;
		validClientEmail = Constants.CLIENT_EMAIL;
		validInstallmentMethod = Constants.PAYMENT_METHOD;
		validClientId = Constants.CLIENT_ID;
		validClientBirthDay = Constants.CLIENT_BIRTH_DAY;
		validClientBirthMonth = Constants.CLIENT_BIRTH_MONTH;
		validClientBirthYear = Constants.CLIENT_BIRTH_YEAR;
		validClientCity = Constants.CLIENT_CITY;
		validClientDistrict = Constants.CLIENT_DISTRICT;
		validClientAddress = Constants.CLIENT_ADDRESS;
		validClientGuarantorPhone = Constants.CLIENT_GUARANTOR_PHONE;
		validBanner = Constants.INDEX_OF_BANNER;
	}

	@AfterMethod
	public void tearDown()	{
		QTiumAutomation.sendEmail();
		QTiumAutomation.close();
	}

	@Test(description = "TC 001: Verify Order An Item By Searching Successfully",
			invocationCount = 1)
	public void TC001_Order_Item_By_Searching() throws Exception {

		// Open HomePage
		PageFactory.HomePage().Open();
		// Search for item at HomePage
		PageFactory.HomePage().searchItem(validItem);
		// Select item at SearchResultPage
		PageFactory.SearchResultPage().selectItem(validItem);
		// Select Buy Now at ItemDetailPage
		PageFactory.ItemDetailPage().buyNow();
		// Select Checkout at CartPage
		PageFactory.CartPage().checkOut();
		// Select Shipping at ShippingPage
		PageFactory.ShippingPage().selectShipping(validClientName, validClientPhone, validClientEmail);
		// VP: Check order result at OrderResultPage
		PageFactory.OrderResultPage().checkOrderResult();

	}

	 @Test(description = "TC 002: Verify Order An Item By Category Successfully",
			 invocationCount = 1)
	public void TC002_Order_Item_By_Category() throws Exception {

		// Open HomePage
		PageFactory.HomePage().Open();
		// Select a Brand at HomePage
		PageFactory.HomePage().selectBrand(validCategory, validBrand);
		// Select item at BrandPage
		PageFactory.BrandPage().selectItem(validItem);
		// Select Buy Now at ItemDetailPage
		PageFactory.ItemDetailPage().buyNow();
		// Select Checkout at CartPage
		PageFactory.CartPage().checkOut();
		// Select Shipping at ShippingPage
		PageFactory.ShippingPage().selectShipping(validClientName, validClientPhone, validClientEmail);
		// VP: Check order result at OrderResultPage
		PageFactory.OrderResultPage().checkOrderResult();

	}

	@Test(description = "TC 003: Verify Pre-Order An Item By Category Banner Successfully",
			invocationCount = 1)
	public void TC003_Pre_Order_Item_By_Category_Banner() throws Exception {

		// Open HomePage
		PageFactory.HomePage().Open();
		// Step 01: Select a category at HomePage
		PageFactory.HomePage().selectCategory(validCategory);
		// Step 02: Select a banner
		PageFactory.CategoryPage().selectBanner(validBanner);
		// Step 03: Select Buy Now at ItemDetailPage
		PageFactory.PreOrderPage().orderNow(validClientName, validClientPhone, validClientEmail);
		// VP: Pre-order an item successfully at PreOrderPage
		PageFactory.PreOrderPage().checkPreOrderResult();
	}

	@Test(description = "TC 004: Successfully Installment Buying An Item By Searching",
			invocationCount = 1)
	public void TC004_Installment_Buying() throws Exception {
		// Open HomePage
		PageFactory.HomePage().Open();
		// Search for an item at HomePage
		PageFactory.HomePage().searchItem(validItem);
		// Select the item at SearchResultPage
		PageFactory.SearchResultPage().selectItem(validItem);
		// Select InstallBuying at ItemDetailPage
		PageFactory.ItemDetailPage().installmentBuying();
		// Select an installment method at InstallmentBuyingPage
		PageFactory.InstallmentBuyingPage().selectInstallmentBuyingMethod(validInstallmentMethod);
		// Fill information at InstallmentBuyingPage
		PageFactory.InstallmentBuyingPage().fillInformationInstallmentBuying(validClientName, validClientPhone,
				validClientId, validClientBirthDay, validClientBirthMonth, validClientBirthYear, validClientCity,
				validClientDistrict, validClientAddress, validClientGuarantorPhone);
		// VP: Successfully Installment Buying
		PageFactory.InstallmentBuyingPage().checkInstallmentBuyingResult();
	}

}
