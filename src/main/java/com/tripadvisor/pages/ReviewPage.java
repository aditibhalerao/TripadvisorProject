package com.tripadvisor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.tripadvisor.basePackage.InitDriver;

public class ReviewPage extends CommonFunctions {

	@FindBy(id="bubble_rating")
	 WebElement ratings;
	
	@FindBy(id="ReviewTitle")
	WebElement YourReviewTitle;
	
	@FindBy(xpath="//div[text()='Hotel Ratings']//following::div[@class= 'detailsRatings'][1]//span")
	WebElement ServiceRatings;
	
	
	@FindBy(xpath="//div[text()='Hotel Ratings']//following::div[@class= 'detailsRatings'][2]//span")
	WebElement RoomRatings;
	
	@FindBy(xpath="//div[text()='Hotel Ratings']//following::div[@class= 'detailsRatings'][3]//span")
	WebElement CleanlinessRatings;
	
	@FindBy(id="noFraud")
	WebElement submitReviewCheckbox;
	
	@FindBy(id="SUBMIT")
	WebElement submitButton;
	
public void giveOverallRatings(int stars) {
	setRatings(stars, ratings);
	System.out.println("----Overall ratings given----");
}

public ReviewPage writeReviewTitle() {
	click(YourReviewTitle);
	
	YourReviewTitle.sendKeys("Review Title Test");
	System.out.println("----Review title set----");
	return this;
}

public ReviewPage setServiceRatings(int stars) {
	setRatings(stars, ServiceRatings);
	
	String ratingTitle = ServiceRatings.getAttribute("data-name");
	System.out.println("----"+ratingTitle+" ratings given----");
	return this;
	}

public ReviewPage setRoomRatings(int stars) {
	setRatings(stars, RoomRatings);
	String ratingTitle = RoomRatings.getAttribute("data-name");

	//String ratingTitleXpath = getXpath(RoomRatings)+"/parent::div/preceding-sibling::div[contains(@class,'detailsQuestion')]";
	//String ratingTitle = InitDriver.driver.findElement(By.xpath(ratingTitleXpath)).getText();
	System.out.println("----"+ratingTitle+" ratings given----");
	return this;

	}

public ReviewPage setCleanlinessRatings(int stars) {
	setRatings(stars, CleanlinessRatings);
	
	String ratingTitle = CleanlinessRatings.getAttribute("data-name");
	System.out.println("----"+ratingTitle+" ratings given----");
	return this;
	}

public void submitReview() {
	click(submitReviewCheckbox);
	System.out.println("-------Submit checkbox checked-------");
	
}


}
