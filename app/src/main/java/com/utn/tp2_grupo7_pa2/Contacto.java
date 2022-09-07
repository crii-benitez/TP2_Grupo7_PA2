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
    private String fechaNacimiento;
    private String estudios;
    private List<String> intereses ;
    private boolean recibirInfo;

    public Contacto() {}

    public Contacto(String nombre, String apellido, String email, String direccion, String fechaNacimiento)
    {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.email = email;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
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

    public String toCSV(){
        return nombre + ";" +
                apellidos + ";" +
                email + ";" +
                direccion + ";" +
                fechaNacimiento + ";\n";
    }

    public String getHeaderCSV(){
        return "nombre;apellidos;email;direccion;fechaNacimiento;\n";
    }

    public static Contacto fromCsvToClass(String CSV){
        String values [] = CSV.split(";");
        return new Contacto(values[0], values[1], values[2], values[3], values[4]);
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " - " + email;
    }
}
