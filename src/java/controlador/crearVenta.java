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
import javax.servlet.http.HttpSession;
import modelo.DAO.DAOVenta;
import modelo.DTO.DTOUsuario;
import modelo.DTO.DTOVenta;
import tareas.correos;

/**
 *
 * @author camil
 */
public class crearVenta extends HttpServlet {

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
            HttpSession misession = request.getSession(false);
            DTOUsuario usuario = (DTOUsuario) misession.getAttribute("usuario");

            String documento_identidad = request.getParameter("documento_identidad");
            int numero_folio = Integer.parseInt(request.getParameter("numero_folio"));
            int precio_venta = Integer.parseInt(request.getParameter("precio_venta"));
            int cantidad_venta = Integer.parseInt(request.getParameter("cantidad_venta"));
            String mensaje = request.getParameter("mensaje");
            int id_estado_negociacion = 5;
            int id_estado_compra = 5;
            int id_estado_venta = 1;
            String correo = request.getParameter("correo");
            String titulo = request.getParameter("titulo");
            String vendedor = request.getParameter("vendedor");

            DAOVenta daoVenta = new DAOVenta();
            DTOVenta dtoVenta = new DTOVenta();
            correos enviarCorreo = new correos();

            dtoVenta.setDocumento_identidad(documento_identidad);
            dtoVenta.setNumero_folio(numero_folio);
            dtoVenta.setPrecio_venta(precio_venta);
            dtoVenta.setCantidad_venta(cantidad_venta);
            dtoVenta.setMensaje(mensaje);
            dtoVenta.setId_estado_negociacion(id_estado_negociacion);
            dtoVenta.setId_estado_compra(id_estado_compra);
            dtoVenta.setId_estado_venta(id_estado_venta);

            boolean crearVenta = daoVenta.crearVenta(dtoVenta);

            String remitente = "tierragricola2021@gmail.com";
            String password = "juikumlryugzlhjd";
            String asunto = "Negociación de producto " + titulo + " | Tierragricola";
            String cuerpo = "¡Hola!, " + vendedor + " sabemos que tu tiempo vale oro y por eso desde Tierragricola te avisamos que alguien esta "
                    + "interesado en tu producto " + titulo + " publicado en Tierragricola ve y mira en el apartado de negociaciones desde tu perfil "
                    + "acepta o rechaza este negocio. Muchas gracias, Hasta luego. Tierragricola.";

            if (crearVenta == true) {
                enviarCorreo.enviarCorreo(remitente, correo, password, asunto, cuerpo);
                out.println("<div class='modal-ok'>");
                out.println("<p>" + usuario.getNombre() + " " + usuario.getApellido() + " se ha enviado el negocio al vendedor.</p>");
                out.println("</div>");
            } else {
                out.println("<div class='modal-error'>");
                out.println("<p>Ha ocurrido no se pudo enviar el negocio al vendedor intentalo de nuevo pr favor!</p>");
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
