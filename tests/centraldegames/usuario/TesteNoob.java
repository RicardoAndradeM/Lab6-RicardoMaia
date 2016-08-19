package centraldegames.usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import centraldegames.exceptions.NomeInvalidoException;
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
		assertEquals("MasterChief", jogador.getId());
		
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
			jogador2 = new Noob("", "MasterChief");
			fail("Jogador não deveria aceitar nome vazio");
		} catch (NomeInvalidoException exp) {
			assertEquals("Nome do jogador nao poder ser vazio ou null", exp.getMessage());
		}
	}

	/*@Test
	public void testCompraJogo() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionarDinheiro() {
		fail("Not yet implemented");
	}

	@Test
	public void testGastarDinheiro() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionaJogo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNomeReal() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetId() {
		fail("Not yet implemented");
	}*/

}
