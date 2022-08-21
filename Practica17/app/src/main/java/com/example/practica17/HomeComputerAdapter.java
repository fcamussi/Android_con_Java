package com.example.practica17;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class HomeComputerAdapter extends ArrayAdapter<HomeComputer> {

    public HomeComputerAdapter(Context context, ArrayList<HomeComputer> homeComputers) {
        super(context, 0, homeComputers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomeComputer homeComputer = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_homecomputer, parent, false);
        }
        TextView tvMarca = convertView.findViewById(R.id.tvMarca);
        TextView tvModelo = convertView.findViewById(R.id.tvModelo);
        tvMarca.setText(homeComputer.getMarca());
        tvModelo.setText(homeComputer.getModelo());
        return convertView;
    }

}
