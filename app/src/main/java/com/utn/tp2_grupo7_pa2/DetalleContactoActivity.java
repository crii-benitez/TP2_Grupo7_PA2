package com.utn.tp2_grupo7_pa2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DetalleContactoActivity extends AppCompatActivity {
    private final static String FileName = "contactos.txt";
    RadioGroup rgEstudios;
    RadioButton rbPrimarioIncompleto, rbPrimarioCompleto, rbSecundarioIncompleto, rbSecundarioCompleto, rbOtros;
    CheckBox cbDeporte, cbMusica, cbArte, cbTecnologia;
    Switch switchRecibirInfo;
    Button btnGuardar;

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

            Contacto contacto = GetContacto(v);

            if (contacto == null)
            {
                Toast.makeText(this, "Complete todos los campos del formulario para continuar.", Toast.LENGTH_SHORT).show();
            }
            else
            {

                Almacenamiento almacenamiento = new Almacenamiento();
                String archivos [] = fileList();
                if(!almacenamiento.ArchivoExiste(archivos, FileName)){
                    try {
                        OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(FileName, Activity.MODE_PRIVATE));
                        archivo.write(contacto.toCSV());
                        archivo.flush();
                        archivo.close();
                    }catch (IOException e){

                    }
                }
                else{
                    try {
                        OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(FileName, Activity.MODE_APPEND));
                        archivo.append(contacto.toCSV());
                        archivo.flush();
                        archivo.close();
                        Toast.makeText(this, "Contacto guardado correctamente", Toast.LENGTH_SHORT).show();
                    }catch (IOException e){
                        Toast.makeText(this, "El contacto no se pudo guardar correctamente", Toast.LENGTH_SHORT).show();
                    }
                }
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
                this.finish();
            }
        });
    }

    public Contacto GetContacto(View v)
    {
        Bundle prevBundle = getIntent().getExtras();

        Contacto con = new Contacto();
        con.setIdentificación("1234");
        con.setApellidos(prevBundle.getString("apellido"));
        con.setNombre(prevBundle.getString("nombre"));
        con.setDireccion(prevBundle.getString("direccion"));
        con.setEmail(prevBundle.getString("email"));

        int radioButtonID = rgEstudios.getCheckedRadioButtonId();
        if (radioButtonID == -1)
        {
            Toast.makeText(v.getContext(), "Seleccione un estudio", Toast.LENGTH_SHORT).show();
            return null;
        }
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
        con.setTelefono(prevBundle.getString("telefono"));
        con.setRecibirInfo(switchRecibirInfo.isChecked());

        return con;
    }
}