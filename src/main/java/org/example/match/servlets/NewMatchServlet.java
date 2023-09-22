package org.example.match.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.match.services.MatchService;
import org.example.player.Player;


import java.io.IOException;
import java.util.UUID;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {
    private final MatchService ongoingMatchesService = MatchService.getOngoingMatchesService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/new-match.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerOne = req.getParameter("player-1");
        String playerTwo = req.getParameter("player-2");
        int setsInMatch = Integer.parseInt(req.getParameter("match-sets"));

        Player firstPlayer = new Player(playerOne.toUpperCase());
        Player secondPlayer = new Player(playerTwo.toUpperCase());
        UUID uuid = UUID.randomUUID();

        ongoingMatchesService.createNewMatch(uuid, firstPlayer, secondPlayer, setsInMatch);

        resp.sendRedirect("match-score?uuid=" + uuid);
    }
}
