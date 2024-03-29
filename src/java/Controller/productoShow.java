/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Comentario;
import Models.Consultas;
import Models.producto;
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
public class productoShow extends HttpServlet {

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
        int idpro = Integer.parseInt(request.getParameter("idprod"));
        Consultas co = new Consultas();
        Consultas co2 = new Consultas();
        Consultas co3 = new Consultas();
        Consultas co4 = new Consultas();
         Consultas co7 = new Consultas();
        
        String loCompro="";
        
        HttpSession sesion = request.getSession();
        String idus = (String)sesion.getAttribute("usuario");
        
        Consultas co5= new Consultas();
        Consultas co6= new Consultas();
        
        int cantPro = co7.cantPro(idpro);
               
        int idUser = co5.getIdUser(idus);
        
        if(co4.obComprado(idUser, idpro)){
            loCompro="true";
        }else{
            loCompro="false";
        }
        
        int likes = co2.cntLikes(idpro);
        int dislikes = co3.cntDislikes(idpro);
        producto proS = co.productoSearch(idpro);
        List<Comentario> lstCome=co6.shwComentario(idpro);
        request.setAttribute("productoSh", proS);
        request.setAttribute("cntLikes", likes);
        request.setAttribute("cntDislikes", dislikes);
        request.setAttribute("compro", loCompro);
        request.setAttribute("lstComentario", lstCome);
        request.setAttribute("cantProducto", cantPro);
        
        request.getRequestDispatcher("producto.jsp").forward(request, response);
      
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
