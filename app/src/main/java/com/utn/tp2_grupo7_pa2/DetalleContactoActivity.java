package com.utn.tp2_grupo7_pa2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

        Bundle prevBundle = getIntent().getExtras();

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
                ObjectOutputStream objOutput = new ObjectOutputStream(openFileOutput(archivo, MODE_PRIVATE));

                Contacto con = new Contacto();
                con.setIdentificación("1234");
                con.setApellidos(prevBundle.getString("apellido"));
                con.setNombre(prevBundle.getString("nombre"));
                con.setDireccion(prevBundle.getString("direccion"));
                con.setEmail(prevBundle.getString("email"));

                int radioButtonID = rgEstudios.getCheckedRadioButtonId();
                if(radioButtonID == -1)
                    Toast.makeText(v.getContext(), "Seleccione un estudio", Toast.LENGTH_SHORT).show();
                else {
                    RadioButton radioButton = (RadioButton) rgEstudios.findViewById(radioButtonID);
                    String estudiosText = (String) radioButton.getText();
                    con.setEstudios(estudiosText);
                }
                ArrayList<String> intereses = new ArrayList<String>();
                if(cbArte.isChecked())
                    intereses.add(cbArte.getText().toString());
                if(cbDeporte.isChecked())
                    intereses.add(cbDeporte.getText().toString());
                if(cbMusica.isChecked())
                    intereses.add(cbMusica.getText().toString());
                if(cbTecnologia.isChecked())
                    intereses.add(cbTecnologia.getText().toString());
                con.setIntereses(intereses);
                try {
                    con.setFechaNacimiento(new SimpleDateFormat("dd/MM/yyyy").parse(prevBundle.getString("fechanac")));
                } catch(Exception e) {
                    Toast.makeText(v.getContext(), "Fecha inválida", Toast.LENGTH_SHORT).show();
                }
                con.setTelefono(prevBundle.getString("telefono"));
                con.setRecibirInfo(switchRecibirInfo.isChecked());
                objOutput.writeObject(con);
                Toast.makeText(v.getContext(), "Guardado con exito", Toast.LENGTH_SHORT).show();
                objOutput.close();
            }catch (IOException e){
                Toast.makeText(v.getContext(), "Error al guardar el archivo", Toast.LENGTH_SHORT).show();
            }

            finish();
        });
    }
}