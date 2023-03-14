package br.wc.aquino.appium.page;

import org.openqa.selenium.By;

import br.wc.aquino.appium.core.BasePage;
import br.wc.aquino.appium.core.DriverFactor;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage{
	
	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome(){
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterVolarCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarCheckBox() {
		clicar(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("Switch"));
	}
	public void clicarSeekBar(double posicao) {
		int delta =55;
		MobileElement seek = DriverFactor.getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seek.getLocation().y+(seek.getSize().height/2);
		System.out.println(y);
		
		int xinicial = (int)seek.getLocation().x + delta;
		int x = (int)(xinicial +((seek.getSize().width-2*delta)*posicao));
		System.out.println(x);
		
		tap(x,y);
	}
	
	public boolean checkBoxMarcada() {
		return isCheckMarked(By.className("android.widget.CheckBox"));
	}
	
	public boolean switchMarcado() {
		return isCheckMarked(MobileBy.AccessibilityId("switch"));
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void salvarDemorado() {
		clicarPorTexto("SALVAR DEMORADO");
	}
	
	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.CheckedTextView[@text='Nome: Wagner']"));
	}
	
	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.CheckedTextView[starts-with(@text, 'Console:')]"));
	}
	
	public String obterCheckBoxCadastro() {
		return obterTexto(By.xpath("//android.widget.CheckedTextView[starts-with(@text, 'Checkbox:')]"));
	}
	
	public String obterSwitchCadastro() {
		return obterTexto(By.xpath("//android.widget.CheckedTextView[starts-with(@text, 'Switch:')]"));
	}
	
}
