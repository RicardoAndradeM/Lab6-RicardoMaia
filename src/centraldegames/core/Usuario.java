package centraldegames.core;

import java.util.HashSet;

import centraldegames.componentes.Jogo;
import centraldegames.exceptions.NomeInvalidoException;

/** <p>Classe que representa usuario</p>
 * @author Ricardo Andrade
 * @since 18/08/16
 * @version v0.1
 * @link https://github.com/RicardoAndradeM/Lab6-Ricardo
 */
public abstract class Usuario {
	private String nomeReal;
	private String id; // significa identity/identidade
	private HashSet<Jogo> meusJogos;
	private double saldo = 0;
	
	/**
	 * @param nome nome real do usuario
	 * @param id nome de usuario(identificador)
	 * @throws NomeInvalidoException caso nome passado seja invalido
	 * @since 18/08/16
	 */
	public Usuario(String nome, String id) throws NomeInvalidoException {
		this.setNomeReal(nome);
		this.setId(id);
	}

	/** <p>Çadiciona dinheiro a conta do usuario</p>
	 * @param dinheiro dinheiro a ser adicionado no saldo
	 * @since 18/08/16
	 */
	public void adicionarDinheiro(double dinheiro) {
		this.saldo += dinheiro;
	}
	
	/** <p>Desconta dinheiro do usuario, geralmente quando ele compra um jogo</p>
	 * @param dinheiro dinheiro a ser descontado
	 * @return se a oprecao foi bem sucedida
	 * @since 18/08/16
	 */
	public boolean gastarDinheiro(double dinheiro) {
		if(dinheiro <= this.saldo){
			this.saldo -= dinheiro;
			return true;
		} else {
			// adicionar execao aqui
		}
	}
	
	public void adicionaJogo(Jogo jogo) {
		this.meusJogos.add(jogo);
	}
	
	public abstract boolean compraJogo(Jogo jogo);
	
	/*gets e sets*/

	public String getNomeReal() {
		return nomeReal;
	}

	/**
	 * @param nomeReal novo nome real do usuario
	 * @throws NomeInvalidoException caso o nome seja invalido
	 */
	public void setNomeReal(String nomeReal) throws NomeInvalidoException {
		if (!(nomeReal == null || nomeReal == "")) {
			this.nomeReal = nomeReal;
		} else {
			throw new NomeInvalidoException("Nome do jogador nao poder ser vazio ou null");
		}
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashSet<Jogo> getMeusJogos() {
		return meusJogos;
	}

	public void setMeusJogos(HashSet<Jogo> meusJogos) {
		this.meusJogos = meusJogos;
	}
	public double getSaldo() {
		return this.saldo;
	}
}
