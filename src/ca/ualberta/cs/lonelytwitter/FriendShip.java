package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class FriendShip {
	private ArrayList<Friend> friendslist;
	
	public FriendShip() {
		super();
		friendslist = new ArrayList<Friend>();
	}

	public ArrayList<Friend> getFriendslist() {
		return friendslist;
	}

	public void setFriendslist(ArrayList<Friend> friendslist) {
		this.friendslist = friendslist;
	}
	
	public void addFriend(Friend friend) {
		friendslist.add(friend);
	}
	
	public void removeFriend(Friend friend) {
		friendslist.remove(friend);
	}
}
