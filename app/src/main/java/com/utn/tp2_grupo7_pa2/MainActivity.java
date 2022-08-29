package com.utn.tp2_grupo7_pa2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //mostrar u ocultar menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
    }

    //asigna funciones a las opciones del menu
    public boolean onOptionsItemSelected(MenuItem item){
        int idOpcion = item.getItemId();

        if(idOpcion == R.id.it_agregar){
            //Toast.makeText(this,"agregar",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Listar",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void agregarContacto(View view){
        Intent agregarContacto = new Intent(this, AgregarContactoActivity.class);
        startActivity(agregarContacto);
    }
}