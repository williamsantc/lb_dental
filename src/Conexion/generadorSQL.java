/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Freddy Jaimes Moificado por William santos
 */
public class generadorSQL {

    public static void main(String args[]) throws SQLException, IOException {
        generarVO();
        generarMetodos();
//        generarDAO();
//        generarServlets();
//        generarwebxml();
    }

    /*
     * Permite tomar la DataBase y construir de forma automatica los Values Object.
     */
    
    public static void generarMetodos() throws SQLException, IOException {
        conexion cn = new conexion();
        Statement stm = cn.getConnection().createStatement();
        String consultarTablas = "SELECT tablename FROM pg_tables WHERE schemaname = 'public'";
        ResultSet rs = stm.executeQuery(consultarTablas);
        while (rs.next()) {
            String tabla = rs.getString("tablename");
            File clase = new File("C:\\Users\\willi\\Documents\\NetbeansProjects\\LB_dental\\src\\CRUD", "CRUD_" + tabla + ".java");
            FileWriter escribirClase = new FileWriter(clase);

            String clasetxt = "import Class.*;\n\npublic class CRUD_" + tabla + " {\n \n";
            String atributos = "";

            String consultarTabla = "SELECT * FROM " + tabla;
            stm = cn.getConnection().createStatement();
            ResultSet rs1 = stm.executeQuery(consultarTabla);

            ResultSetMetaData rm = rs1.getMetaData();
            atributos = "QuertyReflect QR = new QuertyReflect();\n"
                    + "\n"
                    + "    public boolean registro(" + tabla + " obj) {\n"
                    + "        return QR.Registrar(obj);\n"
                    + "    }\n"
                    + "\n"
                    + "    public boolean modificar(" + tabla + " obj) {\n"
                    + "        return QR.Modificar(obj);\n"
                    + "    }\n"
                    + "\n"
                    + "    public boolean eliminar(int id) {\n"
                    + "        return QR.Eliminar(new " + tabla + "(), id);\n"
                    + "    }\n"
                    + "\n"
                    + "    public String listar() {\n"
                    + "        return QR.generarTablaHtml(\"select * from " + tabla + " order by " + rm.getColumnName(1) + "\", new "+tabla + "());\n"
                    + "    }";
            clasetxt = "package CRUD;\n\n" + clasetxt + atributos + "\n" + "}";
            escribirClase.write(clasetxt);
            escribirClase.close();
        }
    }
    
