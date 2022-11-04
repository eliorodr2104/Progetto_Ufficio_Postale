import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Eliomar Rodriguez
 * @author Alessandro Duta
 * @since 19.0.1
 * @version %I%, %G%
 * @version 1.0
 * @see Main#main(String[]) istanza nella classe Main
 * Descrizione: Classe InterfacciaSportelli, che gestisce l'interfaccia grafica di tutto il programma
 */
public class InterfacciaSportelli {
    GestisciSportelli g1 = new GestisciSportelli(); //Istanza della classe GestisciSportelli

    private int scelta, indiceSportello, contaBancoPosta, contaServiziPostale, contaPagamentoBollettini;
    private final String regexCodiceFiscale, regexNomeCognome;
    private String codiceFiscale, nome, cognome, tipoServizio, ticket;

    /**
     * Metodo costruttore()
     * @see Main#main(String[])
     */
    public InterfacciaSportelli(){
        this.scelta = 0;
        this.indiceSportello = 0;
        this.regexCodiceFiscale = "[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]";
        this.regexNomeCognome = "[a-zA-Z]*";
    }

    /**
     * Metodo stampaSportelli(), che stampa tutti gli sportelli
     * @return la quantità di sportelli che ci sono
     * @see InterfacciaSportelli#menu(), Si salva il risultato in una variabile temporanea
     */
    public int stampaSportelli(){
        String[] tipologiaServizio;
        int ultimoIndice = 0;

        char oldChar, newChar;

        //For che itera per tutta la lunghezza dell'array di sportelli
        for (int i = 0 ; i < g1.sportelloArrayList.size() ; i++){
            tipologiaServizio = g1.sportelloArrayList.get(i).getTipologiaServizio().split("_"); //Split delle tipo di servizio di ogni sportello

            oldChar = tipologiaServizio[0].charAt(0); //Prende il primo carattere e lo salva su un char temporaneo

            newChar = Character.toUpperCase(oldChar); //Salva il char vecchio convertito in maiuscolo su un altro char temporaneo

            tipologiaServizio[0] = tipologiaServizio[0].replace(oldChar, newChar); //Fa lo scambio tra il char vecchio per quello nuovo

            System.out.println(i + 1 + ". Lavoratore: " + g1.sportelloArrayList.get(i).getNomeLavoratore() +
                    ", Tipo sportello: " + tipologiaServizio[0] + " " + tipologiaServizio[1] + ".");

            ultimoIndice = i + 1;
        }

        return ultimoIndice;
    }

    /**
     * Metodo stampaCode(), che stampa la coda della tipologia di lavoro dello sportello attuale
     * @param tipoServizio il tipo di servizio che si sta utilizzando per stampare le code
     * @see InterfacciaSportelli#menu() si utilizza nel case quatttro dello switch per la scelta dell'azione che desidera fare l'utente
     */
    public void stampaCode(String tipoServizio){
        ArrayList<Cliente> arrayTemp = g1.gestisciCode.popArrayList(tipoServizio);

        if (!arrayTemp.isEmpty()){
            for (int i = 0; i < arrayTemp.size(); i++){
                System.out.println(i + ". Il codice fiscale è: " + arrayTemp.get(i).getCodiceFiscale() + ", Il nome è: " + arrayTemp.get(i).getNome() + " " + arrayTemp.get(i).getCognome());
            }

        }else
            System.out.println("Non c'è nessuno nella coda");
    }

