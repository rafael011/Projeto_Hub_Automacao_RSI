package br.com.rsi.hub3.automacao.tdd.reports;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

	public static String getScreenshot(WebDriver driver, String nomeScreenshot) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String caminhoScreenshot = System.getProperty("user.dir") + "./src/test/resources/Screenshots/" + nomeScreenshot + ".png";	
		File caminho = new File(caminhoScreenshot);
		try {
			FileUtils.copyFile(src, caminho);
		} catch (IOException e) {
			System.out.println(" O print falhou " + e.getMessage());
		}
		return caminhoScreenshot;
	}
}