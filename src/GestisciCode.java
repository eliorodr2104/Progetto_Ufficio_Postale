import java.util.ArrayList;

/**
 * @author Eliomar Rodriguez
 * @author Alessandro Duta
 * @since 19.0.1
 * @version %I%, %G%
 * @version 1.0
 * @see GestisciSportelli creazione dell'istanza nella classe gestisciSportelli
 * Descrizione: Classe GestisciCode, che gestisce unisce tutta la logica delle tre code e le unisci in una singola classe
 */
public class GestisciCode {
    //Creazioni delle tre istanze
    BancoPosta bancoPosta = new BancoPosta();
    PagamentoBollettini pagamentoBollettini = new PagamentoBollettini();
    ServiziPostale serviziPostale = new ServiziPostale();

    /**
     * Metodo costruttore(), Vuoto
     * @see GestisciSportelli Creazione dell'istanza nella classe GestisciSportelli
     */
    public GestisciCode(){}

    /**
     * Metodo push(), che inserisci l'oggetto dentro la coda selezionata in precedenza
     * @param tipoCoda chiede il tipo della coda dove si deve inserire il cliente
     * @param cliente chiede l'oggetto cliente
     * @see GestisciSportelli#aggiungerePersonaCoda(String, String, String, String, String, String) che chiama il metodo
     *      e inserisce il cliente dentro alla coda
     */
    public void push(String tipoCoda, Cliente cliente){
        switch (tipoCoda){
            case "banco_posta" -> bancoPosta.push(cliente);
            case "servizi_postale" -> serviziPostale.push(cliente);
            case "pagamento_bollettini" -> pagamentoBollettini.push(cliente);
        }
    }

    /**
     * Metodo pop(), che chiede il tipo della coda e restituisce il valore preso dalla coda selezionata
     * @param tipoCoda chiede il tipo della coda dove si deve inserire il cliente
     * @return il cliente che c'era dentro alla coda
     * @see GestisciSportelli viene richiamato molte volte per prendere i clienti dalla coda
     */
    public Cliente pop(String tipoCoda){
        switch (tipoCoda){
            case "banco_posta" -> {
                return bancoPosta.pop();
            }
            case "servizi_postale" -> {
                return serviziPostale.pop();
            }
            case "pagamento_bollettini" -> {
                return pagamentoBollettini.pop();
            }
        }

        return null;
    }

    /**
     * Metodo isEmpty(), che restituisce se la coda selezionata è vuota
     * @param tipoCoda chiede il tipo della coda dove si deve inserire il cliente
     * @return true se la coda è vuota, altrimenti false
     * @see GestisciSportelli viene utilizzato molte volte come controllo per evitare degli errori nell'esecuzione
     */
    public boolean isEmpty(String tipoCoda){
        switch (tipoCoda){
            case "banco_posta" -> {
                return bancoPosta.isEmpty();
            }
            case "servizi_postale" -> {
                return serviziPostale.isEmpty();
            }
            case "pagamento_bollettini" -> {
                return pagamentoBollettini.isEmpty();
            }
        }

        return false;
    }

    /**
     * Metodo popArray(), che prende l'Arraylist della coda selezionata e lo restituisce
     * @param tipoCoda chiede il tipo della coda dove si deve inserire il cliente
     * @return l'ArrayList selezionato
     */
    public ArrayList<Cliente> popArrayList(String tipoCoda){
        switch (tipoCoda){
            case "banco_posta" -> {
                return bancoPosta.clienteArrayList;
            }
            case "servizi_postale" -> {
                return serviziPostale.clienteArrayList;
            }
            case "pagamento_bollettini" -> {
                return pagamentoBollettini.clienteArrayList;
            }
        }

        return null;
    }

}
