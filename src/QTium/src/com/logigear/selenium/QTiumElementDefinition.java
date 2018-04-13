package com.logigear.selenium;
import org.openqa.selenium.By;

public class QTiumElementDefinition {

	public static By Id(String id)
	{
		return By.id(id);
	}
	public static By Name(String name)
	{
		return By.name(name);
	}
	public static By Xpath(String xpath)
	{
		return By.xpath(xpath);
	}
	public static By CssSelector (String selector)
	{
		return By.cssSelector(selector);
	}
	public static By LinkText (String linkText)
	{
		return By.linkText(linkText);
	}
}
