package br.wc.aquino.appium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.wc.aquino.appium.core.BaseTest;
import br.wc.aquino.appium.page.MenuPage;
import br.wc.aquino.appium.page.sb.SBContasPage;
import br.wc.aquino.appium.page.sb.SBHomePage;
import br.wc.aquino.appium.page.sb.SBMenuPage;
import br.wc.aquino.appium.page.sb.SBMovimentacaoPage;
import br.wc.aquino.appium.page.sb.SBPage;
import br.wc.aquino.appium.page.sb.SBResumoPage;

public class TesteSB extends BaseTest {
	
	private MenuPage menu= new MenuPage();
	private SBPage login = new SBPage();
	private SBMenuPage menuSB= new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage(); 
	private SBResumoPage resumo = new SBResumoPage();
	
	@Before
	public void setup() {
		menu.acessarLoginSBNativo();
		login.setEmail("brococaxi@a");
		login.setSenha("brococaxi");
		login.entrar();
	}
	
	@Test
	public void deveInserirContaComSucesso() {
		menuSB.acessarContas();
		contas.setContas("Conta Teste");
		contas.salvar();
		assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
	
	@Test
	public void deveExcluirConta() {
		menuSB.acessarContas();
		contas.selecionarConta("Conta Teste");
		contas.excluir();
		assertTrue(contas.existeElementoPorTexto("Conta excluida com sucesso"));
	}
	
	@Test
	public void deveValidarInclusaoDaMovimentacao() {
		menuSB.acessarMovimentacoes();
		mov.salvar();
		assertTrue(mov.existeElementoPorTexto("Descrição é um campo obrigatório"));
		
		mov.setDescricao("Desc");
		mov.salvar();
		assertTrue(mov.existeElementoPorTexto("Interessado é um campo obrigatório"));
		
		mov.setInteressado("interess");
		mov.salvar();
		assertTrue(mov.existeElementoPorTexto("Valor é um campo obrigatório"));
		
		mov.setValor("123");
		mov.salvar();
		assertTrue(mov.existeElementoPorTexto("Conta é um campo obrigatório"));
		
		mov.setConta("Conta para Alterar");
		mov.salvar();
		assertTrue(mov.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
		
	}
	
	@Test
	public void deveAtualizarSaldoAoExcluirMovimentacao() {
		assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
		menuSB.acessarResumo();
		resumo.excluirMovimentacao("Movimentaco 3, calculo saldo");
		assertTrue(resumo.existeElementoPorTexto("Movimentação excluida com sucesso"));
		menuSB.acessarHome();
		esperar(10000);
		home.scroll(0.2, 0.9);
		assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
	}
}
