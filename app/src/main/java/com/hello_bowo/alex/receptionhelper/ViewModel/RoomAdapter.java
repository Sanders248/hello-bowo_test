package com.hello_bowo.alex.receptionhelper.ViewModel;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.hello_bowo.alex.receptionhelper.Model.Room;
import com.hello_bowo.alex.receptionhelper.R;

import java.util.List;

import javax.sql.DataSource;

/**
 * Created by Alex on 13/06/2017.
 */

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyViewHolder>{

    private Context _context;
    private List<Room> _rooms;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;
        public ImageView picture;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            price = (TextView) view.findViewById(R.id.price);
            picture = (ImageView) view.findViewById(R.id.picture);
        }
    }

    public RoomAdapter(Context _context, List<Room> _rooms) {
        this._context = _context;
        this._rooms = _rooms;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.room_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Room room = _rooms.get(position);
        holder.title.setText(room.get_title());
        holder.price.setText(room.get_price() + " euros");
     //   holder.picture.setImageResource(R.drawable.room_icone);

        Glide
                .with(_context)
                .load(room.get_picture())
               // .listener(requestListener)
                .error(R.drawable.room_icone)
                .into(holder.picture);

/*
        try {
            // loading album cover using Glide library
            Glide.with(_context).load(room.get_picture()).into(holder.picture);
        }
        catch (Exception e)
        {
            String error = e.toString();
        }
  */    /*  holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return _rooms.size();
    }


}
