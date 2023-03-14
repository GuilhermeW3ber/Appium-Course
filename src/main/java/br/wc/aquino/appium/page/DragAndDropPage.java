package br.wc.aquino.appium.page;

import java.util.List;

import org.openqa.selenium.By;

import br.wc.aquino.appium.core.BasePage;
import br.wc.aquino.appium.core.DriverFactor;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class DragAndDropPage extends BasePage {
	public void arrastar(String origem, String destino) {
		MobileElement inicio = DriverFactor.getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
		MobileElement fim = DriverFactor.getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));
		
		new TouchAction(DriverFactor.getDriver()).longPress(inicio).moveTo(fim).release().perform();
	}
	
	public String[] obterLista() {
		List<MobileElement> elements = DriverFactor.getDriver().findElements((By.className("android.widget.TextView")));
		String[] retorno = new String[elements.size()];
		for(int i=0; i<elements.size();i++) {
			retorno[i]=elements.get(i).getText();
			//System.out.println("\"" + retorno[i]+"\", ");
		}
		return retorno;
	}
}
