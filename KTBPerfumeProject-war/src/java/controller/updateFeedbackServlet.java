package controller;

import bean.FeedbackFacadeLocal;
import entity.Feedback;
import entity.UserAdmin;
import java.io.IOException;
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
@WebServlet(name = "updateFeedbackServlet", urlPatterns = {"/admin/updateFeedbackServlet"})
public class updateFeedbackServlet extends HttpServlet {

    @EJB
    private FeedbackFacadeLocal feedbackFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("Id");
        Feedback cur = feedbackFacade.find(id);
        if (cur.getStatus().equalsIgnoreCase("not read")) {
            cur.setStatus("Read");
            feedbackFacade.edit(cur);
        }
        request.setAttribute("b", cur);
        request.getRequestDispatcher("update_feedback.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("feedbackId");
        Feedback x = feedbackFacade.find(id);
        HttpSession session = request.getSession();
        UserAdmin user = (UserAdmin) session.getAttribute("userA");

        String reply = request.getParameter("reply");
        x.setReply(reply);
        x.setUsername(user);
        x.setStatus("Replied");
        feedbackFacade.edit(x);
        request.getRequestDispatcher("showFeedbackAdminServlet").forward(request, response);

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
