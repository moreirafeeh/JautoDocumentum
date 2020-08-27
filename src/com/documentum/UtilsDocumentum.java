package src.com.documentum;
import java.io.IOException;
import java.util.ArrayList;
import src.com.documentum.ObjectsParam.Querys;

import src.com.documentum.conexao_documentum;
import src.com.documentum.ObjectsParam.Querys;
import com.documentum.com.DfClientX;
import com.documentum.com.IDfClientX;
import com.documentum.fc.client.DfQuery;
import com.documentum.fc.client.IDfACL;
import com.documentum.fc.client.IDfActivity;
import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.client.IDfDocbaseMap;
import com.documentum.fc.client.IDfDocument;
import com.documentum.fc.client.IDfFolder;
import com.documentum.fc.client.IDfProcess;
import com.documentum.fc.client.IDfQuery;
import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.client.IDfType;
import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.client.IDfVirtualDocument;
import com.documentum.fc.client.IDfVirtualDocumentNode;
import com.documentum.fc.client.IDfWorkflowBuilder;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.DfId;
import com.documentum.fc.common.DfList;
import com.documentum.fc.common.IDfAttr;
import com.documentum.fc.common.IDfId;
import com.documentum.fc.common.IDfList;
import com.documentum.operations.IDfExportNode;
import com.documentum.operations.IDfExportOperation;

public class UtilsDocumentum extends conexao_documentum {
	
	public UtilsDocumentum(){
		super();
	}

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
	//EXPORTA DOCUMENTOS NORMAIS--(NAO VIRTUAIS)
	public void EXPORT_Normal_doc(){
	
		IDfSysObject sysObj = null;
		
		try {
			
			//Creating a IDfSysObject object for the document to be exported
			sysObj = (IDfSysObject) getSessDctm().getObjectByPath("/Sinistros Autos/S100020106000539/DPA01/DPA01_Abertura (060999.pdf)");
			
			//Creating the Export operation object
			IDfExportOperation operation = new DfClientX().getExportOperation();
			
			//Setting the Destination directory to which the Documents will be exported to
			operation.setDestinationDirectory("C:\\temp\\documentum");
			
			//Adding the object(to be exported)to the Export Operation
			//More than one document can be added, just repeat the below step for it
			IDfExportNode node = (IDfExportNode) operation.add(sysObj);
			
			//Setting the Format of the document
			node.setFormat(sysObj.getFormat().getName());
			
			//Exporting the document
			operation.execute();
			
			//Getting the filepath and filename
			String fileName = node.getFilePath();
			
			//Printing the filepath and filename
			System.out.println(fileName);
			
		} catch (DfException e) {
			//Printing the Stacktrace
			e.printStackTrace();
		} finally {
			//Releasing the session
			getSessDctm().getSessionManager().release(getSessDctm());
		}
	}
	//-----------------------------------------------------
	
