package src.com.documentum.ObjectsParam;

public class Querys {

	//QuantidadeArquivoDiretorio(/RH)
	public static String QuantidadeArquivoDiretorio(String Diretorio){
		String query = "select count(*) as resultado_query from dm_document doc where CABINET('"+ Diretorio + "',descend)";
		return query;
	}
	
	//QuantidadeArquivoDiretorio(/RH)
	public static String TamanhoOcupadoPelosArquivos(String Diretorio){
		String query = "select sum(r_full_content_size) as resultado_query from dm_document where CABINET('"+ Diretorio +"',descend);";
		return query;
	}
	//contar quantidade de documentos existente entre datas especificas
	//FORMATO DATA 1/1/2018 23:59:59
	public static String ContarDatasArquivos(String DataInicio, String DataFim){
		
		String query = "select count(*) as resultado_query from dm_document where r_creation_date between date('" + DataInicio + "') and date('" + DataFim + "')";
		return query;
	}
	
	public static String ConsultarGabinets(){
		String query = "select object_name as resultado_query from dm_cabinet;";
		return query;
	}
	
	public static String GabinetesParaArquivos(String cabinetName){ //em construcao
		String query = "select * from dm_document where CABINET('"+cabinetName+"' , descend)";
		
		return query;
	}
	
	//acha arquivos dentro de um folder
	// PastaparaArquivo(/Felipe Twitch/felipinho3)
	public static String PastaParaArquivo(String PathDeBusca){
		String query = "select object_name as resultado_query from dm_sysobject,dm_document where FOLDER('" + PathDeBusca +  "',descend) and dm_document.a_storage_type ='filestore_01';";
		System.out.println(query);
		return query;
	}
	
	public static String ArquivosDeUmaPasta(String PathDeBusca){
		String query = "select dm_document.object_name as resultado_query from dm_document where FOLDER('"+ PathDeBusca +"') and dm_document.a_storage_type ='filestore_01';";
		System.out.println(query);
		return query;
	}
	
	public static String VerificaPasta(String NomePasta){
		String query = "select object_name as resultado_query from dm_folder where object_name='" + NomePasta + "' ";
		return query;
	}
	
	public static String UPDATE_LINK(String PathSeraLinkado ,String id_arquivo){
		String query = "update dm_document object link '" + PathSeraLinkado +"' where r_object_id='" + id_arquivo +"'";
		return query;
		
	}
	
	public static String UPDATE_UNLINK(String PathSeraLinkado ,String id_arquivo){
		String query = "update dm_document object unlink '" + PathSeraLinkado +"' where r_object_id='" + id_arquivo +"'";
		return query;
	}
	
	
	
	
	
	
	
}
