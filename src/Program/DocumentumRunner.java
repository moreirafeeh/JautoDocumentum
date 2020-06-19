package Program;

import com.documentum.UtilsDocumentum;
import com.documentum.ObjectsParam.Querys;

import dealt_apache.FileFolderApache;



public class DocumentumRunner {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		
		
		//UtilsDocumentum Utils = new UtilsDocumentum("ftwitch","@Twitch6","MapfreD03");
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
		
		////////////////////////////////////////////////////////////////////
		
		
		//leitura de arquivo ==
		FileFolderApache functionFile = new FileFolderApache();
		// excel == 
		//functionFile.lerExcel("C:\\Users\\lvidotti\\Desktop\\teste.xlsx");
		//functionFile.colunaEspecificaExcel("C:\\Users\\lvidotti\\Desktop\\teste.xlsx");
		//functionFile.celulaEspecificaExcel("C:\\Users\\lvidotti\\Desktop\\teste.xlsx");
		
		
	}

}
