package com.example.practica16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    NumeroAleatorio numeroAleatorio;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, intent.getStringExtra("data"), Toast.LENGTH_LONG).show();
            }
        };
        IntentFilter filter = new IntentFilter(MiWorker.NOTIFICATION);
        this.registerReceiver(broadcastReceiver, filter);
    }

    public void iniciarTrabajoOnClick(View view) {
        WorkRequest MiWorkRequest = new OneTimeWorkRequest.Builder(MiWorker.class).build();
        WorkManager.getInstance(this).enqueue(MiWorkRequest);
    }

    public void obtenerNumeroOnClick(View view) {
        tv.setText(String.valueOf(NumeroAleatorio.get()));
    }

}