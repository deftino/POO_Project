package login.pk;

import java.util.HashMap;

public class Autenticacao{
  HashMap<String, String>logininfo = new HashMap<String,String>();
  
  public Autenticacao(){
	  this.logininfo = GerenciadorDados.carregarUsuarios();
  }
  public HashMap<String, String> getlogininfo() {
	  return logininfo;
  }
  public void salvarUsuarios() {
      GerenciadorDados.salvarUsuarios(this.logininfo);
  }
}

