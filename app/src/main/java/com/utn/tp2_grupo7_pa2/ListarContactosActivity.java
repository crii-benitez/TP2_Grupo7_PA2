package com.utn.tp2_grupo7_pa2;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ListarContactosActivity extends AppCompatActivity {

    private final static String FileName = "contactos.txt";
    private ListView lvContacto;
    private String archivo = "persona.obj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listar_contactos);
        lvContacto = findViewById(R.id.lvContacto);

        Almacenamiento almacenamiento = new Almacenamiento();
        String archivos [] = fileList();

        ArrayList<Contacto> contactoList = new ArrayList<Contacto>();

        if(almacenamiento.ArchivoExiste(archivos, FileName)){
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput(FileName));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();

                while(linea != null){
                    contactoList.add(Contacto.fromCsvToClass(linea));
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
            }catch (IOException e){
                Toast.makeText(this, "Ocurrió un error al leer los contactos.", Toast.LENGTH_SHORT).show();
            }
        }

        SetLisView(contactoList);
    }

    public void SetLisView(ArrayList<Contacto> contactoList)
    {
        // Recibe una lista de contactos y la setea en el listview.
        ArrayAdapter<Contacto> arrayAdapter = new ArrayAdapter<Contacto>(this, android.R.layout.simple_list_item_1, contactoList);
        lvContacto.setAdapter(arrayAdapter);
    }
}
