package com.cutehacks.automatictesting;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
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
        String labelString = getActivity().getString(R.string.hello_world);

        solo.takeScreenshot("Before checking the text is displayed");
        onView(withText(labelString)).check(matches(isDisplayed()));
    }

    public void testOpenAndCloseDialog() {
        String openButtonText = getActivity().getString(R.string.button_name);
        String okButtonText = getActivity().getString(android.R.string.ok);

        solo.takeScreenshot("Before opening the dialog");
        onView(withText(openButtonText)).perform(click());

        solo.takeScreenshot("Before closing the dialog");
        onView(withText(okButtonText)).perform(click());

        solo.takeScreenshot("Before checking the dialog is closed");
        onView(withText(okButtonText)).check(doesNotExist());
   }
}