    public static void generarVO() throws SQLException, IOException {
        conexion cn = new conexion();
        Statement stm = cn.getConnection().createStatement();
        String consultarTablas = "SELECT tablename FROM pg_tables WHERE schemaname = 'public'";
        ResultSet rs = stm.executeQuery(consultarTablas);
        while (rs.next()) {
            String tabla = rs.getString("tablename");
            File clase = new File("C:\\Users\\willi\\Documents\\NetbeansProjects\\LB_dental\\src\\Clases", tabla + ".java");
            FileWriter escribirClase = new FileWriter(clase);

            String importaciones = "";
            String clasetxt = "\n\npublic class " + tabla +" {\n \n";
            String atributos = "";
            String metodos = "";

            String consultarTabla = "SELECT * FROM " + tabla;
            stm = cn.getConnection().createStatement();
            ResultSet rs1 = stm.executeQuery(consultarTabla);

            ResultSetMetaData rm = rs1.getMetaData();
            String constructor = "public " + tabla + "(";
            for (int i = 1; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                String tipoCampo = "";
                if (rm.getColumnTypeName(i).equals("text") || rm.getColumnTypeName(i).equals("varchar")) {
                    tipoCampo = "String";
                } else if (rm.getColumnTypeName(i).equals("date") || rm.getColumnTypeName(i).equals("timestamp")) {
                    tipoCampo = "Date";
                    if (importaciones.indexOf("sql.Date") == -1) {
                        importaciones = importaciones + "import java.sql.Date;\n";
                    }
                } else if (rm.getColumnTypeName(i).equals("time")) {
                    tipoCampo = "Time";
                    if (importaciones.indexOf("sql.Time") == -1) {
                        importaciones = importaciones + "import java.sql.Time;\n";
                    }
                } else if (rm.getColumnTypeName(i).equals("numeric") || rm.getColumnTypeName(i).equals("integer") || rm.getColumnTypeName(i).equals("serial") || rm.getColumnTypeName(i).equals("int4")) {
                    tipoCampo = "int";
                } else if (rm.getColumnTypeName(i).equals("bool")) {
                    tipoCampo = "boolean";
                }

                constructor += tipoCampo + " " + nombreCampo;
                if (i != rm.getColumnCount()) {
                    constructor += ", ";
                }

            }
            constructor += "){\n";

            String constVacio = "public " + tabla + "(){\n}";
            for (int i = 1; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                String tipoCampo = "";
                System.out.println(rm.getColumnTypeName(i));
                if (rm.getColumnTypeName(i).equals("text") || rm.getColumnTypeName(i).equals("varchar")) {
                    tipoCampo = "String";
                } else if (rm.getColumnTypeName(i).equals("date") || rm.getColumnTypeName(i).equals("timestamp")) {
                    tipoCampo = "Date";
                } else if (rm.getColumnTypeName(i).equals("time")) {
                    tipoCampo = "Time";
                } else if (rm.getColumnTypeName(i).equals("numeric") || rm.getColumnTypeName(i).equals("integer") || rm.getColumnTypeName(i).equals("serial") || rm.getColumnTypeName(i).equals("int4")) {
                    tipoCampo = "int";
                } else if (rm.getColumnTypeName(i).equals("bool")) {
                    tipoCampo = "boolean";
                }

                constructor += "\tthis." + nombreCampo + " = " + nombreCampo + ";\n";

                atributos = atributos + "\tprivate " + tipoCampo + " " + nombreCampo + ";\n";

                metodos = metodos + "\tpublic " + tipoCampo + " get" + nombreCampo + "() {\n"
                        + "\t\treturn this." + nombreCampo + ";\n\t}\n\n";

                metodos = metodos + "\tpublic void set" + nombreCampo + "(" + tipoCampo + " " + nombreCampo + ") {\n"
                        + "\t\tthis." + nombreCampo + "=" + nombreCampo + ";\n\t}\n\n";
            }
            constructor += "}\n";
            clasetxt = "package Class;\n" + importaciones + clasetxt + atributos + "\n" + constructor
                    + "\n" + constVacio + "\n" + metodos + "}";
            escribirClase.write(clasetxt);
            escribirClase.close();
        }
    }

