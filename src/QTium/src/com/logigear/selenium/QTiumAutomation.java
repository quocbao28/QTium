package com.logigear.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.logigear.qtium.QTiumNavigator;
import com.logigear.qtium.driver.QTiumDriverManager;
import com.logigear.qtium.driver.QTiumWebDriver;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class QTiumAutomation {

	private static QTiumWebDriver getQTiumWebDriver() {
		return QTiumDriverManager.getQTiumDriver();
	} // end method

	public static RemoteWebDriver getDriver() {
		return QTiumAutomation.getQTiumWebDriver().getWebDriver();
	}

	public static void moveMouseToElement(By element) {
		waitForControl(element, QTiumSetting.getObjecWait());
		WebElement webElement = QTiumAutomation.getDriver().findElement(element);
		try {
			Actions action = new Actions(QTiumAutomation.getDriver());
			action.moveToElement(webElement).build().perform();
		} catch(Exception e){
			System.out.println(">>>>> moveMouseToElement Exception: " + e);
			moveMouseToElementJS(webElement);
		}
	}

	public static void moveMouseToElement(String xpath, String value) {
		By element = By.xpath(String.format(xpath, value));
		waitForControl(element, QTiumSetting.getObjecWait());
		WebElement webElement = QTiumAutomation.getDriver().findElement(element);
		try {
			Actions action = new Actions(QTiumAutomation.getDriver());
			action.moveToElement(webElement).build().perform();
		} catch(Exception e){
			System.out.println(">>>>> moveMouseToElement Exception: " + e);
			moveMouseToElementJS(webElement);
		}
	}

	public static void moveMouseToElementJS(WebElement webElement) {
		System.out.println(">>>>> moveMouseToElementJS: " + webElement);
		String javaScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";
		((JavascriptExecutor) QTiumAutomation.getDriver()).executeScript(javaScript, webElement);
	}

	public static void open() {
		/*
		 * try {
		 * //QTiumLocalDriverFactory.createInstance(QTiumConfigManager.getDeviceConfig()
		 * ); QTiumAutomation.getQTiumWebDriver().createWebDriver(); String strLog =
		 * String.format("[info] Automation:Open - on thread[%d] driver info[%s]",
		 * Thread.currentThread().getId(), getDriver().toString());
		 * System.out.println(strLog); } catch (Exception e) { //TODO: handle exception
		 * e.printStackTrace(); }
		 */
		try {
			QTiumNavigator.open();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Create WebDriver got error: " + e.getMessage());
			e.printStackTrace();
		}
	} // end method

	public static void openURL(String URL) {
		/*
		 * QTiumAutomation.getDriver().get(URL); String strLog =
		 * String.format("[info] Automation:OpenURL - on thread[%d] driver info[%s]",
		 * Thread.currentThread().getId(), getDriver().toString());
		 * System.out.println(strLog);
		 */
		try {
			QTiumNavigator.open(URL);
		} catch (Exception e) {
			System.err.println("Create WebDriver got error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void waitForPageToBeReady() {
		JavascriptExecutor js = ((JavascriptExecutor) QTiumAutomation.getDriver());
		for (int i = 0; i < 300; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(">>>>> waitForPageToBeReady Exception: " + e);
			}
			// To check page ready state
			// js.executeScript("return document.readyState").toString().equals("complete")
			// "return (document.readyState == 'complete' && jQuery.active == 0)"
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				System.out.println(">>>>> Page is ready!");
				break;
			}
		}
	}

	/*
	 * LongNguyen fix for non-exists web element
	 * http://docs.seleniumhq.org/docs/04_webdriver_advanced.jsp#implicit-waits
	 * 
	 * Implicit Waits An implicit wait is to tell WebDriver to poll the DOM for a
	 * certain amount of time when trying to find an element or elements if they are
	 * not immediately available. The default setting is 0. Once set, the implicit
	 * wait is set for the life of the WebDriver object instance.
	 * 
	 * java code: WebDriver driver = new FirefoxDriver();
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 * driver.get("http://somedomain/url_that_delays_loading"); WebElement
	 * myDynamicElement = driver.findElement(By.id("myDynamicElement"));
	 */

	public static boolean waitForControl(By element, long timeout) {
		waitForPageToBeReady();
		boolean isExist = false;
		try {
			QTiumAutomation.getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
			QTiumAutomation.getDriver().findElement(element);
			isExist = true;
		} catch (Exception e) {
			log.debug("waitForControl:" + e.getMessage());
			isExist = false;
		}
		return isExist;
	}

	public static boolean waitForControl(By element) {

		int timeout = QTiumSetting.getObjecWait();
		return waitForControl(element, timeout);

	}

	public static void waitForControlClose(By element) {
		int timeout = QTiumSetting.getObjecWait();
		try {
			WebDriverWait wait = new WebDriverWait(QTiumAutomation.getDriver(), timeout);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		} catch (Exception e) {
			log.debug("waitForControlClose:" + e.getMessage());
		}
	}

	public static void waitForControlClose(By element, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(QTiumAutomation.getDriver(), timeout);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		} catch (Exception e) {
			log.debug("waitForControlClose:" + e.getMessage());
		}
	}

	public static boolean isPageDisplayed(String pageTitle) {

		boolean isExist = false;
		long timeout = QTiumSetting.getObjecWait() * 1000;
		try {
			QTiumAutomation.getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
			String title = QTiumAutomation.getDriver().getTitle();
			long getTickCount = System.currentTimeMillis();
			while (!title.equals(pageTitle)) {
				Thread.sleep(50);
				title = QTiumAutomation.getDriver().getTitle();
				if ((System.currentTimeMillis() - getTickCount) > timeout) {
					break;
				}
			}

			if (title.equals(pageTitle))
				isExist = true;
		} catch (Exception e) {
			isExist = false;
			System.err.println("isPageDisplayed: title=" + pageTitle + " - message: " + e.getMessage());
		}

		System.out.println("isPageDisplayed - pageTitle: " + pageTitle + " >> " + isExist + " .."
				+ Thread.currentThread().getId());
		return isExist;

		// String title = driver.getTitle();
		// if (title.equals(pageTitle))
		// return true;
		// return false;
	}

	/*
	 * public static void type(CharSequence... keys){ webElement.sendKeys(keys);
	 * 
	 * }
	 */

	public static void enter(By element, String value) {
		waitForControl(element);
		WebElement webElement = QTiumAutomation.getDriver().findElement(element);

		if (webElement == null) {
			System.out.println("....enter - element: " + element.toString() + " - value: " + value);
		}

		System.out.println(">>> enter: webElement: " + (webElement != null) + element);
		webElement.clear();
		webElement.sendKeys(value);
	}

	public static boolean isControlClickable(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(QTiumAutomation.getDriver(), QTiumSetting.getObjecWait());
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			System.out.println("Element is not clickable: " + element);
			return false;
		}
		return true;
	}

	public static boolean isElementExists(By element) {
		return waitForControl(element);
	}

	public static boolean isElementDisplayed(By element) {
		boolean isDisplayed = false;
		boolean isExists = waitForControl(element);
		if (isExists) {
			try {
				isDisplayed = QTiumAutomation.getDriver().findElement(element).isDisplayed();
			} catch (Exception e) {
				log.debug("isElementDisplayed:" + e.getMessage());
			}
		}
		return isDisplayed;
	}

	public static void clickByJS(By element) {
		System.out.println(">>>>> clickByJS" + element);
		waitForControl(element);
		((JavascriptExecutor) QTiumAutomation.getDriver()).executeScript("arguments[0].click();",
				QTiumAutomation.getDriver().findElement(element));
	}

	public static void click(By element) {
		waitForControl(element);
		WebElement webElement = QTiumAutomation.getDriver().findElement(element);
		System.out.println(">>> click: webElement: " + (webElement != null) + element);
		try {
			webElement.click();
		} catch (ElementNotVisibleException ex) {
			System.err.println("click - error: " + ex.getMessage());
			clickByJS(element);
		}
	}

	public static void click(String xpath, String value) {
		By element = By.xpath(String.format(xpath, value));
		waitForControl(element);
		WebElement webElement = QTiumAutomation.getDriver().findElement(element);
		System.out.println(">>> click: webElement: " + (webElement != null) + element);
		try {
			webElement.click();
		} catch (ElementNotVisibleException ex) {
			System.err.println("click - error: " + ex.getMessage());
			clickByJS(element);
		}
	}

	public static void scrollPageToElement(By element) {
		waitForControl(element);
		WebElement webElement = QTiumAutomation.getDriver().findElement(element);
		System.out.println(">>> scrollPageToElement: webElement: " + element);
		((JavascriptExecutor) QTiumAutomation.getDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
	}

	public static void scrollPageToElement(String xpath, String value) {
		By element = By.xpath(String.format(xpath, value));
		waitForControl(element);
		WebElement webElement = QTiumAutomation.getDriver().findElement(element);
		System.out.println(">>> scrollPageToElement: webElement: " + element);
		((JavascriptExecutor) QTiumAutomation.getDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
	}

	public static void setCheckbox(By element, boolean isCheck) {
		if (!isChecked(element) && isCheck) {
			click(element);
		}
	}

	public static void selectByIndex(By element, int index) {
		waitForControl(element);
		Select select = new Select(QTiumAutomation.getDriver().findElement(element));
		System.out.println(">>> select: webElement: " + element);
		select.selectByIndex(index);
	}

	public static void selectByValue(By element, String value) {
		waitForControl(element);
		Select select = new Select(QTiumAutomation.getDriver().findElement(element));
		System.out.println(">>> select: webElement: " + element);
		select.selectByValue(value);
	}

	public static void selectByVisibleText(By element, String text) {
		waitForControl(element);
		Select select = new Select(QTiumAutomation.getDriver().findElement(element));
		System.out.println(">>> select: webElement: " + element);
		select.selectByVisibleText(text);
	}

	public static WebElement findElement(By element) {
		waitForControl(element);
		return QTiumAutomation.getDriver().findElement(element);
	}

	public static List<WebElement> findElements(By element) {
		waitForControl(element);
		return QTiumAutomation.getDriver().findElements(element);
	}

	public static String getTableCellValue(By element, int rowIndex, int colIndex) {
		String sResult = "";
		rowIndex = rowIndex - 1;
		colIndex = colIndex - 1;
		waitForControl(element);
		WebElement tableElement = findElement(element);
		List<WebElement> rows = tableElement.findElements(By.xpath("tbody/tr"));
		if (rowIndex > rows.size())
			return sResult;
		for (int i = 0; i < rows.size(); i++) {
			if (i == rowIndex) {
				WebElement row = rows.get(i);
				List<WebElement> cols = row.findElements(By.xpath("td"));
				if (colIndex > cols.size())
					return sResult;
				for (int j = 0; j < cols.size(); j++) {
					if (j == colIndex) {
						WebElement col = cols.get(j);
						sResult = col.getText();
						break;
					}
				}
				break;
			}
		}

		return sResult;
	}

	public static boolean isChecked(By element) {
		waitForControl(element);
		WebElement webElement = QTiumAutomation.getDriver().findElement(element);
		return webElement.isSelected();
	}

	public static String getSelectedComboboxItemText(By element) {
		String text = "";
		WebElement webElement = findElement(element);
		Select selectedValue = new Select(webElement);
		text = selectedValue.getFirstSelectedOption().getText();

		return text;

	}

	public static String getText(By element) {
		return findElement(element).getText();
	}

	public static void set(By element, boolean isCheck) {
		boolean check = isChecked(element);
		WebElement webElement = findElement(element);
		if ((isCheck && !check) || (!isCheck && check)) {
			webElement.click();
		}
	}

	public static void set(By element, boolean isCheck, boolean realState) {
		WebElement webElement = QTiumAutomation.getDriver().findElement(element);
		if ((isCheck && !realState) || (!isCheck && realState)) {
			webElement.click();
		}
	}

	public static String getAttribute(By element, String att) {
		waitForControl(element);
		WebElement webElement = QTiumAutomation.getDriver().findElement(element);
		return webElement.getAttribute(att);
	}

	public static void logReport(String report, Class<?> cls) {
		Log log = LogFactory.getLog(cls);
		log.info(report);
	}

	private final static Log log = LogFactory.getLog(QTiumAutomation.class);

	public static void focusElement(By element) {
		if (waitForControl(element)) {
			QTiumAutomation.getDriver().findElement(element).sendKeys(Keys.NULL);
		}
	}

	public static void selectDate(By element, String day, String month, String year) {
		// String calMonth = null;
		String calYear = null;
		int expYear = 0;
		// List<String> list = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun",
		// "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		focusElement(element);
		if (isElementExists(element)) {
			click(By.className("datepicker-switch"));
			calYear = QTiumAutomation.getDriver().findElement(By.xpath("//div[2]/div[2]/table/thead/tr/th[2]"))
					.getText();
			expYear = Integer.parseInt(calYear);
			try {
				int numSelectYear = Integer.parseInt(year) - Integer.parseInt(calYear);
				WebElement slectyear = QTiumAutomation.getDriver()
						.findElement(By.xpath("html/body/div[2]/div[1]/table/thead/tr[1]"));
				if (numSelectYear > 0) {
					for (int i = 0; i < numSelectYear; i++) {
						slectyear.findElement(By.className("next")).click();
					}
				} else if (numSelectYear < 0) {
					for (int i = 0; i > numSelectYear; i--) {
						slectyear.findElement(By.className("prev")).click();
					}
				}
				// if(list.indexOf(month)+1 == expMonth
				// String ss="//tbody/tr/td/span[@class='month' or @class='month active'and
				// text()='"+list.get((Integer.parseInt(month))-2)+"']";
				QTiumAutomation.getDriver()
						.findElement(By
								.xpath("//div[2]/div[2]/table/tbody/tr/td/span[" + (Integer.parseInt(month) + 2) + "]"))
						.click();
				// WebElement dateWidget;
				// List<WebElement> rows;
				// List<WebElement> columns;
				// dateWidget =
				// driver.findElement(By.xpath("html/body/div/div[1]/table/tbody"));
				// rows=dateWidget.findElements(By.tagName("tr"));
				// columns=dateWidget.findElements(By.tagName("td"));
				// for (WebElement cell: columns){
				// //Select 13th Date
				// if (cell.getText().equals("13") && cell.getClass().equals("day")){
				// cell.findElement(By.linkText("13")).click();
				// break;
				// }
				// }
				QTiumAutomation.getDriver()
						.findElement(By.xpath("//table/tbody/tr/td[text()='" + day + "' and @class='day']")).click();
			} catch (Exception e) {
				System.out.println("msg : " + e.toString());
			}
		}
	}

	public static void close() {
		QTiumDriverManager.closeWebDriver();
	}
	
	public static void sendEmail() {

		final String username = "frt2018.test001@gmail.com";
		final String password = "FRTtest123a@";

		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.EnableSSL.enable","true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("frt2018.test001@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("frt2018.test001@gmail.com"));
			message.setSubject("Report for FptShop Automation Testing");
//			message.setText("Report for FptShop Automation Testing hihi");

			MimeBodyPart messageBodyPart = new MimeBodyPart();

			Multipart multipart = new MimeMultipart();

			messageBodyPart = new MimeBodyPart();
			String file = "../Selenium-TestNG/test-output/emailable-report.html";
			String fileName = "emailable-report.html";
			DataSource source = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			System.out.println("Sending email...");

			Transport.send(message);

			System.out.println("Sent email!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
