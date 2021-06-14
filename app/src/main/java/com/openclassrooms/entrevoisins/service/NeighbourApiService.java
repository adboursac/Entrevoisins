package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param deleteNeighbour the neighbour to delete
     */
    void deleteNeighbour(Neighbour deleteNeighbour);

    /**
     * Create a neighbour
     * @param neighbour the neighbour to create
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Get Neighbour from id
     * @param neighbourId id of the requested neighbour
     * @return neighbour corresponding to id
     */
    Neighbour getNeighbour(long neighbourId);

    /**
     * Toggle favorite status of specified neighbour with its id.
     */
    boolean toggleFavoriteStatus(long favoriteNeighbourId);

    /**
     * get my favorite neighbours list
     * @return list of my favorite neighbours
     */
    List<Neighbour> getFavoriteNeighbours();
}
