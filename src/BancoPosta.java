import java.util.ArrayList;

/**
 * @author Eliomar Rodriguez
 * @author Alessandro Duta
 * @since 19.0.1
 * @version %I%, %G%
 * @version 1.0
 * @see GestisciCode Creazione dell'istanza nella classe GestisciCode
 * Descrizione: Classe BancoPosta, che gestisce la coda per i clienti che desiderano fare operazioni di tipo banco posta
 */
public class BancoPosta {
    public final ArrayList<Cliente> clienteArrayList;
    private int testa, coda;

    /**
     * Metodo costruttore()
     * @see GestisciCode Creazione dell'istanza nella classe Gestisci code
     */
    public BancoPosta(){
        this.clienteArrayList = new ArrayList<>();
        this.testa = 0;
        this.coda = 0;
    }

    /**
     * Metodo push(), che inserisce il cliente dentro all'ArrayList e aumenta la coda
     * @param clienteAggiungere il cliente a inserire dentro l'ArrayList
     * @see GestisciCode#push(String, Cliente) viene utilizzato gestire l'utilizzo della coda
     */
    public void push(Cliente clienteAggiungere){
        clienteArrayList.add(coda, clienteAggiungere);

        coda++;
    }

    /**
     * Metodo pop(), che restituisce il cliente nella posizione della testa
     * @return cliente nella posizione della testa
     * @see GestisciCode#pop(String) viene utilizzato gestire l'utilizzo della coda
     */
    public Cliente pop(){
        Cliente returnValue = null;

        //Se l'ArrayList non è vuoto restituisce il valore dentro alla testa, sennò restituisce null
        if (!isEmpty()){
            returnValue = clienteArrayList.get(testa);

            testa++;
        }

        return returnValue;
    }

    /**
     * Metodo isEmpty(), che controlla se l'ArrayList è vuoto
     * @return true s'è vuoto, altrimenti false
     */
    public boolean isEmpty(){
        return testa == coda;
    }
}
