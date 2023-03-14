package br.wc.aquino.appium.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.wc.aquino.appium.core.BaseTest;
import br.wc.aquino.appium.page.MenuPage;

public class TestSwipe extends BaseTest {
	
	MenuPage menu=new MenuPage();
	
	@Test
	public void deveRealizarSwipe() {
		menu.acessarSwipe();
		assertTrue(menu.existeElementoPorTexto("a esquerda"));
		menu.swipeRight();;
		assertTrue(menu.existeElementoPorTexto("E veja se"));
		menu.clicarPorTexto(">");
		assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));
		menu.swipeLeft();;
		menu.clicarPorTexto("<");
		assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}
}
