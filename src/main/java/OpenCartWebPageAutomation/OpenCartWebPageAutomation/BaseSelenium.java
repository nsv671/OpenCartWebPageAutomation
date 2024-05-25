package OpenCartWebPageAutomation.OpenCartWebPageAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseSelenium {
	WebDriver driver;

	public BaseSelenium(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatorType, String locator) {
		By returnByElement = null;

		switch (locatorType) {
			case "xpath":
				returnByElement = By.xpath(locator);
				break;
	
			case "cssSelector":
				returnByElement = By.cssSelector(locator);
				break;
				
			case "className":
				returnByElement = By.className(locator);
				break;
				
			case "id":
				returnByElement = By.id(locator);
				break;
				
			case "linkText":
				returnByElement = By.linkText(locator);
				break;
				
			case "partialLinkText":
				returnByElement = By.partialLinkText(locator);
				break;
				
			case "name":
				returnByElement = By.name(locator);
				break;
				
			case "tagName":
				returnByElement = By.tagName(locator);
				break;
		}

		return returnByElement;
	}
	
	public By getBy(String locator) {
		return getBy("xpath", locator);
	}
	
	public boolean isElementPresent(String locatorType, String locator) {
	    try {
	        getWebElement(locatorType, locator);
	        return true;
	      } catch (NoSuchElementException e) {
	        return false;
	      }
	    }

	public boolean isElementPresent(String locator) {
	    return isElementPresent("xpath", locator);
	    }
	
	public WebElement getWebElement(String locatorType, String locator) {
		WebElement webElement;
		By byElement = getBy(locatorType, locator);
		
		webElement = driver.findElement(byElement);
		
		return webElement;
	}
	
	public WebElement getWebElement(String locator) {
		return getWebElement("xpath", locator);
	}
	
	public List<WebElement> getWebElements(String locatorType, String locator) {
		List<WebElement> webElement;
		By byElement = getBy(locatorType, locator);
		
		webElement = driver.findElements(byElement);
		
		return webElement;
	}
	
	public List<WebElement> getWebElements(String locator) {
		return getWebElements("xpath", locator);
	}
	
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	
	public void pageBack() {
		driver.navigate().back();
	}
	
	public void webPageForward() {
		driver.navigate().forward();;
	}
	
	public void scrollToView(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scrollToView(String locatorType,String locator) {
		WebElement element = getWebElement(locatorType, locator);
		scrollToView(element);
	}
	
	public void scrollToView(String locator) {
		WebElement element = getWebElement(locator);
		scrollToView(element);
	}
	
	public void sendKeys(String locatorType, String locator, String value) {
		WebElement element = getWebElement(locatorType, locator);
		element.sendKeys(value);
	}
	
	public void sendKeys(String locator, String value) {
		sendKeys("xpath", locator, value);
	}
	
	
	public String getText(String locator) {
		WebElement el = getWebElement(locator);
	
		return el.getText();
	}
}
