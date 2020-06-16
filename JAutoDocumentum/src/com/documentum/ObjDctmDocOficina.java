package com.documentum;


	/**
	 * @author      Docsys - Projeto Mapfre Autos Gestao Oficinas - Integração Documentum
	 * @version     1.0<br>
	 * ---------------------------------------------------------------------------------------------------------<br>
	 * Histórico de Alterações:<br>
	 * ---------------------------------------------------------------------------------------------------------<br>
	 * 16/07/2012 - 1.0 - Criação da Classe TO;<br>
	 * ---------------------------------------------------------------------------------------------------------<br>
	 */
    public class ObjDctmDocOficina {

		private String Dctm_Id;
		private String Dctm_ObjectName;
		private String Dctm_Folder;
		private String Dctm_Acl;
		private String Dctm_ContentType;
		private String Dctm_Erro;
		private String CaminhoDocumento;
		private String NumeroSinistro;
		private String NumeroProtocolo;
		private String SiglaExpediente;
	    private byte[] DctmConteudoArquivo;
	    
		public String getDctm_Id() {
			return Dctm_Id;
		}
		public void setDctm_Id(String dctm_Id) {
			Dctm_Id = dctm_Id;
		}
		
		public String getDctm_ObjectName() {
			return Dctm_ObjectName;
		}
		
		public void setDctm_ObjectName(String dctm_ObjectName) {
			Dctm_ObjectName = dctm_ObjectName;
		}
		
		public String getDctm_Folder() {
			return Dctm_Folder;
		}
		
		public void setDctm_Folder(String dctm_Folder) {
			Dctm_Folder = dctm_Folder;
		}
		
		public String getDctm_Acl() {
			return Dctm_Acl;
		}
		
		public void setDctm_Acl(String dctm_Acl) {
			Dctm_Acl = dctm_Acl;
		}
		
		public String getDctm_ContentType() {
			return Dctm_ContentType;
		}
		
		public void setDctm_ContentType(String dctm_ContentType) {
			Dctm_ContentType = dctm_ContentType;
		}
		
		public String getDctm_Erro() {
			return Dctm_Erro;
		}
		
		public void setDctm_Erro(String dctm_Erro) {
			Dctm_Erro = dctm_Erro;
		}
		
		public String getCaminhoDocumento() {
			return CaminhoDocumento;
		}
		
		public void setCaminhoDocumento(String caminhoDocumento) {
			CaminhoDocumento = caminhoDocumento;
		}
				
		public String getNumeroProtocolo() {
			return NumeroProtocolo;
		}
		
		public void setNumeroProtocolo(String numeroProtocolo) {
			NumeroProtocolo = numeroProtocolo;
		}
		
		public String getNumeroSinistro() {
			return NumeroSinistro;
		}
		
		public void setNumeroSinistro(String numeroSinistro) {
			NumeroSinistro = numeroSinistro;
		}
				
		public String getSiglaExpediente() {
			return SiglaExpediente;
		}
		
		public void setSiglaExpediente(String siglaExpediente) {
			SiglaExpediente = siglaExpediente;
		}
		
		
		public byte[] getDctmConteudoArquivo() {
			return DctmConteudoArquivo;
		}
		
		public void setDctmConteudoArquivo(byte[] dctmConteudoArquivo) {
			DctmConteudoArquivo = dctmConteudoArquivo;
		}
	    
	}