/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
public class crearProducto extends HttpServlet {

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

            DAOProducto daoProducto = new DAOProducto();
            DAOClienteProducto daoClienteProducto = new DAOClienteProducto();
            DTOProducto dtoProducto = new DTOProducto();
            DTOClienteProducto dtoClienteProducto = new DTOClienteProducto();

            int id_seccion = Integer.parseInt(request.getParameter("id_seccion"));
            int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
            String titulo = request.getParameter("titulo");
            String catalogo = request.getParameter("catalogo");
            int precio = Integer.parseInt(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            String descripcion = request.getParameter("descripcion");
            String documento_identidad = usuario.getDocumento_identidad();
            int id_producto = daoProducto.obtenerIdProducto();

            dtoProducto.setId_seccion(id_seccion);
            dtoProducto.setId_categoria(id_categoria);
            dtoProducto.setTitulo_anuncio(titulo);
            dtoProducto.setCatalogo(catalogo);
            dtoProducto.setPrecio(precio);
            dtoProducto.setCantidad(cantidad);
            dtoProducto.setDescripcion_producto(descripcion);
            dtoClienteProducto.setDocumento_identidad(documento_identidad);
            dtoClienteProducto.setId_producto(id_producto);

            boolean crearProducto = daoProducto.crearProducto(dtoProducto);
            boolean crearClienteProducto = daoClienteProducto.crearClienteProducto(dtoClienteProducto);
           
            if (crearProducto == true && crearClienteProducto == true) {
                out.println("<div class='modal-ok'>");
                out.println("<p>" + usuario.getNombre() + " " + usuario.getApellido() + " el producto ha sido publicado exitosamente!</p>");
                out.println("</div>");
            } else {
                out.println("<div class='modal-error'>");
                out.println("<p>Ha ocurrido un error el producto no ha sido publicado exitosamente!</p>");
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
