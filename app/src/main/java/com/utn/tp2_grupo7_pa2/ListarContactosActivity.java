package com.utn.tp2_grupo7_pa2;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ListarContactosActivity extends AppCompatActivity {

    Button btnContinuar;
    private TextView txtContenido;
    private String archivo = "persona.obj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listar_contactos);
        txtContenido = (TextView)findViewById(R.id.txtContenido);

        btnContinuar = findViewById(R.id.btnListar);

        btnContinuar.setOnClickListener(v -> {
            try{
                ObjectInputStream objInput = new ObjectInputStream(openFileInput(archivo));
                Contacto persona = (Contacto) objInput.readObject();
                objInput.close();
                txtContenido.setText(persona.toString());
                Toast toast2 = Toast.makeText(getApplicationContext(), "Archivo cargado correctamente", Toast.LENGTH_SHORT);
                toast2.setGravity(Gravity.CENTER|Gravity.LEFT,0,0);
                toast2.show();
            }catch (IOException e){
                txtContenido.setText("Error al cargar el archivo");
            }
            catch (ClassNotFoundException e){
                Log.e("MainActivity", "Error clase no encontrada");
            }

        });
    }
}
