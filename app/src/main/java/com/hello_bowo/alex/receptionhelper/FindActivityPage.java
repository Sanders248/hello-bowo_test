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

import com.hello_bowo.alex.receptionhelper.Model.Activity;
import com.hello_bowo.alex.receptionhelper.Model.ICardObject;
import com.hello_bowo.alex.receptionhelper.ViewModel.CardObjectAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 13/06/2017.
 */

public class FindActivityPage extends Fragment {
    private RecyclerView _recyclerView;
    private CardObjectAdapter _adapter;
    private List<ICardObject> _activitys;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_view, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View actual_view = getView();

        _recyclerView = (RecyclerView) actual_view.findViewById(R.id.recycler_view);

        _activitys = new ArrayList<>();


        _adapter = new CardObjectAdapter(getContext(), _activitys);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);

        _recyclerView.setLayoutManager(mLayoutManager);
        //  _recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        _recyclerView.setItemAnimator(new DefaultItemAnimator());
        _recyclerView.setAdapter(_adapter);

        prepareActivitys();
    }

    private void prepareActivitys(){

        Activity a = new Activity("hiking", "20km hikings, 5 hours", 20, R.drawable.ic_sport, "Jura", "0601020304");
        _activitys.add(a);

        Activity b = new Activity("climbing", "Equipment available for all levels", 20, R.drawable.ic_sport, "Jura", "0601020304");
        _activitys.add(b);

        Activity c = new Activity("Bungee jumping", "300m of high sensation", 20, R.drawable.ic_sport, "Jura", "0601020304");
        _activitys.add(c);

        Activity d = new Activity("Tennis", "Let's play at any time with friends or take a teacher", 20, R.drawable.ic_sport, "Jura", "0601020304");
        _activitys.add(d);

        Activity e = new Activity("Diving", "Carpentorum resultantes fabricantur celebratae ingentes in vocali sit nunc et clausis organa non ita doctor fabricantur ludicrarum ludicrarum studiorum tinnitu organa organa non nunc speciem histrionici antea ludicrarum cum levia vocali fidium seriis accitur ludicrarum philosopho instrumenta ingentes resultantes accitur pro in vocali oratoris non fabricantur denique carpentorum carpentorum non.", 20, R.drawable.ic_sport, "Jura", "0601020304");
        _activitys.add(e);

        Activity f = new Activity("Archery", "New way for relaxing and focusing", 20, R.drawable.ic_sport, "Jura", "0601020304");
        _activitys.add(f);

        _adapter.notifyDataSetChanged();
    }
}
