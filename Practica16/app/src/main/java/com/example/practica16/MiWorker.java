package com.example.practica16;

import android.content.Context;
import android.content.Intent;

import androidx.work.Worker;
import androidx.work.WorkerParameters;


public class MiWorker extends Worker {

    public final static String NOTIFICATION = "com.example.practica16.MI_NOTIFICATION";

    public MiWorker(Context context, WorkerParameters params) {
        super(context, params);
    }

    @Override
    public Result doWork() {
        NumeroAleatorio.generar();
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra("data", String.valueOf(NumeroAleatorio.get()));
        intent.setPackage(getApplicationContext().getPackageName()); // para que solo ésta aplicación lo pueda recibir
        getApplicationContext().sendBroadcast(intent);
        return Result.success();
    }

}
