package com.example.profesor.repaso;

/**
 * Created by profesor on 05/05/2016.
 */
public class Persona {
    public Persona(String nombre, String apellido, String numero, String imagen,byte[] datosDeLaImagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
        this.imagen = imagen;
        this.datosImagen= datosDeLaImagen;
    }

    private String nombre;
    private String apellido;
    private String numero;
    private String imagen;
    private byte[] datosImagen;

    public byte[] getDatosImagen() {
        return datosImagen;
    }

    public void setDatosImagen(byte[] datosDeImagen) {
        this.datosImagen = datosDeImagen;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
