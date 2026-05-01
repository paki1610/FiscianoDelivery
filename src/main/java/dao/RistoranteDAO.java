package dao;

import model.ConnessioneDB;
import model.Ristorante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RistoranteDAO {

    // Metodo classico per recuperare tutti i ristoranti dal database
    public List<Ristorante> doRetrieveAll() {
        List<Ristorante> ristoranti = new ArrayList<>();

        // Usiamo gli attributi che hai definito nel tuo progetto di Basi di Dati
        String query = "SELECT codice, nome, indirizzo FROM Ristorante";

        // Il blocco try-with-resources chiude in automatico la connessione quando finisce
        try (Connection con = ConnessioneDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            // Scorre riga per riga i risultati del database
            while (rs.next()) {
                Ristorante r = new Ristorante();
                r.setCodice(rs.getInt("codice"));
                r.setNome(rs.getString("nome"));
                r.setIndirizzo(rs.getString("indirizzo"));

                // Aggiunge il ristorante alla lista
                ristoranti.add(r);
            }
        } catch (SQLException e) {
            System.err.println("Errore durante il recupero dei ristoranti!");
            e.printStackTrace();
        }

        return ristoranti;
    }
}