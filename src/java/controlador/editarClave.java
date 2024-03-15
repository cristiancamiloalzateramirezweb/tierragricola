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
public class editarClave extends HttpServlet {

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
            String documento = request.getParameter("documento");
            String clave = request.getParameter("clave");
            String correo = request.getParameter("correo");
            
            DAOUsuario daoUsuario = new DAOUsuario();
            DTOUsuario dtoUsuario = new DTOUsuario();
            correos enviarCorreo = new correos();

            dtoUsuario.setDocumento_identidad(documento);
            dtoUsuario.setClave(clave);

            boolean editarClave = daoUsuario.editarClave(dtoUsuario);

            String remitente = "tierragricola2021@gmail.com";
            String password = "juikumlryugzlhjd";
            String asunto = "Restablecimiento de contraseña | Tierragricola";
            String cuerpo = "¡Hola!, Su contraseña de acceso a Tierragricola ha sido restablecida exitosamente sus crendeciales de acceso a continuación: "
                    + "Documento de Identidad: " + documento + " y Contraseña: " + clave + ". Tierragricola.";

            if (editarClave == true) {
                enviarCorreo.enviarCorreo(remitente, correo, password, asunto, cuerpo);
                out.println("<div class='modal-ok'>");
                out.println("<p>La contraseña ha sido restablecida exitosamente.</p>");
                out.println("</div>");
            } else {
                out.println("<div class='modal-error'>");
                out.println("<p>Ha ocurrido un error no se pudo restablecer la contraseña intenta nuevamente por favor!</p>");
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
