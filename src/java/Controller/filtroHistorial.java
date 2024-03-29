/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Compra;
import Models.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernandourg
 */
public class filtroHistorial extends HttpServlet {

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
      PrintWriter out = response.getWriter();
    
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
        
        String filtroSelect =request.getParameter("filtro");
        int filtroSele = Integer.parseInt(filtroSelect);
        Consultas co = new Consultas();
        Consultas co2 = new Consultas();
        
        HttpSession sesion = request.getSession();
        String idus = (String)sesion.getAttribute("usuario");
        
        int idUser = co2.getIdUser(idus);
        
        int orden=0;
        
        if(filtroSele==1){
            orden=1;
        }else if(filtroSele==2){
            orden=3;
        }
        else if(filtroSele==3){
            orden=4;
        }
        else if(filtroSele==4){
            orden=5;
        }
            
        
        if(filtroSele ==0)
        {
            request.getRequestDispatcher("shwHCompra").forward(request, response);
        }else if(filtroSele !=0){
            Consultas co3 = new Consultas();
            List<Compra> lisC=co3.shwCompraFiltro(idUser, orden);
            
            request.setAttribute("HiCom", lisC);
        
            request.getRequestDispatcher("historialCompra.jsp").forward(request, response);
            
        }
        
        
        
        
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
