package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSaludo = findViewById(R.id.txt_saludo);
    }

    public void onClick(View view) {
        RadioButton rb = (RadioButton)view;

        String saludo = null;
        int id = rb.getId();
        if (id == R.id.rb_manana) {
            saludo = "Buen día!";
        } else if (id == R.id.rb_tarde) {
            saludo = "Buenas tardes!";
        } else if (id == R.id.rb_noche) {
            saludo = "Buenas noches!";
        }
        txtSaludo.setText(saludo);
    }
}