package centraldegames.componentes;

/**<p>Classe que presenta um jogo</p>
 * <p>&copy; Copyright - Todos os direitos reservados</p>
 * @author Ricardo de Andrade Maia - 115211310
 * @since 11/08/16
 * @version v0.2
 * {@link} https://github.com/RicardoAndradeM/Lab6-Ricardo
 */
public class Jogo {
	private String nome;
	private double preco;
	private double maxScore = 0;
	private int quantVezesJogadas = 0;
	private int quantVezesZerado = 0;
	
	/**
	 * @param nome nome do jogo
	 * @param preco preco do jogo
	 * @author Ricardo Andrade
	 * @since 11/08/16
	 * @throws caso nome ou preco seja invalido
	 */
	public Jogo(String nome, double preco) throws Exception {
		this.setNome(nome);
		this.setPreco(preco);
	}
	
	/**<p>Registra uma partida, atualisando o Recorde do jogo e demais estatisticas</p>
	 * @param score potunacao do jogo
	 * @param isCompletouJogo se o usuario zerou/completou o jogo
	 * @author Ricardo Andrade
	 * @throws Exception caso a pontuacao seja invalida
	 * @since 11/08/16
	 */
	public void registraJogada(int score, boolean isCompletouJogo) throws Exception {
		this.testaScore(score);
		quantVezesJogadas++;
		if (isCompletouJogo) {
			quantVezesZerado++;
		}
		if (score > maxScore) {
			maxScore = score;
		}
	}

	/**
	 * @param score pontuacao
	 * @throws Exception caso pontuacao seja negativa
	 * @author Ricardo Andrade
	 * @since 11/08/16
	 */
	private void testaScore(int score) throws Exception {
		if(score < 0){
			throw new Exception("pontuacao não pode ser negativa");
		}
		
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
}
