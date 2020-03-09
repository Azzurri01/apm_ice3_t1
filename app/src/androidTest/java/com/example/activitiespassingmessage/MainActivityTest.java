package com.example.activitiespassingmessage;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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

    private MainActivity mActivity = null;
    private Activity2 activity2 = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Activity2.class.getName(),null,false);

    @Before
    public void setUp() throws Exception
    {
        mActivity = mActivityRule.getActivity();

    }

    @Test
    public void testActivity()
    {
        View view = mActivity.findViewById(R.id.MessageEditText);
        Assert.assertNotNull(view);
        Assert.assertEquals(view,mActivity.findViewById(R.id.MessageEditText));
    }

    @Test   //Test with Instrumentation
    public void testButton()
    {
        Assert.assertNotNull(mActivity.findViewById(R.id.submitButton));
        onView(withId(R.id.submitButton)).perform(click());

        Activity activity_2 = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(activity_2);
        Assert.assertEquals("Activity2",activity_2.getLocalClassName());
        activity_2.finish();
    }

    @Ignore
    @Test   //Test with view NOT WORKING
    public void testButtonWithView()
    {
        Assert.assertNotNull(mActivity.findViewById(R.id.submitButton));
        onView(withId(R.id.submitButton)).perform(click());

        View view = activity2.findViewById(R.id.textView6);
        Assert.assertNotNull(view);
        Assert.assertEquals(view,activity2.findViewById(R.id.textView6));
    }

    @After
    public void tearDown() throws Exception
    {
        mActivity = null;
    }
}