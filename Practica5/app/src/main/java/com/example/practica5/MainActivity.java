package com.example.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private EditText et;
    private ListView lv;
    private ArrayList<Color> colores;
    private ColorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        et = findViewById(R.id.et);
        lv = findViewById(R.id.lv);

        colores = new ArrayList<>();
        adapter = new ColorAdapter(this, colores);
        lv.setAdapter(adapter);
        adapter.add(new Color("Rojo"));
        adapter.add(new Color("Verde"));
        adapter.add(new Color("Azul"));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(colores.get(i).getColor());
            }
        });
    }

    public void onClickAgregar(View view) {
        if (et.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese un color", Toast.LENGTH_SHORT).show();
        } else {
            Color color = new Color(et.getText().toString());
            adapter.add(color);
            et.setText("");
        }
    }

}