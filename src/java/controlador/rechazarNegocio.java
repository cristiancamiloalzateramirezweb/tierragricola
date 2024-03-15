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
import modelo.DAO.DAOProducto;
import modelo.DAO.DAOVenta;
import modelo.DTO.DTOVenta;
import tareas.correos;

/**
 *
 * @author camil
 */
public class rechazarNegocio extends HttpServlet {

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
            int id_venta = Integer.parseInt(request.getParameter("id_venta"));
            int id_estado_venta = 3;
            String destinatario_comprador = request.getParameter("destinatario_comprador");
            String destinatario_vendedor = request.getParameter("destinatario_vendedor");
            String producto = request.getParameter("producto");
            String vendedor = request.getParameter("vendedor");
            String comprador = request.getParameter("comprador");

            DAOVenta daoVenta = new DAOVenta();
            DTOVenta dtoVenta = new DTOVenta();
            correos correo = new correos();

            dtoVenta.setId_venta(id_venta);
            dtoVenta.setId_estado_venta(id_estado_venta);

            boolean editarVenta = daoVenta.editarVenta(dtoVenta);

            String remitente = "tierragricola2021@gmail.com";
            String password = "juikumlryugzlhjd";
            String asunto_comprador = "¡Hola " + comprador + "!, Seguimiento en la solicitud del producto de " + producto + "!";
            String cuerpo_comprador = "Desde Tierragricola tenemos noticias para ti... la solicitud en el negocio del "
                    + "producto " + producto + " ha sido rechazada por parte de " + vendedor + " el vendedor del producto. Cordial Saludo, Tierragricola.";
            String asunto_vendedor = "¡Hola " + vendedor + "!, Envio de respuesta negocio de " + producto + "!";
            String cuerpo_vendedor = "¡Hola!, Desde Tierragricola hemos enviado la respuesta de la solicitud a " + comprador + " "
                    + "solicitante del producto " + producto + ". Cordial Saludo, Tierragricola.";
            
            if (editarVenta == true) {
                out.println("<div class='modal-ok'>");
                out.println("<p>Respuesta de la solicitud del negocio enviada exitosamente.</p>");
                out.println("</div>");
                correo.enviarCorreo(remitente, destinatario_comprador, password, asunto_comprador, cuerpo_comprador);
                correo.enviarCorreo(remitente, destinatario_vendedor, password, asunto_vendedor, cuerpo_vendedor);
            } else {
                out.println("<div class='modal-error'>");
                out.println("<p>Ha ocurrido un error no se pudo enviar la respuesta de la solicitud, Intentalo de nuevo por favor!</p>");
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
