package br.wc.aquino.appium.page;

import br.wc.aquino.appium.core.BasePage;

public class AlertPage extends BasePage {
	
	public void clicarAlertConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public void clicarAlertaSimples() {
		clicarPorTexto("ALERTA SIMPLES");
	}
	
	public void confirmar() {
		clicarPorTexto("CONFIRMAR");
	}
	
	public void sair() {
		clicarPorTexto("SAIR");
	}
	
	public void clicarForaDaCaixa() {
		tap(100,150);
	}
	
}
