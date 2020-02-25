package baseClass;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import baseClass.InitDriver;
import constants.Constants;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions  {

	public CommonFunctions() {
		PageFactory.initElements(InitDriver.driver, this);
		
	}
	
	public static void click(WebElement el) {
		waitExplicitly(el, Constants.EXPLICITWAIT);
		el.click();
	}
	
	public static void close() {
		InitDriver.driver.quit();
	}
	
	public static void newWindow(String windowName) {
		
		String mainWindow =  InitDriver.driver.getWindowHandle();
		Set<String> allWindows = InitDriver.driver.getWindowHandles();
		if(allWindows.size()>1 ) {
		for(String win:allWindows) {
			if(!(win.equals(mainWindow))) {
				InitDriver.driver.switchTo().window(win);
				System.out.println("Switched to new window "+windowName);
			}
		}
		}else {
			System.out.println("No new window is opened..");
		}
	}
	
	public static void waitImplicitly(int time) {
		
		InitDriver.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void sendInput(WebElement el, String s) {
		el.sendKeys(s);
	}
	
	public static void waitExplicitly(WebElement el, int i) {
		WebDriverWait wait = new WebDriverWait(InitDriver.driver, i);
		wait.until(ExpectedConditions.visibilityOf(el));
	}
	
	public static void setRatings(int stars, WebElement el) {
		waitExplicitly(el, Constants.EXPLICITWAIT);
		int newStars = el.getSize().getWidth()/5*stars;
		Actions act = new Actions(InitDriver.driver);
		act.moveToElement(el, newStars, el.getSize().getHeight()).click().build().perform();;
	}
	
	public static String getXpath(WebElement el) {
		String webElementString =el.toString();
		//System.out.println(webElementString);
		String[] xpathString =webElementString.split(": ");
		String xpathString2 = xpathString[2];
		//System.out.println(xpathString2);
		int len = xpathString2.length();
		xpathString2 =xpathString2.substring(0, len-1);
		//System.out.println(xpathString2);
		return xpathString2;
		
		
	}
	
	}
