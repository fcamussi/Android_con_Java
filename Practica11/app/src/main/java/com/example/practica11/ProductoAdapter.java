package com.example.practica11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ProductoAdapter extends ArrayAdapter<Producto> {

    public ProductoAdapter(Context context, ArrayList<Producto> productos) {
        super(context, 0, productos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Producto producto = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_producto, parent, false);
        }
        TextView tvCodigo = convertView.findViewById(R.id.tvCodigo);
        TextView tvDesc = convertView.findViewById(R.id.tvDesc);
        TextView tvPrecio = convertView.findViewById(R.id.tvPrecio);
        tvCodigo.setText(String.valueOf(producto.getCodigo()));
        tvDesc.setText(producto.getDesc());
        tvPrecio.setText(String.valueOf(producto.getPrecio()));
        return convertView;
    }

}
