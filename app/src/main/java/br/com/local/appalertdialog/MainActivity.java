package br.com.local.appalertdialog;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAlertDialog, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnSair = findViewById(R.id.btnSair);

        btnAlertDialog.setOnClickListener(this);
        btnSair.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnAlertDialog:
                mostrarAlerta();
                break;
            case R.id.btnSair:
                finish();
                break;
        }

    }

    public void mostrarAlerta() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja abrir outra janela?")
                .setIcon(R.drawable.outline_info)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(getApplicationContext(), Resposta_Activity.class);

                        //putextra()

                        startActivity(intent);

                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        respostaNegativa();

                    }
                });
        builder.create();
        builder.show();

    }

    public void respostaNegativa(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater  inflater = getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.modelo_alertdialog,null))
                .setPositiveButton("Signin", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),
                                "Cliquei em entrar",
                                Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create();
        builder.show();

    }

}