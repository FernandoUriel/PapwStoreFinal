/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Consultas;
import Utils.FilesUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author fernandourg
 */
@MultipartConfig(maxFileSize = 1000*1000*5, maxRequestSize = 1000*1000*25, fileSizeThreshold = 1000*1000)
public class productoVenta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  
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
        String descripcion = request.getParameter("descripcion");
        int unidades = Integer.parseInt(request.getParameter("unidades"));
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        Part file = request.getPart("imagen1");
        int estado = Integer.parseInt(request.getParameter("estado"));
        boolean estadoB=false;
        
        HttpSession sesion = request.getSession();
        String idus = (String)sesion.getAttribute("usuario");
        Consultas co2= new Consultas();
        int idUser = co2.getIdUser(idus);
        
        String idusss = Integer.toString(idUser);
        
        if(estado==1){
            estadoB=true;
        
        }else if(estado==2){
            estadoB=false;
        
        }
        //video
        String fileName = this.getServletContext().getRealPath("/VIDEOS");
        //Esto solo es para mandarlos a la carpeta de videos que pos se crea sola y todo
        String newname =idusss+System.currentTimeMillis();
        
        fileName = fileName + "/" +  newname;
        FileOutputStream videoStreamOUT = null;
        InputStream videoStreamIN = null;
        
         try 
            {
                videoStreamIN = request.getPart("video").getInputStream();
                videoStreamOUT = new FileOutputStream(fileName);
                int leido = 0;
                leido = videoStreamIN.read();
                while (leido != -1) {
                    videoStreamOUT.write(leido);
                    leido = videoStreamIN.read();
                }
            } catch (FileNotFoundException ex) {
                System.out.print(ex);
            } catch (IOException ex) {
                System.out.print(ex);
            } finally {
                if(videoStreamOUT!=null)
                {
                videoStreamOUT.flush();
                }
                videoStreamOUT.close();
                videoStreamIN.close();
            }
        
        
        String path = request.getServletContext().getRealPath("");
        File fileSaveDir = new File(path + FilesUtils.RUTE_USER_IMAGE);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }
        
        //Resguardamos la imagen
        String contentType = file.getContentType();//Resguarden esto para saber el tipo
        String nameImage =  file.getName() + System.currentTimeMillis() + FilesUtils.GetExtension(contentType);
        file.write(path + nameImage);
        
        Consultas co = new Consultas();
        
          if(co.productoVenta(nombre, descripcion, unidades,estadoB, categoria,file.getInputStream(),newname))
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
