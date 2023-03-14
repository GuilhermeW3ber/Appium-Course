package br.wc.aquino.appium.tests;

import static org.junit.Assert.assertTrue;

import br.wc.aquino.appium.core.BaseTest;
import br.wc.aquino.appium.page.AbasPage;
import br.wc.aquino.appium.page.MenuPage;

public class TestAbas extends BaseTest {
	
	MenuPage menu=new MenuPage();
	AbasPage page=new AbasPage();
	
	public void deveInteragirComAbas() {
		menu.acessarAbas();
		assertTrue(page.isAba1());
		page.acessarrAba2();
		assertTrue(page.isAba2());
	}
}
