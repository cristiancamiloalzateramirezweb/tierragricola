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
import modelo.DTO.DTOProducto;
import modelo.DTO.DTOUsuario;

/**
 *
 * @author camil
 */
public class recuperarEliminar extends HttpServlet {

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
            
            int id_producto = Integer.parseInt(request.getParameter("id_producto"));

            DAOProducto daoProducto = new DAOProducto();
            DTOProducto producto = daoProducto.obtenerProducto(id_producto);

            String form = "<div class='contenido-modal'>"
                    + "<div class='header-content'>"
                    + "<h2 class='user'>" + usuario.getNombre() + " " + usuario.getApellido() + "</h2>"
                    + "</div>"
                    + "<p>Esta seguro de que quieres eliminar tu anuncio. No sera posible deshacer esta acción.</p>"
                    + "<div class='formulario'>"
                    + "<form action='eliminarProducto' method='post' autocomplete='off'>"
                    + "<input type='hidden' name='id_producto' id='id_producto' value='" + producto.getId_producto() + "'>"
                    + "<button>Eliminar</button>"
                    + "</form>"
                    + "<button id='close-modal'>Cancelar</button>"
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
