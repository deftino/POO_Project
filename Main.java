import login.pk.*;

public class Main {
    
	public static void main(String[] args) {
    	Autenticacao autenticacao = new Autenticacao();
    	Paginalogin login = new Paginalogin(autenticacao.getlogininfo(), autenticacao);
     }
}