package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import android.test.ActivityInstrumentationTestCase2;

public class LonelyTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public LonelyTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testSample() {
		//fail("This is a failing test");
		//assertFalse("This is false", isGreaterThan(5,6));
		assertEquals("5 is equal to 5", 5, 5);
	}
	
	public void testEquals() {
		Date date = new Date();
		NormalTweetModel tweet1 = new NormalTweetModel("Hello", new Date(123));
		NormalTweetModel tweet2 = new NormalTweetModel("Hello", new Date(123));
		NormalTweetModel tweet3 = new NormalTweetModel("Hello", new Date(231));
		NormalTweetModel tweet4 = new NormalTweetModel("Hi", new Date(123));
		ImportantTweetModel tweet5 = new ImportantTweetModel("Hello", new Date(123));
		ImportantTweetModel tweet6 = new ImportantTweetModel("Hello", new Date(123));
		ImportantTweetModel tweet7 = new ImportantTweetModel("Hello", new Date(231));
		ImportantTweetModel tweet8 = new ImportantTweetModel("Hi", new Date(123));
		
		// Exactly same NormalTweetModel
		assertTrue("Different tweets are different", 
				tweet1.equals(tweet2));
		
		// Different Date NormalTweetModel
		assertFalse("Should not be the same 1", 
				tweet1.equals(tweet3));
		
		// Different Tweet NormalTweetModel
		assertFalse("Should not be the same 2", 
				tweet1.equals(tweet4));
		
		// Different TweetModels (Same everything else)
		assertFalse("Should not be the same 3", 
				tweet5.equals(tweet1));
		
		// Exactly Same ImportantTweetModel
		assertTrue("Different tweets are different", 
				tweet5.equals(tweet6));
		
		// Different Date ImportantTweetModel
		assertFalse("Should not be the same 4", 
				tweet5.equals(tweet7));
		
		// Different Tweet ImportantTweetModel
		assertFalse("Should not be the same 5", 
				tweet5.equals(tweet8));
	}

	private boolean isGreaterThan(int i, int j) {
		if (i>j)
			return true;
		else
			return false;
	}
	
}
