package controller;

import bean.ProductFacadeLocal;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "productByPriceServlet", urlPatterns = {"/productByPriceServlet"})
public class productByPriceServlet extends HttpServlet {

    @EJB
    private ProductFacadeLocal productFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String rangePrice = request.getParameter("rangePrice");
        List<Product> listP = new ArrayList<>();
        int count = Integer.parseInt(request.getParameter("i"));
        switch (rangePrice) {
            case "p20_50":
                listP = productFacade.getProductByPrice(20, 50);                
                break;
            case "p50_100":
                listP = productFacade.getProductByPrice(50, 100);
                break;
            case "p100_150":
                listP = productFacade.getProductByPrice(100, 150);
                break;
            case "p150":
                listP = productFacade.getProductByPrice(150, 1000);
                break;

        }
        if(count<0){
            count=0;
        }
        if(count>listP.size()){
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }else if (count + 6 >= listP.size()) {

            listP = listP.subList(count, listP.size());
            request.setAttribute("end", true);
        } else {
            listP = listP.subList(count, count + 6);
            request.setAttribute("end", false);
        }
        
        request.setAttribute("i", count);
        request.setAttribute("listP", listP);
        request.getRequestDispatcher("ShowProduct_byPrice.jsp").forward(request, response);

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
