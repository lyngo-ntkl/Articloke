package Controllers.SearchArticle;

import Respiratory.Article.ArticleDAO;
import Respiratory.Article.ArticleDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowArticleResultServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String URL = "Search.jsp";
        try {
            String keyword = request.getParameter("keyword");
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String topic = request.getParameter("topic");
            String permission = request.getParameter("permission");
            String sortedBy = request.getParameter("sortedBy");
            String action = request.getParameter("action");
            String organization = request.getParameter("organization");

            request.setAttribute("keyword", keyword);
            request.setAttribute("title", title);
            request.setAttribute("author", author);
            request.setAttribute("topic", topic);
            request.setAttribute("permission", permission);
            request.setAttribute("sortedBy", sortedBy);

            List<ArticleDTO> articles = null;
            try {
                articles = ArticleDAO.getArticlesSearch(keyword, title, author, topic, organization, permission, sortedBy);
            } catch (SQLException | ClassNotFoundException ex) {
            }

            request.setAttribute("articles", articles);
            
            
            request.setAttribute("minIndexRow1", 0);
            int maxIndexRow1 = articles.size() - 1;

            if (maxIndexRow1 > 3) {
                maxIndexRow1 = 3;
                request.setAttribute("existRow2", true);
                request.setAttribute("minIndexRow2", 4);
                int maxIndexRow2 = articles.size() - 1;
                if (maxIndexRow2 > 7) {
                    maxIndexRow2 = 7;
                }
                request.setAttribute("maxIndexRow2", maxIndexRow2);

            }
            request.setAttribute("maxIndexRow1", maxIndexRow1);

            request.setAttribute("currentPage", 1);
            int maxPage;
            if (articles == null || articles.isEmpty()) {
                maxPage = 1;
            } else {
                int residual = articles.size() % 8;
                if (residual == 0) {
                    maxPage = articles.size() / 8;
                } else {
                    maxPage = articles.size() / 8 + 1;
                }

            }

            request.setAttribute("maxPage", maxPage);
            request.setAttribute("searchEmpty", true);

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
