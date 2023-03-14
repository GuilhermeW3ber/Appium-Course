package br.wc.aquino.appium.page.sb;

import org.openqa.selenium.By;

import br.wc.aquino.appium.core.BasePage;

public class SBHomePage extends BasePage {
	
	public String obterSaldoConta(String conta) {
		return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
	}
}