    public static void generarDAO() throws SQLException, IOException {
        conexion cn = new conexion();
        Statement stm = cn.getConnection().createStatement();
        String consultarTablas = "SELECT tablename FROM pg_tables WHERE schemaname = 'public'";
        ResultSet rs = stm.executeQuery(consultarTablas);
        while (rs.next()) {
            String tabla = rs.getString("tablename");
            File clase = new File("C:\\Users\\Acer pc\\Documents\\NetBeansProjects\\PruebaScript\\src\\java\\DAO", tabla + "DAO" + ".java");
            FileWriter escribirClase = new FileWriter(clase);

            String importaciones = "import VO.*;\n"
                    + "import conexion.conexion;\n"
                    + "import java.sql.PreparedStatement;\n"
                    + "import java.sql.ResultSet;\n"
                    + "import java.util.LinkedList;\n"
                    + "import java.util.logging.Level;\n"
                    + "import java.util.logging.Logger;\n"
                    + "import java.sql.Date;\n";
            String clasetxt = "\n\npublic class " + tabla + "DAO" + " {\n \n";
            String atributos = "";
            String metodos = "";

            String consultarTabla = "SELECT * FROM " + tabla;
            stm = cn.getConnection().createStatement();
            ResultSet rs1 = stm.executeQuery(consultarTabla);
            ResultSetMetaData rm = rs1.getMetaData();
            System.out.println(rm.getColumnName(1));

            String listar = "public LinkedList Listar" + tabla + "() {\n"
                    + "        conexion cn = null;\n"
                    + "        PreparedStatement select = null;\n"
                    + "        ResultSet rs = null;\n"
                    + "        LinkedList datos = new LinkedList();\n"
                    + "        try {\n"
                    + "            cn = new conexion();\n"
                    + "        select = cn.getConnection().prepareStatement(\"SELECT * FROM public." + tabla + " ORDER BY " + rm.getColumnName(1) + " ASC;\");\n"
                    + "        rs = select.executeQuery();\n"
                    + "            while (rs.next()) {\n"
                    + "        " + tabla + "VO consulta = new " + tabla + "VO(\n";

            for (int i = 1; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                String tipoCampo = "";
                if (rm.getColumnTypeName(i).equals("text") || rm.getColumnTypeName(i).equals("varchar")) {
                    tipoCampo = "String";
                } else if (rm.getColumnTypeName(i).equals("date")) {
                    tipoCampo = "Date";
                } else if (rm.getColumnTypeName(i).equals("time")) {
                    tipoCampo = "Time";
                } else if (rm.getColumnTypeName(i).equals("numeric") || rm.getColumnTypeName(i).equals("integer") || rm.getColumnTypeName(i).equals("serial") || rm.getColumnTypeName(i).equals("int4")) {
                    tipoCampo = "Int";
                } else if (rm.getColumnTypeName(i).equals("bool")) {
                    tipoCampo = "boolean";
                }

                listar += "                        " + "rs.get" + tipoCampo + "(\"" + nombreCampo + "\")";

                if (i != rm.getColumnCount()) {
                    listar += ",\n";
                }
            }

            listar += ");\n                datos.add(consulta);\n"
                    + "            }"
                    + "return datos;\n"
                    + "        } catch (Exception ex) {\n"
                    + "            Logger.getLogger(" + tabla + "DAO.class.getName()).log(Level.SEVERE, null, ex);\n"
                    + "            return datos;\n"
                    + "        } finally {\n"
                    + "            cn.desconectar();\n"
                    + "            cn.cerrarStatement(select);\n"
                    + "            cn.cerrarResultSet(rs);\n"
                    + "        }\n"
                    + "    }\n";

            String insertar = "    public boolean Registrar" + tabla + "(";

            for (int i = 1; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                String tipoCampo = "";
                if (rm.getColumnTypeName(i).equals("text") || rm.getColumnTypeName(i).equals("varchar")) {
                    tipoCampo = "String";
                } else if (rm.getColumnTypeName(i).equals("date")) {
                    tipoCampo = "Date";
                } else if (rm.getColumnTypeName(i).equals("time")) {
                    tipoCampo = "Time";
                } else if (rm.getColumnTypeName(i).equals("numeric") || rm.getColumnTypeName(i).equals("integer") || rm.getColumnTypeName(i).equals("serial") || rm.getColumnTypeName(i).equals("int4")) {
                    tipoCampo = "int";
                } else if (rm.getColumnTypeName(i).equals("bool")) {
                    tipoCampo = "boolean";
                }

                insertar += tipoCampo + " " + nombreCampo;

                if (i != rm.getColumnCount()) {
                    insertar += ", ";
                }
            }
            insertar += ") {\n"
                    + "        conexion cn = null;\n"
                    + "        PreparedStatement insert = null;\n"
                    + "        try {\n"
                    + "            cn = new conexion();\n"
                    + "            boolean registro = false;\n"
                    + "            insert = cn.getConnection().prepareStatement(\"INSERT INTO public." + tabla + "(";

            for (int i = 1; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                insertar += nombreCampo;

                if (i != rm.getColumnCount()) {
                    insertar += ", ";
                }
            }

            insertar += ") VALUES (";

            for (int i = 1; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                insertar += "?";

                if (i != rm.getColumnCount()) {
                    insertar += ", ";
                }
            }

            insertar += ");\");\n";

            for (int i = 1; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                String tipoCampo = "";
                if (rm.getColumnTypeName(i).equals("text") || rm.getColumnTypeName(i).equals("varchar")) {
                    tipoCampo = "String";
                } else if (rm.getColumnTypeName(i).equals("date")) {
                    tipoCampo = "Date";
                } else if (rm.getColumnTypeName(i).equals("time")) {
                    tipoCampo = "Time";
                } else if (rm.getColumnTypeName(i).equals("numeric") || rm.getColumnTypeName(i).equals("integer") || rm.getColumnTypeName(i).equals("serial") || rm.getColumnTypeName(i).equals("int4")) {
                    tipoCampo = "Int";
                } else if (rm.getColumnTypeName(i).equals("bool")) {
                    tipoCampo = "boolean";
                }

                insertar += "            " + "insert.set" + tipoCampo + "(" + i + ", " + nombreCampo + ");\n";
            }

            insertar += "            int r = insert.executeUpdate();\n"
                    + "            if (r != 0) {\n"
                    + "                registro = true;\n"
                    + "            } else {\n"
                    + "                registro = false;\n"
                    + "            }\n"
                    + "            return registro;\n"
                    + "        } catch (Exception ex) {\n"
                    + "            Logger.getLogger(" + tabla + "DAO.class.getName()).log(Level.SEVERE, null, ex);\n"
                    + "            return false;\n"
                    + "        } finally {\n"
                    + "            cn.desconectar();\n"
                    + "            cn.cerrarStatement(insert);\n"
                    + "        }\n"
                    + "\n"
                    + "    }";

            String actualizar = "    public boolean Modificar" + tabla + "(";

            for (int i = 1; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                String tipoCampo = "";
                if (rm.getColumnTypeName(i).equals("text") || rm.getColumnTypeName(i).equals("varchar")) {
                    tipoCampo = "String";
                } else if (rm.getColumnTypeName(i).equals("date")) {
                    tipoCampo = "Date";
                } else if (rm.getColumnTypeName(i).equals("time")) {
                    tipoCampo = "Time";
                } else if (rm.getColumnTypeName(i).equals("numeric") || rm.getColumnTypeName(i).equals("integer") || rm.getColumnTypeName(i).equals("serial") || rm.getColumnTypeName(i).equals("int4")) {
                    tipoCampo = "int";
                } else if (rm.getColumnTypeName(i).equals("bool")) {
                    tipoCampo = "boolean";
                }

                actualizar += tipoCampo + " " + nombreCampo;

                if (i != rm.getColumnCount()) {
                    actualizar += ", ";
                }
            }

            actualizar += ") {\n"
                    + "        conexion cn = null;\n"
                    + "        PreparedStatement insert = null;\n"
                    + "        try {\n"
                    + "            cn = new conexion();\n"
                    + "            boolean registro = false;\n"
                    + "            insert = cn.getConnection().prepareStatement(\"UPDATE public." + tabla + " SET ";

            for (int i = 2; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                actualizar += nombreCampo + "=?";

                if (i != rm.getColumnCount()) {
                    actualizar += ", ";
                }
            }

            actualizar += " WHERE " + rm.getColumnName(1) + "=?;\");\n";

            for (int i = 2; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                String tipoCampo = "";
                if (rm.getColumnTypeName(i).equals("text") || rm.getColumnTypeName(i).equals("varchar")) {
                    tipoCampo = "String";
                } else if (rm.getColumnTypeName(i).equals("date")) {
                    tipoCampo = "Date";
                } else if (rm.getColumnTypeName(i).equals("time")) {
                    tipoCampo = "Time";
                } else if (rm.getColumnTypeName(i).equals("numeric") || rm.getColumnTypeName(i).equals("integer") || rm.getColumnTypeName(i).equals("serial") || rm.getColumnTypeName(i).equals("int4")) {
                    tipoCampo = "Int";
                } else if (rm.getColumnTypeName(i).equals("bool")) {
                    tipoCampo = "boolean";
                }

                actualizar += "            " + "insert.set" + tipoCampo + "(" + (i - 1) + ", " + nombreCampo + ");\n";
            }

            actualizar += "            insert.setInt(" + rm.getColumnCount() + ", " + rm.getColumnName(1) + ");\n"
                    + "            int r = insert.executeUpdate();\n"
                    + "            if (r != 0) {\n"
                    + "                registro = true;\n"
                    + "            } else {\n"
                    + "                registro = false;\n"
                    + "            }\n"
                    + "            return registro;\n"
                    + "        } catch (Exception ex) {\n"
                    + "            Logger.getLogger(" + tabla + "DAO.class.getName()).log(Level.SEVERE, null, ex);\n"
                    + "            return false;\n"
                    + "        } finally {\n"
                    + "            cn.desconectar();\n"
                    + "            cn.cerrarStatement(insert);\n"
                    + "        }\n"
                    + "\n"
                    + "    }";

            String eliminar = "public boolean Eliminar" + tabla + "(int " + rm.getColumnName(1) + ") {\n"
                    + "        conexion cn = null;\n"
                    + "        PreparedStatement delete = null;\n"
                    + "        try {\n"
                    + "            cn = new conexion();\n"
                    + "            boolean registro = false;\n"
                    + "            delete = cn.getConnection().prepareStatement(\"DELETE FROM public." + tabla + " WHERE " + rm.getColumnName(1) + "=?;\");\n"
                    + "            delete.setInt(1, " + rm.getColumnName(1) + ");\n"
                    + "            int r = delete.executeUpdate();\n"
                    + "            if (r != 0) {\n"
                    + "                registro = true;\n"
                    + "            } else {\n"
                    + "                registro = false;\n"
                    + "            }\n"
                    + "            return registro;\n"
                    + "        } catch (Exception ex) {\n"
                    + "            Logger.getLogger(" + tabla + "DAO.class.getName()).log(Level.SEVERE, null, ex);\n"
                    + "            return false;\n"
                    + "        } finally {\n"
                    + "            cn.desconectar();\n"
                    + "            cn.cerrarStatement(delete);\n"
                    + "        }\n"
                    + "    }";

            String buscar = "    public " + tabla + "VO Buscar" + tabla + "(int " + rm.getColumnName(1) + ") {\n"
                    + "        conexion cn = null;\n"
                    + "        PreparedStatement select = null;\n"
                    + "        ResultSet rs = null;\n"
                    + "        " + tabla + "VO pr = null;\n"
                    + "        try {\n"
                    + "            cn = new conexion();\n"
                    + "            select = cn.getConnection().prepareStatement(\"SELECT * FROM public." + tabla + " WHERE " + rm.getColumnName(1) + "=?;\");"
                    + "            select.setInt(1, " + rm.getColumnName(1) + ");\n"
                    + "            rs = select.executeQuery();\n"
                    + "            if (rs.next()) {\n"
                    + "                pr = new " + tabla + "VO(\n";

            for (int i = 1; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                String tipoCampo = "";
                if (rm.getColumnTypeName(i).equals("text") || rm.getColumnTypeName(i).equals("varchar")) {
                    tipoCampo = "String";
                } else if (rm.getColumnTypeName(i).equals("date")) {
                    tipoCampo = "Date";
                } else if (rm.getColumnTypeName(i).equals("time")) {
                    tipoCampo = "Time";
                } else if (rm.getColumnTypeName(i).equals("numeric") || rm.getColumnTypeName(i).equals("integer") || rm.getColumnTypeName(i).equals("serial") || rm.getColumnTypeName(i).equals("int4")) {
                    tipoCampo = "Int";
                } else if (rm.getColumnTypeName(i).equals("bool")) {
                    tipoCampo = "boolean";
                }

                buscar += "                        " + "rs.get" + tipoCampo + "(\"" + nombreCampo + "\")";

                if (i != rm.getColumnCount()) {
                    buscar += ",\n";
                }
            }

            buscar += ");\n"
                    + "            }\n"
                    + "\n"
                    + "            return pr;\n"
                    + "        } catch (Exception ex) {\n"
                    + "            Logger.getLogger(" + tabla + "DAO.class.getName()).log(Level.SEVERE, null, ex);\n"
                    + "            return pr;\n"
                    + "        } finally {\n"
                    + "            cn.desconectar();\n"
                    + "            cn.cerrarStatement(select);\n"
                    + "            cn.cerrarResultSet(rs);\n"
                    + "        }\n"
                    + "    }";

            clasetxt = "package DAO;\n" + importaciones + clasetxt + "\n"
                    + listar + "\n" + insertar + "\n" + buscar + "\n" + actualizar + "\n" + eliminar + "\n" + "}";
            escribirClase.write(clasetxt);
            escribirClase.close();
        }
    }

