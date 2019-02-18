package Clases;

public class doctor {

    private int pers_id;
    private String doct_tarjeta;

    public doctor(int pers_id, String doct_tarjeta) {
        this.pers_id = pers_id;
        this.doct_tarjeta = doct_tarjeta;
    }

    public doctor() {
    }

    public int getpers_id() {
        return this.pers_id;
    }

    public void setpers_id(int pers_id) {
        this.pers_id = pers_id;
    }

    public String getdoct_tarjeta() {
        return this.doct_tarjeta;
    }

    public void setdoct_tarjeta(String doct_tarjeta) {
        this.doct_tarjeta = doct_tarjeta;
    }

}
