package dealt_apache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hslf.model.Line;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.documentum.fc.client.IDfSysObject;

public class FileFolderApache {

	// / Leitura de excel ===

	// ler excel ==
	public List<Cell> lerExcel(String path) throws IOException {

		List<Cell> lista = new ArrayList<Cell>();

		FileInputStream arquivo = new FileInputStream(new File(path));

		XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

		XSSFSheet sheet = workbook.getSheetAt(0);

		// ///////////////////////////////////////////////////////

		for (Row row : sheet) {
			for (Cell cell : row) {
				lista.add(cell);
			}
		}
		return lista;
	}

	// coluna especifica==
	public List<Cell> colunaEspecificaExcel(String path) throws IOException {

		List<Cell> lista = new ArrayList<Cell>();

		FileInputStream arquivo = new FileInputStream(new File(path));

		XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

		XSSFSheet sheet = workbook.getSheetAt(0);

		// /////////////////////////////////////////////////////////////////
		for (Row row : sheet) {
			Cell cell;
			lista.add(row.getCell(2));

		}
		return lista;
	}

	// celula especifica ==
	public Cell celulaEspecificaExcel(String path) throws IOException {

		Cell celularValor;

		FileInputStream arquivo = new FileInputStream(new File(path));

		XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

		////////////////////////////////////////////////////////////////////////

		celularValor = workbook.getSheetAt(0).getRow(2).getCell(1);

		return celularValor;
	}

}
