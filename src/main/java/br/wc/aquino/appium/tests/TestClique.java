package br.wc.aquino.appium.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.wc.aquino.appium.core.BaseTest;
import br.wc.aquino.appium.page.CliquePage;
import br.wc.aquino.appium.page.MenuPage;

public class TestClique extends BaseTest {
	private MenuPage menu = new MenuPage();
	private CliquePage page = new CliquePage();
	
	@Before
	public void setup() {
		menu.acessarCliques();
	}
	
	@Test
	public void deveRealizarCliqueLongo() {
		page.cliqueLongo();
		assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		page.clicarPorTexto("Clique Duplo");
		page.clicarPorTexto("Clique Duplo");
		
		assertEquals("Clique Duplo", page.obterTextoCampo());
	}
}
