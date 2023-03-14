package br.wc.aquino.appium.page;

import br.wc.aquino.appium.core.BasePage;

public class AbasPage extends BasePage {
	public boolean isAba1() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 1");
	}
	
	public boolean isAba2() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 2");
	}
	
	public void acessarrAba2() {
		clicarPorTexto("ABA 2");
	}
}
