package centraldegames.componentes;

import java.util.HashMap;
import java.util.Set;

import centraldegames.core.Jogo;
import centraldegames.core.Usuario;
import centraldegames.exceptions.DinheiroInvalidoException;

/** <p>Classe que representa a loja</p>
 * @author Ricardo Andrade
 * @since 23/08/16
 * @version v0.1
 * @link https://github.com/RicardoAndradeM/Lab6-RicardoMaia.gitv
 */
public class Fachada {
	private HashMap<String, Usuario> usuarios;
	
	public Fachada() {
		this.usuarios = new HashMap<String, Usuario>();
	}
	
	/**
	 * @param usuario usuario a ser adicionado a lista de usuarios
	 */
	public void adicionaUsuario(Usuario usuario){
		this.usuarios.put(usuario.getLogin(), usuario);
	}
	
	/**<p>Adiciona dinheiro em um determina usuario</p>
	 * @param login nome de usuario
	 * @param dinheiro dinheiro a ser depositado
	 */
	public void adicionaDinheiro(String login, double dinheiro) {
		try {
			this.usuarios.get(login).adicionarDinheiro(dinheiro);		
		} catch (DinheiroInvalidoException exp) {
			System.out.println(exp.getMessage());
		}
	}
	
	/**<p>Vende um jogo a um usuario, caso tenha dinheiro para compra-lo</p>
	 * @param login nome de usuario
	 * @param jogo jogo a ser comprado
	 */
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
