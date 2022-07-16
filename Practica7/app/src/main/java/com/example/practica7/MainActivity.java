package com.example.practica7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValor = findViewById(R.id.et_valor);
    }

    public void onClickSiguiente(View view) {
        Intent i = new Intent(this, SegundoActivity.class);
        i.putExtra("valor", etValor.getText().toString());
        startActivity(i);
    }

}