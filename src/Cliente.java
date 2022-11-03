public class Cliente {

    private String codiceFiscale, nome, cognome, tipoServizio, ticket;

    public Cliente(String codiceFiscale, String nome, String cognome, String tipoServizio, String ticket){
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.tipoServizio = tipoServizio;
        this.ticket = ticket;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setTipoServizio(String tipoServizio) {
        this.tipoServizio = tipoServizio;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTipoServizio() {
        return tipoServizio;
    }

    public String getTicket() {
        return ticket;
    }
}
