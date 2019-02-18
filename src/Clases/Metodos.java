/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class Metodos {

    public static void cambiar_icono_boton(JButton btn, String ruta) {
        ImageIcon icono = new ImageIcon(ruta);
        btn.setIcon(icono);
        btn.setText("Nuevo");
    }

    public static boolean solo_numeros(char caracter) {
        int val = (int) caracter;
        if ((caracter < '0' || caracter > '9')) {

            return false;
        }
        return true;
    }

    public static boolean esNumero(String val) {
        try {
            int x = Integer.parseInt(val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean esDate(String val) {
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("dd/mm/yyyy");
            Date fecha = formateador.parse(val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean Coma(char caracter) {
        int val = (int) caracter;
        if (val == 44) {
            return true;
        }
        return false;
    }

    public static String obtenerFecha(Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(fecha);
    }
    
    public static String obtenerFechaSQL(Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(fecha);
    }

    public static Date obtenerFecha(String fecha) {
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
            Date f = formateador.parse(fecha);
            return f;
        } catch (ParseException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Date obtenerFecha_org(String fecha) {
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            Date f = formateador.parse(fecha);
            return f;
        } catch (ParseException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void generar_archivo(String nombre_archivo, String cadena) {
        FileWriter fw = null;
        try {

            File f = new File(nombre_archivo);
            fw = new FileWriter(f);
            fw.write(cadena);
            fw.close();
        } catch (IOException ex) {
//            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
//                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void abrirArchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static int obtenerMeses(Date Finicio, Date Ffinal) {

        Object[] fec = obtenerFecha(Finicio).split("/");
        Object[] fec2 = obtenerFecha(Ffinal).split("/");

        int dFini = Integer.parseInt(fec[0].toString());
        int dFfin = Integer.parseInt(fec2[0].toString());

        int cant = Integer.parseInt(fec2[1].toString()) - Integer.parseInt(fec[1].toString());
        if (dFfin < dFini) {
            cant -= 1;
        }
        return cant;
    }
//
//    public static int obtenerDias2(Date Finicio, Date Ffinal) {
//        Object[] fec = obtenerFecha(Finicio).split("/");
//        Object[] fec2 = obtenerFecha(Ffinal).split("/");
//
//        System.out.println(obtenerDias(Finicio, sumarRestarMeses(Ffinal, -1)) + "--" + obtenerDias(Finicio, Ffinal));
//        int dias = obtenerDias(Finicio, Ffinal);
//
//        int cant = Integer.parseInt(fec2[0].toString()) - Integer.parseInt(fec[0].toString());
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(Ffinal);
//        dias = cal.get(Calendar.DAY_OF_MONTH) - Integer.parseInt(fec[0].toString());
//        int meses = Integer.parseInt(fec2[1].toString()) - Integer.parseInt(fec[1].toString());
//        if (dias < 0) {
//            dias = obtenerDias(sumarRestarMeses(Ffinal, -1), Ffinal) - 1;
//        }
//        return dias;
//    }

    public static int obtenerAños(Date Finicio, Date Ffinal) {
        Object[] fec = obtenerFecha(Finicio).split("/");
        Object[] fec2 = obtenerFecha(Ffinal).split("/");
        int cant = Integer.parseInt(fec2[2].toString()) - Integer.parseInt(fec[2].toString());
        return cant;
    }

    public static int obtenerDias(Date Finicio, Date Ffinal) {
        long fIni = Finicio.getTime();
        long fFin = Ffinal.getTime();

        long diferencia = fFin - fIni;

        int dias = (int) Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return dias;
    }

    public static final int getMonthsDifference(Date date1, Date date2) {
        int m1 = date1.getYear() * 12 + (date1.getMonth() + 1);
        int m2 = date2.getYear() * 12 + (date2.getMonth() + 1);
        System.out.println("m1:" + m1);
        System.out.println("m2:" + m2);
        System.out.println(" m2 - m1 + 1:" + (m2 - m1));

        return m2 - m1;
    }

    public static FileInputStream CargaFileInputStream(String ruta) {
        FileInputStream foto = null;
        try {
            if (ruta.trim().isEmpty()) {
                String rutas = new File("").getAbsolutePath() + "\\Files\\FOTO.png";
                foto = new FileInputStream(rutas);

            } else {
                foto = new FileInputStream(ruta.trim());

            }
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Metodos.getName()).log(Level.SEVERE, null, ex);
            System.err.println("error clase metodos : " + ex.getMessage());

        }
        return foto;
    }

    public static String GetRutaArchivo(int tipofiltro) {
        //Creamos nuestra variable archivo en la cual podremos usar todos los metodos de la clase jFileChooser
        JFileChooser archivo = new JFileChooser();
        //Si deseamos crear filtros para la selecion de archivos
        FileNameExtensionFilter filtro = null;
        if (tipofiltro == 1) {
            filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg", "jpeg");
        }
//Si deseas que se muestre primero los filtros usa la linea q esta abajo de esta.
        // Agregamos el Filtro pero cuidado se mostrara despues de todos los archivos
        archivo.addChoosableFileFilter(filtro);
        // Colocamos titulo a nuestra ventana de Seleccion
        archivo.setDialogTitle("Abrir Archivo");
        //Si deseamos que muestre una carpeta predetermina usa la siguiente linea
//////        File ruta = new File("C:\\Users\\usuario\\Pictures");
        //Le implementamos a nuestro ventana de seleccion
//////        archivo.setCurrentDirectory(ruta);
        //Abrimos nuestra Ventana de Selccion
        int ventana = archivo.showOpenDialog(null);
        //hacemos comparacion en caso de aprete el boton abrir
        String r = "";
        if (ventana == JFileChooser.APPROVE_OPTION) {
            //Obtenemos la ruta de nuestra imagen seleccionada
            File file = archivo.getSelectedFile();
            //Lo imprimimos en una caja de texto para ver su ruta
            r = String.valueOf(file);
        }
        return r.trim();
    }

    public static ImageIcon insertarImagen(String ruta) {
        //de cierto modo necesitamos tener la imagen para ello debemos conocer la ruta de dicha imagen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image foto = toolkit.getImage(ruta);
        //Le damos dimension a nuestro label que tendra la imagen
        foto = foto.getScaledInstance(125, 141, Image.SCALE_DEFAULT);
        //Imprimimos la imagen en el label
        return (new ImageIcon(foto));
    }

    public static int diferenciaFechas(Date Finicio, Date Ffinal, int valor) {
//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        int retorno = 0;
        java.util.Date date1 = null;
        java.util.Date date2 = null;
        Calendar cal1 = null;
        date1 = Finicio;
        cal1 = Calendar.getInstance();
        Calendar cal2 = null;
        date2 = Ffinal;
        cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        long ldate1 = date1.getTime() + cal1.get(Calendar.ZONE_OFFSET) + cal1.get(Calendar.DST_OFFSET);
        cal2.setTime(date2);
        long ldate2 = date2.getTime() + cal2.get(Calendar.ZONE_OFFSET) + cal2.get(Calendar.DST_OFFSET);
        int hr1 = (int) (ldate1 / 3600000);
        int hr2 = (int) (ldate2 / 3600000);
        int days1 = (int) hr1 / 24;
        int days2 = (int) hr2 / 24;
        int dateDiff = days2 - days1;
        int yearDiff = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
        int monthDiff = yearDiff * 12 + cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);

        if (valor == 1) {//Dias
            if (dateDiff < 0) {
                dateDiff = dateDiff * (-1);
            }
            retorno = dateDiff;
        } else if (valor == 2) {//meses
            if (monthDiff < 0) {
                monthDiff = monthDiff * (-1);
            }
            retorno = monthDiff;
        } else if (valor == 3) {//años
            if (yearDiff < 0) {
                yearDiff = yearDiff * (-1);
            }
            retorno = yearDiff;
        }
        return retorno;
    }

    public static boolean validarCampoVacio(String cadenaCaracter) {
        return !cadenaCaracter.trim().isEmpty();
    }

    public static boolean validarDifCero(Double nombre) {
        return nombre > 0;
    }

    public static boolean validarDifcero(int nombre) {
        return nombre > 0;
    }
}
