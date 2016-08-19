package centraldegames.usuarios;

import centraldegames.componentes.Jogo;
import centraldegames.core.Usuario;

public class Veterano extends Usuario {
	
	public Veterano(String nome, String id) {
		super(nome, id);
	}

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
