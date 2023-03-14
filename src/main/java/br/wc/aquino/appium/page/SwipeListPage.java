package br.wc.aquino.appium.page;

import org.openqa.selenium.By;

import br.wc.aquino.appium.core.BasePage;
import br.wc.aquino.appium.core.DriverFactor;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class SwipeListPage extends BasePage {
	public void swipeElementLeft(String opcao) {
		swipeElement(DriverFactor.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
	}
	
	public void swipeElementRight(String opcao) {
		swipeElement(DriverFactor.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
	}
	
	public void clicarBotaoMais() {
		MobileElement botao= DriverFactor.getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
		new TouchAction(DriverFactor.getDriver()).tap(botao, -50, 0).perform();
	}
}
