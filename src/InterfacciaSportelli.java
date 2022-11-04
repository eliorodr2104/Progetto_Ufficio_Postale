import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InterfacciaSportelli {

    GestisciSportelli g1 = new GestisciSportelli();

    private int scelta, indiceSportello, contaBancoPosta, contaServiziPostale, contaPagamentoBollettini;
    private final String regexCodiceFiscale, regexNomeCognome;
    private String codiceFiscale, nome, cognome, tipoServizio, ticket;

    public InterfacciaSportelli(){
        this.scelta = 0;
        this.indiceSportello = 0;
        this.regexCodiceFiscale = "[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]";
        this.regexNomeCognome = "[a-zA-Z]*";
    }

    public int stampaSportelli(){
        String[] tipologiaServizio;
        int ultimoIndice = 0;

        char oldChar, newChar;

        for (int i = 0 ; i < g1.sportelloArrayList.size() ; i++){
            tipologiaServizio = g1.sportelloArrayList.get(i).getTipologiaServizio().split("_");

            oldChar = tipologiaServizio[0].charAt(0);

            newChar = Character.toUpperCase(oldChar);

            tipologiaServizio[0] = tipologiaServizio[0].replace(oldChar, newChar);

            System.out.println(i + 1 + ". Lavoratore: " + g1.sportelloArrayList.get(i).getNomeLavoratore() +
                    ", Tipo sportello: " + tipologiaServizio[0] + " " + tipologiaServizio[1] + ".");

            ultimoIndice = i + 1;
        }

        return ultimoIndice;
    }

    public void stampaCode(String tipoServizio){
        ArrayList<Cliente> arrayTemp = g1.gestisciCode.popArray(tipoServizio);

        if (!arrayTemp.isEmpty()){
            for (int i = 0; i < arrayTemp.size(); i++){
                System.out.println(i + ". Il codice fiscale è: " + arrayTemp.get(i).getCodiceFiscale() + ", Il nome è: " + arrayTemp.get(i).getNome() + " " + arrayTemp.get(i).getCognome());
            }

        }else
            System.out.println("Non c'è nessuno nella coda");


    }

    public void menu(){
        int numeroMassimoSportelli;
        Scanner s1 = new Scanner(System.in);

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

        switch (scelta){
            case 1 ->{
                g1.aggiornaStatoSportello(indiceSportello - 1);
            }

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

        if (scelta == 1)
            menu();
    }
}