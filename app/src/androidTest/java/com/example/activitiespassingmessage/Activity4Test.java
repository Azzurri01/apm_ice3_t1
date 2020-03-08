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
public class Activity4Test {
    @Rule
    public ActivityTestRule<Activity4> activity4Rule = new ActivityTestRule<Activity4>(Activity4.class);
    private Activity4 activity4 = null;

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
    }

    @After
    public void tearDown() throws Exception
    {
        activity4 = null;
    }
}