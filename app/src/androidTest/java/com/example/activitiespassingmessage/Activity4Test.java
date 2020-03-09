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
public class Activity4Test {
    @Rule
    public ActivityTestRule<Activity4> activity4Rule = new ActivityTestRule<Activity4>(Activity4.class);
    private Activity4 activity4 = null;
    private LastActivity lastActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(LastActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception
    {
        activity4 = activity4Rule.getActivity();
    }

    @Test
    public void testActivity()
    {
        View view = activity4.findViewById(R.id.textView6);
        Assert.assertNotNull(view);
        Assert.assertEquals(view,activity4.findViewById(R.id.textView6));
    }

    @Test   //Test with Instrumentation
    public void testButton()
    {
        Assert.assertNotNull(activity4.findViewById(R.id.button));
        onView(withId(R.id.button)).perform(click());

        Activity activity_last = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(activity_last);
        Assert.assertEquals("LastActivity",activity_last.getLocalClassName());
        activity_last.finish();
    }

    @Ignore
    @Test   //Test with view NOT WORKING
    public void testButtonWithView()
    {
        Assert.assertNotNull(activity4.findViewById(R.id.button));
        onView(withId(R.id.button)).perform(click());

        View view = lastActivity.findViewById(R.id.textView6);
        Assert.assertNotNull(view);
        Assert.assertEquals(view,lastActivity.findViewById(R.id.textView6));
    }

    @After
    public void tearDown() throws Exception
    {
        activity4 = null;
    }
}