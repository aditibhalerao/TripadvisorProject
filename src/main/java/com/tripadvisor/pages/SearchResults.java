package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.CommonFunctions;
import baseClass.InitDriver;
import constants.Constants;

public class SearchResults extends CommonFunctions {
	
	String input = "club mahindra";
	
	@FindBy(xpath="//*[@type='search']")
	WebElement searchInput;
	
	@FindBy(xpath="//*[@class='_2oYoDbfY']")
	WebElement Result1;
	
	String result3 = "//*[@type='search']/preceding::form//div//a/div[2]";
		
	@FindBy(xpath="//ul[contains(@class,'local')]/li[@class='displayItem result'][1]")
	WebElement Result2;

	
	public void search() throws InterruptedException {
				
		List<WebElement> SearchBoxList= InitDriver.driver.findElements(By.xpath("//*[@action='/Search']/*[@type='search']"));
		
		if(SearchBoxList.size()>1) {
			click(SearchBoxList.get(1));
			sendInput(SearchBoxList.get(1), input);
			click(Result1);
		}else {

			click(SearchBoxList.get(0));
			sendInput(searchInput, input);
			Thread.sleep(2000);
			WebElement Result3 = (InitDriver.driver.findElement(By.xpath(result3)));		
			click(Result3);
			
		}
		System.out.println("-----Clicked on 1st result-----");
	}
	
	
	
	
	
}
