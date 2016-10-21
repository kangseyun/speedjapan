package com.cyber.seyun.sppedjapan;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.cyber.seyun.sppedjapan.Activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Created by vcs-server on 10/21/16.
 */
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void MainLayoutTest() {
        LayoutPressBack(R.id.main_basic_word);
        LayoutPressBack(R.id.main_word);
        LayoutPressBack(R.id.main_puzzle);
        LayoutPressBack(R.id.main_chinese);
        LayoutPressBack(R.id.main_dic);
        LayoutPressBack(R.id.setting);

    }

    private void LayoutPressBack(int src) {
        onView(withId(src)).perform(click());
        Espresso.pressBack();
    }

}