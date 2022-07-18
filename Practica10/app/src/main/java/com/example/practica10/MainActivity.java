package com.example.practica10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAnimal(View view) {
        String animal = getResources().getResourceEntryName(view.getId());
        Toast.makeText(this, "¡Es un " + animal + "!", Toast.LENGTH_LONG).show();
    }
}