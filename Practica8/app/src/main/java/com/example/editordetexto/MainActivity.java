package com.example.editordetexto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText etFichero;
    private EditText etTexto;
    private CheckBox cbSD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFichero = findViewById(R.id.et_fichero);
        etTexto = findViewById(R.id.et_texto);
        cbSD = findViewById(R.id.cb_sd);
    }

    public void onClickCargar(View view) {
        Toast.makeText(this, "HOLA", Toast.LENGTH_SHORT);
    }

    public void onClickGuardar(View view) {
        String fichero = etFichero.getText().toString();
        try {
            OutputStreamWriter osw = new OutputStreamWriter(openFileOutput(fichero, Activity.MODE_PRIVATE));
            osw.write(etTexto.getText().toString());
            osw.flush();
            osw.close();
        } catch (IOException e) {
        }
        Toast.makeText(this, "Fichero " + fichero + " guardado", Toast.LENGTH_SHORT);
    }

}