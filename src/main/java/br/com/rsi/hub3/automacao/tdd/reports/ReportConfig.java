package br.com.rsi.hub3.automacao.tdd.reports;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportConfig {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void setReport(String nomeReport) {
		htmlReporter = new ExtentHtmlReporter("./src/test/resources/Reports/"+nomeReport+".html"); //CaminhoReport
		htmlReporter.config().setDocumentTitle("Report");
		htmlReporter.config().setReportName("Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	public static ExtentTest criarTeste(String nomeTeste) {
		test = extent.createTest(nomeTeste);
		return test;
	}
	
	public static void realtorioReport(ExtentTest teste, ITestResult result, WebDriver driver) throws IOException {
		String screenPath = Screenshots.getScreenshot(driver, result.getName());
		test.addScreenCaptureFromPath(screenPath);
		
		if (result.getStatus() == ITestResult.FAILURE) {
			teste.log(Status.FAIL, "Teste FALHOU: " + result.getName());
			teste.log(Status.FAIL, "Teste FALHOU: " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			teste.log(Status.SKIP, "Teste SKIPPED: " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			teste.log(Status.PASS, "Teste PASSOU: " + result.getName());
		}
	}

	/*fechando*/
	public static void encerrarReport() {
		extent.flush();
	}
}
