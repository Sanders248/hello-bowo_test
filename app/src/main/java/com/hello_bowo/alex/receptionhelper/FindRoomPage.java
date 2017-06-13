package com.hello_bowo.alex.receptionhelper;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hello_bowo.alex.receptionhelper.Model.Room;
import com.hello_bowo.alex.receptionhelper.ViewModel.RoomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 13/06/2017.
 */

public class FindRoomPage extends Fragment {
    private RecyclerView _recyclerView;
    private RoomAdapter _adapter;
    private List<Room> _rooms;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return inflater.inflate(R.layout.find_room, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View actual_view = getView();

        _recyclerView = (RecyclerView) actual_view.findViewById(R.id.recycler_view);

        _rooms = new ArrayList<>();


        _adapter = new RoomAdapter(getContext(), _rooms);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);

        _recyclerView.setLayoutManager(mLayoutManager);
        //  _recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        _recyclerView.setItemAnimator(new DefaultItemAnimator());
        _recyclerView.setAdapter(_adapter);

        prepareRooms();
    }

    private void prepareRooms(){

        Room a = new Room("Presidencial", "he best we have", 2000, R.drawable.room_icone);
        _rooms.add(a);

        Room b = new Room("Luxe", "The second best we have", 1000, R.drawable.room_icone);
        _rooms.add(b);

        Room c = new Room("Domestic", "For the entire family", 500, R.drawable.room_icone);
        _rooms.add(c);

        Room d = new Room("Huge", "Big room for a lot aof space", 400, R.drawable.room_icone);
        _rooms.add(d);

        Room e = new Room("Normal", "Nice room for 2", 250, R.drawable.room_icone);
        _rooms.add(e);

        Room f = new Room("Cheap", "The cheapest one", 100, R.drawable.room_icone);
        _rooms.add(f);

        _adapter.notifyDataSetChanged();
    }
}
