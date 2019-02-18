/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class Tabla {

    private static Object inf;
    private Field campo;

    public static Object[] ObtenerFila(Object q) {
        try {
            String nombre = q.getClass().getSimpleName();
            int c = 0;
            Class clase = q.getClass();
            Field campo, campos[];

            campos = clase.getDeclaredFields();

            if (nombre.equalsIgnoreCase("Jaula")) {
                c += 2;
            }
            ArrayList<Object> info = new ArrayList();
            for (int i = 0; i < campos.length - c; i++) {
                campos[i].setAccessible(true);
                String val = campos[i].getName();
                inf = sacarInfo(q, val);
                if (inf.getClass().getSimpleName().equalsIgnoreCase("Date")) {
                    info.add(inf);
                } else {
                    info.add(String.valueOf(sacarInfo(q, val)));

                }
            }

            return info.toArray();

        } catch (Exception ex) {
            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR CLASE: Tabla \n msj" + ex.getMessage());
        }
        return null;
    }

    public static Object[] sacar_campos(Object nombreClase) {
        try {

            Class clase = nombreClase.getClass();
            Field campo, campos[];
            campos = clase.getDeclaredFields();

            ArrayList<String> columna = new ArrayList<>();
            for (int i = 0; i < campos.length; i++) {
                campos[i].setAccessible(true);
                campo = campos[i];
                System.out.println("\t" + campo.getName());
                columna.add(campo.getName());
            }

            return columna.toArray();

        } catch (Exception ex) {
            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR CLASE: Tabla \n msj" + ex.getMessage());
        }
        return null;
    }

    public static DefaultTableModel llenarModelo(Object[] columns) {
        Object[][] rows = {};
        DefaultTableModel modelo = new DefaultTableModel(rows, columns);
        return modelo;
    }

    public static void insertaFilaModelo(DefaultTableModel modelo, Object[] datos) {
        int fila = modelo.getRowCount();
        modelo.insertRow(fila, datos);
    }

    public static void eliminarFilaModelo(DefaultTableModel modelo, int row) {
        modelo.removeRow(row);
    }

    private static Object sacarInfo(Object origen, String camp) {
        try {
            Field campo;
            campo = origen.getClass().getDeclaredField(camp);
            campo.setAccessible(true);
            return campo.get(origen);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Object ingresarInfo(Object origen, Object valor, String camp) {
        try {
            Field campo;
            campo = origen.getClass().getDeclaredField(camp);
            campo.setAccessible(true);
            campo.set(origen, valor);
            return campo.get(origen);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
