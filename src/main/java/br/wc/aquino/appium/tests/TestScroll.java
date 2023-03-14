package br.wc.aquino.appium.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.wc.aquino.appium.core.BaseTest;
import br.wc.aquino.appium.core.DriverFactor;
import br.wc.aquino.appium.page.MenuPage;

public class TestScroll extends BaseTest {
	private MenuPage menu=new MenuPage();
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		WebDriverWait wait= new WebDriverWait(DriverFactor.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		System.out.println("Começando");
		menu.scrollDown();
		menu.clicarPorTexto("Opção bem escondida");
		assertEquals("Você achou essa opção", menu.obsterMensagemAlert());
		menu.clicarPorTexto("OK");
	}
}
