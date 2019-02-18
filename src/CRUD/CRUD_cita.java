package CRUD;

import Clases.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUD_cita {

    QuertyReflect QR = new QuertyReflect();

    public boolean registro(cita obj) {
        return QR.Registrar(obj);
    }

    public boolean modificar(cita obj) {
        return QR.Modificar(obj);
    }

    public boolean eliminar(int id) {
        return QR.Eliminar(new cita(), id);
    }

    public ArrayList<cita> listarObject() {
        return (ArrayList<cita>) QR.ListarL("select * from cita order by cita_id", new cita());
    }

    public JComboBox listarCombo(JComboBox combo) {
        return QR.ListarCombos("select 'Doctor: '||pedo.pers_nombre, 'Paciente: '||pepa.pers_nombre from cita cita\n"
                + "join persona pepa on (pepa.pers_id = cita.pers_idpaciente)\n"
                + "join persona pedo on (pedo.pers_id = cita.pers_iddoctor)", combo);
    }

    public void listarTable(JTable table) {
        table.setModel(QR.llenarModelo("select \n"
                + "pepa.pers_nombre||' '||pepa.pers_apellido paciente,\n"
                + "pedo.pers_nombre||' '||pedo.pers_apellido doctor,\n"
                + "cita.cita_hora hora,\n"
                + "cita.cita_fechagenerada fecha\n"
                + "from cita cita\n"
                + "join persona pepa on (pepa.pers_id = cita.pers_idpaciente)\n"
                + "join persona pedo on (pedo.pers_id = cita.pers_iddoctor)"));
        QR.Listar((DefaultTableModel) table.getModel(), "select \n"
                + "pepa.pers_nombre||' '||pepa.pers_apellido paciente,\n"
                + "pedo.pers_nombre||' '||pedo.pers_apellido doctor,\n"
                + "cita.cita_hora hora,\n"
                + "cita.cita_fechagenerada fecha\n"
                + "from cita cita\n"
                + "join persona pepa on (pepa.pers_id = cita.pers_idpaciente)\n"
                + "join persona pedo on (pedo.pers_id = cita.pers_iddoctor)");
    }

    public void listarCitaFiltrada(JTable tabla, java.util.Date fecha) {
        tabla.setModel(QR.llenarModelo("select \n"
                + "pepa.pers_nombre||' '||pepa.pers_apellido paciente,\n"
                + "pedo.pers_nombre||' '||pedo.pers_apellido doctor,\n"
                + "cita.cita_hora hora,\n"
                + "cita.cita_fechagenerada fecha\n"
                + "from cita cita\n"
                + "join persona pepa on (pepa.pers_id = cita.pers_idpaciente)\n"
                + "join persona pedo on (pedo.pers_id = cita.pers_iddoctor)"));
        QR.Listar((DefaultTableModel) tabla.getModel(), "select \n"
                + "pepa.pers_nombre||' '||pepa.pers_apellido paciente,\n"
                + "pedo.pers_nombre||' '||pedo.pers_apellido doctor,\n"
                + "cita.cita_hora hora,\n"
                + "cita.cita_fechagenerada fecha\n"
                + "from cita cita\n"
                + "join persona pepa on (pepa.pers_id = cita.pers_idpaciente)\n"
                + "join persona pedo on (pedo.pers_id = cita.pers_iddoctor)\n"
                + "where cita.cita_fechagenerada = '" + Metodos.obtenerFechaSQL(fecha) + "'");
    }
}
