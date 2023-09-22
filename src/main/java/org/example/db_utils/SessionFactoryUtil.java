package org.example.db_utils;

import org.example.match.Match;
import org.example.player.Player;
import org.hibernate.SessionFactory;

import javax.security.auth.login.AppConfigurationEntry;

import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Player.class);
                configuration.addAnnotatedClass(Match.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return sessionFactory;
    }
}
