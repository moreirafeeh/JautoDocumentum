package com.documentum.ObjectsParam;

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
	
	public static String GabinetesParaArquivos(){ //em construcao
		String query = "select * from <dm_folder ou dm_document> f, dm_cabinet cab" +
						"where f.i_cabinet_id = cab.r_object_id and cab.object_name = '<nome da propriedade >'"	;
		
		return query;
	}
	
	//acha arquivos dentro de um folder
	// PastaparaArquivo(/Felipe Twitch/felipinho3)
	public static String PastaParaArquivo(String PathDeBusca){
		String query = "select object_name as resultado_query from dm_sysobject where FOLDER('" + PathDeBusca +  "',descend);";
		return query;
	}
	
	
	
	
	
	
	
}
