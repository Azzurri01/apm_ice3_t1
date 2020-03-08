package com.example.activitiespassingmessage;

import android.app.Instrumentation;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    public ActivityTestRule<Activity2> activity2Rule = new ActivityTestRule<Activity2>(Activity2.class);
    public static final String EXTRA_TEXT = "com.example.activitiespassingmessage";
    public String text = "This is the text to read";

    private MainActivity mActivity = null;
    private Activity2 activity2 = null;
    private TextView textView6 = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Activity2.class.getName(),null,false);

    @Before
    public void setUp() throws Exception
    {
        mActivity = mActivityRule.getActivity();


    }

    /*@Test
    public void testActivity()
    {
        View view = mActivity.findViewById(R.id.MessageEditText);
        Assert.assertNotNull(view);
    }*/

    @Test
    public void testButton()
    {


        onView(withId(R.id.submitButton)).perform(click());
        Intent intent = new Intent();
        intent.putExtra(EXTRA_TEXT, text);
        activity2Rule.launchActivity(intent);

        System.out.println(intent.toString());
        View view = activity2.findViewById(R.id.textView6);
        Assert.assertNotNull(view);
        System.out.println("Dimitri: " + view.toString());
    }


    @After
    public void tearDown() throws Exception
    {
        mActivity = null;
    }
}