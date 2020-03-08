package com.example.activitiespassingmessage;

import android.view.View;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class Activity3Test {
    @Rule
    public ActivityTestRule<Activity3> activity2Rule = new ActivityTestRule<Activity3>(Activity3.class);
    private Activity3 activity3 = null;

    @Before
    public void setUp() throws Exception
    {
        activity3 = activity2Rule.getActivity();
    }

    @Test
    public void testActivity()
    {
        View view = activity3.findViewById(R.id.textView6);
        Assert.assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception
    {
        activity3 = null;
    }
}