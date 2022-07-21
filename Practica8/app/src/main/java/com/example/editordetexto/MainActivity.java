package com.example.editordetexto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        }

        etFichero = findViewById(R.id.et_fichero);
        etTexto = findViewById(R.id.et_texto);
        cbSD = findViewById(R.id.cb_sd);
    }

    public void onClickCargar(View view) {
        String fichero = etFichero.getText().toString();
        FileInputStream fis;

        try {
            if (cbSD.isChecked()) {
                String rutaSD = Environment.getExternalStorageDirectory().getPath();
                fis = new FileInputStream(new File(rutaSD, fichero));
            } else {
                fis = openFileInput(fichero);
            }
            String texto = "";
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String linea = br.readLine();
            while(linea != null) {
                texto = texto + linea + "\n";
                linea = br.readLine();
            }
            br.close();
            isr.close();
            etTexto.setText(texto);
        } catch(Exception e) {
            Toast.makeText(this, "Error abriendo " + fichero, Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickGuardar(View view) {
        String fichero = etFichero.getText().toString();
        FileOutputStream fos;

        try {
            if (cbSD.isChecked()) {
                String rutaSD = Environment.getExternalStorageDirectory().getPath();
                fos = new FileOutputStream(new File(rutaSD, fichero));
            } else {
                fos = openFileOutput(fichero, Activity.MODE_PRIVATE);
            }
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(etTexto.getText().toString());
            osw.close();
            Toast.makeText(this, fichero + " guardado", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error guardando " + fichero, Toast.LENGTH_SHORT).show();
        }
    }

}