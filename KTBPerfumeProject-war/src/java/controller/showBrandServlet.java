package controller;

import bean.BrandFacadeLocal;
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
@WebServlet(name = "showBrandServlet", urlPatterns = {"/showBrandServlet"})
public class showBrandServlet extends HttpServlet {

    @EJB
    private BrandFacadeLocal brandFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Brand> listBrand = brandFacade.findAll();

        String action = (String) request.getAttribute("action");
        int[] countBrand = new int[listBrand.size()];
        List<Brand> BrandMale = new ArrayList<>();
        List<Brand> BrandFemale = new ArrayList<>();
        List<Brand> BrandUnisex = new ArrayList<>();
        int[] countMale = new int[listBrand.size()];
        int[] countFemale = new int[listBrand.size()];
        int[] countUnisex = new int[listBrand.size()];

        for (int i = 0; i < listBrand.size(); i++) {
            int count = brandFacade.showByBrand(listBrand.get(i)).size();
            countBrand[i] = count;
        }

        for (int i = 0; i < listBrand.size(); i++) {
            List<Product> listProduct = brandFacade.showByBrand(listBrand.get(i));
            for (int o = 0; o < listProduct.size(); o++) {
                if (listProduct.get(o).getForGender().equalsIgnoreCase("male")) {
                    if (!BrandMale.contains(listBrand.get(i))) {
                        BrandMale.add(listBrand.get(i));
                    }
                    countMale[BrandMale.indexOf(listBrand.get(i))]++;
                } else if (listProduct.get(o).getForGender().equalsIgnoreCase("female")) {
                    if (!BrandFemale.contains(listBrand.get(i))) {
                        BrandFemale.add(listBrand.get(i));
                    }
                    countFemale[BrandFemale.indexOf(listBrand.get(i))]++;
                } else {
                    if (!BrandUnisex.contains(listBrand.get(i))) {
                        BrandUnisex.add(listBrand.get(i));
                    }
                    countUnisex[BrandUnisex.indexOf(listBrand.get(i))]++;
                }
            }
        }
        request.setAttribute("FemaleBrand", BrandFemale);
        request.setAttribute("MaleBrand", BrandMale);
        request.setAttribute("UniBrand", BrandUnisex);
        request.setAttribute("FemaleCount", countFemale);
        request.setAttribute("MaleCount", countMale);
        request.setAttribute("UniCount", countUnisex);
        request.setAttribute("countB", countBrand);
        request.setAttribute("listBrand", listBrand);
        if (action == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher(action).forward(request, response);
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
