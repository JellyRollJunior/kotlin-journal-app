package com.example.kotlinjournal

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AffirmationsListTests {

    /**
     *  In order to test the UI of the activity, we have to specify that we want it to launch.
     *  Make an activity scenario rule for the main activity.
     */
    @get:Rule
    val activity = ActivityScenarioRule(AffirmationsMain::class.java)

    @Test
    fun scroll_to_data() {
        /**
         * The name RecyclerViewActions is exactly what the name implies: a class that lets your tests
         * take actions on a RecyclerView. scrollToPosition()is a static method from the
         * RecyclerViewActions class that will scroll to a specified position. This method returns
         * what is called a Generic. Generics are outside of the scope of this codelab, but in this case
         * you can think of it as the scrollToPosition() method returning whatever the items in the
         * RecyclerView are, which could be anything.
         *
         * In our app, the items in our RecyclerView are ViewHolders, so we place a pair of angle
         * brackets after the method call and in them we specify RecyclerView.ViewHolder. Finally,
         * pass in the final position in the list (9).
         *
         * When you are unsure of the length of your list you can use the scrollTo action. The
         * scrollTo function requires a Matcher<View!>! to find a particular item. This can be a
         * number of things, but to serve the purposes of this test, use withText.
         */
        onView(withId(R.id.recycler_view)).perform(
                RecyclerViewActions
                    .scrollTo<RecyclerView.ViewHolder>(
                        withText(R.string.affirmation10)
                    )
        )

        /**
         * Now that scrolling to the desired position of the RecyclerView is enabled, make an
         * assertion to ensure that the UI is displaying the expected information. Make sure that
         * once you have scrolled to the last item, the text associated with the final affirmation
         * is displayed. Start with a ViewInteraction, but this time pass in a new ViewMatcher
         * (in this case, withText()). To that method, pass the string resource that contains the
         * text of the last affirmation. The withText() method identifies a UI component based on
         * the text it displays.
         *
         * For this component, all that needs to be done is to check that it
         * displays the desired text. This is done by calling check() on the ViewInteraction.
         * check() requires a ViewAssertion, for which you can use the matches() method. Finally,
         * make the assertion that the UI component is displayed by passing the method isDisplayed().
         */
        Thread.sleep(3000)
        onView(withText(R.string.affirmation10))
            .check(matches(isDisplayed()))
    }
}