package com.example.activitiespassingmessage;

import android.view.View;

//import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class Activity2Test {
    @Rule
    public ActivityTestRule<Activity2> activity2Rule = new ActivityTestRule<Activity2>(Activity2.class);
    //public IntentsTestRule<MainActivity>intentsTestRule = new IntentsTestRule<>(MainActivity.class);
    private Activity2 activity2 = null;

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
    }

    @After
    public void tearDown() throws Exception
    {
        activity2 = null;
    }
}