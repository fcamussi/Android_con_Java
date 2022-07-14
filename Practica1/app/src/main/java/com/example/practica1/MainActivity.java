package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtNum1, txtNum2;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum1 = findViewById(R.id.txt_num1);
        txtNum2 = findViewById(R.id.txt_num2);
        txtResultado = findViewById(R.id.txt_resultado);
    }

    public void Sumar(View view) {
        String num1 = txtNum1.getText().toString();
        String num2 = txtNum2.getText().toString();
        int resultado = Integer.parseInt(num1) + Integer.parseInt(num2);
        txtResultado.setText(String.valueOf(resultado));
    }
}