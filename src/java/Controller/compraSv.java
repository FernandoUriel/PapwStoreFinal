/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernandourg
 */
@MultipartConfig(maxFileSize = 1000*1000*5, maxRequestSize = 1000*1000*25, fileSizeThreshold = 1000*1000)
public class compraSv extends HttpServlet {

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
            int unidades = Integer.parseInt(request.getParameter("proCant"));
            int idCarrito = Integer.parseInt(request.getParameter("idcarrito"));
            int metodoP = Integer.parseInt(request.getParameter("metodoP"));
            int preP = Integer.parseInt(request.getParameter("precioP"));
            Consultas co = new Consultas();
            Consultas co2 = new Consultas();
            Consultas co3 = new Consultas();
            Consultas co4 = new Consultas();
            Consultas co5 = new Consultas();
            Consultas co6 = new Consultas();
            
            int proid = co.proxCart(idCarrito);
            
            int unPro = co2.cantPro(proid);
            int resta = unPro-unidades;
            
            HttpSession sesion = request.getSession();
            String idus = (String)sesion.getAttribute("usuario");
            
            int idUser = co3.getIdUser(idus);
            
            
            if(resta<0){
                request.setAttribute("uni", unidades);
                request.setAttribute("uniPro", unPro);
                request.getRequestDispatcher("errCompra.jsp").forward(request, response);
            }else{
                co4.addCompraH(preP, unidades, metodoP, idUser, proid);
                
                co5.updCnt(resta, proid);
                co6.cartDel(idCarrito);
                request.getRequestDispatcher("dashboard").forward(request, response);
            }
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
