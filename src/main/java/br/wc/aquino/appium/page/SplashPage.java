package br.wc.aquino.appium.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.wc.aquino.appium.core.BasePage;
import br.wc.aquino.appium.core.DriverFactor;

public class SplashPage extends BasePage {
	
	public boolean existeElementoSplashVisivel() {
		return existeElementoPorTexto("Splash!");
	}
	
	public void aguardarSplashSumir() {
		DriverFactor.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(DriverFactor.getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
	}
}
