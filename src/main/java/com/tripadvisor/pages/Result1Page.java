package com.tripadvisor.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.tripadvisor.basePackage.*;
import com.tripadvisor.constants.*;

public class Result1Page extends CommonFunctions {

	@FindBy(xpath ="//a[contains(@href,'/UserReview')]//parent::div")
	WebElement WriteReview;
	
	@FindBy(xpath="//*[@class='sbx_banner']//div[@class='sbx_close']")
	WebElement blockerPopup;
	
	
	public void clickOnReview() throws InterruptedException {
		List<WebElement> list = InitDriver.driver.findElements(By.className("sbx_banner"));
		if(list.size()>0) {
				click(blockerPopup);
			}
		
		waitExplicitly(WriteReview, Constants.EXPLICITWAIT);
		click(WriteReview);
		System.out.println("----Review page is about to open----");
	
	}
	
	public ReviewPage switchtoReviewPage() throws InterruptedException {
		newWindow("Review Page");
		return new ReviewPage();
			}

}
