import java.util.ArrayList;

public class PagamentoBollettini {
    public final ArrayList<Cliente> clienteArrayList;
    private int testa, coda;

    /**
     * Metodo costruttore()
     */
    public PagamentoBollettini(){
        this.clienteArrayList = new ArrayList<>();
        this.testa = 0;
        this.coda = 0;
    }

    /**
     * Metodo push(), che inserisce il numero dentro all'ArrayList e aumenta la testa
     * @param clienteAggiungere il numero a inserire dentro l'Array
     */
    public void push(Cliente clienteAggiungere){
        clienteArrayList.add(coda, clienteAggiungere);

        coda++;
    }

    /**
     * Metodo pop(), che restituisce il valore nella posizione della testa
     * @return valore nella posizione della testa
     */
    public Cliente pop(){
        Cliente returnValue = null;

        if (!isEmpty()){
            returnValue = clienteArrayList.get(testa);

            testa++;
        }

        return returnValue;
    }

    /**
     * Metodo isEmpty(), che controlla se l'Array è vuoto
     * @return true s'è vuoto || false se c'è qualcosa dentro all'Array
     */
    public boolean isEmpty(){
        return testa == coda;
    }
}
