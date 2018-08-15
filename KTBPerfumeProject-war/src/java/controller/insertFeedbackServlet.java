/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.FeedbackFacadeLocal;
import entity.Customer;
import entity.Feedback;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tri
 */
@WebServlet(name = "insertFeedbackServlet", urlPatterns = {"/insertFeedbackServlet"})
public class insertFeedbackServlet extends HttpServlet {

    @EJB
    private FeedbackFacadeLocal feedbackFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Customer cus = (Customer) session.getAttribute("cus");
        String subject = request.getParameter("subject");
        String content = request.getParameter("message");
        if (cus == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            Feedback x = new Feedback();
            x.setFeedbackId("fb" + cus.getCustomerId() + (new Date().getTime()));
            x.setCustomerId(cus);
            x.setContent(content);
            x.setDate(new Timestamp(new Date().getTime()));
            x.setReply("");
            x.setStatus("Not Read");
            x.setSubject(subject);
            x.setUsername(null);
            feedbackFacade.create(x);
        }
        request.getRequestDispatcher("./").forward(request, response);
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
