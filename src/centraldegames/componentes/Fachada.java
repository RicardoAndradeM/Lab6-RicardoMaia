package centraldegames.componentes;

import java.util.HashMap;
import java.util.Set;

import centraldegames.core.Jogo;
import centraldegames.core.Usuario;
import centraldegames.exceptions.DinheiroInvalidoException;

public class Fachada {
	private HashMap<String, Usuario> usuarios;
	
	public Fachada() {
		this.usuarios = new HashMap<String, Usuario>();
	}
	
	public void adicionaUsuario(Usuario usuario){
		this.usuarios.put(usuario.getLogin(), usuario);
	}
	
	public void adicionaDinheiro(String login, double dinheiro) {
		try {
			this.usuarios.get(login).adicionarDinheiro(dinheiro);		
		} catch (DinheiroInvalidoException exp) {
			System.out.println(exp.getMessage());
		}
	}
	
	public void venderjogo(String login, Jogo jogo){
		this.usuarios.get(login).adicionaJogo(jogo);
	}
	
	@Override
	public String toString() {
		String saida = "=== Central P2-CG ===\n";
		Set<String> LoginsDosUsuarios = usuarios.keySet();
		for (String Login : LoginsDosUsuarios) {
			saida += usuarios.get(Login).toString();
		}
		saida += "\n--------------------------------------------";
		return saida;
	}
}
