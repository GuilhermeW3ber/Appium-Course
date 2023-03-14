package br.wc.aquino.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.wc.aquino.appium.core.BaseTest;
import br.wc.aquino.appium.page.MenuPage;
import br.wc.aquino.appium.page.SplashPage;

public class SplashTest extends BaseTest {
	
	private MenuPage menu=new MenuPage();
	private SplashPage page=new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() {
		menu.acessarSplash();
		page.existeElementoSplashVisivel();
		page.aguardarSplashSumir();
		
		Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
	}	
}
