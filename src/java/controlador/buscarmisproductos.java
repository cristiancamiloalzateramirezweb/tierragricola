/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DAO.DAOClienteProducto;
import modelo.DAO.DAOProducto;
import modelo.DTO.DTOClienteProducto;
import modelo.DTO.DTOProducto;
import modelo.DTO.DTOUsuario;

/**
 *
 * @author camil
 */
public class buscarmisproductos extends HttpServlet {

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
            HttpSession misession = request.getSession();
            DTOUsuario usuario = (DTOUsuario) misession.getAttribute("usuario");
            String busqueda = request.getParameter("busqueda").toLowerCase();
            DAOProducto daoProducto = new DAOProducto();
            DAOClienteProducto daoClienteProducto = new DAOClienteProducto();

            List<DTOProducto> busquedaProductosCliente = daoProducto.listarBusquedaProductosCliente(usuario.getDocumento_identidad(), busqueda);
            List<DTOClienteProducto> busquedaClienteProductoCliente = daoClienteProducto.listarBusquedaClienteProductoUsuario(usuario.getDocumento_identidad(), busqueda);
            String busqueda_productos = "";

            for (int i = 0; i < busquedaClienteProductoCliente.size(); i++) {
                busqueda_productos += "<div class='product-item'>"
                        + "<div class='header-item'> "
                        + "<h2>Publicado el:<br> " + busquedaProductosCliente.get(i).getFecha_publicacion() + "</h2>"
                        + "</div>"
                        + "<div class='data-item'>"
                        + "<div class='item-foto'>"
                        + "<img src='./gallery/" + busquedaProductosCliente.get(i).getCatalogo() + "'>"
                        + "</div>"
                        + "<div class='item-info'>"
                        + "<h3>" + busquedaProductosCliente.get(i).getTitulo_anuncio() + "</h3>"
                        + "<p>$ " + busquedaProductosCliente.get(i).getPrecio() + "</p>"
                        + "<p>Cantidad: " + busquedaProductosCliente.get(i).getCantidad() + "</p>"
                        + "</div>"
                        + "<div class='item-descripcion'>"
                        + "<p>" + busquedaProductosCliente.get(i).getDescripcion_producto() + "</p>"
                        + "</div>"
                        + "</div>"
                        + "<div class='options-item'>"
                        + "<a href='editar?id=" + busquedaProductosCliente.get(i).getId_producto() + "' class='edit'>Editar</a>"
                        + "<button class='delete' type='button' id='recuperarEliminar' value='" + busquedaProductosCliente.get(i).getId_producto() + "'>Eliminar</button>"
                        + "<a href='solicitudes?id=" + busquedaClienteProductoCliente.get(i).getNumero_folio() + "' class='edit'>Solicitudes</a>"
                        + "</div>"
                        + "</div>";
            }
            out.println(busqueda_productos);
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
