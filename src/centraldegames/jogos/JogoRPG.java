package centraldegames.jogos;

import java.util.HashSet;

import centraldegames.componentes.EstiloJogabilidade;
import centraldegames.core.Jogo;
import centraldegames.exceptions.ScoreInvalidoException;

public class JogoRPG extends Jogo {
	public JogoRPG(String nome, double preco, HashSet<EstiloJogabilidade> jogabilidades) throws Exception {
		super(nome, preco, jogabilidades);
	}
	
	public JogoRPG(String nome, double preco) throws Exception {
		super(nome, preco);
	}
	
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
