package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDB {

    private static Connection connection;

    // Inserisci qui le credenziali che usi per accedere a MySQL (es. tramite Workbench)
    private static final String URL = "jdbc:mysql://localhost:3306/FiscianoDelivery?serverTimezone=UTC";
    private static final String USER = "root"; // Cambia se il tuo utente è diverso
    private static final String PASSWORD = "pakiDB16@"; // Cambia con la tua password di MySQL

    // Metodo statico per ottenere la connessione
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Carica il driver (necessario per le versioni meno recenti di Tomcat/Java)
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Crea la connessione
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connessione al DB FiscianoDelivery avvenuta con successo!");

            } catch (ClassNotFoundException e) {
                System.err.println("Driver MySQL non trovato. Hai aggiunto il .jar in WEB-INF/lib?");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Errore di connessione al database. Controlla credenziali e URL.");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
