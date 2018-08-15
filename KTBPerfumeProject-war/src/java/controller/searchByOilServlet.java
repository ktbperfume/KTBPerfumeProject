package controller;

import bean.ProductFacadeLocal;
import entity.Product;
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
 * @author MyPC
 */
@WebServlet(name = "searchByOilServlet", urlPatterns = {"/searchByOilServlet"})
public class searchByOilServlet extends HttpServlet {
    @EJB
    private ProductFacadeLocal productFacade;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String oil = request.getParameter("oil");
        
        int count = Integer.parseInt(request.getParameter("i"));
        List<Product> listO = productFacade.searchOilVolume(oil);
        request.setAttribute("listO", listO);
         if(listO.isEmpty()){
            request.setAttribute("noresult", true);
        }else{
            request.setAttribute("noresult", false);
        }
        if(count<0){
            count=0;
        }
        if(count>listO.size()){
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }else if (count + 3 >= listO.size()) {

          //  result = temp.subList(count, temp.size());
            request.setAttribute("end", true);
        } else {
         //   result = temp.subList(count, count + 3);
            request.setAttribute("end", false);
        }
        request.setAttribute("oil", oil);
        request.setAttribute("i", count);
        request.getRequestDispatcher("showProbyOil.jsp").forward(request, response);
        
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
