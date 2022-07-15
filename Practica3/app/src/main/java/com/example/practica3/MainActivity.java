package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    CheckBox[] cb = new CheckBox[4];
    Button marcarTodo, desmarcarTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb[0] = findViewById(R.id.cb_norte);
        cb[1] = findViewById(R.id.cb_sur);
        cb[2] = findViewById(R.id.cb_este);
        cb[3] = findViewById(R.id.cb_oeste);
    }

    public void onClickMarcarTodo(View view) {
        for (CheckBox x: cb) {
            x.setChecked(true);
        }
    }

    public void onClickDesmarcarTodo(View view) {
        for (CheckBox x: cb) {
            x.setChecked(false);
        }
    }
}