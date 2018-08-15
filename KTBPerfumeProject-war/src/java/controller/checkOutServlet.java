package controller;

import bean.OrderdetailFacadeLocal;
import bean.OrderinfoFacadeLocal;
import entity.Cart;
import entity.Customer;
import entity.Item;
import entity.Orderdetail;
import entity.Orderinfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "checkOutServlet", urlPatterns = {"/checkOutServlet"})
public class checkOutServlet extends HttpServlet {
    @EJB
    private OrderdetailFacadeLocal orderdetailFacade;
    @EJB
    private OrderinfoFacadeLocal orderinfoFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String payment = request.getParameter("payment");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Customer cus = (Customer) session.getAttribute("cus");
        List<Orderdetail> listD = new ArrayList<>();
        
//        try {
            String ID = "O" + (new Date().getTime());            
            Orderinfo orderI = new Orderinfo();
            orderI.setOrderCode(ID);
            orderI.setDate(new Timestamp(new Date().getTime()));
            orderI.setPaymentMethod(payment);
            orderI.setDeliveryTo(address);
            orderI.setMobile(phone);
            orderI.setCustomerId(cus);
            orderI.setStatus(true);
            orderI.setTotal(cart.GrandTotalCart());
            int count=0;
            orderinfoFacade.create(orderI);
            for (Map.Entry<String, Item> list : cart.getCartItems().entrySet()) {
                count++;
                orderdetailFacade.create(new Orderdetail(ID+"_"+count, list.getValue().getQuantity(), orderI ,list.getValue().getProduct()));
                listD.add(new Orderdetail(ID+"_"+count, list.getValue().getQuantity(), orderI ,list.getValue().getProduct()));
            }
            cart = new Cart();
            session.setAttribute("cart", cart);            
            
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        request.setAttribute("orderI", orderI);
        request.setAttribute("listD", listD);
        request.getRequestDispatcher("orderView.jsp").forward(request, response);
        
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
