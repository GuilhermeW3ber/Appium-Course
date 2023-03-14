package br.wc.aquino.appium.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.wc.aquino.appium.core.BaseTest;
import br.wc.aquino.appium.page.MenuPage;
import br.wc.aquino.appium.page.SwipeListPage;

public class TestSwipeElement extends BaseTest {

	private MenuPage menu=new MenuPage();
	private SwipeListPage page = new SwipeListPage();
	
	@Test
	public void deveResolverDesafio() {
		menu.clicarSwipeList();
		page.swipeElementRight("Opção 1");
		page.clicarBotaoMais();
		assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));
		page.swipeElementRight("Opção 4");
		page.clicarPorTexto("(-)");
		assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));
		page.swipeElementLeft("Opção 5 (-)");
		assertTrue(page.existeElementoPorTexto("Opção 5"));
		
	}
}
