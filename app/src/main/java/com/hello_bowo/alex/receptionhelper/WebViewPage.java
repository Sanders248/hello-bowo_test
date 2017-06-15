package com.hello_bowo.alex.receptionhelper;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.hello_bowo.alex.receptionhelper.Model.Activity;
import com.hello_bowo.alex.receptionhelper.Model.Tile;

/**
 * Created by Alex on 14/06/2017.
 */

public class WebViewPage extends AppCompatActivity {
    Tile _tile;
    WebView _webView;

    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.webview);

        _tile = (Tile) getIntent().getSerializableExtra("Tile");


        bindViews();
        populateViews();
    }


    private void bindViews()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.wvtoolbar);
        setSupportActionBar(toolbar);

        _webView = (WebView) findViewById(R.id.webView);
    }

    private void populateViews()
    {
        getSupportActionBar().setSubtitle(_tile.getTextTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        WebSettings settings = _webView.getSettings();
        settings.setJavaScriptEnabled(true);
        _webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        progressBar = ProgressDialog.show(this, _tile.getTextTitle(), "Loading...");

        final AppCompatActivity thisActy = this;

        _webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i("URLloading", "Processing webview url click...");
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.i("PageFinished", "Finished loading URL: " +url);
                if (progressBar.isShowing()) {
                    progressBar.dismiss();
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.e("Error", "Error: " + description);
                Toast.makeText(thisActy, "Oh no! " + description, Toast.LENGTH_SHORT).show();
                alertDialog.setTitle("Error");
                alertDialog.setMessage(description);

/*
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });*/
                alertDialog.show();
            }
        });

        _webView.loadUrl(_tile.get_classPage());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    
}
