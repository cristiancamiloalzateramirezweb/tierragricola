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
import modelo.DAO.DAOClienteProducto;
import modelo.DAO.DAOProducto;
import modelo.DAO.DAOUsuario;
import modelo.DTO.DTOClienteProducto;
import modelo.DTO.DTOProducto;
import modelo.DTO.DTOUsuario;

/**
 *
 * @author camil
 */
public class recuperarChat extends HttpServlet {

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

            DAOUsuario daoUsuario = new DAOUsuario();
            DAOClienteProducto daoClienteProducto = new DAOClienteProducto();
            DAOProducto daoProducto = new DAOProducto();

            DTOUsuario cliente = daoUsuario.obtenerClienteProducto(id_producto);
            DTOClienteProducto clienteProducto = daoClienteProducto.obtenerClienteProducto(id_producto);
            DTOProducto producto = daoProducto.obtenerItemProducto(id_producto);

            String form = "<div class='contenido-modal'>"
                    + "<div class='header-content'>"
                    + "<h2>Negociar con " + cliente.getNombre() + "</h1>"
                    + "<button id='close-modal' class='button-close-modal'>"
                    + "<i class='fa-solid fa-xmark'></i>"
                    + "</button>"
                    + "</div>"
                    + "<div class='presentacion-content'>"
                    + "<div class='foto-comprador'>"
                    + "<img src='./photos/" + usuario.getFoto() + "'>"
                    + "</div>"
                    + "<div class='flecha'>"
                    + " <i class='fa-solid fa-arrow-right-arrow-left'></i>"
                    + "</div>"
                    + "<div class='foto-vendedor'>"
                    + " <img src='./photos/" + cliente.getFoto() + "'>"
                    + "</div>"
                    + "</div>"
                    + "<div id='respuestas'>"
                    + "<div id='respuesta-campos-vacios'></div>"
                    + "</div>"
                    + "<div class='formulario'>"
                    + "<form autocomplete='off'>"
                    + "<input type='hidden' name='numero_folio' id='numero_folio' value='" + clienteProducto.getNumero_folio() + "'>"
                    + "<input type='hidden' name='documento_identidad' id='documento_identidad' value='" + usuario.getDocumento_identidad() + "'>"
                    + "<input type='hidden' name='correo' id='correo' value='" + cliente.getCorreo() + "'>"
                    + "<input type='hidden' name='titulo' id='titulo' value='" + producto.getTitulo_anuncio() + "'>"
                    + "<input type='hidden' name='vendedor' id='vendedor' value='" + cliente.getNombre() + " " + cliente.getApellido() + "'>"
                    + "<label for='cantidad'>¿Que cantidad vas a comprar?</label>"
                    + "<input type='text' name='cantidad' id='cantidad' value='" + producto.getCantidad() + "'>"
                    + "<label for='precio'>¿En cuanto lo va a comprar?</label>"
                    + "<input type='text' name='precio' id='precio' value='" + producto.getPrecio() + "'>"
                    + "<label for='mensaje'>Escribe un mensaje al vendedor</label>"
                    + "<textarea name='mensaje' id='mensaje' placeholder='Mensaje'></textarea>"
                    + "<button type='button' id='negociar'>Negociar</button>"
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
