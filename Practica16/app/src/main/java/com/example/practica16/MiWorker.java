package com.example.practica16;

import android.content.Context;

import androidx.work.Worker;
import androidx.work.WorkerParameters;


public class MiWorker extends Worker {

    public MiWorker(Context context, WorkerParameters params) {
        super(context, params);
    }

    @Override
    public Result doWork() {
        NumeroAleatorio.generar();
        return Result.success();
    }

}
