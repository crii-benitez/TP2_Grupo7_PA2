package com.utn.tp2_grupo7_pa2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class DetalleContactoActivity extends AppCompatActivity {
    RadioGroup rgEstudios;
    RadioButton rbPrimarioIncompleto, rbPrimarioCompleto, rbSecundarioIncompleto, rbSecundarioCompleto, rbOtros;
    CheckBox cbDeporte, cbMusica, cbArte, cbTecnologia;
    Switch switchRecibirInfo;
    Button btnGuardar;
    private String archivo = "persona.obj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);


        rgEstudios = (RadioGroup) findViewById(R.id.rgEstudios);
        rbPrimarioIncompleto = (RadioButton) findViewById(R.id.rbPrimarioIncompleto);
        rbPrimarioCompleto = (RadioButton) findViewById(R.id.rbPrimarioCompleto);
        rbSecundarioIncompleto = (RadioButton) findViewById(R.id.rbSecundarioInCompleto);
        rbSecundarioCompleto = (RadioButton) findViewById(R.id.rbSecundarioCompleto);
        rbOtros = (RadioButton) findViewById(R.id.rbOtros);

        cbDeporte = (CheckBox) findViewById(R.id.cbDeporte);
        cbMusica = (CheckBox) findViewById(R.id.cbMusica);
        cbArte = (CheckBox) findViewById(R.id.cbArte);
        cbTecnologia = (CheckBox) findViewById(R.id.cbTecnologia);

        switchRecibirInfo = (Switch) findViewById(R.id.swtichInfoSi);

        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(v -> {

            try{
                String[] interest = {"Musica"};
                Date d3 = new Date(2010, 1, 3);
                ObjectOutputStream objOutput = new ObjectOutputStream(openFileOutput(archivo, MODE_PRIVATE));
                objOutput.writeObject(new Contacto("3456","Juan", "Gómez","112112312","sdas@gmail.com","calle falsa 123", d3,"Secundarios", interest ,true));
                Toast.makeText(v.getContext(), "Guardado con exito", Toast.LENGTH_SHORT).show();
                objOutput.close();
            }catch (IOException e){
                Toast.makeText(v.getContext(), "Error al guardar el archivo", Toast.LENGTH_SHORT).show();
            }

            finish();
        });
    }
}