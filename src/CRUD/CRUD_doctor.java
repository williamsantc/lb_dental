package CRUD;

import Clases.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUD_doctor {

    QuertyReflect QR = new QuertyReflect();

    public boolean registro(doctor obj) {
        return QR.Registrar(obj);
    }

    public boolean modificar(doctor obj) {
        return QR.Modificar(obj);
    }

    public boolean eliminar(int id) {
        return QR.Eliminar(new doctor(), id);
    }

    public boolean esDoctor(String documento) {
        return QR.existe("select * from persona pers join doctor doct on (doct.pers_id = pers.pers_id) where pers.pers_documento = '" + documento + "'");
    }

    public ArrayList<doctor> listarObject() {
        return (ArrayList<doctor>) QR.ListarL("select * from doctor order by pers_id", new doctor());
    }

    public JComboBox listarCombo(JComboBox combo) {
        return QR.ListarCombos("select pers.pers_documento, pers.pers_nombre||' '||pers.pers_apellido from persona pers join doctor doct on (doct.pers_id = pers.pers_id)", combo);
    }

    public void listarTable(JTable table) {
        table.setModel(QR.llenarModelo("SELECT \n"
                + "pers.pers_documento DOCUMENTO, \n"
                + "pers.pers_nombre NOMBRE, \n"
                + "pers.pers_apellido APELLIDO, \n"
                + "pers.pers_telefono TELEFONO,\n"
                + "pers.pers_correo CORREO,\n"
                + "doct.doct_tarjeta TARJETA\n"
                + "FROM persona pers\n"
                + "join doctor doct on (doct.pers_id = pers.pers_id)"));
        QR.Listar((DefaultTableModel) table.getModel(), "SELECT \n"
                + "pers.pers_documento DOCUMENTO, \n"
                + "pers.pers_nombre NOMBRE, \n"
                + "pers.pers_apellido APELLIDO, \n"
                + "pers.pers_telefono TELEFONO,\n"
                + "pers.pers_correo CORREO,\n"
                + "doct.doct_tarjeta TARJETA\n"
                + "FROM persona pers\n"
                + "join doctor doct on (doct.pers_id = pers.pers_id)");
    }
}
