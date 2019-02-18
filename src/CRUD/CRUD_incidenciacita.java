package CRUD;

import Clases.*;
import java.util.ArrayList;

public class CRUD_incidenciacita {

    QuertyReflect QR = new QuertyReflect();

    public boolean registro(incidenciacita obj) {
        return QR.Registrar(obj);
    }

    public boolean modificar(incidenciacita obj) {
        return QR.Modificar(obj);
    }

    public boolean eliminar(int id) {
        return QR.Eliminar(new incidenciacita(), id);
    }

    public ArrayList<incidenciacita> listarObject() {
        return (ArrayList<incidenciacita>) QR.ListarL("select * from incidenciacita order by inci_id", new incidenciacita());
    }
}
