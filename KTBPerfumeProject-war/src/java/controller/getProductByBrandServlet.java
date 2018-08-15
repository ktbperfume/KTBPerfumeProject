package controller;

import bean.BrandFacadeLocal;
import bean.ProductFacadeLocal;
import entity.Brand;
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
@WebServlet(name = "getProductByBrandServlet", urlPatterns = {"/getProductByBrandServlet"})
public class getProductByBrandServlet extends HttpServlet {

    @EJB
    private ProductFacadeLocal productFacade;

    @EJB
    private BrandFacadeLocal brandFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String gen = request.getParameter("gen");
        String Searchname = request.getParameter("searchName");
        List<Product> result = new ArrayList<>();
        List<Product> temp = new ArrayList<>();
        int count = Integer.parseInt(request.getParameter("i"));

        if (id == null) {
            request.setAttribute("action", "ShowProduct.jsp");
            if (Searchname != null) {
                temp = productFacade.searchName(Searchname);
            } else {
                temp = productFacade.findAll();
            }
        } else {
            Brand x = brandFacade.find(id);
            List<Product> list = brandFacade.showByBrand(x);
            if (Searchname != null) {
                temp = productFacade.searchName(Searchname);
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (gen == null) {
                        temp.add(list.get(i));
                    } else if (list.get(i).getForGender().equalsIgnoreCase(gen)) {
                        temp.add(list.get(i));
                    }
                }

            }
            request.setAttribute("action", "ShowProduct_byBrand.jsp");
            request.setAttribute("brand", x);

        }
        if(temp.isEmpty()){
            request.setAttribute("noresult", true);
        }else{
            request.setAttribute("noresult", false);
        }
        if(count<0){
            count=0;
        }
        if(count>temp.size()){
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }else if (count + 3 >= temp.size()) {

          //  result = temp.subList(count, temp.size());
            request.setAttribute("end", true);
        } else {
         //   result = temp.subList(count, count + 3);
            request.setAttribute("end", false);
        }
        request.setAttribute("Searchname", Searchname);
        request.setAttribute("result", temp);
        request.setAttribute("i", count);
        request.getRequestDispatcher("showBrandServlet").forward(request, response);
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
