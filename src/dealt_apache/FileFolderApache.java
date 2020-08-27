package src.dealt_apache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

import src.com.documentum.UtilsDocumentum;
import src.com.documentum.conexao_documentum;
import src.com.documentum.ObjectsParam.Querys;

import com.documentum.fc.client.DfQuery;
import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.client.IDfQuery;
import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.common.DfException;

public class FileFolderApache extends conexao_documentum {

	public FileFolderApache() {
	}

	public FileFolderApache(String Usuario_, String Senha_, String Repositorio_) {
		super(Usuario_, Senha_, Repositorio_);
	}

	// / Leitura de excel ===

	// ler excel ==

	/*
	 * row.getRowNum() == nomero da linha cell.getColumnIndex() numero da coluna
	 */

	Querys querysObj = new Querys();

	public void lerExcel(String path) throws IOException {

		try {
			FileInputStream arquivo = new FileInputStream(new File(path));

			HSSFWorkbook workbook = new HSSFWorkbook(arquivo);

			HSSFSheet sheet = workbook.getSheetAt(0);

			// ///////////////////////////////////////////////////////

			for (Row row : sheet) {
				for (Cell cell : row) {
					System.out.print(cell + "|");
				}
				System.out.println("\n");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	// coluna especifica==
	public List<Cell> colunaEspecificaExcel(String path) throws IOException {

		List<Cell> lista = new ArrayList<Cell>();
		try {
			FileInputStream arquivo = new FileInputStream(new File(path));

			XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

			XSSFSheet sheet = workbook.getSheetAt(0);

			// /////////////////////////////////////////////////////////////////
			for (Row row : sheet) {
				Cell cell;
				lista.add(row.getCell(2));

			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return lista;
	}

	// celula especifica ==
	Cell celularValor;

	public Cell celulaEspecificaExcel(String path) throws IOException {

		FileInputStream arquivo = new FileInputStream(new File(path));

		XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

		// //////////////////////////////////////////////////////////////////
		// ////

		celularValor = workbook.getSheetAt(0).getRow(10).getCell(1);

		return celularValor;
	}

	// // retorna um array ==

	public List<ExcelObjTeste> listExcel(String path) throws IOException {

		List<ExcelObjTeste> lista = new ArrayList<ExcelObjTeste>();

		try {
			FileInputStream arquivo = new FileInputStream(new File(path));

			XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			// ///////////////////////////////////////////////////////

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				ExcelObjTeste excelObj = new ExcelObjTeste();

				lista.add(excelObj);
				while (cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					int celula;
					int indiceColuna;
					
					celula = cell.getCellType(); 
                    indiceColuna =  cell.getColumnIndex();
                    
					if(celula == Cell.CELL_TYPE_STRING && indiceColuna == 0){excelObj.setCampo1(cell.getStringCellValue());}
					else if(celula == Cell.CELL_TYPE_NUMERIC && indiceColuna == 0){excelObj.setCampo1(String.valueOf(cell.getNumericCellValue()));}
					//else if(celula == Cell.CELL_TYPE_BOOLEAN){System.out.print(cell.getBooleanCellValue());}
					else if(celula == Cell.CELL_TYPE_STRING && indiceColuna == 1){excelObj.setCampo2(cell.getStringCellValue());}
					else if(celula == Cell.CELL_TYPE_NUMERIC && indiceColuna == 1){excelObj.setCampo2(String.valueOf(cell.getNumericCellValue()));}
					else if(celula == Cell.CELL_TYPE_STRING && indiceColuna == 2){excelObj.setCampo3(cell.getStringCellValue());}
					else if(celula == Cell.CELL_TYPE_NUMERIC && indiceColuna == 2){excelObj.setCampo3(String.valueOf(cell.getNumericCellValue()));}
					else if(celula == Cell.CELL_TYPE_STRING && indiceColuna == 3){excelObj.setCampo4(cell.getStringCellValue());}
					else if(celula == Cell.CELL_TYPE_NUMERIC && indiceColuna == 3){excelObj.setCampo4(String.valueOf(cell.getNumericCellValue()));}
					else if(celula == Cell.CELL_TYPE_STRING && indiceColuna == 4){excelObj.setCampo5(cell.getStringCellValue());}
					else if(celula == Cell.CELL_TYPE_NUMERIC && indiceColuna == 4){excelObj.setCampo5(String.valueOf(cell.getNumericCellValue()));}
					else if(celula == Cell.CELL_TYPE_STRING && indiceColuna == 5){excelObj.setCampo6(cell.getStringCellValue());}
					else if(celula == Cell.CELL_TYPE_NUMERIC && indiceColuna == 5){excelObj.setCampo6(String.valueOf(cell.getNumericCellValue()));}
					else if(celula == Cell.CELL_TYPE_STRING && indiceColuna == 6){excelObj.setCampo7(cell.getStringCellValue());}
					else if(celula == Cell.CELL_TYPE_NUMERIC && indiceColuna == 6){excelObj.setCampo7(String.valueOf(cell.getNumericCellValue()));}
					else if(celula == Cell.CELL_TYPE_STRING && indiceColuna == 7){excelObj.setCampo8(cell.getStringCellValue());}
					else if(celula == Cell.CELL_TYPE_NUMERIC && indiceColuna == 7){excelObj.setCampo8(String.valueOf(cell.getNumericCellValue()));}
					else if(celula == Cell.CELL_TYPE_STRING && indiceColuna == 8){excelObj.setCampo9(cell.getStringCellValue());}
					else if(celula == Cell.CELL_TYPE_NUMERIC && indiceColuna == 8){excelObj.setCampo9(String.valueOf(cell.getNumericCellValue()));}
					else if(celula == Cell.CELL_TYPE_STRING && indiceColuna == 9){excelObj.setCampo10(cell.getStringCellValue());}
					else if(celula == Cell.CELL_TYPE_NUMERIC && indiceColuna == 9){excelObj.setCampo10(String.valueOf(cell.getNumericCellValue()));}
					else if(celula == Cell.CELL_TYPE_STRING && indiceColuna == 10){excelObj.setCampo11(cell.getStringCellValue());}
					else if(celula == Cell.CELL_TYPE_NUMERIC && indiceColuna == 10){excelObj.setCampo11(String.valueOf(cell.getNumericCellValue()));}
					
				}
			}
			arquivo.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return lista;
	}

	// // preenche excel ===

	public void copiaExcel(String path, String pathNew) throws IOException {

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("newExcel");

		int rownum = 0;
		for (ExcelObjTeste excelObj : listExcel(path)) {
			Row row = sheet.createRow(rownum++);
			int cellnum = 0;
			Cell cellNome = row.createCell(cellnum++);
			cellNome.setCellValue(excelObj.getCampo1());
			Cell cellIdade = row.createCell(cellnum++);
			cellIdade.setCellValue(excelObj.getCampo2());
			Cell cellNota = row.createCell(cellnum++);
			cellNota.setCellValue(excelObj.getCampo3());

		}
		try {
			FileOutputStream out = new FileOutputStream(new File(pathNew));
			workbook.write(out);
			out.close();
			System.out.println("Arquivo Excel criado com sucesso!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!");
		}

	}

	public void dqlPreencheExcel(String pathNew) throws Exception {

		System.out.println("conectar Documentum == " + getSessDctm());

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("newExcel");

		IDfQuery query = new DfQuery();

		query.setDQL(querysObj.GabinetesParaArquivos("/Lucas Vidotti"));

		IDfCollection coll = query.execute(getSessDctm(), 0);

		int rownum = 0;
		// add os valores no excel ===
		while (coll.next()) {

			IDfTypedObject typeObject = (IDfTypedObject) coll.getTypedObject();

			Row row = sheet.createRow(rownum++);
			int cellnum = 0;
			Cell cellNome = row.createCell(cellnum++);
			cellNome.setCellValue(typeObject.getString("object_name"));
			Cell cellIdade = row.createCell(cellnum++);
			cellIdade.setCellValue(typeObject.getString("r_creation_date"));

		}
		// arruma o tamanho das colunas ==
		int quantidadeColunas = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = 0; i < quantidadeColunas; i++) {
			sheet.autoSizeColumn(i);
		}

		if (coll != null) {

			coll.close();
		}

		try {
			FileOutputStream out = new FileOutputStream(new File(pathNew));
			workbook.write(out);
			out.close();
			System.out.println("Arquivo Excel criado com sucesso!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!");
		}
		DesconectarDocumentum();

	}

}
