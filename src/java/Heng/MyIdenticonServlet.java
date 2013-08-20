/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Heng;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.docuverse.identicon.IdenticonRenderer;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author hdr
 */
public class MyIdenticonServlet extends HttpServlet {
    
    private static String salt="thisisagoodlookingsalt";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UnsupportedEncodingException {
        //setup
        processRequest(request, response);
        String codeString=request.getParameter("c");
        
        //obtain identicon code
        int code=-1;
        try {
            code=IdenticonCodeGenerator.getIdenticonCode(codeString+salt);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MyIdenticonServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //render and generate image
        IdenticonRenderer render=new MyIdenticonRenderer();
        RenderedImage renderedImage=render.render(code, 64);
        ByteArrayOutputStream byteOut=new ByteArrayOutputStream();
        ImageIO.write(renderedImage, "PNG", byteOut);
        byte[] imageBytes=byteOut.toByteArray();
        response.setContentType("image/png");
        response.setContentLength(imageBytes.length);
        response.getOutputStream().write(imageBytes);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
