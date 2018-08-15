/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.UserAdminFacadeLocal;
import entity.UserAdmin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author tri
 */
@WebServlet(name = "updateUserAdminServlet", urlPatterns = {"/admin/updateUserAdminServlet"})
@MultipartConfig
public class updateUserAdminServlet extends HttpServlet {
    @EJB
    private UserAdminFacadeLocal userAdminFacade;

    String ProductId = "";

    private String path = "";
    private static final long SerialVersionUID = 1L;
    private static final String UPLOAD_DIR = "avatar";
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateUserAdminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateUserAdminServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String id = request.getParameter("Id");
        UserAdmin cur = userAdminFacade.find(id);

        request.setAttribute("p", cur);
        request.getRequestDispatcher("updateUserAdmin.jsp").forward(request, response);
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
        path = uploadFile(request);
        String image = path;
        String username=request.getParameter("UserId");
        UserAdmin new1=userAdminFacade.find(username);
        String pass=request.getParameter("UserPass");
        String name=request.getParameter("UserName");
        String email=request.getParameter("UserEmail");
        String role=request.getParameter("role");
        new1.setFullName(name);
        new1.setPassword(pass);
        new1.setEmail(email);
        new1.setRole(role);
        if (!image.equalsIgnoreCase("nochange")) {
            new1.setAvatar(image);
        }
        userAdminFacade.edit(new1);
        request.getRequestDispatcher("showUserAdminServlet").forward(request, response);
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
        processRequest(request, response);
    }

   private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
        String fileName = "";
        String filePath = "";
        try {
            Part filePart = request.getPart("file");
            fileName = (String) getFileName(filePart);
            if (fileName.length() == 0) {
                return "nochange";
            }
            String basePath = getServletContext().getRealPath("") + "\\images" + File.separator + UPLOAD_DIR + File.separator;
            String warFile = basePath.substring(0, basePath.length() - 73) + "\\KTBPerfumeProject-war\\web\\images" + File.separator + UPLOAD_DIR + File.separator;

            File uploadDir = new File(basePath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            uploadDir = new File(warFile);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            InputStream inputStream = null;
            OutputStream outputStream = null;
            filePath = getServletContext().getContextPath() +  File.separator +"images"+File.separator + UPLOAD_DIR + File.separator + fileName;
            try {

                File outputFilePath = new File(basePath + fileName);
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }

                outputFilePath = new File(warFile + fileName);
                inputStream = null;
                inputStream = filePart.getInputStream();
                outputStream = null;
                outputStream = new FileOutputStream(outputFilePath);
                read = 0;
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (Exception e) {
                e.printStackTrace();
                fileName = "";
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }

        } catch (Exception e) {
            fileName = "";
        }
        return filePath;
    }

    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("*****partHeader :" + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }

        return null;
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
