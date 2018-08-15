package controller;

import bean.ProductFacadeLocal;
import entity.Cart;
import entity.Item;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet(name = "cartServlet", urlPatterns = {"/cartServlet"})
public class cartServlet extends HttpServlet {
    @EJB
    private ProductFacadeLocal productFacade;     
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String command = request.getParameter("command");
        String proId = request.getParameter("proId");
        Cart cart = (Cart) session.getAttribute("cart");
        
        try {
            Product product = productFacade.find(proId);
            switch(command){
                case "plus":
                    if(cart.getCartItems().containsKey(proId)){
                        cart.insertToCart(proId, new Item(product,cart.getCartItems().get(proId).getQuantity()));
                    }else{
                        cart.insertToCart(proId, new Item(product,1));
                    }  
                break;
                    case "remove":
                        cart.removeToCart(proId);
                        break;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
        
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

    }
}
