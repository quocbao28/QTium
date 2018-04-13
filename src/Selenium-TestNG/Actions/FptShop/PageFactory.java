package FptShop;

import FptShop.AbstractPage;

public class PageFactory {
	
	public static HomePage HomePage()
	{
		return HomePage.getHomePage();
	}

	public static AbstractPage AbstractPage()
	{		
		return AbstractPage.getAbstractPage();
	}
	
	public static SearchResultPage SearchResultPage()
	{
		return SearchResultPage.getSearchResultPage();
	}
	
	public static ItemDetailPage ItemDetailPage()
	{
		return ItemDetailPage.getItemDetailPage();
	}
	
	public static InstallmentBuyingPage InstallmentBuyingPage()
	{
		return InstallmentBuyingPage.getInstallmentBuyingPage();
	}
	
	public static CartPage CartPage()
	{
		return CartPage.getCartPage();
	}
	
	public static ShippingPage ShippingPage()
	{
		return ShippingPage.getShippingPage();
	}
	
	public static OrderResultPage OrderResultPage()
	{
		return OrderResultPage.getOrderResultPage();
	}
	
	public static BrandPage BrandPage()
	{
		return BrandPage.getBrandPage();
	}
	
	public static CategoryPage CategoryPage()
	{
		return CategoryPage.getCategoryPage();
	}
	
	public static PreOrderPage PreOrderPage()
	{
		return PreOrderPage.getPreOrderPage();
	}
}