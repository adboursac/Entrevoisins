package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Dummy mock for the Api
 */

public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     * @param deleteNeighbour the neighbour to delete
     */
    @Override
    public void deleteNeighbour(Neighbour deleteNeighbour) {
        neighbours.remove(deleteNeighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbourId id of the requested neighbour
     * @return
     */
    @Override
    public Neighbour getNeighbour(long neighbourId) {
        for(Neighbour n : neighbours) {
            if(n.getId() == neighbourId) return n;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * @param favoriteNeighbourId id of neighbour who is changing status.
     * @return  Updated status (true/false) if specified neighbour exists, false if this neighbour doesn't exists.
     */
    public boolean toggleFavoriteStatus(long favoriteNeighbourId) {
        for(Neighbour n : neighbours) {
            if(n.getId() == favoriteNeighbourId) return n.toggleFavoriteStatus();
        }
        //throw new Exception("toggleFavoriteStatus : couldn't find neighbour with id" + favoriteNeighbourId);
        return false;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        return neighbours.stream()
                .filter(n -> n.getFavorite())
                .collect(Collectors.toList());
    }
}
