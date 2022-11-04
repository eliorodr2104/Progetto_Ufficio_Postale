/**
 * @author Eliomar Rodriguez
 * @author Alessandro Duta
 * @since 19.0.1
 * @version %I%, %G%
 * @version 1.0
 * @see GestisciCode#push(String, Cliente) chiede il cliente per inserirlo dentro alla coda selezionata
 * @see GestisciCode#pop(String) restituisce il cliente dentro alla coda selezionata
 * @see GestisciCode#popArrayList(String) restituisce un'ArrayList di clienti
 * @see PagamentoBollettini#push(Cliente) chiede il cliente per inserirlo dentro alla coda
 * @see PagamentoBollettini#pop() restituisce il cliente dentro alla coda
 * @see ServiziPostale#push(Cliente) chiede il cliente per inserirlo nella coda
 * @see ServiziPostale#pop() restituisce il cliente dentro alla coda
 * @see BancoPosta#push(Cliente) chiede il cliente per inserirlo dentro alla coda
 * @see GestisciSportelli crea un'ArrayList di oggetti Cliente
 * Descrizione: Classe Cliente, che viene utilizzata per creare gli oggetti Clienti
 */
public class Cliente {

    private String codiceFiscale, nome, cognome, tipoServizio, ticket;

    /**
     * Metodo costruttore()
     * @param codiceFiscale chiede il codice fiscale della persona
     * @param nome chiede il nome della persona
     * @param cognome chiede il cognome della persona
     * @param tipoServizio chiede il tipo di servizio che desidera fare la persona
     * @param ticket chiede il numero di ticker da assegnare alla persona
     */
    public Cliente(String codiceFiscale, String nome, String cognome, String tipoServizio, String ticket){
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.tipoServizio = tipoServizio;
        this.ticket = ticket;
    }

    /**
     * Metodo setCodiceFiscale(), che setta la variabile codiceFiscale
     * @param codiceFiscale valore a settare dentro la variabile
     */
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    /**
     * Metodo setNome(), che setta la variabile nome
     * @param nome valore a settare dentro la variabile
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo setCognome() che setta la variabile cognome
     * @param cognome valore a settare dentro la variabile
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Metodo setTipoServizio(), che setta la variabile tipoServizio
     * @param tipoServizio valore a settare dentro la variabile
     */
    public void setTipoServizio(String tipoServizio) {
        this.tipoServizio = tipoServizio;
    }

    /**
     * Metodo setTicket(), che setta la variabile ticket
     * @param ticket valore a settare dentro la variabile
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     * Metodo getCodiceFiscale()
     * @return restituisce la variabile codiceFiscale
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Metodo getNome()
     * @return restituisce la variabile nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo getCognome()
     * @return restituisce la variabile cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Metodo getTipoServizio()
     * @return restituisce la variabile tipoServizio
     */
    public String getTipoServizio() {
        return tipoServizio;
    }

    /**
     * Metodo getTicket()
     * @return restituisce la variabile ticket
     */
    public String getTicket() {
        return ticket;
    }
}
