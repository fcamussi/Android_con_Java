package com.example.practica11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private EditText etCodigo;
    private EditText etDesc;
    private EditText etPrecio;
    private ProductoCursorAdapter adapter;
    AdminSQLiteOpenHelper admin;
    SQLiteDatabase BD;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        etCodigo = findViewById(R.id.etCodigo);
        etDesc = findViewById(R.id.etDesc);
        etPrecio = findViewById(R.id.etPrecio);

        admin = new AdminSQLiteOpenHelper(this, "BD", null, 1);
        BD = admin.getWritableDatabase();
        actualizarCursor();
        adapter = new ProductoCursorAdapter(this, cursor);
        lv.setAdapter(adapter);
    }

    public void actualizarCursor() {
        cursor = BD.rawQuery("SELECT * FROM PRODUCTOS", null);
        if (adapter != null) {
            adapter.changeCursor(cursor);
        }
    }

    public void onClickAgregar(View view) {
        String codigo = etCodigo.getText().toString();
        String desc = etDesc.getText().toString();
        String precio = etPrecio.getText().toString();
        if (!codigo.isEmpty() && !desc.isEmpty() && !precio.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("CODIGO", codigo);
            registro.put("DESCRIPCION", desc);
            registro.put("PRECIO", precio);
            long res = BD.insert("PRODUCTOS", null, registro);
            actualizarCursor();

            if (res > 0) {
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