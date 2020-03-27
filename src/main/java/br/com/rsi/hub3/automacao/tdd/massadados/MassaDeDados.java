package br.com.rsi.hub3.automacao.tdd.massadados;

public class MassaDeDados {

	public String getUsuario() throws Exception {
		ExcelUtils.setExcelFile(ExcelUtils.Path_TestData + ExcelUtils.File_TestData, "Planilha1");
		return ExcelUtils.getCellData(0, 0);
	}

	public String getSenha() throws Exception {
		ExcelUtils.setExcelFile(ExcelUtils.Path_TestData + ExcelUtils.File_TestData, "Planilha1");
		return ExcelUtils.getCellData(0, 1);
	}
	
	public String getUsuarioInvalido() throws Exception {
		ExcelUtils.setExcelFile(ExcelUtils.Path_TestData + ExcelUtils.File_TestData, "Planilha1");
		return ExcelUtils.getCellData(1, 0);
	}
	
	public String getSenhaInvalida() throws Exception {
		ExcelUtils.setExcelFile(ExcelUtils.Path_TestData + ExcelUtils.File_TestData, "Planilha1");
		return ExcelUtils.getCellData(1, 1);
	}
}
