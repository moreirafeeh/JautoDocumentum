package dealt_apache;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

public class Txt {

	public void lerTxt() throws IOException {

		String path = "C://Users//lvidotti//Desktop//mapfre//projeto_funções_java//LCS300TESTE.txt";

		FileReader fr = new FileReader(path);

		BufferedReader br = new BufferedReader(fr);

		// enquanto houver mais linhas

		while (br.ready()) {
			// lê a proxima linha
			String linha = br.readLine();
			// faz algo com a linha
			System.out.println(linha);
		}
		br.close();
		fr.close();

	}

	public void escreverTxt() throws IOException {
		// escrever em uma nova linha ===
		String path = "C://Users//lvidotti//Desktop//mapfre//projeto_funções_java//LCS300TESTE.txt";
		// escreve no arquivo
		FileWriter fw = new FileWriter(path, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.newLine();
		bw.append("arquivo já foi lido !\r\n" + "Sucess!!");

		bw.close();
		fw.close();

	}
	
	public void creatTxt(String path,String lista) throws IOException{
		FileWriter arquivo;
		
		arquivo = new FileWriter(new File(path));
		
		arquivo.write(lista);
		arquivo.close();
	}
	
	public void editTxt(String palavraAntiga,String palavraNova,String arquivo,String arquivoTmp) throws IOException {


		BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
		BufferedReader reader = new BufferedReader(new FileReader(arquivo));

		String linha;
		while ((linha = reader.readLine()) != null) {
			if (linha.contains(palavraAntiga)) {
				linha = linha.replace(palavraAntiga, palavraNova);
			}
			writer.write(linha + "\n");
		}

		writer.close();
		reader.close();

		new File(arquivo).delete();
		new File(arquivoTmp).renameTo(new File(arquivo));
	}
	
	

}
