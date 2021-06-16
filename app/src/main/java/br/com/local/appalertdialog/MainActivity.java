package br.com.local.appalertdialog;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
        builder.setMessage("Deseja realmente sair?")
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

                        Toast.makeText(getApplicationContext(),
                                "Cliquei em não!!!",
                                Toast.LENGTH_SHORT).show();

                    }
                });
        builder.create();
        builder.show();

    }

}