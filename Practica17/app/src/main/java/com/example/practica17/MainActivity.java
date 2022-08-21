package com.example.practica17;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private ArrayList<HomeComputer> homeComputers;
    private HomeComputerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        homeComputers = new ArrayList<>();
        adapter = new HomeComputerAdapter(this, homeComputers);
        lv.setAdapter(adapter);
        adapter.add(new HomeComputer("Spectravideo", "SVI-728"));
        adapter.add(new HomeComputer("Spectravideo", "SVI-738"));
        adapter.add(new HomeComputer("Talent", "DPC-200"));
        adapter.add(new HomeComputer("Talent", "TPC-310"));
        adapter.add(new HomeComputer("Commodore", "64"));
        adapter.add(new HomeComputer("Commodore", "128"));
        adapter.add(new HomeComputer("Czerweny", "Spectrum"));

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setActivated(!view.isActivated());
                return true;
            }
        });
    }

}