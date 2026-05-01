package model;

public class Ristorante {

    private int codice;
    private String nome;
    private String indirizzo;
    // Potremmo aggiungere orarioApertura, ecc., ma per ora teniamo le cose semplici

    // Costruttore vuoto (obbligatorio per i JavaBean)
    public Ristorante() {}

    // Costruttore con parametri
    public Ristorante(int codice, String nome, String indirizzo) {
        this.codice = codice;
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    // --- GETTER E SETTER ---

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
