package com.example.practica11;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class ProductoCursorAdapter extends CursorAdapter {

    public ProductoCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    TextView tvCodigo;
    TextView tvDesc;
    TextView tvPrecio;

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_producto, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        tvCodigo = view.findViewById(R.id.tvCodigo);
        tvDesc = view.findViewById(R.id.tvDesc);
        tvPrecio = view.findViewById(R.id.tvPrecio);
        String codigo = cursor.getString(cursor.getColumnIndexOrThrow("CODIGO"));
        String desc = cursor.getString(cursor.getColumnIndexOrThrow("DESCRIPCION"));
        String precio = cursor.getString(cursor.getColumnIndexOrThrow("PRECIO"));
        tvCodigo.setText(codigo);
        tvDesc.setText(desc);
        tvPrecio.setText(precio);
    }

}
