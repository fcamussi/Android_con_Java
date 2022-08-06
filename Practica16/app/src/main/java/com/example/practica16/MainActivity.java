package com.example.practica16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;
    NumeroAleatorio numeroAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
    }

    public void iniciarTrabajoOnClick(View view) {
        WorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(MiWorker.class).build();
        WorkManager.getInstance(this).enqueue(uploadWorkRequest);
    }

    public void obtenerNumeroOnClick(View view) {
        tv2.setText(String.valueOf(NumeroAleatorio.get()));
    }

}