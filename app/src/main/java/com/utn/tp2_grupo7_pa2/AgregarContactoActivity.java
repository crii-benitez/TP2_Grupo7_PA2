package com.utn.tp2_grupo7_pa2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AgregarContactoActivity extends AppCompatActivity {

    Button btnContinuar;
    EditText etNombre, etApellido, etTelefono, etEmail, etDireccion, etFechaNac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);

        btnContinuar = findViewById(R.id.btnContinuar);
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDireccion = findViewById(R.id.etDireccion);
        etFechaNac = findViewById(R.id.etFechaNac);

        btnContinuar.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetalleContactoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("nombre", etNombre.getText().toString());
            bundle.putString("apellido", etApellido.getText().toString());
            bundle.putString("telefono", etTelefono.getText().toString());
            bundle.putString("email", etEmail.getText().toString());
            bundle.putString("direccion", etDireccion.getText().toString());
            bundle.putString("fechanac", etFechaNac.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        });
    }
}