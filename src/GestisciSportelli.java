import java.util.ArrayList;

/**
 * @author Eliomar Rodriguez
 * @author Alessandro Duta
 * @since 19.0.1
 * @version %I%, %G%
 * @version 1.0
 * @see InterfacciaSportelli crezione dell'istanza nella classe InterfacciaSportelli
 * Descrizione: Classe GestisciSportelli, che gestisce tutta la logica degli sportelli
 */
public class GestisciSportelli {
    GestisciCode gestisciCode = new GestisciCode(); //Istanza della classe GestisciCode
    public ArrayList<Sportello> sportelloArrayList = new ArrayList<>();
    private String ticketAttuale;

    /**
     * Metodo costruttore(), con tutte le variabili inizializzate
     * @see InterfacciaSportelli#g1 Viene dichiarato come istanza nela classe InterfacciaSportelli
     */
    public GestisciSportelli(){
        this.sportelloArrayList.add(new Sportello("Antonio", "pagamento_bollettini", "", "", true));
        this.sportelloArrayList.add(new Sportello("Alberto", "pagamento_bollettini", "", "", true));
        this.sportelloArrayList.add(new Sportello("Gustavo", "banco_posta", "", "", true));
        this.sportelloArrayList.add(new Sportello("Jose", "banco_posta", "", "", true));
        this.sportelloArrayList.add(new Sportello("Yoneikler", "servizi_postale", "", "", true));
        this.sportelloArrayList.add(new Sportello("Yeferson", "servizi_postale", "", "", true));
        this.ticketAttuale = "";
    }

    /**
     * Metodo aggiornaStatoSportello(), che aggiorna il ticket attuale e quello che viene nello sportello
     * @param numeroSportello l'indice dello sportello che sta usando il programma
     * @see InterfacciaSportelli#menu() Vinene utilizzato nel case uno dello switch che gestisce la scelta dell'utente
     */
    public void aggiornaStatoSportello(int numeroSportello){
        String tipologiaServizio = sportelloArrayList.get(numeroSportello).getTipologiaServizio();

        //if che controlla se la coda è vuota
        if (!gestisciCode.isEmpty(tipologiaServizio)){
            /*
             * if che controlla se il numero del ticket attuale è vuoto, s'è vero setta l'attributo "sportelloLibero" a
             * false, setta l'attributo numeroTicket eseguendo un pop della coda che gestisce lo sportello
             */
            if (sportelloArrayList.get(numeroSportello).getNumeroTicket().equals("")){
                sportelloArrayList.get(numeroSportello).setSportelloLibero(false);

                sportelloArrayList.get(numeroSportello).setNumeroTicket(gestisciCode.pop(tipologiaServizio).getTicket());

                //if che controlla se la coda non è vuota, s'è vero setta l'attributo "numeroProgressivo" con un pop della coda che si sta gestendo
                if (!gestisciCode.isEmpty(tipologiaServizio))
                    sportelloArrayList.get(numeroSportello).setNumeroProgressivo(gestisciCode.pop(tipologiaServizio).getTicket());

            //Altrimenti prende il valore dell'attributo "numeroProgressivo" e lo salva sulla variabile temporanea "ticketAttuale"
            }else {

                ticketAttuale = sportelloArrayList.get(numeroSportello).getNumeroProgressivo();

                /*
                 * if che verifica se la variabile "ticketAttuale" non è vuota, s'è vero setta l'attributo
                 * "sportelloLibero" a false, setta l'attributo "numeroTicket" con il valore dentro alla variabile
                 * "ticketAttuale" e per ultimo setta l'attributo "numeroProgressivo" con un pop della coda che si sta
                 * gestendo
                 */
                if (!ticketAttuale.equals("")){

                    sportelloArrayList.get(numeroSportello).setSportelloLibero(false);

                    sportelloArrayList.get(numeroSportello).setNumeroTicket(ticketAttuale);

                    sportelloArrayList.get(numeroSportello).setNumeroProgressivo(gestisciCode.pop(tipologiaServizio).getTicket());

                //Altrimenti setta l'attributo "sportelloLibero" a false e setta l'attributo "numeroProgressivo" con un pop della coda che si sta gestendo
                }else {
                    sportelloArrayList.get(numeroSportello).setSportelloLibero(false);

                    sportelloArrayList.get(numeroSportello).setNumeroProgressivo(gestisciCode.pop(tipologiaServizio).getTicket());
                }
            }

        //Altrimenti fa un altro controllo nel caso non ci siano più persone nella coda e controlla se il ticket successivo è vuoto
        }else{
            //if che controlla se il pop della coda che si sta gestendo returna null
            if (gestisciCode.pop(tipologiaServizio) == null){
                /*
                 * if che controlla se l'attributo "numeroProgressivo" non è vuoto, s'è vero assegna il valore
                 * dell'attributo "numeroProgressivo" alla variabile "ticketAttuale", setta l'attributo "numeroTicket"
                 * con il valore della variabile "ticketAttuale" e setta l'attributo "numeroProgressivo" a vuoto
                 */
                if (!sportelloArrayList.get(numeroSportello).getNumeroProgressivo().equals("")){
                    ticketAttuale = sportelloArrayList.get(numeroSportello).getNumeroProgressivo();

                    sportelloArrayList.get(numeroSportello).setNumeroTicket(ticketAttuale);

                    sportelloArrayList.get(numeroSportello).setNumeroProgressivo("");

                //Altrimenti setta l'attributo "numeroTicket" a vuoto e setta l'attributo "sportelloLibero" a true
                }else {
                    sportelloArrayList.get(numeroSportello).setNumeroTicket("");

                    sportelloArrayList.get(numeroSportello).setSportelloLibero(true);
                }
            }
        }
    }

    /**
     * Metodo aggiungerePersonaCoda(), che chiede nei parametri le caratteristiche dell'oggetto a creare
     * @param tipologiaServizio chiede il tipo di servizio della coda dove si deve inserire il cliente
     * @param codiceFiscale chiede il codice fiscale del cliente
     * @param nome chiede il nome del cliente
     * @param cognome chiede il cognome del cliente
     * @param tipoServizio chiede il tipo di servizio che desidera il cliente
     * @param ticket chiede il numero del ticket del cliente
     * @see InterfacciaSportelli#menu() che vinene richiamato nel case due dello switch che gestisce cosa desidera fare
     *                                  l'utente
     */
    public void aggiungerePersonaCoda(String tipologiaServizio, String codiceFiscale, String nome, String cognome, String tipoServizio, String ticket){
        gestisciCode.push(tipologiaServizio, new Cliente(codiceFiscale, nome, cognome, tipoServizio, ticket));
    }

    /**
     * Metodo controlloSportello(), che controlla se lo sportello attuale è libero
     * @param numeroSportello chiede l'indice dello sportello che desidera fare l'azione
     * @return true s'è libero, altrimenti false
     */
    public boolean controlloSportello(int numeroSportello){
        return sportelloArrayList.get(numeroSportello).isSportelloLibero();
    }
}
