package com.example.practica15;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setText("MiServicio detenido");
    }

    public void onClickIniciar(View view) {
        Intent intent = new Intent(this, MiServicio.class);
        startService(intent);
        textView.setText("MiServicio iniciado");
    }

    public void onClickDetener(View view) {
        Intent intent = new Intent(this, MiServicio.class);
        stopService(intent);
        textView.setText("MiServicio detenido");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MiServicio", "onDestroy activity");
    }

}