package org.example;

import org.example.db_utils.SessionFactoryUtil;
import org.example.player.Player;
import org.example.player.PlayerDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Player player = new Player("ALBERT");
        Player player1 = new Player("STEPAN");
        Player player2 = new Player("LOH");
        Transaction transaction = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(player);
            session.save(player1);
            session.save(player2);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            List<Player> students = session.createQuery("from Player", Player.class).list();
            students.forEach(s -> System.out.println(s.getName()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        PlayerDao playerDao = new PlayerDao();

        System.out.println(playerDao.getByName("LOH"));
    }
}
