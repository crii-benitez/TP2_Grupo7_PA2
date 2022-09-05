package com.utn.tp2_grupo7_pa2;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ListarContactosActivity extends AppCompatActivity {

    Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contactos);

        btnContinuar = findViewById(R.id.btnListar);

        btnContinuar.setOnClickListener(v -> {

        });
    }
}
