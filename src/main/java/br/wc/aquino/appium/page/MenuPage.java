package br.wc.aquino.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.wc.aquino.appium.core.BasePage;
import br.wc.aquino.appium.core.DriverFactor;

public class MenuPage extends BasePage{
	public void acessarFormulario() {
		clicarPorTexto("Formulário");
	}
	
	public void acessarSplash() {
		clicarPorTexto("Splash");
	}
	
	public void acessarAlert() {
		clicarPorTexto("Alertas");
	}
	
	public void acessarAbas() {
		clicarPorTexto("Abas");
	}
	
	public void acessarAccordion() {
		clicarPorTexto("Accordion");
	}
	
	public void acessarCliques() {
		clicarPorTexto("Cliques");
	}
	public void acessarSwipe() {
		clicarPorTexto("Swipe");
	}
	
	public void clicarSwipeList() {
		WebDriverWait wait= new WebDriverWait(DriverFactor.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		scrollDown();
		clicarPorTexto("Swipe List");
	}
	
	public void clicarDragAndDrop() {
		WebDriverWait wait= new WebDriverWait(DriverFactor.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		scrollDown();
		clicarPorTexto("Drag and drop");
	}
	
	public void acessarLoginSBHibrido() {
		clicarPorTexto("SeuBarriga Híbrido");
	}
	
	public void acessarLoginSBNativo() {
		clicarPorTexto("SeuBarriga Nativo");
	}
}
