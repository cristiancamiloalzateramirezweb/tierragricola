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
public class validarCorreoContrasena extends HttpServlet {

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
            String correo = request.getParameter("correo");

            DAOUsuario daoUsuario = new DAOUsuario();
            correos enviarCorreo = new correos();

            boolean validarCorreo = daoUsuario.validarCorreoUsuario(correo);
            DTOUsuario usuario = daoUsuario.obtenerUsuarioCorreo(correo);

            String remitente = "tierragricola2021@gmail.com";
            String clave = "juikumlryugzlhjd";
            String asunto = "Solicitud de restablecimiento de contraseña en Tierragricola!";
            String cuerpo = "Solicitud de restablecimiento de contraseña. "
                    + "Hola, " + usuario.getNombre() + ". "
                    + "Usted ha solicitado restablecer la contraseña para la cuenta Tierragricola " + correo + ". "
                    + "Haga clic en el siguiente enlace para completar el proceso. "
                    + "http://localhost:8080/WebTierragricola/restablecercontrasena?documento=" + usuario.getDocumento_identidad() + "&correo=" + correo + "";

            if (validarCorreo == true) {
                enviarCorreo.enviarCorreo(remitente, correo, clave, asunto, cuerpo);
                out.println("<div class='modal-ok'>");
                out.println("<p>Se ha enviado un correo electrónico a " + correo + " con instrucciones sobre cómo restablecer su contraseña en Tierragricola.</p>");
                out.println("</div>");
            } else {
                out.println("<div class='modal-error'>");
                out.println("<p>Ha ocurrido un error esa dirección de correo eléctronico no esta registrada en Tierragricola!</p>");
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
