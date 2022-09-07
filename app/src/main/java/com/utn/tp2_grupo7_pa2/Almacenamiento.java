package com.utn.tp2_grupo7_pa2;

import java.util.ArrayList;

public class Almacenamiento
{
    private final static String FileName = "contactos.txt";

    public Almacenamiento()
    {
    }

    public static boolean ArchivoExiste(String archivos [], String NombreArchivo){
        for(int i = 0; i < archivos.length; i++)
            if(NombreArchivo.equals(archivos[i]))
                return true;
        return false;
    }
}
