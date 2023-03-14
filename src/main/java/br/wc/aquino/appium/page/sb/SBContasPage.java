package br.wc.aquino.appium.page.sb;

import org.openqa.selenium.By;

import br.wc.aquino.appium.core.BasePage;

public class SBContasPage extends BasePage {
	public void setContas(String nome) {
		escrever(By.className("android.widget.EditText"), nome);
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void excluir() {
		clicarPorTexto("EXCLUIR");
	}
	
	public void selecionarConta(String nome) {
		cliqueLongo(By.xpath("//*[@text='"+nome+"']"));
	}
}
