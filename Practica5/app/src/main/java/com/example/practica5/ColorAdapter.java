package com.example.practica5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ColorAdapter extends ArrayAdapter<Color> {

    public ColorAdapter(Context context, ArrayList<Color> colores) {
        super(context, 0, colores);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Color color = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_color, parent, false);
        }
        TextView tvColor = convertView.findViewById(R.id.tvColor);
        tvColor.setText(color.getColor());
        return convertView;
    }

}
