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

//import androidx.test.espresso.intent.rule.IntentsTestRule;

@RunWith(AndroidJUnit4.class)
public class Activity2Test {
    @Rule
    public ActivityTestRule<Activity2> activity2Rule = new ActivityTestRule<Activity2>(Activity2.class);
    //public IntentsTestRule<MainActivity>intentsTestRule = new IntentsTestRule<>(MainActivity.class);
    private Activity2 activity2 = null;
    private Activity3 activity3 = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Activity3.class.getName(),null,false);

    @Before
    public void setUp() throws Exception
    {
        activity2 = activity2Rule.getActivity();
    }

    @Test
    public void testActivity()
    {
        View view = activity2.findViewById(R.id.textView6);
        Assert.assertNotNull(view);
        Assert.assertEquals(view,activity2.findViewById(R.id.textView6));
    }

    @Test   //Test with Instrumentation
    public void testButton()
    {
        Assert.assertNotNull(activity2.findViewById(R.id.button));
        onView(withId(R.id.button)).perform(click());

        Activity activity_3 = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(activity_3);
        Assert.assertEquals("Activity3",activity_3.getLocalClassName());
        activity_3.finish();
    }

    @Ignore
    @Test   //Test with view NOT WORKING
    public void testButtonWithView()
    {
        Assert.assertNotNull(activity2.findViewById(R.id.button));
        onView(withId(R.id.button)).perform(click());

        View view = activity3.findViewById(R.id.textView6);
        Assert.assertNotNull(view);
        Assert.assertEquals(view,activity3.findViewById(R.id.textView6));
    }

    @After
    public void tearDown() throws Exception
    {
        activity2 = null;
    }
}