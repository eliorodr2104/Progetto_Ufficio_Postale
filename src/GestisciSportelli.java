import java.util.ArrayList;

public class GestisciSportelli {
    GestisciCode gestisciCode = new GestisciCode();
    private ArrayList<Sportello> sportelloArrayList = new ArrayList<>();

    private boolean controlloPrimaVolta;

    public GestisciSportelli(){
        this.sportelloArrayList.add(new Sportello("Antonio", "pagamento_bollettini", "", "", true));
        this.sportelloArrayList.add(new Sportello("Alberto", "pagamento_bollettini", "", "", true));
        this.sportelloArrayList.add(new Sportello("Gustavo", "banco_posta", "", "", true));
        this.sportelloArrayList.add(new Sportello("Jose", "banco_posta", "", "", true));
        this.sportelloArrayList.add(new Sportello("Yoneikler", "servizi_postale", "", "", true));
        this.sportelloArrayList.add(new Sportello("Yeferson", "servizi_postale", "", "", true));
        this.controlloPrimaVolta = true;
    }

    public void aggiornaStatoSportello(int numeroSportello){
        String tipologiaServizio = sportelloArrayList.get(numeroSportello).getTipologiaServizio();
        String ticketAttuale;

        if (controlloPrimaVolta && !gestisciCode.isEmpty(tipologiaServizio)){
            sportelloArrayList.get(numeroSportello).setSportelloLibero(false);

            sportelloArrayList.get(numeroSportello).setNumeroTicket(gestisciCode.pop(tipologiaServizio).getTicket());

            sportelloArrayList.get(numeroSportello).setNumeroProgressivo(gestisciCode.pop(tipologiaServizio).getTicket());

            controlloPrimaVolta = false;
        }

        if (gestisciCode.isEmpty(tipologiaServizio)){
            sportelloArrayList.get(numeroSportello).setSportelloLibero(true);

        }else {
            ticketAttuale = sportelloArrayList.get(numeroSportello).getNumeroProgressivo();

            sportelloArrayList.get(numeroSportello).setSportelloLibero(false);

            sportelloArrayList.get(numeroSportello).setNumeroTicket(ticketAttuale);

            sportelloArrayList.get(numeroSportello).setNumeroProgressivo(gestisciCode.pop(tipologiaServizio).getTicket());
        }

    }

    public void aggiungerePersonaCoda(int numeroSportello, String codiceFiscale, String nome, String cognome, String tipoServizio, String ticket){
        String tipologiaServizio = sportelloArrayList.get(numeroSportello).getTipologiaServizio();

        gestisciCode.push(tipologiaServizio, new Cliente(codiceFiscale, nome, cognome, tipoServizio, ticket));
    }

    public boolean controlloSportello(int numeroSportello){
        return sportelloArrayList.get(numeroSportello).isSportelloLibero();
    }

}