    public static void generarServlets() throws SQLException, IOException {
        conexion cn = new conexion();
        Statement stm = cn.getConnection().createStatement();
        String consultarTablas = "SELECT tablename FROM pg_tables WHERE schemaname = 'public'";
        ResultSet rs = stm.executeQuery(consultarTablas);
        while (rs.next()) {
            String tabla = rs.getString("tablename");
            File clase = new File("C:\\Users\\Acer pc\\Documents\\NetBeansProjects\\PruebaScript\\src\\java\\Controllers", "Controller" + tabla + ".java");
            FileWriter escribirClase = new FileWriter(clase);

            String importaciones = "import DAO.*;\n"
                    + "import java.io.IOException;\n"
                    + "import java.io.PrintWriter;\n"
                    + "import javax.servlet.ServletException;\n"
                    + "import javax.servlet.http.HttpServlet;\n"
                    + "import javax.servlet.http.HttpServletRequest;\n"
                    + "import javax.servlet.http.HttpServletResponse;\n"
                    + "import javax.servlet.http.HttpSession;\n"
                    + "import javax.swing.JOptionPane;\n";
            String clasetxt = "\n\npublic class Controller" + tabla
                    + " extends HttpServlet {\n"
                    + "\n"
                    + "    /**\n"
                    + "     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>\n"
                    + "     * methods.\n"
                    + "     *\n"
                    + "     * @param request servlet request\n"
                    + "     * @param response servlet response\n"
                    + "     * @throws ServletException if a servlet-specific error occurs\n"
                    + "     * @throws IOException if an I/O error occurs\n"
                    + "     */\n"
                    + "    protected void processRequest(HttpServletRequest request, HttpServletResponse response)\n"
                    + "            throws ServletException, IOException {\n"
                    + "        response.setContentType(\"text/html;charset=UTF-8\");\n"
                    + "        try (PrintWriter out = response.getWriter()) {\n"
                    + "            /* TODO output your page here. You may use following sample code. */\n"
                    + "            out.println(\"<!DOCTYPE html>\");\n"
                    + "            out.println(\"<html>\");\n"
                    + "            out.println(\"<head>\");\n"
                    + "            out.println(\"<title>Servlet Controllerventa</title>\");            \n"
                    + "            out.println(\"</head>\");\n"
                    + "            out.println(\"<body>\");\n"
                    + "            out.println(\"<h1>Servlet Controllerventa at \" + request.getContextPath() + \"</h1>\");\n"
                    + "            out.println(\"</body>\");\n"
                    + "            out.println(\"</html>\");\n"
                    + "        }\n"
                    + "    }\n"
                    + "\n"
                    + "    // <editor-fold defaultstate=\"collapsed\" desc=\"HttpServlet methods. Click on the + sign on the left to edit the code.\">\n"
                    + "    /**\n"
                    + "     * Handles the HTTP <code>GET</code> method.\n"
                    + "     *\n"
                    + "     * @param request servlet request\n"
                    + "     * @param response servlet response\n"
                    + "     * @throws ServletException if a servlet-specific error occurs\n"
                    + "     * @throws IOException if an I/O error occurs\n"
                    + "     */\n"
                    + "    @Override\n"
                    + "    protected void doGet(HttpServletRequest request, HttpServletResponse response)\n"
                    + "            throws ServletException, IOException {\n"
                    + "        processRequest(request, response);\n"
                    + "    }\n"
                    + "\n"
                    + "    /**\n"
                    + "     * Handles the HTTP <code>POST</code> method.\n"
                    + "     *\n"
                    + "     * @param request servlet request\n"
                    + "     * @param response servlet response\n"
                    + "     * @throws ServletException if a servlet-specific error occurs\n"
                    + "     * @throws IOException if an I/O error occurs\n"
                    + "     */\n"
                    + "    @Override\n"
                    + "    protected void doPost(HttpServletRequest request, HttpServletResponse response)\n"
                    + "            throws ServletException, IOException {\n"
                    + "        processRequest(request, response);\n"
                    + "    }\n"
                    + "\n"
                    + "    /**\n"
                    + "     * Returns a short description of the servlet.\n"
                    + "     *\n"
                    + "     * @return a String containing servlet description\n"
                    + "     */\n"
                    + "    @Override\n"
                    + "    public String getServletInfo() {\n"
                    + "        return \"Short description\";\n"
                    + "    }// </editor-fold>\n"
                    + "\n"
                    + "}\n"
                    + "";
            String atributos = "";
            String metodos = "";

            String consultarTabla = "SELECT * FROM " + tabla;
            stm = cn.getConnection().createStatement();
            ResultSet rs1 = stm.executeQuery(consultarTabla);

            ResultSetMetaData rm = rs1.getMetaData();
            String constructor = "public " + tabla + "VO(";
            for (int i = 1; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                String tipoCampo = "";
                if (rm.getColumnTypeName(i).equals("text") || rm.getColumnTypeName(i).equals("varchar")) {
                    tipoCampo = "String";
                } else if (rm.getColumnTypeName(i).equals("date")) {
                    tipoCampo = "Date";
                    if (importaciones.indexOf("sql.Date") == -1) {
                        importaciones = importaciones + "import java.sql.Date;\n";
                    }
                } else if (rm.getColumnTypeName(i).equals("time")) {
                    tipoCampo = "Time";
                    if (importaciones.indexOf("sql.Time") == -1) {
                        importaciones = importaciones + "import java.sql.Time;\n";
                    }
                } else if (rm.getColumnTypeName(i).equals("numeric") || rm.getColumnTypeName(i).equals("integer") || rm.getColumnTypeName(i).equals("serial") || rm.getColumnTypeName(i).equals("int4")) {
                    tipoCampo = "int";
                } else if (rm.getColumnTypeName(i).equals("bool")) {
                    tipoCampo = "boolean";
                }

                constructor += tipoCampo + " " + nombreCampo;
                if (i != rm.getColumnCount()) {
                    constructor += ", ";
                }

            }
            constructor += "){\n";

            String constVacio = "public " + tabla + "VO(){\n}";
            for (int i = 1; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                String tipoCampo = "";
                if (rm.getColumnTypeName(i).equals("text") || rm.getColumnTypeName(i).equals("varchar")) {
                    tipoCampo = "String";
                } else if (rm.getColumnTypeName(i).equals("date")) {
                    tipoCampo = "Date";
                } else if (rm.getColumnTypeName(i).equals("time")) {
                    tipoCampo = "Time";
                } else if (rm.getColumnTypeName(i).equals("numeric") || rm.getColumnTypeName(i).equals("integer") || rm.getColumnTypeName(i).equals("serial") || rm.getColumnTypeName(i).equals("int4")) {
                    tipoCampo = "int";
                } else if (rm.getColumnTypeName(i).equals("bool")) {
                    tipoCampo = "boolean";
                }

                constructor += "\tthis." + nombreCampo + " = " + nombreCampo + ";\n";

                atributos = atributos + "\tprivate " + tipoCampo + " " + nombreCampo + ";\n";

                metodos = metodos + "\tpublic " + tipoCampo + " get" + nombreCampo + "() {\n"
                        + "\t\treturn this." + nombreCampo + ";\n\t}\n\n";

                metodos = metodos + "\tpublic void set" + nombreCampo + "(" + tipoCampo + " " + nombreCampo + ") {\n"
                        + "\t\tthis." + nombreCampo + "=" + nombreCampo + ";\n\t}\n\n";
            }
            constructor += "}\n";
            clasetxt = "package Controllers;\n" + importaciones + clasetxt;
            escribirClase.write(clasetxt);
            escribirClase.close();
        }
    }

