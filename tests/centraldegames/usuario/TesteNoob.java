package centraldegames.usuario;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import centraldegames.componentes.EstiloJogabilidade;
import centraldegames.core.Jogo;
import centraldegames.exceptions.DinheiroInvalidoException;
import centraldegames.exceptions.NomeInvalidoException;
import centraldegames.exceptions.SaldoInsuficienteExeception;
import centraldegames.usuarios.Noob;

public class TesteNoob {
	private Noob jogador;
	
	@Before
	public void setUp() throws NomeInvalidoException {
		jogador = new Noob("John-117", "MasterChief");
	}
	
	@Test
	public void testNoob() {
		assertEquals("John-117", jogador.getNomeReal());
		assertEquals("MasterChief", jogador.getLogin());
		
		// Testando execoes
		Noob jogador2;
		try {
			jogador2 = new Noob("", "MasterChief");
			fail("Jogador não deveria aceitar nome vazio");
		} catch (NomeInvalidoException exp) {
			assertEquals("Nome do jogador nao poder ser vazio ou null", exp.getMessage());
		}
		try {
			jogador2 = new Noob(null, "MasterChief");
			fail("Jogador não deveria aceitar nome null");
		} catch (NomeInvalidoException exp) {
			assertEquals("Nome do jogador nao poder ser vazio ou null", exp.getMessage());
		}
		try {
			jogador2 = new Noob("John-117", "");
			fail("login não deveria aceitar nome vazio");
		} catch (NomeInvalidoException exp) {
			assertEquals("login do jogador nao poder ser vazio ou null", exp.getMessage());
		}
		try {
			jogador2 = new Noob("John-117", null);
			fail("login não deveria aceitar nome null");
		} catch (NomeInvalidoException exp) {
			assertEquals("login do jogador nao poder ser vazio ou null", exp.getMessage());
		}
	}

	@Test
	public void testAdicionarDinheiro() throws DinheiroInvalidoException {
		this.jogador.adicionarDinheiro(100);
		assertEquals(100, this.jogador.getSaldo(),0);
		this.jogador.adicionarDinheiro(50);
		assertEquals(150, this.jogador.getSaldo(),0);
		
		try {
			this.jogador.adicionarDinheiro(-1);
			fail("Não deveria aceitar dinheiro negativo");
		} catch (DinheiroInvalidoException exp) {
			assertEquals("Dinheiro nao pode ser negativo", exp.getMessage());
		}
	}
	
	@Test
	public void testGastarDinheiro() throws DinheiroInvalidoException, SaldoInsuficienteExeception {
		this.jogador.adicionarDinheiro(150);
		
		this.jogador.gastarDinheiro(50);
		assertEquals(100, this.jogador.getSaldo(),0);
		this.jogador.gastarDinheiro(0);
		assertEquals(100, this.jogador.getSaldo(),0);
		this.jogador.gastarDinheiro(100);
		assertEquals(0, this.jogador.getSaldo(),0);
		
		this.jogador.adicionarDinheiro(150);
		try {
			this.jogador.gastarDinheiro(-3);
			fail("Não deveria aceitar dinheiro negativo");
		} catch (DinheiroInvalidoException exp) {
			assertEquals("Dinheiro nao pode ser negativo", exp.getMessage());
		}
		try {
			this.jogador.gastarDinheiro(200);
			fail("Não deveria aceitar gasto maior que o saldo");
		} catch (SaldoInsuficienteExeception exp) {
			assertEquals("Saldo insuficiente", exp.getMessage());
		}
		
	}

	@Test
	public void testCompraJogo() throws Exception {
		HashSet<EstiloJogabilidade> Jogabilidades = new HashSet<EstiloJogabilidade>();
		Jogabilidades.add(EstiloJogabilidade.ONLINE);
		Jogabilidades.add(EstiloJogabilidade.OFFLINE);
		Jogabilidades.add(EstiloJogabilidade.MULTIPLAYER);
		Jogabilidades.add(EstiloJogabilidade.COMPETITIVO);
		Jogabilidades.add(EstiloJogabilidade.COOPERATIVO);
		Jogo jogo = new Jogo("Halo 5", 200.0, Jogabilidades);
		Jogo jogo2 = new Jogo("GOW", 199.0, Jogabilidades);
		
		this.jogador.adicionarDinheiro(300);
		this.jogador.compraJogo(jogo);
		
		try {
			this.jogador.compraJogo(jogo2);
			fail("Não deveria vender jogo sem saldo suficiente para isso");
		} catch (SaldoInsuficienteExeception exp) {
			assertEquals("Saldo insuficiente", exp.getMessage());
		}
		
	}
}
