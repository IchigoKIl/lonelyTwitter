package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public class Friend extends User implements Closeness {
	
	private int Closeness;
	
	@Override
	public void setUsername(String x) throws IOException {
		this.username = x;
	}

	public void setCloseness(int value) {
		Closeness = value;
	}

}
