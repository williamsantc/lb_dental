package Clases;

public class persona {

    private int pers_id;
    private String pers_documento;
    private String pers_nombre;
    private String pers_apellido;
    private String pers_telefono;
    private String pers_correo;

    public persona(int pers_id, String pers_documento, String pers_nombre, String pers_apellido, String pers_telefono, String pers_correo) {
        this.pers_id = pers_id;
        this.pers_documento = pers_documento;
        this.pers_nombre = pers_nombre;
        this.pers_apellido = pers_apellido;
        this.pers_telefono = pers_telefono;
        this.pers_correo = pers_correo;
    }

    public persona() {
    }

    public int getpers_id() {
        return this.pers_id;
    }

    public void setpers_id(int pers_id) {
        this.pers_id = pers_id;
    }

    public String getpers_documento() {
        return this.pers_documento;
    }

    public void setpers_documento(String pers_documento) {
        this.pers_documento = pers_documento;
    }

    public String getpers_nombre() {
        return this.pers_nombre;
    }

    public void setpers_nombre(String pers_nombre) {
        this.pers_nombre = pers_nombre;
    }

    public String getpers_apellido() {
        return this.pers_apellido;
    }

    public void setpers_apellido(String pers_apellido) {
        this.pers_apellido = pers_apellido;
    }

    public String getpers_telefono() {
        return this.pers_telefono;
    }

    public void setpers_telefono(String pers_telefono) {
        this.pers_telefono = pers_telefono;
    }

    public String getpers_correo() {
        return this.pers_correo;
    }

    public void setpers_correo(String pers_correo) {
        this.pers_correo = pers_correo;
    }

}
