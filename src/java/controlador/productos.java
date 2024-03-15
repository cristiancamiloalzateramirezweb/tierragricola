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
public class productos extends HttpServlet {

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
                DAOUsuario daoUsuario = new DAOUsuario();
                DAOProducto daoProducto = new DAOProducto();
                DAOClienteProducto daoClienteProducto = new DAOClienteProducto();
                DAOVenta daoVenta = new DAOVenta();
                DAOEstadoVenta daoEstadoVenta = new DAOEstadoVenta();
                DTOUsuario dtoUsuario = daoUsuario.obtenerUsuario(usuario.getDocumento_identidad());
                List<DTOProducto> listarProductosCliente = daoProducto.listarProductosCliente(usuario.getDocumento_identidad());
                List<DTOClienteProducto> listarClienteProductoCliente = daoClienteProducto.listarClienteProductoUsuario(usuario.getDocumento_identidad());
                List<DTOProducto> listarProductosComprasCliente = daoProducto.listarProductosComprasCliente(usuario.getDocumento_identidad());
                List<DTOVenta> listarComprasProductoCliente = daoVenta.listarComprasProductoCliente(usuario.getDocumento_identidad());
                List<DTOEstadoVenta> listarEstadoComprasCliente = daoEstadoVenta.listarEstadoComprasCliente(usuario.getDocumento_identidad());
                misession.setAttribute("usuario", dtoUsuario);
                request.setAttribute("listar_productos", listarProductosCliente);
                request.setAttribute("listar_cliente_producto", listarClienteProductoCliente);
                request.setAttribute("listar_productos_compras", listarProductosComprasCliente);
                request.setAttribute("listar_compras_producto", listarComprasProductoCliente);
                request.setAttribute("listar_estado_compras", listarEstadoComprasCliente);
                request.getRequestDispatcher("productos.jsp").forward(request, response);
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