	//utilizado para conexao simples de api Tster como dump,c,<id>
	public void dump()
	{
		try {
			getSessDctm().apiGet("save", "0900069f800b99ba");
		} catch (DfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//------------------------------IMPORTAR-------------------
	
	public void ImportarDocumentum(){
	
		IDfDocument sysObj = null;
		
		try {
				
			sysObj = (IDfDocument) getSessDctm().newObject("dm_document");
	
			sysObj.setObjectName("testandoTwitch100.txt");
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
		  ArrayList<String> pastas = this.ConsultarQuery(Querys.VerificaPasta(folder_name));
		  if (folder != null && pastas.size() == 0) {
		
		      folder.setObjectName(folder_name);
		
		      folder.link("/"+Cabinet_link);
		
		      folder.save();
		      
		      System.out.println("Pasta criada com sucesso no cabinet"+ Cabinet_link);
		
		   }
		  else{
			  System.out.println("PASTA JA EXISTENTE");
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
	//---------------------------Pegar atributos---------------------------
	public void getTypeAttributes() throws Exception {
		
		IDfType type = (IDfType) getSessDctm().getType("dm_document");
		
		for (int i = 0; i < type.getAttrCount(); i++) {
		
			IDfAttr attr = type.getAttr(i);
		
		    System.out.println("Name " + attr.getName());
		
		    System.out.println("Datatype " + attr.getDataType());
		
		    System.out.println("Length " + attr.getLength());
		
		    System.out.println("IS Repeating Attr " + attr.isRepeating());
		
		}
		
	}
	//---------------------------------------------------------------------
	//EXPLICAR FUNCIONAMENTO CHECKIN CHECKOUT
	//checkoutDoc("/Felipe Twitch/felipinho3/alterei_denovo")
		public void checkoutDoc(String path_arquivo) throws Exception {
		
			IDfSysObject sysObject = null; 
		
			sysObject = (IDfSysObject) getSessDctm().getObjectByPath(path_arquivo);
		
			if (!sysObject.isCheckedOut()) // if it is not checked out
		
				sysObject.checkout();
		
		 		System.out.println("is Check out " + sysObject.isCheckedOut());
	
		}
		//EXPLICAR FUNCIONAMENTO CHECKIN CHECKOUT
		//checkinDoc("/Felipe Twitch/felipinho3/alterei_denovo")
		public void checkinDoc(String path_arquivo) throws Exception {
		
			IDfSysObject sysObject = null;
		
			sysObject = (IDfSysObject) getSessDctm().getObjectByPath(path_arquivo);
		
			if (sysObject.isCheckedOut()) { // if it is checked out
		
				sysObject.checkin(false, "CURRENT");
		
			}
		
		}
	//------------------------------------------------------------
	//-------------------deletar arquivo/documento----------------	
		//deleteDoc("/Felipe Twitch/testandoTwitch.txt")
		public void deleteDoc(String path_arquivo) throws Exception {
			
			IDfSysObject sysObject = null;
			
			sysObject = (IDfSysObject) getSessDctm().getObjectByPath(path_arquivo);
			
			if (sysObject != null) {
				sysObject.destroyAllVersions(); // delete all versions
				System.out.println("object destroyed…..");
			}
			else{
				System.out.println("documento nao existe ou aj foi deletado");
			}
			
		}
	//--------------------------------------------------------------
		//cria um documento virtual---------------------------------NAO SEI TESTEI
		public void createVirtualDocument() throws Exception {
			
			
			IDfSysObject pSys = (IDfSysObject) getSessDctm().getObjectByPath("/Training Cabinet XXX/Folder Level 2/log4j.properties");
			
			IDfSysObject cSys = (IDfSysObject) getSessDctm().getObjectByPath("/Training Cabinet XXX/Folder Level 1/trace.log");
			
			pSys.setIsVirtualDocument(true);
			
			pSys.save();
			
			IDfVirtualDocument vDoc = pSys.asVirtualDocument("CURRENT", false);
			
			IDfVirtualDocumentNode pNode = vDoc.getRootNode();
		
			pSys.checkout();
			
			IDfVirtualDocumentNode nodeChild1 = vDoc.addNode(pNode, null, cSys.getChronicleId(), "CURRENT", false, false);
			
			pSys.checkin(false, "CURRENT");
			
			}
		//--------------------------------------------------------
		
		public void viewVirtualDocument() throws Exception {
			
			 IDfSysObject pSys = (IDfSysObject) getSessDctm().getObjectByPath("/Felipe Twitch/felipinho3/alterei_denovo");
			
			 if (pSys.isVirtualDocument()) {
			
				 System.out.println("virtual document –> true");
			
			     IDfVirtualDocument vDoc = pSys.asVirtualDocument("CURRENT", false);
			
			     IDfVirtualDocumentNode pNode = vDoc.getRootNode();
						
			     System.out.println("Iterating thru the lis to get the child nodes");
			     
			     for (int i = 0; i < pNode.getChildCount(); i++) {
			
			    	 IDfVirtualDocumentNode cNode = pNode.getChild(i);
			
			         System.out.println("Child Name " + cNode.getSelectedObject().getObjectName());
			
			     }
			
			 }
			
		}
		//-------------------CONSULTAS DQL--------------------
		public ArrayList<String> ConsultarQuery(String queryString) throws Exception {
			
			System.out.println(getRepositorioDctm());
			System.out.println(getSessDctm());
			System.out.println(getUsuarioDctm());
			
			ArrayList<String> arquivo = new ArrayList<String>();
			
			IDfQuery query = new DfQuery();
			
			query.setDQL(queryString);
			
			IDfCollection coll = query.execute(getSessDctm(), 0);
			
			while (coll.next()) {
			
				IDfTypedObject typeObject = (IDfTypedObject) coll.getTypedObject();	
				
				System.out.println("----------------------------------------------------");
			    System.out.println("resultado: "+ typeObject.getString("resultado_query"));
			    //System.out.println("creation date "+ typeObject.getString("r_object_id"));
			    System.out.println("----------------------------------------------------");
			    
			    arquivo.add(typeObject.getString("resultado_query"));
			}
			
			if (coll != null)
			
				coll.close();
			
			return arquivo; 
			
			}
		//------------------------------------------------------
		
		//UPDATE QUERYS----
		public void ConsultarQueryUPDATE(String queryString) throws Exception {
			
			System.out.println(getRepositorioDctm());
			System.out.println(getSessDctm());
			System.out.println(getUsuarioDctm());
			
			IDfQuery query = new DfQuery();
			
			query.setDQL(queryString);
			
			query.execute(getSessDctm(), 0);
			 
			
			}
		
		//-----------------
		//antes de usar esse metodos é necessario utilizar o "consultarquery() para puxar o arquivos";
		public void assignACL(ArrayList<String> arquivos) throws Exception {
			
			System.out.println(arquivos);
			
			for (int i = 0; i < arquivos.size(); i++){
				
				IDfSysObject mDocs = (IDfSysObject) getSessDctm().getObjectByQualification("dm_document where object_name like '" + arquivos.get(i)  + "'");
			
			System.out.println(mDocs);
			
			IDfACL dfACL = (IDfACL) getSessDctm().getObjectByQualification("dm_acl where object_name='LCS_felipeTW_not'");
			
			mDocs.setACL(dfACL);
			
			mDocs.save();
			}
		}
	//-----------------------------------
	//---------------CRIAR E STARTTAR WORKFLOW----------------------
		public void startWorkflow() throws Exception {
			
			 
			
			// to get the attachment document
			IDfSysObject sysObj = (IDfSysObject) getSessDctm().getObjectByQualification("dm_document where object_name='DFCtest'");
			
			// to get the Workflow Template
			IDfProcess process = (IDfProcess) getSessDctm().getObjectByQualification("dm_process where object_name like '%INDIA_TIMES%'");
			
			// to create a Workflo Builder to start a workflow
			IDfWorkflowBuilder builder = getSessDctm().newWorkflowBuilder(process.getObjectId());
			IDfId wfId = builder.initWorkflow();
			
			 // get the First Activity
			
			 IDfList startActivityNames = builder.getStartActivityNames();
			 IDfList startActivities = builder.getStartActivityIds();
			 String activityName = startActivityNames.getString(0);
			 IDfId activityID = (IDfId) startActivities.get(0);
			 IDfActivity activity = (IDfActivity) getSessDctm().getObject(activityID);
			
			 // to get the Package Name , Port and Package DocType
			
			 int nPorts = activity.getPortCount();
			
			 String InputPortName = null;
			 String PkgType = null;
			 String PkgName = null;
			
			 
			
			 for (int j = 0; j < nPorts; j++) {
			
				 System.out.println("Port Name: " + activity.getPortName(j) + ", "+ "Port Type = " + activity.getPortType(j));
			
				 if (activity.getPortType(j).equals("INPUT")) {
				
					 InputPortName = activity.getPortName(j);
					 PkgType = activity.getPackageType(j);
					 PkgName = activity.getPackageName(j);
				
				 }
			
			 }
			
			 // to Add the attachment document to List
			
			 IDfList dfList = new DfList();
			 dfList.append(sysObj.getObjectId());
			
			 
			
			 IDfId wfId2 = builder.runWorkflow();
			
			 // Add a Package to Workflow Builder
			
			 builder.addPackage(activityName, InputPortName, PkgName, PkgType, null,false, dfList);
			
			 System.out.println("package added");
			
			 
			}

		
}
