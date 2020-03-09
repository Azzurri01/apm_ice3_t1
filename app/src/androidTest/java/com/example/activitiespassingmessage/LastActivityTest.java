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
public class LastActivityTest {
    @Rule
    public ActivityTestRule<LastActivity> lastActivityRule = new ActivityTestRule<LastActivity>(LastActivity.class);
    private LastActivity lastActivity = null;
    private MainActivity mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception
    {
        lastActivity = lastActivityRule.getActivity();
    }

    @Test
    public void testActivity()
    {
        View view = lastActivity.findViewById(R.id.textView6);
        Assert.assertNotNull(view);
        Assert.assertEquals(view,lastActivity.findViewById(R.id.textView6));
    }

    @Test   //Test with Instrumentation
    public void testButton()
    {
        Assert.assertNotNull(lastActivity.findViewById(R.id.button));
        onView(withId(R.id.button)).perform(click());

        Activity activity_main = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(activity_main);
        Assert.assertEquals("MainActivity",activity_main.getLocalClassName());
        activity_main.finish();
    }

    @Ignore
    @Test   //Test with view NOT WORKING
    public void testButtonWithView()
    {
        Assert.assertNotNull(lastActivity.findViewById(R.id.button));
        onView(withId(R.id.button)).perform(click());

        View view = mActivity.findViewById(R.id.textView6);
        Assert.assertNotNull(view);
        Assert.assertEquals(view,mActivity.findViewById(R.id.textView6));
    }

    @After
    public void tearDown() throws Exception
    {
        lastActivity = null;
    }
}