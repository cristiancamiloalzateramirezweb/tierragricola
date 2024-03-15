/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAO.DAOUsuario;
import modelo.DTO.DTOUsuario;
import tareas.correos;

/**
 *
 * @author camil
 */
public class crearCuenta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DAOUsuario daoUsuario = new DAOUsuario();
            DTOUsuario dtoUsuario = new DTOUsuario();
            correos enviarCorreo = new correos();

            String documento_identidad = request.getParameter("documento_identidad");
            String tipo_documento = request.getParameter("tipo_documento");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String correo = request.getParameter("correo");
            String clave = request.getParameter("clave");
            String celular = request.getParameter("celular");
            int id_departamento = Integer.parseInt(request.getParameter("id_departamento"));
            int id_municipio = Integer.parseInt(request.getParameter("id_municipio"));
            String direccion = request.getParameter("direccion");

            dtoUsuario.setDocumento_identidad(documento_identidad);
            dtoUsuario.setTipo_documento(tipo_documento);
            dtoUsuario.setNombre(nombre);
            dtoUsuario.setApellido(apellido);
            dtoUsuario.setCorreo(correo);
            dtoUsuario.setClave(clave);
            dtoUsuario.setCelular(celular);
            dtoUsuario.setId_departamento(id_departamento);
            dtoUsuario.setId_municipio(id_municipio);
            dtoUsuario.setDireccion(direccion);

            boolean crearCuenta = daoUsuario.crearUsuario(dtoUsuario);

            String remitente = "tierragricola2021@gmail.com";
            String password = "juikumlryugzlhjd";
            String asunto = nombre + " " + apellido + " Bienvenid@ a Tierragricola!";
            String cuerpo = "¡Hola!, " + nombre + " " + apellido + " bienvenid@ a Tierragricola. Aplicación donde podras "
                    + "buscar, comprar y vender cerca de ti productos del agro colombiano sus crendeciales de acceso a continuación: "
                    + "Documento de Identidad: " + documento_identidad + " y Contraseña: " + clave + ". Gracias por crear una cuenta. Tierragricola.";

            if (crearCuenta == true) {
                enviarCorreo.enviarCorreo(remitente, correo, password, asunto, cuerpo);
                out.println("<div class='modal-ok'>");
                out.println("<p>" + nombre + " " + apellido + " tu cuenta en Tierragricola ha sido creada exitosamente!</p>");
                out.println("</div>");
            } else {
                out.println("<div class='modal-error'>");
                out.println("<p>Ha ocurrido un error la cuenta no se pudo crear intentalo nuevamente por favor!</p>");
                out.println("</div>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
