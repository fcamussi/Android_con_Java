package com.example.productos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etCodigo, etDesc, etPrecio;
    AdminSQLiteOpenHelper admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admin = new AdminSQLiteOpenHelper(this, "BD", null, 1);
        etCodigo = findViewById(R.id.txt_codigo);
        etDesc = findViewById(R.id.txt_desc);
        etPrecio = findViewById(R.id.txt_precio);
    }

    public void onCreateRegistrar(View view) {
        String codigo = etCodigo.getText().toString();
        String desc = etDesc.getText().toString();
        String precio = etPrecio.getText().toString();
        if (!codigo.isEmpty() && !desc.isEmpty() && !precio.isEmpty()) {
            SQLiteDatabase BD = admin.getWritableDatabase(); // Abre la base de datos
            ContentValues registro = new ContentValues();
            registro.put("CODIGO", codigo);
            registro.put("DESCRIPCION", desc);
            registro.put("PRECIO", precio);
            long res = BD.insert("PRODUCTOS", null, registro);
            BD.close();
            if (res >= 0) {
                etCodigo.setText("");
                etDesc.setText("");
                etPrecio.setText("");
                Toast.makeText(this, "Producto registrado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El producto ya existe", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Faltan campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void onCreateConsultar(View view) {
        String codigo = etCodigo.getText().toString();
        if (!codigo.isEmpty()) {
            SQLiteDatabase BD = admin.getReadableDatabase();
            Cursor cursor = BD.rawQuery(
                    "SELECT DESCRIPCION,PRECIO FROM PRODUCTOS WHERE CODIGO=" + codigo,null);
            if (cursor.moveToFirst()) {
                etDesc.setText(cursor.getString(0));
                etPrecio.setText(cursor.getString(1));
            } else {
                Toast.makeText(this, "No existe el producto", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
            BD.close();
        } else {
            Toast.makeText(this, "Falta código", Toast.LENGTH_SHORT).show();
        }
    }

    public void onCreateModificar(View view) {
        String codigo = etCodigo.getText().toString();
        String desc = etDesc.getText().toString();
        String precio = etPrecio.getText().toString();
        if (!codigo.isEmpty() && !desc.isEmpty() && !precio.isEmpty()) {
            SQLiteDatabase BD = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("CODIGO", codigo);
            registro.put("DESCRIPCION", desc);
            registro.put("PRECIO", precio);
            int n = BD.update("PRODUCTOS", registro, "CODIGO=" + codigo, null);
            BD.close();
            if (n > 0) {
                Toast.makeText(this, "Producto modificado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No existe el producto", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Faltan campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void onCreateEliminar(View view) {
        String codigo = etCodigo.getText().toString();
        if (!codigo.isEmpty()) {
            SQLiteDatabase BD = admin.getWritableDatabase();
            int n = BD.delete("PRODUCTOS", "CODIGO == " + codigo, null);
            BD.close();
            if (n > 0) {
                etCodigo.setText("");
                etDesc.setText("");
                etPrecio.setText("");
                Toast.makeText(this, "Producto eliminado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No existe el producto", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Falta código", Toast.LENGTH_SHORT).show();
        }
    }

}