package Clases;

public class incidenciacita {

    private int inci_id;
    private int cita_id;
    private String inci_observaciones;

    public incidenciacita(int inci_id, int cita_id, String inci_observaciones) {
        this.inci_id = inci_id;
        this.cita_id = cita_id;
        this.inci_observaciones = inci_observaciones;
    }

    public incidenciacita() {
    }

    public int getinci_id() {
        return this.inci_id;
    }

    public void setinci_id(int inci_id) {
        this.inci_id = inci_id;
    }

    public int getcita_id() {
        return this.cita_id;
    }

    public void setcita_id(int cita_id) {
        this.cita_id = cita_id;
    }

    public String getinci_observaciones() {
        return this.inci_observaciones;
    }

    public void setinci_observaciones(String inci_observaciones) {
        this.inci_observaciones = inci_observaciones;
    }

}
