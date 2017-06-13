package com.hello_bowo.alex.receptionhelper.ViewModel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hello_bowo.alex.receptionhelper.Model.ICardObject;
import com.hello_bowo.alex.receptionhelper.Model.Room;
import com.hello_bowo.alex.receptionhelper.R;

import java.util.List;

/**
 * Created by Alex on 13/06/2017.
 */

public class CardObjectAdapter extends RecyclerView.Adapter<CardObjectAdapter.MyViewHolder>{

    private Context _context;
    private List<ICardObject> _cardObjects;

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

    public CardObjectAdapter(Context _context, List<ICardObject> _cardObject) {
        this._context = _context;
        this._cardObjects = _cardObject;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.room_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ICardObject cardObject = _cardObjects.get(position);
        holder.title.setText(cardObject.get_title());
        holder.price.setText(cardObject.get_price() + " euros");

        Glide
                .with(_context)
                .load(cardObject.get_picture())
               // .listener(requestListener)
                .error(R.drawable.ic_not_found)
                .into(holder.picture);

    }

    @Override
    public int getItemCount() {
        return _cardObjects.size();
    }


}
