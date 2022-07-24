package com.example.practica11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ProductoAdapter extends ArrayAdapter<Producto> {

    private static class ViewHolder {
        TextView tvCodigo;
        TextView tvDesc;
        TextView tvPrecio;
    }

    public ProductoAdapter(Context context, ArrayList<Producto> productos) {
        super(context, 0, productos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Producto producto = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_producto, parent, false);
            viewHolder.tvCodigo = convertView.findViewById(R.id.tvCodigo);
            viewHolder.tvDesc = convertView.findViewById(R.id.tvDesc);
            viewHolder.tvPrecio = convertView.findViewById(R.id.tvPrecio);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.tvCodigo.setText(String.valueOf(producto.getCodigo()));
        viewHolder.tvDesc.setText(producto.getDesc());
        viewHolder.tvPrecio.setText(String.valueOf(producto.getPrecio()));
        return convertView;
    }

}
