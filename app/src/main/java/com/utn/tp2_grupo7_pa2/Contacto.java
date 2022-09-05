package com.utn.tp2_grupo7_pa2;
import java.io.Serializable;

public class Contacto implements Serializable {
    private String identificación;
    private String nombre;
    private String apellidos;

    public Contacto(String identificación, String nombre, String apellidos) {
        this.identificación = identificación;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getIdentificación() {
        return identificación;
    }

    public void setIdentificación(String identificación) {
        this.identificación = identificación;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Identificación: "+identificación+"\nNombre: "+nombre+" "+apellidos+"\n";
    }
}
