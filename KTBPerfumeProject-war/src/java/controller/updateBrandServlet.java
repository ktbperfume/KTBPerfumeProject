/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.BrandFacadeLocal;
import entity.Brand;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "updateBrandServlet", urlPatterns = {"/admin/updateBrandServlet"})
@MultipartConfig
public class updateBrandServlet extends HttpServlet {

    @EJB
    private BrandFacadeLocal brandFacade;
    private String path = "";
    private String brandId = "";
    private static final long SerialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        brandId = request.getParameter("brandId");

        Brand b = brandFacade.find(brandId);
        request.setAttribute("b", b);
        request.getRequestDispatcher("update_brand.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        path = uploadFile(request);
        String id = request.getParameter("Brandid");
        String name = request.getParameter("name");
        String logo = path;
        String des = request.getParameter("des");

        Brand x = brandFacade.find(id);
        x.setBrandName(name);
        x.setDescription(des);
        if (!logo.equalsIgnoreCase("nochange")) {
            x.setLogo(logo);
        }
        brandFacade.edit(x);
        request.setAttribute("message", logo);
        request.getRequestDispatcher("showBrandAdminServlet").forward(request, response);

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
        String basePath = getServletContext().getRealPath("") + File.separator+"images"+File.separator+"brand" +File.separator;
            String warFile = basePath.substring(0, basePath.length() - 72) + File.separator+"KTBPerfumeProject-war"+File.separator+"web"+File.separator+"images"+File.separator+"brand" +File.separator;

        try {
            Part filePart = request.getPart("file");
            fileName = (String) getFileName(filePart);
            if (fileName.length() == 0) {
                return "nochange";
            }
            
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
            filePath = getServletContext().getContextPath() + "/images/brand/"+ fileName;
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
