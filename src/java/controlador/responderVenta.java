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
import modelo.DAO.DAOProducto;
import modelo.DAO.DAOUsuario;
import modelo.DAO.DAOVenta;
import modelo.DTO.DTOProducto;
import modelo.DTO.DTOUsuario;
import modelo.DTO.DTOVenta;

/**
 *
 * @author camil
 */
public class responderVenta extends HttpServlet {

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
            int id_venta = Integer.parseInt(request.getParameter("id_venta"));
            DAOProducto daoProducto = new DAOProducto();
            DAOUsuario daoUsuario = new DAOUsuario();
            DAOVenta daoVenta = new DAOVenta();

            DTOUsuario usuarioVenta = daoUsuario.obtenerClienteVenta(id_venta);
            DTOProducto productoVenta = daoProducto.obtenerProductoVenta(id_venta);
            DTOVenta venta = daoVenta.obtenerVenta(id_venta);

            String form = "<div class='contenido-modal'>"
                    + "<div class='header-content'>"
                    + "<h2>Responder a " + usuarioVenta.getNombre() + "</h1>"
                    + "<button id='close-modal' class='button-close-modal'>"
                    + "<i class='fa-solid fa-xmark'></i>"
                    + "</button>"
                    + "</div>"
                    + "<div class='presentacion-content'>"
                    + "<div class='foto-comprador'>"
                    + "<img src='./photos/" + usuario.getFoto() + "'>"
                    + "</div>"
                    + "<div class='flecha'>"
                    + "<i class='fa-solid fa-arrow-right-arrow-left'></i>"
                    + "</div>"
                    + "<div class='foto-vendedor'>"
                    + "<img src='./photos/" + usuarioVenta.getFoto() + "'>"
                    + "</div>"
                    + "</div>"
                    + "<div id='respuestas-negocio'>"
                    + "</div>"
                    + "<div class='formulario'>"
                    + "<form autocomplete='off'>"
                    + "<input type='hidden' name='id_venta' id='id_venta' value='" + venta.getId_venta() + "'>"
                    + "<input type='hidden' name='numero_folio' id='numero_folio' value='" + venta.getNumero_folio() + "'>"
                    + "<input type='hidden' name='correo_comprador' id='correo_comprador' value='" + usuarioVenta.getCorreo() + "'>"
                    + "<input type='hidden' name='correo_vendedor' id='correo_vendedor' value='" + usuario.getCorreo() + "'>"
                    + "<input type='hidden' name='titulo' id='titulo' value='" + productoVenta.getTitulo_anuncio() + "'>"
                    + "<input type='hidden' name='vendedor' id='vendedor' value='" + usuario.getNombre() + "'>"
                    + "<input type='hidden' name='comprador' id='comprador' value='" + usuarioVenta.getNombre() + "'>"
                    + "<button type='button' id='aceptarVenta'>Aceptar</button>"
                    + "<button type='button' id='rechazarVenta'>Rechazar</button>"
                    + "</form>"
                    + "</div>"
                    + "</div>";
            out.println(form);
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
