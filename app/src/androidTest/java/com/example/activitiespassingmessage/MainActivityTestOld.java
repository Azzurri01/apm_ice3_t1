package com.example.activitiespassingmessage;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTestOld {

    @Rule
    public ActivityTestRule<MainActivity> aTestRule = new ActivityTestRule(MainActivity.class);
    private MainActivity mActivity = null;

    private EditText MessageEditText;
    private TextView resultTextView;
    private TextView confirmation;
    public String message;
    public static final String EXTRA_TEXT = "com.example.activitiespassingmessage";

    @Before
    public void setUp() throws Exception {
        mActivity = aTestRule.getActivity();
    }

    @Test
    public void onCreate()
    {

    }

    @Test
    public void activity2()
    {
        Intent intent = new Intent();
        Assert.assertNotNull(intent);
    }
}