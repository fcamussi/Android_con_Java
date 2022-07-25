package com.example.practica12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<Persona> personaList;

    public RecyclerAdapter(ArrayList<Persona> personaList) {
        this.personaList = personaList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre, tvLocalidad, tvPais;

        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), personaList.get(getAdapterPosition()).getNombre(), Toast.LENGTH_SHORT).show();
                }
            });
            tvNombre = view.findViewById(R.id.tvNombre);
            tvLocalidad = view.findViewById(R.id.tvLocalidad);
            tvPais = view.findViewById(R.id.tvPais);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String nombre = personaList.get(position).getNombre();
        String localidad = personaList.get(position).getLocalidad();
        String pais = personaList.get(position).getPais();
        holder.tvNombre.setText(nombre);
        holder.tvLocalidad.setText(localidad);
        holder.tvPais.setText(pais);
    }

    @Override
    public int getItemCount() {
        return personaList.size();
    }
}
