package centraldegames.usuarios;

import java.util.HashSet;

import centraldegames.core.Jogo;
import centraldegames.core.Usuario;
import centraldegames.exceptions.DinheiroInvalidoException;
import centraldegames.exceptions.NomeInvalidoException;
import centraldegames.exceptions.SaldoInsuficienteExeception;

/** <p>Classe que representa usuario Veterano</p>
 * @author Ricardo Andrade
 * @since 18/08/16
 * @version v0.1
 * @link https://github.com/RicardoAndradeM/Lab6-RicardoMaia.git
 */
public class Veterano extends Usuario {
	
	/**
	 * @param nome nome real do usuario
	 * @param id nome de usuario(identificador)
	 * @throws NomeInvalidoException caso nome passado seja invalido
	 * @author Ricardo Andrade
	 * @since 18/08/16
	 */
	public Veterano(String nome, String login) throws NomeInvalidoException {
		super(nome, login);
	}

	@Override
	public boolean compraJogo(Jogo jogo) throws DinheiroInvalidoException, SaldoInsuficienteExeception {
		double precoComDesconto = jogo.getPreco() - (20/100.0)*jogo.getPreco();
			this.gastarDinheiro(precoComDesconto);
			this.adicionaJogo(jogo);
			this.setX2p(this.getX2p() + ((int) jogo.getPreco() * 15));
			return true;
	}
	
	@Override
	public String toString() {
		String saida = String.format("\n%s\n%s - jogador Veterano\nLista de Jogos:", this.getLogin(),this.getNomeReal());
		HashSet<Jogo> jogos = this.getMeusJogos();
		double precoTotal = 0;
		for (Jogo jogo : jogos) {
			saida += "\n+ " + jogo.toString();
			precoTotal += jogo.getPreco();
		}
		saida += String.format("\n\n Total de preco dos jogos: R$ %.2f", precoTotal);
		return saida;
	}
}
