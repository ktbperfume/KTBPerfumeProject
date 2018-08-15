package controller;

import bean.CustomerFacadeLocal;
import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tri
 */
@WebServlet(name = "updateCustomerAdminServlet", urlPatterns = {"/admin/updateCustomerAdminServlet"})
public class updateCustomerAdminServlet extends HttpServlet {

    @EJB
    private CustomerFacadeLocal customerFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Customer p = customerFacade.find(id);
        request.setAttribute("p", p);
        request.getRequestDispatcher("update_customer.jsp").forward(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id==null){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        Customer new1 = customerFacade.find(id);
        String pass = request.getParameter("CustomerPass");
        String status = request.getParameter("CustomerStatus");
        new1.setPassword(pass);
        if (status.equalsIgnoreCase("true")) {
            
            new1.setStatus(true);
        } else {
            new1.setStatus(false);
        }
        customerFacade.edit(new1);
        request.getRequestDispatcher("showCustomerAdminServlet").forward(request, response);
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
