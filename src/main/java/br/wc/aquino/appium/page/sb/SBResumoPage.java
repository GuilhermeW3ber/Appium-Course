package br.wc.aquino.appium.page.sb;

import org.openqa.selenium.By;

import br.wc.aquino.appium.core.BasePage;
import br.wc.aquino.appium.core.DriverFactor;
import io.appium.java_client.MobileElement;

public class SBResumoPage extends BasePage {

		public void excluirMovimentacao(String desc) {
			MobileElement el = DriverFactor.getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
			swipeElement(el, 0.9, 0.1);
			clicarPorTexto("Del");
		}
}
