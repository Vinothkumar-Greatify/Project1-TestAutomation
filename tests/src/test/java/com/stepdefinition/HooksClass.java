package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeOptions;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		System.setProperty("javax.net.debug", "ssl");
		System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,TLSv1");
		System.setProperty("mail.smtp.ssl.ciphers", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");

//		getDriver(getPropertyFileValue("browser"));
//		implicitwait(30);
//		maxWindow();

	}

	@After
	public void afterScenario(Scenario scenario) throws InterruptedException {
		boolean b = scenario.isFailed();
		if (b == true) {
			scenario.attach(Screenshot(), "image/png", "Failed Scenario Screenshot");
		}
		Thread.sleep(500);
//		closeAllWind();
	}

}