package com.example.editordetexto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        String fichero = etFichero.getText().toString();
        try {
            String texto = "";
            InputStreamReader isr = new InputStreamReader(openFileInput(fichero));
            BufferedReader br = new BufferedReader(isr);
            String linea = br.readLine();
            while(linea != null) {
                texto = texto + linea + "\n";
                linea = br.readLine();
            }
            br.close();
            isr.close();
            etTexto.setText(texto);
        } catch(IOException e) {
            Toast.makeText(this, "Error abriendo " + fichero, Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickGuardar(View view) {
        String fichero = etFichero.getText().toString();
        try {
            OutputStreamWriter osw = new OutputStreamWriter(openFileOutput(fichero, Activity.MODE_PRIVATE));
            osw.write(etTexto.getText().toString());
            osw.close();
            Toast.makeText(this, fichero + " guardado", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error guardando " + fichero, Toast.LENGTH_SHORT).show();
        }
    }

}