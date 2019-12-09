/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Consultas;
import Models.Mensaje;
import Models.proCart;
import Models.producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class mnjMsj extends HttpServlet {

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
        
        int idChat = Integer.parseInt(request.getParameter("idcha"));
        int idCart = Integer.parseInt(request.getParameter("idcar"));
        String mensaje = request.getParameter("msje");
        HttpSession sesion = request.getSession();
        String idus = (String)sesion.getAttribute("usuario");
        
        Consultas co = new Consultas();
        Consultas co2 = new Consultas();
        Consultas co3 = new Consultas();
        Consultas co4 = new Consultas();
        Consultas co5 = new Consultas();
        Consultas co6 = new Consultas();
        
        int idUser = co2.getIdUser(idus);
        
        co.addMsj(mensaje,idUser , idChat);
        
        int iddChat = co3.chatExist(idCart);
        
        List<Mensaje> msjs = co4.getMsj(iddChat);
            
            proCart procart = co5.getCarPro(idCart);
            
            int idpro = procart.getIdproducto();
            
            producto pro = co6.productoSearch(idpro);
            
            String nompro = pro.getNombre();
            
            request.setAttribute("idChat", iddChat);
            request.setAttribute("msjsCht", msjs);
            request.setAttribute("proNom", nompro);
            request.setAttribute("idCcart", idCart);      
        
        
        
        request.getRequestDispatcher("chat.jsp").forward(request, response);
        
      
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
