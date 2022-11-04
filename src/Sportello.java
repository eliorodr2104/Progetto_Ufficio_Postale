/**
 * @author Eliomar Rodriguez
 * @author Alessandro Duta
 * @since 19.0.1
 * @version %I%, %G%
 * @version 1.0
 * @see GestisciSportelli crea l'istanza e anche degli oggetti nella classe GestisciSportelli
 * Descrizione: Classe Sportello, che viene utilizzata per creare gli oggetti Sportello
 */
public class Sportello {
    private String nomeLavoratore, tipologiaServizio, numeroTicket, numeroProgressivo;
    private boolean sportelloLibero;

    /**
     * Metodo costruttore()
     * @param nomeLavoratore chiede nome del lavoratore dello sportello
     * @param tipologiaServizio chiede la tipologia di servizio che svolge quello sportello
     * @param numeroTicket chiede il numero di ticket del cliente
     * @param numeroProgressivo chiede il numero del prossimo ticket del cliente
     * @param sportelloLibero chiede s'è vero ch'è vuoto o no
     * @see GestisciSportelli crea gli oggetti nella classe GestisciSportelli
     */
    public Sportello(String nomeLavoratore, String tipologiaServizio, String numeroTicket, String numeroProgressivo, boolean sportelloLibero){
        this.nomeLavoratore = nomeLavoratore;
        this.tipologiaServizio = tipologiaServizio;
        this.numeroTicket = numeroTicket;
        this.numeroProgressivo = numeroProgressivo;
        this.sportelloLibero = sportelloLibero;
    }

    /**
     * Metodo setNomeLavoratore(), che setta la variabile nomeLavoratore
     * @param nomeLavoratore valore a settare dentro la variabile
     */
    public void setNomeLavoratore(String nomeLavoratore) {
        this.nomeLavoratore = nomeLavoratore;
    }

    /**
     * Metodo setTipologiaServizio(), che setta la variabile tipologiaServizio
     * @param tipologiaServizio valore a settare dentro la variabile
     */
    public void setTipologiaServizio(String tipologiaServizio) {
        this.tipologiaServizio = tipologiaServizio;
    }

    /**
     * Metodo setNumeroTicket(), che setta la variabile numeroTicket
     * @param numeroTicket valore a settare dentro la variabile
     */
    public void setNumeroTicket(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    /**
     * Metodo setNumeroProgressivo(), che setta la variabile numeroProgressivo
     * @param numeroProgressivo valore a settare dentro la variabile
     */
    public void setNumeroProgressivo(String numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }

    /**
     * Metodo setSportelloLibero(), che setta la variabile sportelloLibero
     * @param sportelloLibero valore a settare dentro la variabile
     */
    public void setSportelloLibero(boolean sportelloLibero) {
        this.sportelloLibero = sportelloLibero;
    }

    /**
     * Metodo getNomeLavoratore()
     * @return restituisce la variabile nomeLavoratore
     */
    public String getNomeLavoratore() {
        return nomeLavoratore;
    }

    /**
     * Metodo getTipologiaServizio()
     * @return restituisce la variabile tipologiaServizio
     */
    public String getTipologiaServizio() {
        return tipologiaServizio;
    }

    /**
     * Metodo getNumeroTicket()
     * @return restituisce la variabile numeroTicket
     */
    public String getNumeroTicket() {
        return numeroTicket;
    }

    /**
     * Metodo getNumeroProgressivo()
     * @return restituisce la variabile numeroProgressivo
     */
    public String getNumeroProgressivo() {
        return numeroProgressivo;
    }

    /**
     * Metodo isSportelloLibero()
     * @return restituisce la variabile sportelloLibero
     */
    public boolean isSportelloLibero() {
        return sportelloLibero;
    }
}
