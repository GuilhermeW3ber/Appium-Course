package br.wc.aquino.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	@Rule
	public TestName testName=new TestName();
	
	@AfterClass
	public static void finalizarClasse() {
		DriverFactor.KillDriver();
	}
	
	@After
	private void finalizar() {
		gerarScreenshot();
		DriverFactor.getDriver().resetApp();
	}
	
	public void gerarScreenshot() {
		try {
			File image=((TakesScreenshot)DriverFactor.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(image, new File("target/screenshots/"+testName.getMethodName()+".png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void esperar(long tempo) {
		try {
			Thread.sleep(tempo);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
