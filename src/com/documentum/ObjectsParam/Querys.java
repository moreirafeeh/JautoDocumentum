package com.documentum.ObjectsParam;

public class Querys {

	public Querys() {
		
	}
	//QuantidadeArquivoDiretorio(/RH)
	public String QuantidadeArquivoDiretorio(String Diretorio){
		String quantidade = "select count(*) from dm_document doc where CABINET('"+ Diretorio + "',descend)";
		return quantidade;
	}
}
