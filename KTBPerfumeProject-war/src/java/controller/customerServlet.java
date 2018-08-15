package controller;

import bean.CustomerFacadeLocal;
import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "customerServlet", urlPatterns = {"/customerServlet"})
public class customerServlet extends HttpServlet {

    @EJB
    private CustomerFacadeLocal customerFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String command = request.getParameter("command");
        //String url = "";
        Customer cus = new Customer();
        HttpSession session = request.getSession();
        if (command.equalsIgnoreCase("signup")) {
            cus.setCustomerId("CUS" + new Date().getTime());
            cus.setFullName(request.getParameter("fullName"));
            cus.setPassword(request.getParameter("pass"));
            if (request.getParameter("pass").equals(request.getParameter("re_pass"))) {
                cus.setPassword(request.getParameter("pass"));
            } else {
                String error = "Password and Confirm Password not match!";
                request.setAttribute("error", error);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }

            cus.setGender(request.getParameter("gender"));
            cus.setDateOfBirth(new Date(request.getParameter("date")));
            if (customerFacade.isExistedEmail(request.getParameter("email"))) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                cus.setEmail(request.getParameter("email"));
            }
            cus.setMobile(request.getParameter("phone"));
            cus.setStatus(Boolean.TRUE);
            cus.setAvatar("/KTBPerfumeProject-war/images/avatar/noimage.jpg");
            customerFacade.create(cus);
            session.setAttribute("cus", cus);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
