package centraldegames.jogos;

import java.util.HashSet;

import centraldegames.componentes.EstiloJogabilidade;
import centraldegames.core.Jogo;
import centraldegames.exceptions.ScoreInvalidoException;

public class JogoLuta extends Jogo {
	public JogoLuta(String nome, double preco, HashSet<EstiloJogabilidade> jogabilidades) throws Exception {
		super(nome, preco, jogabilidades);
	}
	
	public JogoLuta(String nome, double preco) throws Exception {
		super(nome, preco);
	}
	
	@Override
	public int registraJogada(int score, boolean isCompletouJogo) throws ScoreInvalidoException {
		double scoreMaximoAntigo = this.getMaxScore();
		super.registraJogada(score, isCompletouJogo);
		if(this.getMaxScore() > scoreMaximoAntigo){
			return (int) this.getMaxScore()/1000;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s - Luta:\n==> Jogou %d vez(es)\n==> Zerou %d vez(es)\n==> Maior score: %d",
				this.getNome(), this.getQuantVezesJogadas(), this.getQuantVezesZerado(),this.getMaxScore());
	}
}
