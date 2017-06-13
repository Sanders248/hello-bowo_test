package com.hello_bowo.alex.receptionhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hello_bowo.alex.receptionhelper.Model.Room;

/**
 * Created by Alex on 13/06/2017.
 */

public class RoomDescPage extends AppCompatActivity {
    TextView _textTitle;
    TextView _textPrice;
    TextView _textDesc;
    ImageView _imPicture;

    Room _room;

    public RoomDescPage() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_description);

        _room = (Room)getIntent().getSerializableExtra("CardObject");

        bindViews();
        populateViews();
    }

    private void bindViews() {
        _textDesc = (TextView) findViewById(R.id.textDescription);
        _textPrice = (TextView) findViewById(R.id.textPrice);
        _textTitle = (TextView) findViewById(R.id.textTitle);
        _imPicture = (ImageView) findViewById(R.id.roomPicture);
    }

    private void populateViews() {
        _textDesc.setText(_room.get_description());
        _textTitle.setText(_room.get_title());
        _textPrice.setText(_room.get_price() + " euros / night");
        _imPicture.setBackgroundResource(_room.get_picture());

        Glide
                .with(this)
                .load(_room.get_picture())
                // .listener(requestListener)
                .error(R.drawable.ic_not_found)
                .into(_imPicture);
    }
}
