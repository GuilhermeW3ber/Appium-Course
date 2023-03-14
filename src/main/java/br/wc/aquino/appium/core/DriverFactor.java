package br.wc.aquino.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactor {
	
	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver(){
		if(driver == null){
			inicializarAppium();
			//createTestObjectDriver();
		}
		return driver;
	}
	@Before
	private static void inicializarAppium() {
		DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName","Android");
		desiredCapabilities.setCapability("deviceName","emulator-5554");
		desiredCapabilities.setCapability("automationName","uiautomator2");
		/*desiredCapabilities.setCapability("appPackage","com.android.calculator2");
		desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");*/
		desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:/Users/broco/eclipse-workspace/CursoAppiumMVN/src/main/resources/CTAAppium_2_0.apk");
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);;
		}catch(MalformedURLException e){
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	private static void createTestObjectDriver() {
		DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
		desiredCapabilities.setCapability("testobject_api_key","91E74CCC23FC432EBF8F5C10F8685A15");
		desiredCapabilities.setCapability("appiumVersion","1.7.2");
		//desiredCapabilities.setCapability("deviceName","emulator-5554");
		desiredCapabilities.setCapability("automationName","uiautomator2");
		//desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:/Users/broco/eclipse-workspace/CursoAppiumMVN/src/main/resources/CTAAppium_2_0.apk");
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://us1.appium.testobject.com/wd/hub"), desiredCapabilities);;
		}catch(MalformedURLException e){
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	public static void KillDriver() {
		if(driver!= null) {
			driver.quit();
			driver=null;
		}
	}
}
