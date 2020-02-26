package com.tripadvisor.tests;

import com.tripadvisor.basePackage.InitDriver;
import com.tripadvisor.pages.*;


public class TestReviewPage extends CommonFunctions {
	
	static SearchResults searchResults;
	static Result1Page resultPage;
	static ReviewPage reviewPage;
	
	
	
	public static void main(String[] a) {
		try {
			InitDriver id = new InitDriver();
			searchResults = new SearchResults();
			searchResults.search();
			resultPage = new Result1Page();
			
			resultPage.clickOnReview();
			reviewPage =resultPage.switchtoReviewPage();
			//Thread.sleep(5000);
			reviewPage.giveOverallRatings(3);
			Thread.sleep(2000);
			reviewPage.writeReviewTitle().setServiceRatings(4).setRoomRatings(3).setCleanlinessRatings(3);
			reviewPage.submitReview();
			
			Thread.sleep(5000);
			close();
			
		}		
		catch(Exception e) {
			e.printStackTrace();
			//close();
		
		}	
		
		
	}

}
