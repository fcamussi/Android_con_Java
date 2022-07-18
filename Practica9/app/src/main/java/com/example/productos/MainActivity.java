package com.example.productos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etCodigo, etDesc, etPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCodigo = findViewById(R.id.txt_codigo);
        etDesc = findViewById(R.id.txt_desc);
        etPrecio = findViewById(R.id.txt_precio);
    }

    public void onCreateRegistrar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Productos",
                null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();
        String codigo = etCodigo.getText().toString();
        String desc = etDesc.getText().toString();
        String precio = etPrecio.getText().toString();
        if (!codigo.isEmpty() && !desc.isEmpty() && !precio.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("CODIGO", codigo);
            registro.put("DESCRIPCION", desc);
            registro.put("PRECIO", precio);
            BD.insert("PRODUCTOS", null, registro);
            BD.close();
            etCodigo.setText("");
            etDesc.setText("");
            etPrecio.setText("");
            Toast.makeText(this, "Producto registrado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Faltan campos", Toast.LENGTH_SHORT).show();
        }
    }

}