/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jframe;

import CRUD.CRUD_cita;
import CRUD.CRUD_paciente;
import CRUD.CRUD_persona;
import Clases.paciente;
import Clases.persona;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class test {

    public static void main(String[] args) {
        CRUD_persona perCRUD = new CRUD_persona();
        ArrayList<persona> lista = perCRUD.listarObject();

        persona persona = new persona(-1, "123456", "cualquier", "cosa", "6867", "g@f.com");

        if (perCRUD.registro(persona)) {

            lista = perCRUD.listarObject();

            int idPersona = perCRUD.buscarIdPorDocumento("123456");

            paciente paciente = new paciente(idPersona, "calle ciega");
            
            CRUD_paciente paciCRUD = new CRUD_paciente();
            
            
            if(paciCRUD.registro(paciente)) {
                System.out.println("registro exitosoo de persona y paciente!!");
            }
        }

    }

}
