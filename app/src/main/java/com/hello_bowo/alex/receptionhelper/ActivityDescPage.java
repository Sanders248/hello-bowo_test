package com.hello_bowo.alex.receptionhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hello_bowo.alex.receptionhelper.Model.Activity;
import com.hello_bowo.alex.receptionhelper.Model.Room;

/**
 * Created by Alex on 13/06/2017.
 */

public class ActivityDescPage extends AppCompatActivity {
    TextView _textTitle;
    TextView _textPrice;
    TextView _textDesc;
    ImageView _imPicture;

    Activity _activity;

    public ActivityDescPage() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_description);

        _activity = (Activity) getIntent().getSerializableExtra("CardObject");

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
        _textDesc.setText(_activity.get_description());
        _textTitle.setText(_activity.get_title());
        _textPrice.setText(_activity.get_price() + "");
        _imPicture.setBackgroundResource(_activity.get_picture());

        Glide
                .with(this)
                .load(_activity.get_picture())
                // .listener(requestListener)
                .error(R.drawable.ic_not_found)
                .into(_imPicture);
    }
}

