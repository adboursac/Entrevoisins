
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    private ListNeighbourActivity mActivity;

    private static List<Neighbour> NEIGHBOURS_LIST = DI.getNeighbourApiService().getNeighbours();

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least one item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        int neighbourInitialAmount = NEIGHBOURS_LIST.size();
        // Given : We remove the element at row 2 (position = 1)
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(neighbourInitialAmount));
        // When perform a click on a delete icon
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(neighbourInitialAmount-1));
    }

    /**
     * When click on item, detail screen is displayed
     * and showing the right neighbour details
     */
    @Test
    public void clickNeighbourItem_showDetailScreen_And_NeighbourName() {
        // Perform click on the element at row 2 (position = 1)
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        // Check if the detail View has been displayed
        onView(ViewMatchers.withId(R.id.activity_neighbour_detail))
                .check(matches(isDisplayed()));
        // Check if the detail View is showing the right name
        onView(ViewMatchers.withId(R.id.detailName))
                .check(matches( withText(NEIGHBOURS_LIST.get(1).getName()) ));
    }

    /**
     * Check that Favorite tab displays favorite neighbours only,
     * by clicking the favorite button (star) of the neighbour at position 1
     * then checking that the list displayed in favorite page is correct
     */
    @Test
    public void addNewFavorite_FavoriteTab_DisplaysFavoriteOnly() {
        // click to show detail view of neighbour at position 1
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        // Click on favorite (star button)
        onView(withId(R.id.favoriteButton)).perform(click());
        // Click on backButton
        onView(withId(R.id.backButton)).perform(click());
        // Click on favorite Tab
        onView(withText(R.string.tab_favorites_title)).perform(click());
        // Check if favorite list displays the right amount of favorite neighbours (only 1)
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(1));
        // Click to show detail view of neighbour at position 0
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        // Check if the detail View is showing the right name
        onView(ViewMatchers.withId(R.id.detailName))
                .check(matches( withText(NEIGHBOURS_LIST.get(1).getName()) ));
    }
}