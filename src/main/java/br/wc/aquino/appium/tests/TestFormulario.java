package br.wc.aquino.appium.tests;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.wc.aquino.appium.core.BaseTest;
import br.wc.aquino.appium.core.DriverFactor;
import br.wc.aquino.appium.page.FormularioPage;
import br.wc.aquino.appium.page.MenuPage;
import io.appium.java_client.MobileBy;

public class TestFormulario extends BaseTest{
	
	private MenuPage menu=new MenuPage();
	private FormularioPage page=new FormularioPage();
	
	@Before
	private void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}
	
	@Test
	public void devePreencherCampoDeTexto() throws MalformedURLException { 
		page.escreverNome("Wagner");
		Assert.assertEquals("Wagner", page.obterNome());
		
	}
	
	@Test
	public void devePreencherCombo() throws MalformedURLException {	 
		page.selecionarCombo("Nintendo Switch");
		Assert.assertEquals("Nintendo Switch", page.obterVolarCombo());
		
	}
	
	@Test
	public void devePreencherCheckBoxESwitch() throws MalformedURLException { 		
		//Verificar status dos elementos 
		Assert.assertFalse(page.checkBoxMarcada());
		Assert.assertTrue(page.switchMarcado());
		
		page.clicarCheckBox();
		page.clicarSwitch();
		
		//Verificar estados alterados 
		Assert.assertTrue(page.checkBoxMarcada());
		Assert.assertFalse(page.switchMarcado());
	}
	
	@Test
	public void devePreencherLogin() throws MalformedURLException {
		page.escreverNome("Wagner");
		page.clicarCheckBox();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");
		page.salvar();
		
		Assert.assertEquals("Nome: Wagner", page.obterNomeCadastrado());
		Assert.assertEquals("Console: Nintendo Switch", page.obterConsoleCadastrado());
		Assert.assertTrue(page.obterSwitchCadastro().endsWith("Off"));
		Assert.assertTrue(page.obterCheckBoxCadastro().endsWith("Marcado"));
		
	}
	
	@Test
	public void devePreencherLoginDemorado() throws MalformedURLException {
		page.escreverNome("Wagner");
		DriverFactor.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.salvarDemorado();
		//esperar(3000);
		WebDriverWait wait=new WebDriverWait(DriverFactor.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Wagner']")));
		
		Assert.assertEquals("Nome: Wagner", page.obterNomeCadastrado());	
	}
	
	@Test
	public void deveSelecionarData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		assertTrue(page.existeElementoPorTexto("20/02/2000"));
	}
	
	@Test
	public void deveSelecionarHora() {
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicar(MobileBy.AccessibilityId("40"));
		page.clicarPorTexto("OK");
		assertTrue(page.existeElementoPorTexto("10:40"));
	}
	
	@Test
	public void deveInteragirComSeekBar() {
		page.clicarSeekBar(0.25);
		page.salvar();
	}
}
