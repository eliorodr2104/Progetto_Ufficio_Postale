public class Sportello {
    private String nomeLavoratore, tipologiaServizio, numeroTicket, numeroProgressivo;
    private boolean sportelloLibero;

    public Sportello(String nomeLavoratore, String tipologiaServizio, String numeroTicket, String numeroProgressivo, boolean sportelloLibero){
        this.nomeLavoratore = nomeLavoratore;
        this.tipologiaServizio = tipologiaServizio;
        this.numeroTicket = numeroTicket;
        this.numeroProgressivo = numeroProgressivo;
        this.sportelloLibero = sportelloLibero;
    }

    public void setNomeLavoratore(String nomeLavoratore) {
        this.nomeLavoratore = nomeLavoratore;
    }

    public void setTipologiaServizio(String tipologiaServizio) {
        this.tipologiaServizio = tipologiaServizio;
    }

    public void setNumeroTicket(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public void setNumeroProgressivo(String numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }

    public void setSportelloLibero(boolean sportelloLibero) {
        this.sportelloLibero = sportelloLibero;
    }

    public String getNomeLavoratore() {
        return nomeLavoratore;
    }

    public String getTipologiaServizio() {
        return tipologiaServizio;
    }

    public String getNumeroTicket() {
        return numeroTicket;
    }

    public String getNumeroProgressivo() {
        return numeroProgressivo;
    }

    public boolean isSportelloLibero() {
        return sportelloLibero;
    }
}
