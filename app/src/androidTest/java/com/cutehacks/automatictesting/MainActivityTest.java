package com.cutehacks.automatictesting;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    Solo solo;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testHelloWorld() {
        solo.takeScreenshot("Before testing Hello World!");
        onView(withText(getActivity().getString(R.string.hello_world))).check(matches(isDisplayed()));
    }
}