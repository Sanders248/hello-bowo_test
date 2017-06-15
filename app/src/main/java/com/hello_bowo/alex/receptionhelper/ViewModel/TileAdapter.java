package com.hello_bowo.alex.receptionhelper.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.hello_bowo.alex.receptionhelper.Model.Tile;
import com.hello_bowo.alex.receptionhelper.R;
import com.hello_bowo.alex.receptionhelper.RoomDescPage;
import com.hello_bowo.alex.receptionhelper.WebViewPage;

import java.util.List;

/**
 * Created by Alex on 14/06/2017.
 */

public class TileAdapter extends RecyclerView.Adapter<TileAdapter.MyViewHolder>{

    private Context _context;
    private List<Tile> _tiles;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public Button button;
        public ImageView logo;
        public RelativeLayout background;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.textTitle);
            button = (Button) view.findViewById(R.id.button);
            logo = (ImageView) view.findViewById(R.id.imLogo);
            background = (RelativeLayout) view.findViewById(R.id.tile_relativelayout);
        }
    }

    public TileAdapter(Context _context, List<Tile> tiles) {
        this._context = _context;
        this._tiles = tiles;
    }

    @Override
    public TileAdapter.MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tile_card, parent, false);

        return new TileAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TileAdapter.MyViewHolder holder, final int position) {
        Tile tile = _tiles.get(position);

        holder.title.setText(tile.getTextTitle());
        holder.button.setText(tile.getTextButton());

        Glide.with(_context).load(tile.get_picBackground()).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    holder.background.setBackground(drawable);
                }
            }
        });

        Glide
                .with(_context)
                .load(tile.get_picLogo())
                .error(null)
                .into(holder.logo);

        if (tile.getTextButton() == "")
            holder.button.setVisibility(View.GONE);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tile t = _tiles.get(position);
                Intent intent = new Intent(_context, WebViewPage.class);
                intent.putExtra("Tile", t);

                _context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return _tiles.size();
    }


    public boolean isHeader(int position) {
        return position == 0;
    }
}

