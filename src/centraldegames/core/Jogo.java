package centraldegames.core;

import java.util.HashSet;

import centraldegames.componentes.EstiloJogabilidade;
import centraldegames.exceptions.ScoreInvalidoException;

/**<p>Classe que presenta um jogo</p>
 * <p>&copy; Copyright - Todos os direitos reservados</p>
 * @author Ricardo de Andrade Maia - 115211310
 * @since 11/08/16
 * @version v0.2
 * @link https://github.com/RicardoAndradeM/Lab6-RicardoMaia.git
 */
public class Jogo {
	private String nome;
	private double preco;
	private double maxScore = 0;
	private int quantVezesJogadas = 0;
	private int quantVezesZerado = 0;
	private HashSet<EstiloJogabilidade> jogabilidades;
	
	/**
	 * @param nome nome do jogo
	 * @param preco preco do jogo
	 * @param jogabilidades estilos do jogo 
	 * @author Ricardo Andrade
	 * @since 11/08/16
	 * @throws caso nome ou preco seja invalido
	 */
	public Jogo(String nome, double preco, HashSet<EstiloJogabilidade> jogabilidades) throws Exception {
		this.testaNome(nome);
		this.nome = nome;
		this.testaPreco(preco);
		this.preco =preco;
		this.jogabilidades = jogabilidades;
	}
	
	/**
	 * @param nome nome do jogo
	 * @param preco preco do jogo
	 * @author Ricardo Andrade
	 * @since 17/08/16
	 * @throws caso nome ou preco seja invalido
	 */
	public Jogo(String nome, double preco) throws Exception {
		this.testaNome(nome);
		this.nome = nome;
		this.testaPreco(preco);
		this.preco =preco;
	}
	
	/**<p>Registra uma partida, atualisando o Recorde do jogo e demais estatisticas</p>
	 * @param score potunacao do jogo
	 * @param isCompletouJogo se o usuario zerou/completou o jogo
	 * @author Ricardo Andrade
	 * @throws ScoreInvalidoException se o score for invalido
	 * @throws Exception caso a pontuacao seja invalida
	 * @since 11/08/16
	 */
	public int registraJogada(int score, boolean isCompletouJogo) throws ScoreInvalidoException {
		this.testaScore(score);
		quantVezesJogadas++;
		if (isCompletouJogo) {
			quantVezesZerado++;
		}
		if (score > maxScore) {
			maxScore = score;
		}
		return 0;
	}
	
	/**
	 * @param preco preco do jogo
	 * @throws Exception caso preco seja invalido
	 */
	private void testaPreco(double preco) throws Exception{
		if (preco < 0) {
			throw new Exception("Preco de jogo nao pode ser negativo");
		}
	}
	
	/**
	 * @param nome nome do jogo
	 * @throws Exception caso o nome seja invalido
	 */
	private void testaNome(String nome) throws Exception{
		if(nome == null || nome.equals("")){
			throw new Exception("Nome do jogo nao pode ser vazio ou null");
		}
	}

	/**
	 * @param score pontuacao
	 * @throws Exception caso pontuacao seja negativa
	 * @author Ricardo Andrade
	 * @throws ScoreInvalidoException se o valor for negativo
	 * @since 11/08/16
	 */
	private void testaScore(int score) throws ScoreInvalidoException {
		if(score < 0){
			throw new ScoreInvalidoException("pontuacao não pode ser negativa");
		}
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogabilidades == null) ? 0 : jogabilidades.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Jogo))
			return false;
		Jogo other = (Jogo) obj;
		if (jogabilidades == null) {
			if (other.jogabilidades != null)
				return false;
		} else if (!jogabilidades.equals(other.jogabilidades))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	/*gets e sets*/

	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome nome do jogo
	 * @throws Exception se o nome for invalido
	 * @author Ricardo Andrade
	 * @since 17/08/16
	 */
	public void setNome(String nome) throws Exception {
		if(nome == null || nome.equals("")){
			throw new Exception("Nome do jogo nao pode ser vazio ou null");
		} else {
			this.nome = nome;
		}
	}

	public double getPreco() {
		return preco;
	}
	
	/**
	 * @param preco preco do jogo
	 * @throws Exception caso preco seja negativo
	 * @author Ricardo Andrade
	 * @side 17/08/16
	 */
	public void setPreco(double preco) throws Exception {
		if (preco < 0) {
			throw new Exception("Preco de jogo nao pode ser negativo");
		} else {
			this.preco = preco;
		}
	}

	public double getMaxScore() {
		return maxScore;
	}

	public int getQuantVezesJogadas() {
		return quantVezesJogadas;
	}

	public int getQuantVezesZerado() {
		return quantVezesZerado;
	}

	public HashSet<EstiloJogabilidade> getJogabilidades() {
		return jogabilidades;
	}
}
