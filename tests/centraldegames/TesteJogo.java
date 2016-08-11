package centraldegames;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteJogo {
	private Jogo jogo;
	
	@Before
	public void criaJogo() throws Exception {
		this.jogo = new Jogo("Halo 5", 199.0);
	}
	
	@Test
	public void testJogo() {
		//testanto se o construtor criou o objeto de maneira correta;
		assertEquals("Nome do jogo esta errado","Halo 5", this.jogo.getNome());
		assertEquals("Preco do jogo esta errado", 199.0,this.jogo.getPreco(),0);
		
		//testanto excecoes
		Jogo jogo2; 
		try {
			jogo2 = new Jogo("", 199.0);
			fail("Jogo nao deveria aceitar nome vazio");
		} catch (Exception exp) {
			assertEquals("excecao errada lançada", "Nome do jogo nao pode ser vazio ou null", exp.getMessage());
		}
		
		Jogo jogo3;
		try {
			jogo3 = new Jogo(null, 199.0);
			fail("Jogo nao deveria aceitar nome null");
		} catch (Exception exp) {
			assertEquals("excecao errada lançada", "Nome do jogo nao pode ser vazio ou null", exp.getMessage());
		}
		
		Jogo jogo4;
		try {
			jogo4 = new Jogo("halo 5", -5);
			fail("Jogo nao deveria aceita preco negativo");
		} catch (Exception exp) {
			assertEquals("excecao errada lançada","Preco de jogo nao pode ser negativo", exp.getMessage());
		}
	}

	@Test
	public void testRegistraJogada() throws Exception {
		//testando um caso certo
		this.jogo.registraJogada(100, true);
		assertEquals("Recorde não  computado", 100, this.jogo.getMaxScore(),0);
		assertEquals("Vezes Jogadas não computadas", 1, this.jogo.getQuantVezesJogadas());
		assertEquals("Vezes zeradas não computadas", 1, this.jogo.getQuantVezesZerado());
		
		//novo recorde sem zerar
		this.jogo.registraJogada(500, false);
		assertEquals("Recorde não computado", 500, this.jogo.getMaxScore(),0);
		assertEquals("Vezes Jogadas não computadas", 2, this.jogo.getQuantVezesJogadas());
		assertEquals("Vezes zeradas não devia computar", 1, this.jogo.getQuantVezesZerado());
		
		//zerndo sem fazer recorde
		this.jogo.registraJogada(250, true);
		assertEquals("Recorde não deveria ter mudado", 500, this.jogo.getMaxScore(),0);
		assertEquals("Vezes Jogadas não computadas", 3, this.jogo.getQuantVezesJogadas());
		assertEquals("Vezes zeradas não computadas", 2, this.jogo.getQuantVezesZerado());
		
		//testando se pontuacao negativo
		try {
			this.jogo.registraJogada(-300, true);
			fail("não deveria aceitar pontuacao negativa");
		} catch (Exception exp) {
			assertEquals("excecao errada lançada", "pontuacao não pode ser negativa", exp.getMessage());
		}
	}
	
	@Test
	public void testsetPreco() throws Exception{
		this.jogo.setPreco(59.99);
		assertEquals("valor do preco errado", 59.99, this.jogo.getPreco(),0);
		
		this.jogo.setPreco(0);
		assertEquals("deveria ceitar preco zero", 0, this.jogo.getPreco(),0);
		
		try {
			this.jogo.setPreco(-5);
		} catch (Exception exp) {
			assertEquals("excecao errada lançada", "Preco de jogo nao pode ser negativo", exp.getMessage());
			assertEquals(0,this.jogo.getPreco(),0);
		}
	}

}