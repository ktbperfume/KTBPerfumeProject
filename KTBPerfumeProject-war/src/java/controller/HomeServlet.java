/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.BrandFacadeLocal;
import bean.ProductFacadeLocal;
import entity.Brand;
import entity.Cart;
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
import javax.servlet.http.HttpSession;


@WebServlet(name = "HomeServlet", urlPatterns = {""})
public class HomeServlet extends HttpServlet {

    @EJB
    private BrandFacadeLocal brandFacade;
    @EJB
    private ProductFacadeLocal productFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        
        //home product
        List<Product> result = productFacade.sortDate();
        result = result.subList(0, 6);
        //all brand name
        List<Brand> listBrand = brandFacade.findAll();
        //number of product in each brand
        int[] countBrand = new int[listBrand.size()];
        List<Brand> BrandMale = new ArrayList<>();
        List<Brand> BrandFemale = new ArrayList<>();
        List<Brand> BrandUnisex = new ArrayList<>();
        int[] countMale = new int[listBrand.size()];
        int[] countFemale = new int[listBrand.size()];
        int[] countUnisex = new int[listBrand.size()];
        //count how many product each brand have
        for (int i = 0; i < listBrand.size(); i++) {
            int count = brandFacade.showByBrand(listBrand.get(i)).size();
            countBrand[i] = count;
        }

        for (int i = 0; i < listBrand.size(); i++) {
            //get all product in each brand
            List<Product> listProduct = brandFacade.showByBrand(listBrand.get(i));
            for (int o = 0; o < listProduct.size(); o++) {
                //check if a product is for male
                if (listProduct.get(o).getForGender().equalsIgnoreCase("male")) {
                    //check if this brand is in the BrandMale list
                    if (!BrandMale.contains(listBrand.get(i))) {
                        //add brand name into brand that have product for male list
                        BrandMale.add(listBrand.get(i));
                    }
                    //else count++
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
        session.setAttribute("FemaleBrand", BrandFemale);
        session.setAttribute("MaleBrand", BrandMale);
        session.setAttribute("UniBrand", BrandUnisex);
        session.setAttribute("FemaleCount", countFemale);
        session.setAttribute("MaleCount", countMale);
        session.setAttribute("UniCount", countUnisex);
        session.setAttribute("countB", countBrand);
        session.setAttribute("listBrand", listBrand);
        
        request.setAttribute("result", result);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
