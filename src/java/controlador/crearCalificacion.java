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
import modelo.DAO.DAOCalificacion;
import modelo.DTO.DTOCalificacion;
import tareas.correos;

/**
 *
 * @author camil
 */
public class crearCalificacion extends HttpServlet {

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
            int calificacion = Integer.parseInt(request.getParameter("calificacion"));
            String observaciones = request.getParameter("observaciones");

            String remitente = "tierragricola2021@gmail.com";
            String destinatario = "tierragricola2021@gmail.com";
            String clave = "juikumlryugzlhjd";
            String asunto = "Calificacion en Tierragricola!";
            String cuerpo = "Un Usuario de Tierragricola dio su calificación la cual fue de " + calificacion + " "
                    + "con su observacion de: " + observaciones + ".";

            DAOCalificacion daoCalificacion = new DAOCalificacion();
            DTOCalificacion dtoCalificacion = new DTOCalificacion();
            correos enviarCorreo = new correos();
            
            dtoCalificacion.setCalificacion(calificacion);
            dtoCalificacion.setObservaciones(observaciones);
            
            boolean crearCalificacion = daoCalificacion.crearCalificacion(dtoCalificacion);
            
            if (crearCalificacion == true) {
                enviarCorreo.enviarCorreo(remitente, destinatario, clave, asunto, cuerpo);
                out.println("<div class='modal-ok'>");
                out.println("<p>Se ha enviado la calificación a Tierragricola. Muchas gracias.</p>");
                out.println("</div>");
            } else {
                out.println("<div class='modal-error'>");
                out.println("<p>Ha ocurrido un error no se ha enviado la calificación a Tierragricola!</p>");
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
