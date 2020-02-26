package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePackage.InitDriver;

public class ReviewPage extends CommonFunctions {

	@FindBy(id="bubble_rating")
	 WebElement ratings;
	
	@FindBy(id="ReviewTitle")
	WebElement YourReviewTitle;
	
	@FindBy(xpath="//div[text()='Hotel Ratings']//following::div[@class= 'detailsRatings'][1]")
	WebElement ServiceRatings;
	
	@FindBy(xpath="//div[text()='Hotel Ratings']//following::div[@class= 'detailsRatings'][2]")
	WebElement RoomRatings;
	
	@FindBy(xpath="//div[text()='Hotel Ratings']//following::div[@class= 'detailsRatings'][3]")
	WebElement CleanlinessRatings;
	
	@FindBy(id="noFraud")
	WebElement submitReviewCheckbox;
	
	@FindBy(id="SUBMIT")
	WebElement submitButton;
	
public void giveOverallRatings(int stars) {
	setRatings(stars, ratings);
	System.out.println("----Overall ratings given----");
}

public void writeReviewTitle() {
	click(YourReviewTitle);
	YourReviewTitle.sendKeys("Review Title Test");
	System.out.println("----Review title set----");
}

public void setServiceRatings() {
	setRatings(4, ServiceRatings);
	
	String ratingTitleXpath = getXpath(ServiceRatings)+"/parent::div/preceding-sibling::div[@class='detailsQuestion question']";
	String ratingTitle = InitDriver.driver.findElement(By.xpath(ratingTitleXpath)).getText();
	System.out.println("----"+ratingTitle+" ratings given----");
	}

public void setRoomRatings() {
	setRatings(4, RoomRatings);
	
	String ratingTitleXpath = getXpath(RoomRatings)+"/parent::div/preceding-sibling::div[contains(@class,'detailsQuestion')]";
	String ratingTitle = InitDriver.driver.findElement(By.xpath(ratingTitleXpath)).getText();
	System.out.println("----"+ratingTitle+" ratings given----");

	}

public void setCleanlinessRatings() {
	setRatings(4, CleanlinessRatings);
	
	String ratingTitleXpath = getXpath(CleanlinessRatings)+"/parent::div/preceding-sibling::div[contains(@class,'detailsQuestion')]";
	String ratingTitle = InitDriver.driver.findElement(By.xpath(ratingTitleXpath)).getText();
	System.out.println("----"+ratingTitle+" ratings given----");

	}

public void submitReview() {
	click(submitReviewCheckbox);
	System.out.println("-------Submit checkbox checked-------");
	
}


}
