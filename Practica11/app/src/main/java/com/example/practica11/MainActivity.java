package com.example.practica11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private EditText etCodigo;
    private EditText etDesc;
    private EditText etPrecio;
    private ArrayList<Producto> productos;
    private ProductoAdapter adapter;
    AdminSQLiteOpenHelper admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        etCodigo = findViewById(R.id.etCodigo);
        etDesc = findViewById(R.id.etDesc);
        etPrecio = findViewById(R.id.etPrecio);

        productos = new ArrayList<>();
        adapter = new ProductoAdapter(this, productos);
        lv.setAdapter(adapter);
        adapter.add(new Producto("1", "Teclado USB", "33.50"));
        adapter.add(new Producto("2", "Mouse USB", "20.00"));
        adapter.add(new Producto("3", "Pendrive 32GB", "25.50"));
    }

    public void onClickAgregar(View view) {
        String codigo = etCodigo.getText().toString();
        String desc = etDesc.getText().toString();
        String precio = etPrecio.getText().toString();
        if (!codigo.isEmpty() && !desc.isEmpty() && !precio.isEmpty()) {
            Producto producto = new Producto(codigo, desc, precio);
/*
            SQLiteDatabase BD = admin.getWritableDatabase(); // Abre la base de datos
            ContentValues registro = new ContentValues();
            registro.put("CODIGO", codigo);
            registro.put("DESCRIPCION", desc);
            registro.put("PRECIO", precio);
            long res = BD.insert("PRODUCTOS", null, registro);
            BD.close();
 */
            adapter.add(producto);
            if (true) {
                etCodigo.setText("");
                etDesc.setText("");
                etPrecio.setText("");
                Toast.makeText(this, "Producto agregado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El producto ya existe", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Faltan campos", Toast.LENGTH_SHORT).show();
        }
    }

}