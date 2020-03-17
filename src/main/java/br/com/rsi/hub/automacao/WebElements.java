package br.com.rsi.hub.automacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElements {
	private WebDriver driver;
	private WebElement botaoAcessoUsuarios;
	private WebElement user = driver.findElement(By.name("username"));
	
	public WebElement getBotaoAcessoUsuarios() {
		return botaoAcessoUsuarios;
	}
	public void setBotaoAcessoUsuarios(WebElement botaoAcessoUsuarios) {
		botaoAcessoUsuarios =  driver.findElement(By.id("menuUserSVGPath"));
		this.botaoAcessoUsuarios = botaoAcessoUsuarios;
	}
	public WebElement getUser() {
		return user;
	}
	public void setUser(WebElement user) {
		this.user = user;
	}
	public WebElement getPassword() {
		return password;
	}
	public void setPassword(WebElement password) {
		this.password = password;
	}
	public WebElement getBotaoLogar() {
		return botaoLogar;
	}
	public void setBotaoLogar(WebElement botaoLogar) {
		this.botaoLogar = botaoLogar;
	}
	private WebElement password = driver.findElement(By.name("password"));
	private WebElement botaoLogar = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-sender/button"));
}
