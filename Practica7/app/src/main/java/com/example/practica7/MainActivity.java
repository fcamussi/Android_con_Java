package com.example.practica7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etURL;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etURL = findViewById(R.id.et_url);
        preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        etURL.setText(preferences.getString("url", ""));
    }

    public void onClickIraURL(View view) {
        Intent i = new Intent(this, SegundoActivity.class);
        i.putExtra("url", etURL.getText().toString());
        startActivity(i);
    }

    public void onClickGuardar(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("url", etURL.getText().toString());
        editor.commit();
    }

}