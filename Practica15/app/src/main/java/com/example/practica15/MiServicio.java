package com.example.practica15;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MiServicio extends Service {

    String TAG = "MiServicio";
    static Thread thread;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        NumeroAleatorio.generar();
                        Log.d(TAG, thread + " número aleatorio generado: " + NumeroAleatorio.get());
                        Thread.sleep(1000);
                        if (Thread.currentThread().isInterrupted()) {
                            throw new InterruptedException();
                        }
                    }
                } catch (InterruptedException e) {
                    Log.d(TAG, thread + " INTERRUMPIDO!");
                }
            }
        };
        thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        thread.interrupt();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
