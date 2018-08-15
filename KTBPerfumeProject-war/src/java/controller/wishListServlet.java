package controller;

import bean.ProductFacadeLocal;
import bean.WishlistFacadeLocal;
import entity.Customer;
import entity.Product;
import entity.Wishlist;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
@WebServlet(name = "wishListServlet", urlPatterns = {"/wishListServlet"})
public class wishListServlet extends HttpServlet {

    @EJB
    private ProductFacadeLocal productFacade;
    @EJB
    private WishlistFacadeLocal wishlistFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Customer cus = (Customer) session.getAttribute("cus");
        String id = request.getParameter("id");
        if (id != null) {
            Product x = productFacade.find(id);
            Wishlist newW = new Wishlist();
            newW.setCustomerId(cus);
            newW.setProductId(x);
            newW.setWishlistId("W" + cus.getCustomerId() +x.getProductId());
            wishlistFacade.create(newW);
        }
        List<Wishlist> listW = (List<Wishlist>) cus.getWishlistCollection();
        request.setAttribute("listW", listW);
        request.getRequestDispatcher("wishList.jsp").forward(request, response);

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
