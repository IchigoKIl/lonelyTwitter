package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetList {
	
	private ArrayList<LonelyTweetModel> tweetList;
	private int count;
	
	public TweetList() {
		tweetList = new ArrayList<LonelyTweetModel>();
		count = 0;
	}
	
	public ArrayList<LonelyTweetModel> getTweets() {
		return tweetList;
	}

	public int getCount() {
		return count;
	}

	public boolean hasTweet(LonelyTweetModel tweet) {
		boolean exists = false;
		for (LonelyTweetModel tweets: tweetList) {
			if (tweets.equals(tweet)) {
				exists = true;
			}
		}
		return exists;
	}
	
	public void addTweet(LonelyTweetModel tweet) throws IllegalArgumentException {
		if (hasTweet(tweet)) {
			throw new IllegalArgumentException();
		} else {
			tweetList.add(tweet);
			count++;
		}
		
	}

	public void removeTweet(NormalTweetModel tweet) {
		tweetList.remove(tweet);
		count--;
	}

}
