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
public class Activity3Test {
    @Rule
    public ActivityTestRule<Activity3> activity3Rule = new ActivityTestRule<Activity3>(Activity3.class);
    private Activity3 activity3 = null;
    private Activity4 activity4 = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Activity4.class.getName(),null,false);

    @Before
    public void setUp() throws Exception
    {
        activity3 = activity3Rule.getActivity();
    }

    @Test
    public void testActivity()
    {
        View view = activity3.findViewById(R.id.textView6);
        Assert.assertNotNull(view);
        Assert.assertEquals(view,activity3.findViewById(R.id.textView6));
    }

    @Test   //Test with Instrumentation
    public void testButton()
    {
        Assert.assertNotNull(activity3.findViewById(R.id.button));
        onView(withId(R.id.button)).perform(click());

        Activity activity_4 = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(activity_4);
        Assert.assertEquals("Activity4",activity_4.getLocalClassName());
        activity_4.finish();
    }

    @Ignore
    @Test   //Test with view NOT WORKING
    public void testButtonWithView()
    {
        Assert.assertNotNull(activity3.findViewById(R.id.button));
        onView(withId(R.id.button)).perform(click());

        View view = activity4.findViewById(R.id.textView6);
        Assert.assertNotNull(view);
        Assert.assertEquals(view,activity4.findViewById(R.id.textView6));
    }

    @After
    public void tearDown() throws Exception
    {
        activity3 = null;
    }
}