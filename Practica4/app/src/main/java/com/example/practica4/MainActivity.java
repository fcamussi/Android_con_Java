package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNumero1, txtNumero2;
    Spinner spinner;
    Button button;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumero1 = findViewById(R.id.txt_numero1);
        txtNumero2 = findViewById(R.id.txt_numero2);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        txtResultado = findViewById(R.id.txt_resultado);

        String [] operaciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.custom_spinner_item, operaciones);
        spinner.setAdapter(adapter);
    }

    public void buttonOnClick(View view) {
        int numero1 = Integer.parseInt(txtNumero1.getText().toString());
        int numero2 = Integer.parseInt(txtNumero2.getText().toString());
        String operacion = spinner.getSelectedItem().toString();
        switch (operacion) {
            case "Sumar":
                txtResultado.setText(String.valueOf(numero1 + numero2));
                break;
            case "Restar":
                txtResultado.setText(String.valueOf(numero1 - numero2));
                break;
            case "Multiplicar":
                txtResultado.setText(String.valueOf(numero1 * numero2));
                break;
            case "Dividir":
                if (numero2 != 0) {
                    txtResultado.setText(String.valueOf(numero1 / numero2));
                } else {
                    Toast.makeText(this, "No se puede dividir por 0", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}