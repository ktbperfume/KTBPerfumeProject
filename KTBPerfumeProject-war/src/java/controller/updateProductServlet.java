/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.BrandFacadeLocal;
import bean.ProductFacadeLocal;
import entity.Brand;
import entity.Product;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Date;
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

/**
 *
 * @author nguye
 */
@WebServlet(name = "updateProductServlet", urlPatterns = {"/admin/updateProductServlet"})
@MultipartConfig
public class updateProductServlet extends HttpServlet {

    @EJB
    private BrandFacadeLocal brandFacade;

    @EJB
    private ProductFacadeLocal productFacade;

    String ProductId = "";

    private String path = "";
    private static final long SerialVersionUID = 1L;
    private static final String UPLOAD_DIR = "product";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        ProductId = request.getParameter("ProductId");

        Product p = productFacade.find(ProductId);
            List<Brand> listBrand = brandFacade.findAll();
            request.setAttribute("listBrand", listBrand);
        request.setAttribute("p", p);
        request.getRequestDispatcher("update_product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        path = uploadFile(request);
        String id = request.getParameter("Productid");
        String name = request.getParameter("Productname");
        String Bid = request.getParameter("PBrandid");
        Brand x = brandFacade.find(Bid);
        String des = request.getParameter("PDescription");
        String gen = request.getParameter("optionsRadiosInline");
        int price = Integer.parseInt(request.getParameter("Productprice"));
        String image = path;
        String size = request.getParameter("Productsize");
        String country = request.getParameter("Productcountry");
        String type = request.getParameter("Producttype");
        int year = Integer.parseInt(request.getParameter("year"));
        Date dateRef = new Date();
        Product new1 = productFacade.find(id);
        new1.setProductName(name);
        new1.setBrandId(x);
        new1.setDescription(des);
        new1.setForGender(gen);
        new1.setPrice(price);
        if (!image.equalsIgnoreCase("nochange")) {
            new1.setImage(image);
        }
        new1.setSizeOfBottle(size);
        new1.setCountry(country);
        new1.setVolumeOfPerfumeOil(type);
        new1.setYearIssue(year);
        productFacade.edit(new1);
        request.setAttribute("product", new1);

        request.setAttribute("message", image);
        request.getRequestDispatcher("showProductServlet").forward(request, response);

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
            String basePath = getServletContext().getRealPath("") +File.separator + "images" + File.separator + UPLOAD_DIR + File.separator;
            String warFile = basePath.substring(0, basePath.length() - 74) + File.separator +"KTBPerfumeProject-war"+File.separator +"web"+File.separator +"images" + File.separator + UPLOAD_DIR + File.separator;

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
            filePath = getServletContext().getContextPath() + "/images/" + UPLOAD_DIR + "/" + fileName;
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
