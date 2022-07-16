package com.example.practica7;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SegundoActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        wv = findViewById(R.id.webView);
        String url = getIntent().getStringExtra("url");
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(url);
    }

    public void onClickAnterior(View view) {
        //Intent i = new Intent(this, MainActivity.class);
        //startActivity(i);
        finish();
    }
}