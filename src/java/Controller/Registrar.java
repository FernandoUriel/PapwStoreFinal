/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Consultas;
import Utils.FilesUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author fernandourg
 */
@MultipartConfig(maxFileSize = 1000*1000*5, maxRequestSize = 1000*1000*25, fileSizeThreshold = 1000*1000)
public class Registrar extends HttpServlet {
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
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String usuario = request.getParameter("username");
        String contrasena = request.getParameter("password");
        String correo = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        Part file = request.getPart("imagen");
        
        String path = request.getServletContext().getRealPath("");
        File fileSaveDir = new File(path + FilesUtils.RUTE_USER_IMAGE);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }
        
        String contentType = file.getContentType();//Resguarden esto para saber el tipo
        String nameImage =  file.getName() + System.currentTimeMillis() + FilesUtils.GetExtension(contentType);
        file.write(path + nameImage);
        
        Consultas co = new Consultas();
        
         if(co.registrar(nombre, apellido, direccion, telefono, usuario, correo,contrasena,file.getInputStream()))
         {
            response.sendRedirect("dashboard");
        }else{
            response.sendRedirect("index.html");
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
