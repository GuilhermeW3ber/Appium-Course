package br.wc.aquino.appium.tests;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import br.wc.aquino.appium.core.BaseTest;
import br.wc.aquino.appium.page.MenuPage;
import br.wc.aquino.appium.page.WebViewPage;

public class TestWebView extends BaseTest {
	
	private MenuPage menu=new MenuPage();
	private WebViewPage page=new WebViewPage();
	
	@Test
	public void devefazerLogin() {
		menu.acessarLoginSBHibrido();
		esperar(3000);
		page.entrarContextoWeb();
		page.setEmail("brococaxi@a");
		page.setSenha("brococaxi");
		page.cadastrar();
		assertEquals("Bem vindo, brococaxi!", page.getMensagem());
	}
	
	@After
	public void terDown() {
		page.sairContextoWeb();
	}
	
}
