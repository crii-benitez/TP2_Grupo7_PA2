package com.utn.tp2_grupo7_pa2;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Contacto implements Serializable {
    private String identificación;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private String direccion;
    private Date fechaNacimiento;
    private String estudios;
    private List<String> intereses ;
    private boolean recibirInfo;

    public Contacto() {}

    public Contacto(String identificación, String nombre, String apellidos, String telefono, String email, String direccion, Date fechaNacimiento, String estudios, List<String> intereses, boolean recibirInfo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.estudios = estudios;
        this.intereses = intereses;
        this.recibirInfo = recibirInfo;
        this.identificación = identificación;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public List<String> getIntereses() {
        return intereses;
    }

    public void setIntereses(List<String> intereses) {
        this.intereses = intereses;
    }

    public boolean isRecibirInfo() {
        return recibirInfo;
    }

    public void setRecibirInfo(boolean recibirInfo) {
        this.recibirInfo = recibirInfo;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " - " + email;
    }
}
