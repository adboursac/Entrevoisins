package com.openclassrooms.entrevoisins.service;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1,
                    "Caroline",
                    "https://i.pravatar.cc/150?u=a042581f4e29026704d",
                    "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",
                    "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",
                    "www.facebook.fr",
                    false),
            new Neighbour(2,
                    "Jack",
                    "https://i.pravatar.cc/150?u=a042581f4e29026704e",
                    "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",
                    "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",
                    "www.facebook.fr",
                    false),
            new Neighbour(3,
                    "Chloé",
                    "https://i.pravatar.cc/150?u=a042581f4e29026704f",
                    "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",
                    "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",
                    "www.facebook.fr",
                    false),
            new Neighbour(4,
                    "Vincent",
                    "https://i.pravatar.cc/150?u=a042581f4e29026704a",
                    "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",
                    "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",
                    "www.facebook.fr",
                    false),
            new Neighbour(5,
                    "Elodie",
                    "https://i.pravatar.cc/150?u=a042581f4e29026704b",
                    "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",
                    "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",
                    "www.facebook.fr",
                    false),
            new Neighbour(6,
                    "Sylvain",
                    "https://i.pravatar.cc/150?u=a042581f4e29026704c",
                    "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",
                    "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",
                    "www.facebook.fr",
                    false),
            new Neighbour(7, "Laetitia",
                    "https://i.pravatar.cc/150?u=a042581f4e29026703d",
                    "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",
                    "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",
                    "www.facebook.fr",
                    false),
            new Neighbour(8,
                    "Dan",
                    "https://i.pravatar.cc/150?u=a042581f4e29026703b",
                    "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",
                    "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",
                    "www.facebook.fr",
                    false),
            new Neighbour(9,
                    "Joseph",
                    "https://i.pravatar.cc/150?u=33",
                    "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",
                    "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",
                    "www.facebook.fr",
                    false),
            new Neighbour(10,
                    "Emma",
                    "https://i.pravatar.cc/150?u=a042581f4e29026706d",
                    "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",
                    "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",
                    "www.facebook.fr",
                    false),
            new Neighbour(11,
                    "Patrick",
                    "https://i.pravatar.cc/150?u=a042581f4e29026702d",
                    "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",
                    "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",
                    "www.facebook.fr",
                    false),
            new Neighbour(12,
                    "Ludovic",
                    "https://i.pravatar.cc/150?u=a042581f3e39026702d",
                    "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",
                    "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",
                    "www.facebook.fr",
                    false)
    );
    
    @RequiresApi(api = Build.VERSION_CODES.N)
    static List<Neighbour> generateNeighbours() {
        //return new ArrayList<>(DUMMY_NEIGHBOURS);
        return DUMMY_NEIGHBOURS.stream().map(n -> new Neighbour(n.getId(),
                                                                n.getName(),
                                                                n.getAvatarUrl(),
                                                                n.getAddress(),
                                                                n.getPhoneNumber(),
                                                                n.getAboutMe(),
                                                                n.getSocialMediaUrl(),
                                                                false
                                                                )
                                                ).collect(Collectors.toList());
    }
}
