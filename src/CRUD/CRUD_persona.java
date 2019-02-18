package CRUD;

import Clases.*;
import java.util.ArrayList;

public class CRUD_persona {

    QuertyReflect QR = new QuertyReflect();

    public boolean registro(persona obj) {
        return QR.Registrar(obj);
    }

    public int buscarIdPorDocumento(String documento) {
        ArrayList<persona> lista = this.listarObject();
        for (persona object : lista) {
            if (documento.equalsIgnoreCase(object.getpers_documento())) {
                return object.getpers_id();
            }
        }
        return -1;
    }

    public boolean existePersona(String documento) {
        ArrayList<persona> listaPersonas = this.listarObject();
        for (persona persona : listaPersonas) {
            if (persona.getpers_documento().equalsIgnoreCase(documento)) {
                return true;
            }
        }
        return false;
    }

    public boolean modificar(persona obj) {
        return QR.Modificar(obj);
    }

    public boolean eliminar(int id) {
        return QR.Eliminar(new persona(), id);
    }

    public ArrayList<persona> listarObject() {
        return (ArrayList<persona>) QR.ListarL("select * from persona order by pers_id", new persona());
    }
}
