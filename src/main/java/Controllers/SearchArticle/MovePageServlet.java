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

public class MovePageServlet extends HttpServlet {

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
            int minIndexRow1 = Integer.parseInt(request.getParameter("minIndexRow1"));
            int maxIndexRow1 = Integer.parseInt(request.getParameter("maxIndexRow1"));
            int minIndexRow2 = Integer.parseInt(request.getParameter("minIndexRow2"));
            int maxIndexRow2 = Integer.parseInt(request.getParameter("maxIndexRow2"));
            int currentPage = Integer.parseInt(request.getParameter("currentPage"));
            int maxPage = Integer.parseInt(request.getParameter("maxPage"));

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

            if (action.equals("Next")) {
                currentPage += 1;
                minIndexRow1 += 8;
                maxIndexRow1 = articles.size() - 1;
                if (maxIndexRow1 > minIndexRow1 + 11) {
                    maxIndexRow1 = minIndexRow1 + 11;
                    request.setAttribute("existRow2", true);
                    minIndexRow2 = minIndexRow1 + 12;
                    maxIndexRow2 = articles.size() - 1;
                    if (maxIndexRow2 > minIndexRow1 + 15) {
                        maxIndexRow2 = minIndexRow1 + 15;
                    }

                }
            } else if (action.equals("Previous")) {
                currentPage -= 1;  
                maxIndexRow1 =  minIndexRow1 - 5;
                request.setAttribute("existRow2", true);
                minIndexRow2 = minIndexRow1 - 4;
                maxIndexRow2 = minIndexRow1 - 1;
                minIndexRow1 -= 8;
                
            }

            request.setAttribute("articles", articles);
            request.setAttribute("minIndexRow1", minIndexRow1);
            request.setAttribute("maxIndexRow1", maxIndexRow1);
            request.setAttribute("minIndexRow2", minIndexRow2);
            request.setAttribute("maxIndexRow2", maxIndexRow2);
            request.setAttribute("currentPage", currentPage);
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
