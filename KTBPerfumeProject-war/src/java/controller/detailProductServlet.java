package controller;

import bean.BrandFacadeLocal;
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
@WebServlet(name = "detailProductServlet", urlPatterns = {"/detailProductServlet"})
public class detailProductServlet extends HttpServlet {
    @EJB
    private BrandFacadeLocal brandFacade;
    @EJB
    private ProductFacadeLocal productFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("proId");
        List<Product> proList = productFacade.findAll();
        Product pro = productFacade.findProductById(id);
        List<Product> recomPro = productFacade.getByBrand(pro.getBrandId());
        recomPro.remove(pro);
        request.setAttribute("recomPro", recomPro);
        request.setAttribute("pro", pro);
        request.setAttribute("proList", proList);
        request.getRequestDispatcher("product_detail.jsp").forward(request, response);
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
