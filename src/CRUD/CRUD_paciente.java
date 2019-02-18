package CRUD;

import Clases.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUD_paciente {

    QuertyReflect QR = new QuertyReflect();

    public boolean registro(paciente obj) {
        return QR.Registrar(obj);
    }

    public boolean modificar(paciente obj) {
        return QR.Modificar(obj);
    }

    public boolean eliminar(int id) {
        return QR.Eliminar(new paciente(), id);
    }

    public boolean esPaciente(String documento) {
        return QR.existe("select * from persona pers join paciente paci on (paci.pers_id = pers.pers_id) where pers.pers_documento = '" + documento + "'");
    }

    public ArrayList<paciente> listarObject() {
        return (ArrayList<paciente>) QR.ListarL("select * from paciente order by pers_id", new paciente());
    }

    public JComboBox listarCombo(JComboBox combo) {
        return QR.ListarCombos("select pers.pers_documento, pers.pers_nombre||' '||pers.pers_apellido from persona pers join paciente paci on (paci.pers_id = pers.pers_id)", combo);
    }

    public void listarTable(JTable table) {
        table.setModel(QR.llenarModelo("SELECT \n"
                + "pers.pers_documento DOCUMENTO, \n"
                + "pers.pers_nombre NOMBRE, \n"
                + "pers.pers_apellido APELLIDO, \n"
                + "pers.pers_telefono TELEFONO,\n"
                + "pers.pers_correo CORREO,\n"
                + "paci.paci_direccion DIRECCION\n"
                + "FROM persona pers\n"
                + "join paciente paci on (paci.pers_id = pers.pers_id)"));
        QR.Listar((DefaultTableModel) table.getModel(), "SELECT \n"
                + "pers.pers_documento DOCUMENTO, \n"
                + "pers.pers_nombre NOMBRE, \n"
                + "pers.pers_apellido APELLIDO, \n"
                + "pers.pers_telefono TELEFONO,\n"
                + "pers.pers_correo CORREO,\n"
                + "paci.paci_direccion DIRECCION\n"
                + "FROM persona pers\n"
                + "join paciente paci on (paci.pers_id = pers.pers_id)");
    }
}
