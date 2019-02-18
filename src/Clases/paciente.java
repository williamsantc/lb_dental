package Clases;

public class paciente {

    private int pers_id;
    private String paci_direccion;

    public paciente(int pers_id, String paci_direccion) {
        this.pers_id = pers_id;
        this.paci_direccion = paci_direccion;
    }

    public paciente() {
    }

    public int getpers_id() {
        return this.pers_id;
    }

    public void setpers_id(int pers_id) {
        this.pers_id = pers_id;
    }

    public String getpaci_direccion() {
        return this.paci_direccion;
    }

    public void setpaci_direccion(String paci_direccion) {
        this.paci_direccion = paci_direccion;
    }

}
