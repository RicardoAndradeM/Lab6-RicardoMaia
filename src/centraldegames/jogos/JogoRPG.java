package centraldegames.jogos;

import java.util.HashSet;

import centraldegames.componentes.EstiloJogabilidade;
import centraldegames.core.Jogo;
import centraldegames.exceptions.ScoreInvalidoException;

/**<p>Classe que presenta um jogo RPG</p>
 * <p>&copy; Copyright - Todos os direitos reservados</p>
 * @author Ricardo de Andrade Maia - 115211310
 * @since 21/08/16
 * @version v0.1
 * @link https://github.com/RicardoAndradeM/Lab6-RicardoMaia.git
 */
public class JogoRPG extends Jogo {
	
	/**
	 * @param nome nome do jogo
	 * @param preco preco do jogo
	 * @param jogabilidades estilos do jogo 
	 * @author Ricardo Andrade
	 * @since 23/08/16
	 * @throws caso nome ou preco seja invalido
	 */
	public JogoRPG(String nome, double preco, HashSet<EstiloJogabilidade> jogabilidades) throws Exception {
		super(nome, preco, jogabilidades);
	}
	
	/**
	 * @param nome nome do jogo
	 * @param preco preco do jogo
	 * @author Ricardo Andrade
	 * @since 23/08/16
	 * @throws caso nome ou preco seja invalido
	 */
	public JogoRPG(String nome, double preco) throws Exception {
		super(nome, preco);
	}
	
	/**<p>Registra uma partida, atualisando o Recorde do jogo e demais estatisticas</p>
	 * @param score potunacao do jogo
	 * @param isCompletouJogo se o usuario zerou/completou o jogo
	 * @author Ricardo Andrade
	 * @throws ScoreInvalidoException se o score for invalido
	 * @throws Exception caso a pontuacao seja invalida
	 * @since 23/08/16
	 */
	@Override
	public int registraJogada(int score, boolean isCompletouJogo) throws ScoreInvalidoException {
		super.registraJogada(score, isCompletouJogo);
		return 10;
	}
	
	@Override
	public String toString() {
		return String.format("%s - RPG:\n==> Jogou %d vez(es)\n==> Zerou %d vez(es)\n==> Maior score: %d",
				this.getNome(), this.getQuantVezesJogadas(), this.getQuantVezesZerado(),this.getMaxScore());
	}
}
