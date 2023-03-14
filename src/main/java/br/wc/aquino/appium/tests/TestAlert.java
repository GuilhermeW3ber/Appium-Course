package br.wc.aquino.appium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import br.wc.aquino.appium.core.BaseTest;
import br.wc.aquino.appium.page.AlertPage;
import br.wc.aquino.appium.page.MenuPage;

public class TestAlert extends BaseTest {
	
	private MenuPage menu=new MenuPage();
	private AlertPage page= new AlertPage();

	@Test
	public void deceConfirmarAlert() {
		menu.acessarAlert();
		page.clicarAlertConfirm();
		assertEquals("Confirma a operação?", page.obsterMensagemAlert());
		page.confirmar();
		assertEquals("Confirmado", page.obsterMensagemAlert());
		page.sair();
	}
	
	public void deveClicarFora() {
		page.clicarAlertaSimples();
		page.clicarForaDaCaixa();
		assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}
}
