package com.example.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private EditText et;
    private ListView lv;
    private ArrayList<String> colores;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        et = findViewById(R.id.et);
        lv = findViewById(R.id.lv);
        colores = new ArrayList<>();

        adapter = new ArrayAdapter<>(this,
                R.layout.custom_list_item, colores);
        lv.setAdapter(adapter);
        adapter.add("Rojo");
        adapter.add("Verde");
        adapter.add("Azul");

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(lv.getItemAtPosition(i).toString());
            }
        });
    }

    public void onClickAgregar(View view) {
        adapter.add(et.getText().toString());
    }

}