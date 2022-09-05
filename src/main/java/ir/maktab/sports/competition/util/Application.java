package ir.maktab.sports.competition.util;

import java.sql.Connection;

public class Application {
        private static Connection connection = new DbHelper().connection();

        public static Connection getConnection() {
            return connection;
    }
}
