package Clases;

import CRUD.CRUD_paciente;
import CRUD.CRUD_persona;
import java.sql.Date;

public class cita {

    private int cita_id;
    private int pers_idpaciente;
    private int pers_iddoctor;
    private String cita_hora;
    private Date cita_fechaingreso;
    private Date cita_fechagenerada;

    public cita(int cita_id, int pers_idpaciente, int pers_iddoctor, String cita_hora, Date cita_fechaingreso, Date cita_fechagenerada) {
        this.cita_id = cita_id;
        this.pers_idpaciente = pers_idpaciente;
        this.pers_iddoctor = pers_iddoctor;
        this.cita_hora = cita_hora;
        this.cita_fechaingreso = cita_fechaingreso;
        this.cita_fechagenerada = cita_fechagenerada;
    }

    public cita() {
    }

    public int getcita_id() {
        return this.cita_id;
    }

    public void setcita_id(int cita_id) {
        this.cita_id = cita_id;
    }

    public int getpers_idpaciente() {
        return this.pers_idpaciente;
    }

    public void setpers_idpaciente(int pers_idpaciente) {
        this.pers_idpaciente = pers_idpaciente;
    }

    public int getpers_iddoctor() {
        return this.pers_iddoctor;
    }

    public void setpers_iddoctor(int pers_iddoctor) {
        this.pers_iddoctor = pers_iddoctor;
    }

    public String getcita_hora() {
        return this.cita_hora;
    }

    public void setcita_hora(String cita_hora) {
        this.cita_hora = cita_hora;
    }

    public Date getcita_fechaingreso() {
        return this.cita_fechaingreso;
    }

    public void setcita_fechaingreso(Date cita_fechaingreso) {
        this.cita_fechaingreso = cita_fechaingreso;
    }

    public Date getcita_fechagenerada() {
        return this.cita_fechagenerada;
    }

    public void setcita_fechagenerada(Date cita_fechagenerada) {
        this.cita_fechagenerada = cita_fechagenerada;
    }

}
