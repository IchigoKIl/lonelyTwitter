package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;
import java.util.Date;

import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetList;
import android.test.ActivityInstrumentationTestCase2;

public class TweetListTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetListTest() {
		super(LonelyTwitterActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testTweetList() {
		TweetList tweetlist = new TweetList();
		//ArrayList<LonelyTweetModel> tweets = tweetlist.getTweets();
		assertNotNull("Tweet List not initialized", tweetlist.getTweets());
	}
	
	public void testCount() {
		TweetList tweetList = new TweetList();
		NormalTweetModel tweet = new NormalTweetModel("Hello");
		tweetList.addTweet(tweet);
		assertEquals("This should be one", 1, tweetList.getCount());
	}
	
	public void testAddTweet() {
		//addTweet(LonelyTweetModel) should throw an IllegalArgumentException when a tweet that equals() one of the tweets in the list is added.
		TweetList tweetList = new TweetList();
		NormalTweetModel tweet1 = new NormalTweetModel("Hello", new Date(123));
		NormalTweetModel tweet2 = new NormalTweetModel("Hello", new Date(123));
		
		tweetList.addTweet(tweet1);
		
		try {
			tweetList.addTweet(tweet2);
		} catch (IllegalArgumentException e) {
			
		}
		
		assertTrue("Should only have 1 tweet", tweetList.getCount() == 1);
	}
	
	public void testGetTweets() {
		//getTweets(): LonelyTweetModel[] should return all tweets in the order they were added
		TweetList tweetList = new TweetList();
		NormalTweetModel tweet1 = new NormalTweetModel("Hello", new Date(123));
		NormalTweetModel tweet2 = new NormalTweetModel("Hello", new Date(231));
		
		tweetList.addTweet(tweet1);
		tweetList.addTweet(tweet2);
		
		ArrayList<LonelyTweetModel> list = tweetList.getTweets();
		assertTrue("First tweet is not tweet1", list.get(0).equals(tweet1));
		assertTrue("First tweet is not tweet2", list.get(1).equals(tweet2));
	}
	
    public void testHasTweet() {
    	// hasTweet(LonelyTweetModel) should return true/false a tweet that equals() this one is already in the list
		TweetList tweetList = new TweetList();
		NormalTweetModel tweet1 = new NormalTweetModel("Hello", new Date(123));
		tweetList.addTweet(tweet1);
		assertTrue("Doesn't have tweet1", tweetList.hasTweet(tweet1));
    }
    
    public void testRemoveTweet() {
    	// removeTweet(LonelyTweetModel) should remove a tweet
		TweetList tweetList = new TweetList();
		NormalTweetModel tweet1 = new NormalTweetModel("Hello", new Date(123));
		tweetList.addTweet(tweet1);
		tweetList.removeTweet(tweet1);
		assertTrue("tweetList still has tweet 1", tweetList.getCount() == 0);
    }
	
}
