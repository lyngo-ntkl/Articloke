package Controllers.Profile;

import Respiratiory.Reaction.ReactionDAO;
import Respiratory.Article.ArticleDAO;
import Respiratory.Article.ArticleDTO;
import Respiratory.Paper.PaperDAO;
import Respiratory.Paper.PaperDTO;
import Respiratory.Topic.TopicDAO;
import Respiratory.User.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ShowMyProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          String URL = "MyProfile.jsp";
        try {
            HttpSession session = request.getSession(false);
            UserDTO user = null;
            if (session != null) {
                user = (UserDTO) session.getAttribute("user");
            }

            String username = null;
            if (user != null) {
                username = user.getUsername();
            }
            List<PaperDTO> papers = null;
            List<ArticleDTO> articles = null;
            Map<String, Integer> topics = null;
            
            int totalCount = 0;
            try {
                papers = PaperDAO.getPapersUsernameLastedModifiedDate(username);
            } catch (SQLException | ClassNotFoundException ex) {
            }

            try {
                articles = ArticleDAO.getArticlesUsernameLatestDate(username);
            } catch (SQLException | ClassNotFoundException ex) {
            }
            
             try {
               totalCount = ReactionDAO.getTotalReaction(username);
            } catch (SQLException | ClassNotFoundException ex) {
            }
      
            
            request.setAttribute("papers", papers);
            request.setAttribute("articles", articles);
            request.setAttribute("totalCount", totalCount);
            
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(URL);
            rd.forward(request, response);
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
