package com.example.practica14;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton1(View view) {
        Dialog dialog = new Dialog(view.getContext());
        dialog.setContentView(R.layout.popup);
        TextView textView = dialog.findViewById(R.id.textView);
        textView.setText(getString(R.string.message));
        dialog.show();
    }

    public void onClickButton2(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Hola! Soy otro popup");
        alertDialogBuilder.setIcon(android.R.drawable.sym_action_chat);
        alertDialogBuilder.setTitle("Popup");
        alertDialogBuilder.setNegativeButton("ok", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}