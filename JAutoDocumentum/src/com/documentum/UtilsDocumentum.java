package com.documentum;
import com.documentum.conexao_documentum;
import com.documentum.com.DfClientX;
import com.documentum.com.IDfClientX;
import com.documentum.fc.client.IDfDocbaseMap;
import com.documentum.fc.client.IDfDocument;
import com.documentum.fc.client.IDfFolder;
import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.client.IDfType;
import com.documentum.fc.client.IDfVirtualDocument;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.DfId;
import com.documentum.fc.common.IDfAttr;
import com.documentum.fc.common.IDfId;
import com.documentum.operations.IDfExportNode;
import com.documentum.operations.IDfExportOperation;

public class UtilsDocumentum extends conexao_documentum {

	public UtilsDocumentum(String Usuario_, String Senha_, String Repositorio_) {
		super(Usuario_, Senha_, Repositorio_);	
	}
	
	
//-------------------------EXPORTAR------------------------
	public void exportVirtualDocument(String tipo_busca,String Obj_Busca) throws Exception {
			
			IDfClientX clientx = new DfClientX();
	        IDfExportOperation expOperation = clientx.getExportOperation();
	        IDfSysObject sysObject = null;
	        
	        
	        if(tipo_busca == "id"){
	        
	        IDfId sysObjId = new DfId(Obj_Busca);
	
	        IDfSysObject sysObject2 = (IDfSysObject) sessDctm.getObject(sysObjId);
	        
	        System.out.println(sysObject2);
	        
	        sysObject = sysObject2;
	        
	        }
	        
	        else if(tipo_busca == "path"){
	        	
		        IDfSysObject sysObject2 = (IDfSysObject) sessDctm.getObjectByPath(Obj_Busca);
		        
		        sysObject = sysObject2;
	    
	        }
	        try{
		        if (sysObject.isVirtualDocument()) {
	
		        	IDfVirtualDocument Vdoc = sysObject.asVirtualDocument("CURRENT",false);
	
		        	IDfExportNode expNode = (IDfExportNode) expOperation.add(sysObject);
		        	
		        	System.out.println(expOperation.getDefaultDestinationDirectory());
		        	
		        	expOperation.setDestinationDirectory(expOperation.getDefaultDestinationDirectory());
		
		        	boolean flag = expOperation.execute();
		        	System.out.println("exeutei sem erros");
		
		        }  
		        
		        else{
		        	System.out.println("nao é um documento virtual");
		        }
	      }
	      catch(Exception e){
	    	  System.out.println(e);
	      }
	        
	}
	//---------------------------------------------------------
	
	//------------------------------IMPORTAR-------------------
	
	public void ImportarDocumentum(){
	
		IDfDocument sysObj = null;
		
		try {
				
			sysObj = (IDfDocument) getSessDctm().newObject("dm_document");
	
			sysObj.setObjectName("testandoTwitch65.txt");
			sysObj.setContentType("crtext");
			sysObj.setFile("C:\\Users\\fmoreiraf\\Desktop\\repo_documentum\\ImportacaoTeste\\src\\arquivoTeste.txt");
			sysObj.save();
			
		} catch (DfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//---------------------------------------------------------
	
	//---------------PEGA TODAS DOC BASES----------------------
	
	public void getAllDocbases() throws Exception {
		
		
		IDfDocbaseMap docbaseMap = getClientDctm().getDocbaseMap();
		
		for (int i = 0; i < docbaseMap.getDocbaseCount(); i++) {
		
			System.out.println("Docbase Name : " + docbaseMap.getDocbaseName(i));
		
		    System.out.println("Docbase Desc : " + docbaseMap.getDocbaseDescription(i));
		
		    }
		
	}
	//--------------------------------------------------------
	//------------------Criar Cabinet-------------------------
	public void createCabinet(String Cabinet_name) throws Exception {
		 
		IDfFolder cabinet = (IDfFolder) getSessDctm().newObject("dm_cabinet");
		
		if (cabinet != null) {
		
			cabinet.setObjectName(Cabinet_name);
			cabinet.save();
			
			System.out.println("Cabinet criado com sucesso");
		
		    }
		
	}
	//---------------------------------------------------------
	//----------------Criar Pasta (necessario passar cabinet onde a pasta ficará)------------------------------
	public void createFolder(String Cabinet_link, String folder_name) throws Exception {
		
		  IDfFolder folder = (IDfFolder) getSessDctm().newObject("dm_folder");
		
		  if (folder != null) {
		
		      folder.setObjectName(folder_name);
		
		      folder.link("/"+Cabinet_link);
		
		      folder.save();
		      
		      System.out.println("Pasta criada com sucesso no cabinet"+ Cabinet_link);
		
		   }
	}
    //---------------------------------------------------------
	//----------------Criar(Importar) um Documento-------------
	//EXEMPLOS                                                                                            
	//createDocument("Felipe_teste_func", "crtext", "C:\\Documentum\\export\\testandoTwitch.txt","/Felipe Twitch/felipinho3");
	//-------
	public IDfDocument createDocument(String Nome_doc, String tipo_conteudo, String path_conteudo, String documentum_path) throws Exception {
		
		IDfDocument document = (IDfDocument) getSessDctm().newObject("dm_document");
		
		if (document != null) {
		
			document.setObjectName(Nome_doc);
		
		    document.setContentType(tipo_conteudo);
		
		    document.setFile(path_conteudo);
		
		    document.link(documentum_path);
		
		    document.save();
		
		    }
		
		return document;
		
	}
	//---------------------------------------------------------
	//updateAttributes("/Felipe Twitch/felipinho3/Felipe_teste_func", "object_name", "meu_doc_alterado")
	//------------------Atualizar Atributos--------------------MELHORAR
	public void updateAttributes(String path_conteudo_documentum, String nome_atributo, String atributo_alterado) throws Exception {
		
		IDfSysObject sysObject = null; 
		
		sysObject = (IDfSysObject) getSessDctm().getObjectByPath(path_conteudo_documentum);
		
		sysObject.setString(nome_atributo, atributo_alterado);
	
		sysObject.save();
		
		System.out.println("atributo: '" + nome_atributo + "'alterado  com sucesso");
		
	}
	//---------------------------------------------------------------------
	//---------------------------Pegar atributos---------------------------NAO ESTA FUNCIONANDO AINDA
	public void getTypeAttributes() throws Exception {
		
		IDfType type = (IDfType) getSessDctm().newObject("dm_document");
		
		for (int i = 0; i < type.getAttrCount(); i++) {
		
			IDfAttr attr = type.getAttr(i);
		
		    System.out.println("Name " + attr.getName());
		
		    System.out.println("Datatype " + attr.getDataType());
		
		    System.out.println("Length " + attr.getLength());
		
		    System.out.println("IS Repeating Attr " + attr.isRepeating());
		
		}
		
	}
	//---------------------------------------------------------------------
	
	public void checkoutDoc() throws Exception {
		
		IDfSysObject sysObject = null; 
		
		sysObject = (IDfSysObject) getSessDctm().getObjectByPath("/Training Cabinet XXX/Folder Level 1/");
		
		if (!sysObject.isCheckedOut()) // if it is not checked out
		
			sysObject.checkout();
		
		 	System.out.println("is Check out " + sysObject.isCheckedOut());
	
		}

	
	
	
	
}
