public class GestisciCode {

    BancoPosta bancoPosta = new BancoPosta();
    PagamentoBollettini pagamentoBollettini = new PagamentoBollettini();
    ServiziPostale serviziPostale = new ServiziPostale();

    public GestisciCode(){

    }

    public void push(String tipoCoda, Cliente cliente){
        switch (tipoCoda){
            case "banco_posta" -> bancoPosta.push(cliente);
            case "servizi_postale" -> serviziPostale.push(cliente);
            case "pagamento_bollettini" -> pagamentoBollettini.push(cliente);
        }
    }

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

}
