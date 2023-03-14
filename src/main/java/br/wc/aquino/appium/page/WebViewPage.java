package br.wc.aquino.appium.page;

import java.util.Set;

import org.openqa.selenium.By;

import br.wc.aquino.appium.core.BasePage;
import br.wc.aquino.appium.core.DriverFactor;

public class WebViewPage extends BasePage {
	public void entrarContextoWeb() {
		Set<String> contextHandles = DriverFactor.getDriver().getContextHandles();
		//for(String valor:contextHandles) {
		//	System.out.println(valor);
		//}
		DriverFactor.getDriver().context((String) contextHandles.toArray()[1]);
	}
	
	public void setEmail(String valor) {
		DriverFactor.getDriver().findElement(By.id("email")).sendKeys(valor);
	}
	
	public void sairContextoWeb() {
		DriverFactor.getDriver().context((String) DriverFactor.getDriver().getContextHandles().toArray()[0]);
	}
	
	public void setSenha(String valor) {
		DriverFactor.getDriver().findElement(By.id("senha")).sendKeys(valor);
	}
	
	public void cadastrar() {
		clicar(By.xpath("//button[@tupe='submit']"));
	}
	
	public String getMensagem() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
}
