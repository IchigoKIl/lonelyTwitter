package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.R;

public class IntentReaderActivityTests extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderActivityTests() {
		super(IntentReaderActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testSendText() {
		String text = "Hello world!";
		IntentReaderActivity activity = startWithText(text, 
				IntentReaderActivity.NORMAL);
		assertEquals("Got the text?", text, activity.getText());
	}
	
	public void testDoubleText() {
		String text = "Hello world!";
		IntentReaderActivity activity = startWithText(text, 
				IntentReaderActivity.DOUBLE);
		assertEquals("Got the text?", text + text, activity.getText());
	}
	
	public void testReverseText() {
		String text = "Hello world!";
		IntentReaderActivity activity = startWithText(text, 
				IntentReaderActivity.REVERSE);
		
		String reverseText = "";
		for (char i: text.toCharArray()) {
			reverseText = i + reverseText;
		}
		
		assertEquals("Got the text?", reverseText, activity.getText());
	} 
	
	public void testDisplayText() {
		String text = "Hello!";
		IntentReaderActivity activity = startWithText(text, 
				IntentReaderActivity.NORMAL);
		TextView view = (TextView) activity.findViewById(R.id.intentText);
		assertEquals("Correct text?", text, view.getText());
	}
	
	public void testDefaultText() {
		String text = "";
		IntentReaderActivity activity = startWithText(text, 
				IntentReaderActivity.NORMAL);
		TextView view = (TextView) activity.findViewById(R.id.intentText);
		assertEquals("Correct text?", activity.DEFAULT_TEXT, view.getText());
	}
	
	public void testVisibility() {
		String text = "";
		IntentReaderActivity activity = startWithText(text, 
				IntentReaderActivity.NORMAL);
		
		View view = activity.getWindow().getDecorView();
		ViewAsserts.assertOnScreen(view, activity.findViewById(R.id.intentText));
	}
	
	private IntentReaderActivity startWithText(String text, int mode) {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, mode);
		setActivityIntent(intent);
		return (IntentReaderActivity) getActivity();
	}
	
}
