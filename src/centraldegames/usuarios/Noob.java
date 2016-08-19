package centraldegames.usuarios;

import centraldegames.componentes.Jogo;
import centraldegames.core.Usuario;
import centraldegames.exceptions.NomeInvalidoException;

public class Noob extends Usuario {

	public Noob(String nome, String id) throws NomeInvalidoException {
		super(nome, id);	}

	@Override
	public boolean compraJogo(Jogo jogo) {
		double precoComDesconto = jogo.getPreco() - (20/100.0)*jogo.getPreco();
		if(precoComDesconto <= this.getSaldo()){
			this.gastarDinheiro(precoComDesconto);
			this.adicionaJogo(jogo);
			return true;
		} else {
			//exeption aqui
		}
	}
}
