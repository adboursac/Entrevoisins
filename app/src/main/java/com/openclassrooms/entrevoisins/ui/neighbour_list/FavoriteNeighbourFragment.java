package com.openclassrooms.entrevoisins.ui.neighbour_list;
import android.support.v7.widget.RecyclerView;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.util.List;

public class FavoriteNeighbourFragment extends NeighbourFragment {

    @Override
    public void initList() {
        setNeighbours(getApiService().getFavoriteNeighbours());
        getRecyclerView().setAdapter(new MyNeighbourRecyclerViewAdapter(getNeighbours()));
    }
}
