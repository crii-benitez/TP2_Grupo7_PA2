package com.utn.tp2_grupo7_pa2;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ListarContactosActivity extends AppCompatActivity {

    Button btnContinuar;
    private ListView lvContacto;
    private String archivo = "persona.obj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listar_contactos);
        lvContacto = findViewById(R.id.lvContacto);
        try{
            ObjectInputStream objInput = new ObjectInputStream(openFileInput(archivo));
            Contacto contacto = (Contacto) objInput.readObject();
            objInput.close();

            //TODO: Deberiamos recorrer por medio de un foreach todos los contactos y agregarlos en el array contactoList:
            ArrayList<Contacto> contactoList = new ArrayList<Contacto>();
            contactoList.add(contacto);

            //TODO: Agrego un contacto para visualizar más de uno
            Contacto cont = new Contacto();
            cont.setNombre("Gabriel");
            cont.setApellidos("Robledo");
            cont.setEmail("gaby-2011@hotmail.com");
            contactoList.add(cont);

            // Llamo al metodo que se encarga de armar el ListView con todos los contactos.
            SetLisView(contactoList);

            Toast toast2 = Toast.makeText(getApplicationContext(), "Archivo cargado correctamente", Toast.LENGTH_SHORT);
            toast2.setGravity(Gravity.CENTER|Gravity.LEFT,0,0);
            toast2.show();
        }catch (IOException e){
            Toast.makeText(this, "Error al cargar el archivo", Toast.LENGTH_SHORT).show();
        }
        catch (ClassNotFoundException e){
            Log.e("MainActivity", "Error clase no encontrada");
        }
    }

    public void SetLisView(ArrayList<Contacto> contactoList)
    {
        // Recibe una lista de contactos y la setea en el listview.
        ArrayAdapter<Contacto> arrayAdapter = new ArrayAdapter<Contacto>(this, android.R.layout.simple_list_item_1, contactoList);
        lvContacto.setAdapter(arrayAdapter);
    }
}
