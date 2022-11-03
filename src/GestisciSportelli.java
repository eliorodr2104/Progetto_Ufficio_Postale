import java.util.ArrayList;

public class GestisciSportelli {
    GestisciCode gestisciCode = new GestisciCode();
    public ArrayList<Sportello> sportelloArrayList = new ArrayList<>();
    private String ticketAttuale;

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
     * Devo rifare
     * @param numeroSportello
     */
    public void aggiornaStatoSportello(int numeroSportello){
        String tipologiaServizio = sportelloArrayList.get(numeroSportello).getTipologiaServizio();

        if (!gestisciCode.isEmpty(tipologiaServizio)){
            if (sportelloArrayList.get(numeroSportello).getNumeroTicket().equals("")){
                sportelloArrayList.get(numeroSportello).setSportelloLibero(false);

                sportelloArrayList.get(numeroSportello).setNumeroTicket(gestisciCode.pop(tipologiaServizio).getTicket());

                if (!gestisciCode.isEmpty(tipologiaServizio))
                    sportelloArrayList.get(numeroSportello).setNumeroProgressivo(gestisciCode.pop(tipologiaServizio).getTicket());

            }else {

                ticketAttuale = sportelloArrayList.get(numeroSportello).getNumeroProgressivo();

                if (!ticketAttuale.equals("")){

                    sportelloArrayList.get(numeroSportello).setSportelloLibero(false);

                    sportelloArrayList.get(numeroSportello).setNumeroTicket(ticketAttuale);

                    sportelloArrayList.get(numeroSportello).setNumeroProgressivo(gestisciCode.pop(tipologiaServizio).getTicket());

                }else {
                    sportelloArrayList.get(numeroSportello).setSportelloLibero(false);

                    sportelloArrayList.get(numeroSportello).setNumeroProgressivo(gestisciCode.pop(tipologiaServizio).getTicket());
                }
            }

        }else{
            if (gestisciCode.pop(tipologiaServizio) == null){
                if (!sportelloArrayList.get(numeroSportello).getNumeroProgressivo().equals("")){
                    ticketAttuale = sportelloArrayList.get(numeroSportello).getNumeroProgressivo();

                    sportelloArrayList.get(numeroSportello).setNumeroTicket(ticketAttuale);

                    sportelloArrayList.get(numeroSportello).setNumeroProgressivo("");

                }else {
                    sportelloArrayList.get(numeroSportello).setNumeroTicket("");

                    sportelloArrayList.get(numeroSportello).setSportelloLibero(true);
                }
            }
        }
    }

    public void aggiungerePersonaCoda(String tipologiaServizio, String codiceFiscale, String nome, String cognome, String tipoServizio, String ticket){
        gestisciCode.push(tipologiaServizio, new Cliente(codiceFiscale, nome, cognome, tipoServizio, ticket));
    }

    public boolean controlloSportello(int numeroSportello){
        return sportelloArrayList.get(numeroSportello).isSportelloLibero();
    }
}
