package centraldegames.usuario;

import static org.junit.Assert.*;

import org.junit.Test;

import centraldegames.core.Jogo;
import centraldegames.usuarios.Veterano;

public class TesteVeterano {

	@Test
	public void testCompraJogo() throws Exception {
		Jogo jogo = new Jogo("Assassins Creed", 50);
		Veterano jogador = new Veterano("Ezil Alditore", "EA");
		
		jogador.adicionarDinheiro(200);
		jogador.compraJogo(jogo);
	}

}
