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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernandourg
 */
public class goChat extends HttpServlet {

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
        int idCart = Integer.parseInt(request.getParameter("idcart"));
        Consultas co = new Consultas();
        
        if(co.isChat(idCart))
        {
            Consultas co2 = new Consultas();
            
            int iddChat = co2.chatExist(idCart);
            
            Consultas co3 = new Consultas();
            Consultas co4 = new Consultas();
            Consultas co5 = new Consultas();
            
            List<Mensaje> msjs = co3.getMsj(iddChat);
            
            proCart procart = co4.getCarPro(idCart);
            
            int idpro = procart.getIdproducto();
            
            producto pro = co5.productoSearch(idpro);
            
            String nompro = pro.getNombre();
            
            request.setAttribute("idChat", iddChat);
            request.setAttribute("msjsCht", msjs);
            request.setAttribute("proNom", nompro);
            request.setAttribute("idCcart", idCart);

            
            request.getRequestDispatcher("chat.jsp").forward(request, response);
            
        }
        else if(co.isChat(idCart)==false) {
            
            Consultas co2 = new Consultas();
            Consultas co3 = new Consultas();
            Consultas co4 = new Consultas();
            Consultas co5 = new Consultas();
            
            proCart procart = co2.getCarPro(idCart);
            
            int iduser = procart.getIdusuario();
            int idpro = procart.getIdproducto();
            int admin = 3;
            
            if(co3.chatMK(iduser, admin, idpro, idCart))
            {
            
                int iddChat = co4.chatExist(idCart);

                List<Mensaje> msjs = co3.getMsj(iddChat);

                producto pro = co5.productoSearch(idpro);

                String nompro = pro.getNombre();
                
                request.setAttribute("idChat", iddChat);
                request.setAttribute("msjsCht", msjs);
                request.setAttribute("proNom", nompro);
                request.setAttribute("idCcart", idCart);

                request.getRequestDispatcher("chat.jsp").forward(request, response);
            }
            
            else{
                request.getRequestDispatcher("dashboard").forward(request, response);
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
