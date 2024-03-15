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
import modelo.DAO.DAOEstadoVenta;
import modelo.DAO.DAOProducto;
import modelo.DAO.DAOUsuario;
import modelo.DAO.DAOVenta;
import modelo.DTO.DTOClienteProducto;
import modelo.DTO.DTOEstadoVenta;
import modelo.DTO.DTOProducto;
import modelo.DTO.DTOUsuario;
import modelo.DTO.DTOVenta;

/**
 *
 * @author camil
 */
public class solicitudes extends HttpServlet {

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

            if (usuario != null) {
                int numero_folio = Integer.parseInt(request.getParameter("id"));
                DAOClienteProducto daoClienteProducto = new DAOClienteProducto();
                DAOProducto daoProducto = new DAOProducto();
                DAOVenta daoVenta = new DAOVenta();
                DAOEstadoVenta daoEstadoVenta = new DAOEstadoVenta();
                DTOProducto productoFolio = daoProducto.obtenerProductoVentaFolio(numero_folio);
                List<DTOClienteProducto> listarClienteProductoVentas = daoClienteProducto.listarClienteProductoVentas(numero_folio);
                List<DTOProducto> listarProductoVentasCliente = daoProducto.listarProductoVentasCliente(numero_folio);
                List<DTOVenta> listarVentasProductoCliente = daoVenta.listarVentasProductoCliente(numero_folio);
                List<DTOEstadoVenta> listarEstadoNegociosCliente = daoEstadoVenta.listarEstadoNegociosCliente(numero_folio);
                request.setAttribute("producto", productoFolio);
                request.setAttribute("cliente_producto_ventas", listarClienteProductoVentas);
                request.setAttribute("producto_ventas_cliente", listarProductoVentasCliente);
                request.setAttribute("ventas_producto_cliente", listarVentasProductoCliente);
                request.setAttribute("estado_negocio_cliente", listarEstadoNegociosCliente);
                request.getRequestDispatcher("solicitudes.jsp").forward(request, response);
            } else if (usuario == null) {
                request.getRequestDispatcher("ingresar").forward(request, response);
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
