package Program;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.documentum.UtilsDocumentum;
import com.documentum.ObjectsParam.Querys;;


public class DocumentumRunner {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		UtilsDocumentum Utils = new UtilsDocumentum("lvidotti","@Dctm03","MapfreD03");
		//Utils.ImportarDocumentum();
		//Utils.exportVirtualDocument("path", "/Felipe Twitch/testandoTwitch.txt");
		//Utils.getAllDocbases();
		//Utils.createCabinet("FelipeTeste");
		//Utils.createFolder("Felipe Twitch" , "Felipe Teste");
		//Utils.createDocument("Felipe_teste_func", "crtext", "C:\\Documentum\\export\\testandoTwitch.txt","/Felipe Twitch/felipinho3");
		//Utils.updateAttributes("/Felipe Twitch/felipinho3/meu_doc_alterado", "object_name", "alterei_denovo");
		//Utils.getTypeAttributes();
		//Utils.checkinDoc();
		//Utils.checkoutDoc();
		//Utils.viewVirtualDocument();
		//Utils.ConsultarQuery(Querys.QuantidadeArquivoDiretorio("/RH"));
		//Utils.ConsultarQuery(Querys.TamanhoOcupadoPelosArquivos("/RH"));
		//Utils.ConsultarQuery(Querys.ContarDatasArquivos("1/1/2018 23:59:59", "1/1/2020 23:59:59"));
		//Utils.ConsultarQuery(Querys.ConsultarGabinets());
		//Utils.ConsultarQuery(Querys.PastaParaArquivo("/Felipe Twitch/felipinho3"));
		Utils.assignACL();
		
		
	}

}
