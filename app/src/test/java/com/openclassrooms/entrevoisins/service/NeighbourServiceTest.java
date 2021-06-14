package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    /**
     * get the neighbour list and ensure it contains every neighbour except
     * the neighbour instance of the user
     */
    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        // expected neighbour list must contains every neighbour except user neighbour instance
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        //ensure that expectedNeighbours list contained all the neighbours
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    /**
     * delete neighbour from neighbour list and ensure it doesn't contains this neighbour anymore
     */
    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    /**
     * get a neighbour from id. Ensure it it's right neighbour
     */
    @Test
    public void getNeighbourByIdWithSuccess() {
        Neighbour expectedNeighbour = service.getNeighbours().get(0);
        Neighbour neighbourById = service.getNeighbour(expectedNeighbour.getId());
        assertEquals( expectedNeighbour, neighbourById);
    }

    /**
     * Ensure that toggleFavoriteStatus change neighbour status correctly
     */
    @Test
    public void toggleFavoriteStatusWithSuccess() {
        Neighbour neighbourToSetFavorite = service.getNeighbours().get(0);
        List<Neighbour> favoritesList = service.getFavoriteNeighbours();
        //ensure that neighbour is not already favourite
        assertFalse(favoritesList.contains(neighbourToSetFavorite));
        //toggle neighbour to add it in favorite list
        service.toggleFavoriteStatus(neighbourToSetFavorite.getId());
        //ensure that favorite list contains this neighbour id
        favoritesList = service.getFavoriteNeighbours();
        assertTrue(favoritesList.contains(neighbourToSetFavorite));
        //toggle neighbour to unset favorite
        service.toggleFavoriteStatus(neighbourToSetFavorite.getId());
        favoritesList = service.getFavoriteNeighbours();
        //ensure that favorite list doesn't contains this neighbour id anymore
        assertFalse(favoritesList.contains(neighbourToSetFavorite));
    }

    /**
     * add a neighbour id in favorite list then ensure that getFavoriteNeighbours()
     * return the correct number of neighbours and that it is the right neighbour
     */
    @Test
    public void getFavoriteNeighboursWithSuccess() {
        //we will add neighbour at position 1 as favorite
        long expectedNeighbourId = service.getNeighbours().get(1).getId();
        //add the neighbour to favorite
        service.toggleFavoriteStatus(expectedNeighbourId);
        //ensure we get the correct number of neighbours
        List<Neighbour> favoritesList = service.getFavoriteNeighbours();
        assertEquals( 1, favoritesList.size());
        //ensure we get the right neighbour
        assertEquals( expectedNeighbourId, favoritesList.get(0).getId());
    }
}
