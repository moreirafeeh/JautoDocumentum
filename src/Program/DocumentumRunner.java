package src.Program;


//------SOAP-----
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.transform.OutputKeys;
import org.w3c.dom.Document;

//--------------


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import src.com.documentum.UtilsDocumentum;
import src.com.documentum.ObjectsParam.Querys;

import src.dealt_apache.*;

public class DocumentumRunner {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		

		//UtilsDocumentum Utils = new UtilsDocumentum();

		//Utils.ImportarDocumentum();
		//Utils.exportVirtualDocument("path", "/Sinistros Autos/S100020106000539/DPA01/DPA01_Abertura (060999.pdf)");
		//Utils.EXPORT_Normal_doc();
		//Utils.getAllDocbases();
		//Utils.createCabinet("FelipeTeste");
		//Utils.createFolder("Felipe Twitch" , "Felipe Teste");
		//Utils.createDocument("Felipe300FUNCIONANDO", "crtext", "C:\\Documentum\\export\\testandoTwitch.txt","/Felipe Twitch/felipinho3");
		//Utils.updateAttributes("/Felipe Twitch/felipinho3/meu_doc_alterado", "object_name", "alterei_denovo");
		//Utils.getTypeAttributes();
		//Utils.checkinDoc();
		//Utils.checkoutDoc();
		//Utils.viewVirtualDocument();
		//Utils.dump();
		
		///////////////////////////////////////////////////////////////////
		
		// query == 
		
		//Utils.ConsultarQuery(Querys.QuantidadeArquivoDiretorio("/RH"));
		//Utils.ConsultarQuery(Querys.TamanhoOcupadoPelosArquivos("/RH"));
		//Utils.ConsultarQuery(Querys.ContarDatasArquivos("1/1/2018 23:59:59", "1/1/2020 23:59:59"));
		//Utils.ConsultarQuery(Querys.ConsultarGabinets());
		//Utils.ConsultarQueryUPDATE(Querys.UPDATE_LINK("/Felipe Twitch/Felipe Teste", "0900069f800b99ba"));
		//Utils.ConsultarQueryUPDATE(Querys.UPDATE_UNLINK("/Felipe Twitch/felipinho3", "0900069f800b99ba"));
		
		//-------
		//ArrayList<String> arquivos =  Utils.ConsultarQuery(Querys.ArquivosDeUmaPasta("/Lucas Vidotti"));
		//Utils.assignACL(arquivos);
		//--------
		
		
		////////////////////////////////////////////////////////////////////
		
		//leitura de arquivo ==
		////FileFolderApache functionFile = new FileFolderApache();
		//excel == m
		//functionFile.lerExcel("C:\\Users\\fmoreiraf\\Desktop\\TESTE.xlsx");
		//functionFile.colunaEspecificaExcel("C:\\Users\\lvidotti\\Desktop\\teste.xlsx");
		//functionFile.celulaEspecificaExcel("C:\\Users\\lvidotti\\Desktop\\teste.xlsx");
		////List<ExcelObjTeste> lista2 = new ArrayList<ExcelObjTeste>();
		////lista2 = functionFile.listExcel("C:\\Users\\fmoreiraf\\Desktop\\TESTE.xlsx");
		
		//System.out.println(lista2.get(1).getCampo5());
		////Utils.createFolder("Felipe Twitch" , "Carros");
		///for(int i = 1; lista2.get(i).getCampo5() != "SEM VALOR"; i++){
			////System.out.println(lista2.get(i).getCampo1());
			//Utils.createDocument("arquivoTwitch" + i , "crtext", lista2.get(i).getCampo5(),"/Felipe Twitch/Carros");
		//}
		
		//Utils.assignACL();
		
		//-----INDEXADOS LINKS----
		//Utils.ConsultarQueryUPDATE(Querys.UPDATE_LINK("/Felipe Twitch/Felipe Teste", "0900069f800b99ba"));
		//Utils.ConsultarQueryUPDATE(Querys.UPDATE_UNLINK("/Felipe Twitch/felipinho3", "0900069f800b99ba"));
		//------------------------
		
		//FLUXO REINDEXA��O--------------
		//Utils.ConsultarQuery(Querys.VerificaPasta("documentadm"));
		////ArrayList<String> arquivosNaoIndexados = Utils.ConsultarQuery(Querys.PastaParaArquivo("/Sinistros Autos/N�o Indexados"));
		
		/*
		for(int i = 0; i <= arquivosNaoIndexados.size(); i++){
			try{
				retornoReq = lib.requisicao(arquivosNaoIndexados.get(i)); //VIDOTTI FAZENDO
			}
			catch (Exception e){
				Utils.createFolder("Felipe Twitch", "parametros incorretos");
				//Utils.ConsultarQueryUPDATE(Querys.UPDATE_UNLINK("/Felipe Twitch/Felipe Teste", "0900069f800b99ba"));
				//Utils.ConsultarQueryUPDATE(Querys.UPDATE_LINK("/Felipe Twitch/parametros incorretos", "0900069f800b99ba"));
				break;
			}
			
			try{
				validarParametrosDaReq(retornoReq);
			}
			catch (Exception e){
				//Utils.createFolder("Felipe Twitch", "Formatos incorretos");
				//Utils.ConsultarQueryUPDATE(Querys.UPDATE_UNLINK("/Felipe Twitch/Felipe Teste", "0900069f800b99ba"));
				//Utils.ConsultarQueryUPDATE(Querys.UPDATE_LINK("/Felipe Twitch/Formatos incorretos", "0900069f800b99ba"));
				break;
			}
			try{
				Utils.createFolder("Felipe Twitch", "PASTA COM NOME DO ARQUIVO FORMATADO");
				Utils.ConsultarQueryUPDATE(Querys.UPDATE_UNLINK("/Felipe Twitch/Felipe Teste", "0900069f800b99ba"));
				Utils.ConsultarQueryUPDATE(Querys.UPDATE_LINK("/Felipe Twitch/Formatos incorretos", "0900069f800b99ba"));
			}
			catch (Exception e){
				continue;
			}
			
			lib.requisicao(CriarAgenda);
			
			
	}
	*/
		
		
		
	
}

}
		
		
		
		
		//-------------------------------

		