    /**
     * Metodo menu(), che gestisce tutta la classe InterfacciaSportelli e chiede all'utente cosa desidera fare
     *                Nota: nei catch imposta la variabile a "-10" così non da nessun problema nel controllo
     * @see Main#main(String[]) esegue il metodo per avviare il programma
     * @see InterfacciaSportelli#menu() per scelta dell'utente si riavvia il metodo per continuare il programma
     */
    public void menu(){
        int numeroMassimoSportelli;
        Scanner s1 = new Scanner(System.in); //Istanza della classe Scanner

        System.out.println("Seleziona il tuo sportello: ");
        numeroMassimoSportelli = stampaSportelli();

        do {
            try {
                indiceSportello = Integer.parseInt(s1.next());

                if (indiceSportello < 0 || indiceSportello > numeroMassimoSportelli)
                    System.out.println("Valore inserito non valido");

            }catch (NumberFormatException e){
                indiceSportello = -10;
                System.out.println("Valore inserito non valido");
            }
        }while (indiceSportello < 0 || indiceSportello > numeroMassimoSportelli);

        System.out.println("Scegli l'operazione che desideri fare: \n" +
                "1.Aggiorna lo stato del tuo sportello.\n" +
                "2.Aggiungi una persona alla coda.\n" +
                "3.Controlla lo stato del tuo sportello. \n" +
                "4.Stampare le persone nella coda.");

        do {
            try{
                scelta = Integer.parseInt(s1.next());

                if (scelta < 1 || scelta > 4)
                    System.out.println("Valore inserito non valido");

            }catch (NumberFormatException e){
                scelta = -10;
                System.out.println("Valore inserito non valido");
            }
        }while (scelta < 1 || scelta > 4);

        //Controlla la variabile scelta e avvia il case richiesto dall'utente
        switch (scelta){
            case 1 -> g1.aggiornaStatoSportello(indiceSportello - 1);


            case 2 ->{
                System.out.println("Inserisci il codici fiscale della persona: ");

                //Esempio di codice fiscale valido: HYHLHL78K62M873H
                do {
                    codiceFiscale = s1.next();

                    if (!Pattern.matches(regexCodiceFiscale, codiceFiscale))
                        System.out.println("Codice fiscale non valido, reinserire!!");

                }while (!Pattern.matches(regexCodiceFiscale, codiceFiscale));

                System.out.println("Inserisci il nome della persona");

                do {
                    nome = s1.next();

                    if (!Pattern.matches(regexNomeCognome, nome))
                        System.out.println("Nome non valido, reinserire!!");

                }while (!Pattern.matches(regexNomeCognome, nome));

                System.out.println("Inserisci il cognome della persona");

                do {
                    cognome = s1.next();

                    if (!Pattern.matches(regexNomeCognome, cognome))
                        System.out.println("Cognome non valido, reinserire!!");

                }while (!Pattern.matches(regexNomeCognome, cognome));

                System.out.println("Selezione il tipo di servizio: \n" +
                        "1.Banco posta.\n" +
                        "2.Servizi postale.\n" +
                        "3.Pagamento bollettini.");

                do {
                    try{
                        scelta = Integer.parseInt(s1.next());

                        if (scelta < 1 || scelta > 3)
                            System.out.println("Valore inserito non valido");

                    }catch (NumberFormatException e){
                        scelta = -10;
                        System.out.println("Valore inserito non valido");
                    }
                }while (scelta < 1 || scelta > 3);

                switch (scelta){
                    case 1 -> {
                        tipoServizio = "banco_posta";

                        if (contaBancoPosta > 999)
                            contaBancoPosta = 0;

                        ticket = "b" + contaBancoPosta;
                        contaBancoPosta++;
                    }
                    case 2 -> {
                        tipoServizio = "servizi_postale";

                        if (contaServiziPostale > 999)
                            contaServiziPostale = 0;

                        ticket = "s" + contaServiziPostale;
                        contaServiziPostale++;
                    }
                    case 3 -> {
                        tipoServizio = "pagamento_bollettini";

                        if (contaPagamentoBollettini > 999)
                            contaPagamentoBollettini = 0;

                        ticket = "p" + contaPagamentoBollettini;
                        contaPagamentoBollettini++;
                    }
                }

                g1.aggiungerePersonaCoda(tipoServizio, codiceFiscale, nome, cognome, tipoServizio, ticket);
            }

            case 3 -> {
                if (!g1.controlloSportello(indiceSportello -1)){
                    System.out.println("Il ticket del cliente attuale è: " + g1.sportelloArrayList.get(indiceSportello -1).getNumeroTicket());

                    System.out.println("Il ticket del prossimo cliente è: " + g1.sportelloArrayList.get(indiceSportello -1).getNumeroProgressivo());

                }else
                    System.out.println("Sportello vuoto");
            }

            case 4 -> stampaCode(g1.sportelloArrayList.get(indiceSportello -1).getTipologiaServizio());

        }

        System.out.println("Inserisci \"1\" per continuare o \"2\" per chiudere il programma");

        do {
            try{
                scelta = Integer.parseInt(s1.next());

                if (scelta < 1 || scelta > 2)
                    System.out.println("Valore inserito non valido");

            }catch (NumberFormatException e){
                scelta = -10;
                System.out.println("Valore inserito non valido");
            }
        }while (scelta < 1 || scelta > 2);

        //Continua il programma se l'utente inserisce uno
        if (scelta == 1)
            menu();
    }
}