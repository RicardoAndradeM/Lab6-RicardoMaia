package centraldegames.jogos;

import java.util.HashSet;

import centraldegames.componentes.EstiloJogabilidade;
import centraldegames.core.Jogo;
import centraldegames.exceptions.ScoreInvalidoException;

public class JogoPlataforma extends Jogo {
	
	public JogoPlataforma(String nome, double preco, HashSet<EstiloJogabilidade> jogabilidades) throws Exception {
		super(nome, preco, jogabilidades);
	}
	
	public JogoPlataforma(String nome, double preco) throws Exception {
		super(nome, preco);
	}
	
	@Override
	public int registraJogada(int score, boolean isCompletouJogo) throws ScoreInvalidoException {
		int vezesZeradasAntiga = this.getQuantVezesZerado();
		super.registraJogada(score, isCompletouJogo);
		if(this.getQuantVezesZerado() > vezesZeradasAntiga){
			return 20;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s - Plataforma:\n==> Jogou %d vez(es)\n==> Zerou %d vez(es)\n==> Maior score: %d",
				this.getNome(), this.getQuantVezesJogadas(), this.getQuantVezesZerado(),this.getMaxScore());
	}

}
