package com.hello_bowo.alex.receptionhelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hello_bowo.alex.receptionhelper.Model.Tile;
import com.hello_bowo.alex.receptionhelper.ViewModel.TileAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 14/06/2017.
 */

public class TilesPage  extends Fragment {
    private RecyclerView _recyclerView;
    private TileAdapter _adapter;
    private List<Tile> _tiles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_view, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View actual_view = getView();

        _recyclerView = (RecyclerView) actual_view.findViewById(R.id.recycler_view);
        _recyclerView.setBackgroundResource(R.drawable.background);
        _tiles = new ArrayList<>();

        _adapter = new TileAdapter(getContext(), _tiles);

        final GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
        _recyclerView.setLayoutManager(mLayoutManager);
        _recyclerView.setItemAnimator(new DefaultItemAnimator());
        _recyclerView.setAdapter(_adapter);

        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return _tiles.get(position).get_spann();
            }
        });

        prepareActivitys();
    }

    private void prepareActivitys(){

        Tile a = new Tile(R.drawable.textmeteo, R.drawable.meteo, "Ensoleillé", "", "http://www.meteo-france.mobi/home#!france", 1);
        _tiles.add(a);

        Tile b = new Tile(R.drawable.logohotel, R.drawable.hotel, "Plus d'info", "Bienvenue dans votre hotel Pullman", "http://www.pullmanhotels.com/fr/france/index.shtml", 2);
        _tiles.add(b);

        Tile c = new Tile(R.drawable.logospa, R.drawable.reserve, "Réservez votre scéance", "Détendez-vous avec nos scéances de Spa & Fitness", "http://lesjardinsdumarais.com/fr/fitness-center.html", 2);
        _tiles.add(c);

        Tile d = new Tile(R.drawable.logocityguide, R.drawable.cityguide, "Visitez la ville", "", "https://www.parisinfo.com/", 1);
        _tiles.add(d);

        Tile e = new Tile(R.drawable.logocommande, R.drawable.commande, "Commandez", "Notre restaurant directement dans votre chambre.", "https://restaurant.michelin.fr/restaurants/paris", 1);
        _tiles.add(e);

        Tile f = new Tile(R.drawable.logoreserve, R.drawable.reserve, "Réservez votre table", "Petit déjeuné, déjeuner, dîner", "https://restaurant.michelin.fr/restaurants/paris", 2);
        _tiles.add(f);

        Tile g = new Tile(R.drawable.logoconciergerie, R.drawable.conciergerie, "Votre demande", "Notre conciergerie.", "http://www.paris-conciergerie.fr/", 3);
        _tiles.add(g);

        Tile h = new Tile(R.drawable.logospotify, R.drawable.spotify, "Lancer Spotify", "", "https://www.spotify.com/fr/", 1);
        _tiles.add(h);

        Tile i = new Tile(-1, R.drawable.netflix, "Lancer Netflix", "", "https://www.netflix.com/fr/", 1);
        _tiles.add(i);

        Tile j = new Tile(R.drawable.news, R.drawable.logonews, "L'actualité", "", "https://news.google.fr/", 1);
        _tiles.add(j);

        _adapter.notifyDataSetChanged();
    }
}