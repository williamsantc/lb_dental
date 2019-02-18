/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Clases.Metodos;
import Clases.Tabla;
import Conexion.conexion;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class QuertyReflect {

    private conexion cn = new conexion();
    private DefaultTableModel modelo;

    public boolean Eliminar(Object objeto, int cod) {
        cn = new conexion();
        PreparedStatement insert = null;
        Object[] campos = Tabla.sacar_campos(objeto);
        try {
            boolean registro = false;
            String statement = "DELETE FROM " + objeto.getClass().getSimpleName() + " WHERE " + campos[0] + "=?";
            System.out.println(statement);
            insert = cn.getConnection().prepareStatement(statement);
            insert.setInt(1, cod);
            int r = insert.executeUpdate();
            if (r != 0) {
                registro = true;
            } else {
                registro = false;
            }
            return registro;
        } catch (Exception ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(insert);
        }
    }

    public boolean Eliminar(String querty) {
        System.out.println(querty);
        cn = new conexion();
        PreparedStatement insert = null;
        try {
            boolean registro = false;
            String statement = querty;
            insert = cn.getConnection().prepareStatement(statement);
            int r = insert.executeUpdate();
            if (r != 0) {
                registro = true;
            } else {
                registro = false;
            }
            return registro;
        } catch (Exception ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(insert);
        }
    }

    public ArrayList consultar(String consulta) {
        cn = new conexion();
        PreparedStatement pt = null;
        ResultSet rs = null;
        ResultSetMetaData rsm = null;
        ArrayList<String> Dat = new ArrayList<>();
        ArrayList Table = new ArrayList<>();

        try {
            pt = cn.getConnection().prepareStatement(consulta);
            rs = pt.executeQuery();
            rsm = rs.getMetaData();
            while (rs.next()) {
                Dat.clear();
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    Dat.add(rs.getString(i));
                }
                ArrayList<String> Dat2 = new ArrayList<>();
                for (int i = 0; i < Dat.size(); i++) {
                    Dat2.add(Dat.get(i));
                }
                Table.add(Dat2);
            }
            System.err.println(Table.size());
            return Table;
        } catch (SQLException ex) {
            Logger.getLogger(QuertyReflect.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cn.desconectar();
            cn.cerrarStatement(pt);
        }
        return null;
    }

    public boolean Modificar(String querty) {
        cn = new conexion();
        ResultSetMetaData rsm = null;
        PreparedStatement list = null;
        ResultSet rs = null;
        boolean registro = false;
        try {
            list = cn.getConnection().prepareStatement(querty);
            int r = list.executeUpdate();
            if (r != 0) {
                registro = true;
            } else {
                registro = false;
            }
            return registro;
        } catch (Exception e) {
            return false;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);
        }
    }

    public boolean Modificar(Object objeto) {
        cn = new conexion();
        PreparedStatement insert = null;
        int c = 0;
        Object[] campos = Tabla.sacar_campos(objeto);
        Object[] valores = Tabla.ObtenerFila(objeto);
        if (objeto.getClass().getSimpleName().equalsIgnoreCase("cliente")) {
            c = 1;
        }
        try {
            boolean registro = false;
            String statement = "UPDATE " + objeto.getClass().getSimpleName() + " SET ";
            for (int i = 1; i < campos.length - c; i++) {
                statement += campos[i] + "=?";

                if (i != campos.length - 1 - c) {
                    statement += ", ";
                }
            }
            statement += " WHERE " + campos[0] + " = " + valores[0];
            insert = cn.getConnection().prepareStatement(statement);

            for (int i = 1; i < campos.length - c; i++) {
                System.out.println(valores[i].getClass().getSimpleName());
                if (Metodos.esNumero(String.valueOf(valores[i]))) {
                    insert.setInt(i, Integer.parseInt(String.valueOf(valores[i])));
                } else if (valores[i].getClass().getSimpleName().equalsIgnoreCase("date")) {
                    insert.setDate(i, (Date) valores[i]);
                } else {
                    insert.setString(i, String.valueOf(valores[i]));
                }
            }
            System.out.println(insert);
            int r = insert.executeUpdate();
            if (r != 0) {
                registro = true;
            } else {
                registro = false;
            }
            return registro;
        } catch (Exception ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(insert);
        }
    }

    public boolean Registrar(Object objeto) {
        cn = new conexion();
        PreparedStatement insert = null;
        Object[] campos = Tabla.sacar_campos(objeto);
        Object[] valores = Tabla.ObtenerFila(objeto);
        try {
            boolean registro = false;
            String statement = "INSERT INTO " + objeto.getClass().getSimpleName() + "(";

            for (int i = 0; i < campos.length; i++) {
                if (i == 0 && Metodos.esNumero(String.valueOf(valores[i])) && Integer.parseInt(String.valueOf(valores[i])) == -1) {
                    continue;
                }
                statement += String.valueOf(campos[i]);

                if (i != campos.length - 1) {
                    statement += ", ";
                }
            }

            statement += ") VALUES (";

            for (int i = 0; i < campos.length; i++) {
                if (i == 0 && Metodos.esNumero(String.valueOf(valores[i])) && Integer.parseInt(String.valueOf(valores[i])) == -1) {
                    continue;
                }
                statement += " ?";

                if (i != campos.length - 1) {
                    statement += ", ";
                }
            }
            statement += ")";
            System.out.println(statement);
            int sumarPos = 0;
            insert = cn.getConnection().prepareStatement(statement);

            for (int i = 0; i < campos.length; i++) {
                if (i == 0 && Metodos.esNumero(String.valueOf(valores[i])) && Integer.parseInt(String.valueOf(valores[i])) == -1) {
                    sumarPos += -1;
                    continue;
                }
                System.out.println(valores[i]);
                if (Metodos.esNumero(String.valueOf(valores[i]))) {
                    insert.setInt(i + 1 + sumarPos, Integer.parseInt(String.valueOf(valores[i])));
                } else if (valores[i].getClass().getSimpleName().equalsIgnoreCase("date")) {
                    insert.setDate(i + 1 + sumarPos, (Date) valores[i]);
                } else if (String.valueOf(valores[i]).equalsIgnoreCase("true") || String.valueOf(valores[i]).equalsIgnoreCase("false")) {
                    insert.setBoolean(i + 1 + sumarPos, Boolean.valueOf(String.valueOf(valores[i])));
                } else {
                    insert.setString(i + 1 + sumarPos, String.valueOf(valores[i]));
                }
            }
            int r = insert.executeUpdate();
            if (r != 0) {
                registro = true;
            } else {
                registro = false;
            }
            return registro;
        } catch (Exception ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(insert);
        }
    }

    public DefaultTableModel llenarModelo(String querty) {
        cn = new conexion();
        ResultSetMetaData rsm = null;
        PreparedStatement list = null;
        ResultSet rs = null;
        try {
            list = cn.getConnection().prepareStatement(querty);
            rs = list.executeQuery();
            rsm = list.getMetaData();
            Object[] campos = new Object[rsm.getColumnCount()];
            for (int i = 1; i <= campos.length; i++) {
                campos[i - 1] = rsm.getColumnName(i);
            }
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);
            return Tabla.llenarModelo(campos);
        } catch (Exception e) {
            return null;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);
        }
    }

    public String generarComboHTML(String querty, String obj) {
        System.out.println(querty);
        cn = new conexion();
        ResultSetMetaData rsm = null;
        PreparedStatement list = null;
        ResultSet rs = null;
        try {
            list = cn.getConnection().prepareStatement(querty);
            rs = list.executeQuery();
            rsm = list.getMetaData();
            Object[] campos = new Object[rsm.getColumnCount()];
            String cod_combo = "<label class=\"white\">" + obj + "</label> \n"
                    + "<select class=\"form-control\" id=\"" + rsm.getColumnName(1) + "\" name=\"" + rsm.getColumnName(1) + "\" required>\n";
            while (rs.next()) {
                if (obj.equalsIgnoreCase("estudiantes")) {
                    cod_combo += "<option value=\"" + rs.getString(1) + "\">" + rs.getString(1) + " " + rs.getString(3) + " " + rs.getString(4) + "</option>\n";
                } else {
                    cod_combo += "<option value=\"" + rs.getString(1) + "\">" + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + "</option>\n";
                }
            }
            cod_combo += "</select>";
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);
            return cod_combo;
        } catch (Exception e) {
            return null;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);
        }
    }

    public String generarTablaHtml(String querty, Object obj) {
        System.out.println(querty);
        cn = new conexion();
        ResultSetMetaData rsm = null;
        PreparedStatement list = null;
        ResultSet rs = null;
        String cod_tabla = "<table id=\"" + obj.getClass().getSimpleName() + "\" class=\"table table-hover table-mc-light-blue\">" + "<thead>" + "<tr>\n";
        try {
            list = cn.getConnection().prepareStatement(querty);
            rs = list.executeQuery();
            rsm = list.getMetaData();
            Object[] campos = new Object[rsm.getColumnCount()];
            for (int i = 1; i <= campos.length; i++) {
                cod_tabla += "<th>" + rsm.getColumnName(i) + "</th>\n";
            }
            if (!obj.getClass().getSimpleName().equalsIgnoreCase("administrador")) {
                cod_tabla += "<th class=\"text-right\">Acciones</th>";
            }

            cod_tabla += "</tr> " + "</thead> <tbody>";
            if (!rs.next()) {
                cod_tabla += "<h3 align=\"center\"> No hay registros. </h3>";
                cod_tabla += "</tbody> </table>";
            }
            while (rs.next()) {
                cod_tabla += "<tr>\n";
                for (int i = 1; i <= rsm.getColumnCount(); i++) {

                    if (rsm.getColumnName(i).equals("genero_cli") || rsm.getColumnName(i).equals("genero_act") || rsm.getColumnName(i).equals("genero_dir")) {
                        if (rs.getInt(i) == 1) {
                            cod_tabla += "<td id=\"" + rsm.getColumnName(i) + "_table\">" + "Masculino" + "</td>\n";
                        } else {
                            cod_tabla += "<td id=\"" + rsm.getColumnName(i) + "_table\">" + "Femenino" + "</td>\n";
                        }
                    } else if (rsm.getColumnType(i) == 91) {
                        java.util.Date fecha = Metodos.obtenerFecha(rs.getString(i));
                        cod_tabla += "<td id=\"" + rsm.getColumnName(i) + "_table\">" + Metodos.obtenerFecha(fecha) + "</td>\n";
                    } else {
                        cod_tabla += "<td id=\"" + rsm.getColumnName(i) + "_table\">" + rs.getString(i) + "</td>\n";
                    }
                }
                if (!obj.getClass().getSimpleName().equalsIgnoreCase("administrador")) {
                    cod_tabla += "<td class=\"td-actions text-right\">\n"
                            + "                <button type=\"button\" rel=\"tooltip\" id=\"modify\" title=\"Editar\" onclick=\"editar();\" class=\"btn btn-success btn-simple btn-xs\">\n"
                            + "                    <i class=\"fa fa-edit\"></i>\n"
                            + "                </button>\n"
                            + "            </td>";
                }
                cod_tabla += "</tr>";
            }
            cod_tabla += "</tbody> </table>";
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);
            return cod_tabla;
        } catch (Exception e) {
            return null;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);
        }
    }

    public ArrayList<String> ListarCombos(String querty) {
        cn = new conexion();
        ResultSetMetaData rsm = null;
        PreparedStatement list = null;
        ArrayList<String> datos = new ArrayList<>();
        ResultSet rs = null;
        try {
            list = cn.getConnection().prepareStatement(querty);
            rs = list.executeQuery();
            rsm = list.getMetaData();

            while (rs.next()) {
                datos.add(rs.getString(1));
            }
            return datos;
        } catch (Exception e) {
            return datos;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);
        }
    }

    public boolean existe(String querty) {
        cn = new conexion();
        ResultSetMetaData rsm = null;
        PreparedStatement list = null;
        ArrayList<String> datos = new ArrayList<>();
        ResultSet rs = null;
        try {
            list = cn.getConnection().prepareStatement(querty);
            rs = list.executeQuery();
            rsm = list.getMetaData();

            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);
        }
        return false;
    }

    public ArrayList ListarL(String querty, Object ob) {
        System.out.println(querty);
        cn = new conexion();
        PreparedStatement list = null;
        ResultSet rs = null;

        Object[] campos = Tabla.sacar_campos(ob);
        ArrayList<Object> lista = new ArrayList();
        try {

            list = cn.getConnection().prepareStatement(querty);
            rs = list.executeQuery();
            while (rs.next()) {
                Object obj = ob.getClass().newInstance();
                for (int i = 0; i < campos.length; i++) {
                    String nCam = (String) campos[i];
                    if (rs.getObject(i + 1).getClass().getSimpleName().equalsIgnoreCase("BigDecimal")) {
                        Tabla.ingresarInfo(obj, rs.getInt(i + 1), nCam);
                    } else {
                        Tabla.ingresarInfo(obj, rs.getObject(i + 1), nCam);
                    }
                }
                lista.add(obj);
            }

            return lista;
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
            return lista;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);

        }
    }

    public int Consultar_Existencia(String querty) {
        cn = new conexion();
        ResultSetMetaData rsm = null;
        PreparedStatement list = null;
        ResultSet rs = null;
        try {
            list = cn.getConnection().prepareStatement(querty);
            rs = list.executeQuery();
            rsm = list.getMetaData();
            ArrayList<String> datos = new ArrayList<>();
            while (rs.next()) {
                datos.add(rs.getString(1));
            }
            return Integer.parseInt(datos.get(0));
        } catch (Exception e) {
            return -1;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);
        }
    }

    public JComboBox ListarCombos(String querty, JComboBox combo) {
        cn = new conexion();
        ResultSetMetaData rsm = null;
        PreparedStatement list = null;
        ResultSet rs = null;
        try {
            System.out.println(querty);
            list = cn.getConnection().prepareStatement(querty);
            rs = list.executeQuery();
            rsm = list.getMetaData();
            while (rs.next()) {
                combo.addItem(rs.getString(1) + " " + rs.getString(2));
            }
            return combo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);
        }
    }

    public void Listar(DefaultTableModel model, String querty) {
        cn = new conexion();
        ResultSetMetaData rsm = null;
        PreparedStatement list = null;
        ResultSet rs = null;
        try {
            list = cn.getConnection().prepareStatement(querty);
            rs = list.executeQuery();
            rsm = list.getMetaData();
            Object[] datos = new Object[rsm.getColumnCount()];
            while (rs.next()) {
                for (int i = 1; i <= datos.length; i++) {
                    datos[i - 1] = rs.getString(i);
                }
                int fila = model.getRowCount();
                model.insertRow(fila, datos);
            }
        } catch (Exception e) {
        } finally {
            cn.desconectar();
            cn.cerrarStatement(list);
            cn.cerrarResultSet(rs);
        }
    }
}
