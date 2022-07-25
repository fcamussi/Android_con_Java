package com.example.practica12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Persona> personaList;
    private RecyclerView recyclerView;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        personaList = new ArrayList<>();

        personaList.add(new Persona("Pedro", "Rosario", "Argentina"));
        personaList.add(new Persona("Pablo", "Capital Federal", "Argentina"));
        personaList.add(new Persona("Juan", "Montevideo", "Uruguay"));

        adapter = new RecyclerAdapter(personaList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        agregarPersona("Luis", "Brasilia", "Brasil");
    }

    void agregarPersona(String nombre, String localidad, String pais) {
        personaList.add(new Persona(nombre, localidad, pais));
        adapter.notifyItemInserted(personaList.size() - 1);
    }

}