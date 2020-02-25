package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.CommonFunctions;
import baseClass.InitDriver;
import constants.Constants;

public class ReviewPage extends CommonFunctions {

	@FindBy(id="bubble_rating")
	 WebElement ratings;
	
	@FindBy(id="ReviewTitle")
	WebElement YourReviewTitle;
	
	@FindBy(xpath="//div[text()='Hotel Ratings']//following::div[@class= 'detailsRatings'][1]")
	//div[text()='Hotel Ratings']/parent::div/div[@class='ratingBubbleTable']/div[1]//div[@class='detailsRatings']
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
	
}


}