    public static void generarwebxml() throws SQLException, IOException {
        conexion cn = new conexion();
        Statement stm = cn.getConnection().createStatement();
        String consultarTablas = "SELECT tablename FROM pg_tables WHERE schemaname = 'public'";
        ResultSet rs = stm.executeQuery(consultarTablas);
        String clasetxt = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<web-app version=\"3.1\" xmlns=\"http://xmlns.jcp.org/xml/ns/javaee\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd\">";
        File clase = new File("C:\\Users\\Acer pc\\Documents\\NetBeansProjects\\PruebaScript\\web\\WEB-INF", "web.xml");
        FileWriter escribirClase = new FileWriter(clase);
        String mapping = "";
        while (rs.next()) {
            String tabla = rs.getString("tablename");
            clasetxt += "    <servlet>\n"
                    + "        <servlet-name>Controller" + tabla + "</servlet-name>\n"
                    + "        <servlet-class>Controlllers.Controller" + tabla + "</servlet-class>\n"
                    + "    </servlet>\n";
            mapping += "    <servlet-mapping>\n"
                    + "        <servlet-name>Controller" + tabla + "</servlet-name>\n"
                    + "        <url-pattern>/Controller" + tabla + "</url-pattern>\n"
                    + "    </servlet-mapping>\n";

            String consultarTabla = "SELECT * FROM " + tabla;
            stm = cn.getConnection().createStatement();
            ResultSet rs1 = stm.executeQuery(consultarTabla);

            ResultSetMetaData rm = rs1.getMetaData();

        }
        clasetxt += mapping + "    <session-config>\n"
                + "        <session-timeout>\n"
                + "            30\n"
                + "        </session-timeout>\n"
                + "    </session-config>\n"
                + "</web-app>";
        escribirClase.write(clasetxt);
        escribirClase.close();
    }
}
