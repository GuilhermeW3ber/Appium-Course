package br.wc.aquino.appium.page;

import org.openqa.selenium.By;

import br.wc.aquino.appium.core.BasePage;

public class AccordionPage extends BasePage {
		public void acessarOp1() {
			clicarPorTexto("Op��o 1");
		}
		public String obterValorOp1() {
			return obterTexto(By.xpath("//*@text='Op��o 1'/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
		}
}
