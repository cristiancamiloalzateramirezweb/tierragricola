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
import modelo.DAO.DAOCategoria;
import modelo.DAO.DAOProducto;
import modelo.DAO.DAOSeccion;
import modelo.DAO.DAOUsuario;
import modelo.DTO.DTOCategoria;
import modelo.DTO.DTOProducto;
import modelo.DTO.DTOSeccion;
import modelo.DTO.DTOUsuario;

/**
 *
 * @author camil
 */
public class editar extends HttpServlet {

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
                int id_producto = Integer.parseInt(request.getParameter("id"));
                DAOProducto daoProducto = new DAOProducto();
                DAOSeccion daoSeccion = new DAOSeccion();
                DAOCategoria daoCategoria = new DAOCategoria();
                DTOProducto producto = daoProducto.obtenerProducto(id_producto);
                DTOSeccion seccion = daoSeccion.obtenerSeccionProducto(id_producto);
                DTOCategoria categoria = daoCategoria.obtenerCategoriaProducto(id_producto);
                request.setAttribute("producto", producto);
                request.setAttribute("seccion", seccion);
                request.setAttribute("categoria", categoria);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
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
