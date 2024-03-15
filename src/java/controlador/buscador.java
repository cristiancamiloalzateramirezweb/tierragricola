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
import modelo.DAO.DAOCategoria;
import modelo.DAO.DAOClienteProducto;
import modelo.DAO.DAODepartamento;
import modelo.DAO.DAOMunicipio;
import modelo.DAO.DAOProducto;
import modelo.DAO.DAOUsuario;
import modelo.DTO.DTOCategoria;
import modelo.DTO.DTOClienteProducto;
import modelo.DTO.DTODepartamento;
import modelo.DTO.DTOMunicipio;
import modelo.DTO.DTOProducto;
import modelo.DTO.DTOUsuario;

/**
 *
 * @author camil
 */
public class buscador extends HttpServlet {

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
            DAODepartamento daoDepartamento = new DAODepartamento();
            DAOMunicipio daoMunicipio = new DAOMunicipio();
            DAOClienteProducto daoClienteProducto = new DAOClienteProducto();
            DAOProducto daoProducto = new DAOProducto();
            DAOCategoria daoCategoria = new DAOCategoria();

            String busqueda = request.getParameter("busqueda").toLowerCase();

            List<DTODepartamento> busquedaDepartamentos = daoDepartamento.listarDepartamentoClientesBusqueda(busqueda);
            List<DTOMunicipio> busquedaMunicipios = daoMunicipio.listarMunicipioClientesBusqueda(busqueda);
            List<DTOClienteProducto> busquedaClienteProducto = daoClienteProducto.listarClientesProductosBusqueda(busqueda);
            List<DTOProducto> busquedaProductos = daoProducto.listarProductosBusqueda(busqueda);
            List<DTOCategoria> busquedaCategorias = daoCategoria.listarCategoriaProductosBusqueda(busqueda);
            request.setAttribute("buscar_departamentos", busquedaDepartamentos);
            request.setAttribute("buscar_municipios", busquedaMunicipios);
            request.setAttribute("buscar_cliente_producto", busquedaClienteProducto);
            request.setAttribute("buscar_productos", busquedaProductos);
            request.setAttribute("buscar_categorias", busquedaCategorias);
            request.setAttribute("busqueda", busqueda);
            request.getRequestDispatcher("buscador.jsp").forward(request, response);
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
