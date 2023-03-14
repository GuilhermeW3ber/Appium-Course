package br.wc.aquino.appium.tests;

import static org.junit.Assert.assertEquals;

import br.wc.aquino.appium.core.BaseTest;
import br.wc.aquino.appium.page.AccordionPage;
import br.wc.aquino.appium.page.MenuPage;

public class TestAccordion extends BaseTest {
	
	MenuPage menu=new MenuPage();
	AccordionPage page=new AccordionPage();
	
	public void deveConfirmarAccordion() {
		menu.acessarAccordion();
		page.acessarOp1();
		esperar(1000);
		assertEquals("Essa � a descri��o da op��o 1", page.obterValorOp1());
	}
}
