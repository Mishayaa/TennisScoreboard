package org.example.match;

import sun.net.httpserver.HttpServerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/new-match")
public class MatchServlet extends HttpServlet {
    private final MatchDao matchDao;

    public MatchServlet(MatchDao matchDao) {
        this.matchDao = matchDao;
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerOne = req.getParameter("player-1");
        String playerTwo = req.getParameter("player-2");
        int setsInMatch = Integer.parseInt(req.getParameter("match-sets"));


    }
}
