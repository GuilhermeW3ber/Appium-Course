
package br.wc.aquino.appium.page;

import org.openqa.selenium.By;

import br.wc.aquino.appium.core.BasePage;
import br.wc.aquino.appium.core.DriverFactor;

public class CliquePage extends BasePage {
	public void cliqueLongo() {
		cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
	}
	
	public String obterTextoCampo() {
		return DriverFactor.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}