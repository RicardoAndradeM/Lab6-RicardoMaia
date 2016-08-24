package centraldegames.core;

import java.util.HashSet;

import centraldegames.exceptions.DinheiroInvalidoException;
import centraldegames.exceptions.NomeInvalidoException;
import centraldegames.exceptions.SaldoInsuficienteExeception;
import centraldegames.exceptions.ScoreInvalidoException;

/** <p>Classe que representa usuario</p>
 * @author Ricardo Andrade
 * @since 18/08/16
 * @version v0.2
 * @link https://github.com/RicardoAndradeM/Lab6-RicardoMaia.git
 */
public abstract class Usuario {
	private String nomeReal;
	private String login;
	private HashSet<Jogo> meusJogos;
	private double saldo = 0;
	private int x2p;
	
	/**
	 * @param nome nome real do usuario
	 * @param id nome de usuario(identificador)
	 * @throws NomeInvalidoException caso nome passado seja invalido
	 * @author Ricardo Andrade
	 * @since 18/08/16
	 */
	public Usuario(String nome, String login) throws NomeInvalidoException {
		this.testaNomeReal(nome);
		this.nomeReal = nome;
		this.testaLogin(login);
		this.login = login;
		this.meusJogos = new HashSet<Jogo>();
	}
	
	private void testaNomeReal(String nome) throws NomeInvalidoException{
		if (nome == null || nome.equals("")) {
			throw new NomeInvalidoException("Nome do jogador nao poder ser vazio ou null");
		}
	}
	
	private void testaLogin(String nome) throws NomeInvalidoException {
		if (nome == null || nome.equals("")) {
			throw new NomeInvalidoException("login do jogador nao poder ser vazio ou null");
		}
	}

	/** <p>Çadiciona dinheiro a conta do usuario</p>
	 * @param dinheiro dinheiro a ser adicionado no saldo
	 * @throws DinheiroInvalidoException 
	 * @author Ricardo Andrade
	 * @since 18/08/16
	 */
	public void adicionarDinheiro(double dinheiro) throws DinheiroInvalidoException {
		if (dinheiro < 0) {
			throw new DinheiroInvalidoException("Dinheiro nao pode ser negativo");
		} else {
			this.saldo += dinheiro;
		}
	}
	
	/** <p>Desconta dinheiro do usuario, geralmente quando ele compra um jogo</p>
	 * @param dinheiro dinheiro a ser descontado
	 * @return se a oprecao foi bem sucedida
	 * @throws DinheiroInvalidoException caso valor do dinheiro seja invalido
	 * @throws SaldoInsuficienteExeception caso nao tenha saldo suficiente
	 * @author Ricardo Andrade
	 * @since 18/08/16
	 */
	public boolean gastarDinheiro(double dinheiro) throws DinheiroInvalidoException, SaldoInsuficienteExeception {
		if(dinheiro < 0){
			throw new DinheiroInvalidoException("Dinheiro nao pode ser negativo");
		}else if(dinheiro > this.saldo){
			throw new SaldoInsuficienteExeception("Saldo insuficiente");
		} else {
			this.saldo -= dinheiro;
			return true;
		}
	}
	
	public void adicionaJogo(Jogo jogo) {
		this.meusJogos.add(jogo);
	}
	
	/**<p>chama o metodo RegistraJogada do jogo e atualisa aquantidade de x2p</p>
	 * @param nomeDoJogo nome do jogo jogado
	 * @param score potuacao atingida
	 * @param zerou ser zerou o jogo
	 * @throws ScoreInvalidoException caso pontuacao seja negativa
	 * @author Ricardo andrade
	 * @since 23/08/16
	 */
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws ScoreInvalidoException{
		for (Jogo jogo : meusJogos) {
			if(jogo.getNome().equals(nomeDoJogo)){
				x2p += jogo.registraJogada(score, zerou);
			}
		}
	}
	
	// metodo para registrar a compra de um jogo e atualizar o x2p	
	public abstract boolean compraJogo(Jogo jogo) throws DinheiroInvalidoException, SaldoInsuficienteExeception;
	
	/*gets e sets*/

	public String getNomeReal() {
		return nomeReal;
	}

	/**
	 * @param nomeReal novo nome real do usuario
	 * @throws NomeInvalidoException caso o nome seja invalido
	 */
	public void setNomeReal(String nomeReal) throws NomeInvalidoException {
		if (!(nomeReal == null || nomeReal.equals(""))) {
			this.nomeReal = nomeReal;
		} else {
			throw new NomeInvalidoException("Nome do jogador nao poder ser vazio ou null");
		}
	}

	public String getLogin() {
		return this.login;
	}

	/**
	 * @param id novo login a ser usado pelo usuario
	 * @throws NomeInvalidoException caso o nome seja invalido
	 */
	public void setLogin(String login) throws NomeInvalidoException {
		if (!(login == null || login.equals(""))) {
			this.login = login;
		} else {
			throw new NomeInvalidoException("login do jogador nao poder ser vazio ou null");
		}
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

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}
}
