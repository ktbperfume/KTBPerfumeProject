package controller;

import bean.UserAdminFacadeLocal;
import entity.UserAdmin;
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

@WebServlet(name = "insertUserServlet", urlPatterns = {"/insertUserServlet"})
@MultipartConfig
public class insertUserServlet extends HttpServlet {

    @EJB
    private UserAdminFacadeLocal userAdminFacade;

    private String path = "";

    private static final long SerialVersionUID = 1L;
    private static final String UPLOAD_DIR = "avatar";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String avatar = path;
            String role = request.getParameter("role");
            boolean status = true;

            UserAdmin u = new UserAdmin();
            u.setUsername(username);
            u.setPassword(password);
            u.setFullName(fullName);
            u.setEmail(email);
            u.setAvatar(avatar);
            u.setRole(role);
            u.setStatus(status);
            userAdminFacade.create(u);
            request.setAttribute("message", avatar);
            request.getRequestDispatcher("showUserAdminServlet").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
        path = uploadFile(request);
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
