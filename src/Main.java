import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {



		// eliude soares
		int n = 200;

		byte tipoBloco=0;
		byte contContainer0=0;
		
		int contContainer=0;
		int contBlocos=0;

		int contByte;

		byte controle[] = new byte[n];

		byte conteudo2[];


		//conteudo2 = conteudo.getBytes();
		int ultimoI = 0;
		
		byte[] blocoFinal = new byte[n+9];


		ArrayList<byte[]> dadosAll = new ArrayList();
		ArrayList<byte[]> dadosFinaisAll = new ArrayList();




		Scanner scanner = new Scanner(System.in);
		String conteudo = "";

		System.out.printf("Informe o nome de arquivo texto:\n");
		String nome;

		String nome2 = "";

		nome = JOptionPane.showInputDialog("Informe o caminho do arquivo texto:");

		System.out.printf("\nConteúdo do arquivo texto:\n");
		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // lê a primeira linha
			// a variável "linha" recebe o valor "null" quando o processo
			// de repetição atingir o final do arquivo texto
			while (linha != null) {
				// System.out.printf("%s\n", linha);
				conteudo = conteudo + "\n" + linha;

				linha = lerArq.readLine(); // lê da segunda até a última linha
			
				byte meta[] = new byte[9];
				byte conteudo3[] = new byte[n];
				System.out.println(linha);
				if(linha!= null) {
				conteudo3=linha.getBytes();
				meta=metaBlocoDeDados(contContainer0, Integer.toString(contBlocos).getBytes(), tipoBloco, Integer.toString(conteudo3.length).getBytes());
				blocoFinal = vectorMerge(meta, conteudo3);
				contBlocos++;
						
				}
				//***adicionar aqui
				

				if(conteudo3!= null) {
					
				
				dadosAll.add(conteudo3);
				dadosFinaisAll.add(blocoFinal);
				//testar
				
				
				}
				
				

					
				
				
				
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		
		

		

		/*
		armazenar(ultimoI, conteudo2, n, dadosAll, contBlocos);

		for (int i = 0; i < dadosAll.get(1).length; i++) {
			System.out.println(dadosAll.get(1)[i]);
		}

		*/

		

		// String msgDecode = new String(dados, "UTF-8");

		for (int i = 0; i < dadosAll.size(); i++) {
			String msgDecode = new String(dadosAll.get(i), "UTF-8");
			System.out.println(msgDecode);

		}

		// System.out.println(msgDecode);
		
		
		
		
		
		imprimirVetor(blocoFinal);

	}
	
	public static void imprimirVetor(byte vetor[]){
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
		
	}
	
	public static byte[] vectorMerge(byte vetor1[], byte vetor2[]){
byte vetorFinal[] = new byte[vetor1.length+vetor2.length];
		
		for (int i = 0; i < vetor1.length; i++) {
			vetorFinal[i]=vetor1[i];
			
		}
		
		for (int i = 0; i < vetor2.length; i++) {
			vetorFinal[i+vetor1.length]=vetor2[i];
		}
		
		
		return vetorFinal;
	}
	
	public static byte[] metaBlocoDeDados(byte idContainer, byte[] idBloco, byte tipo, byte[] utilizado) {
		
		
		byte metadados[] = new byte[9];
		metadados[0]=idContainer;
		
		for (int i = 0; i < idBloco.length; i++) {
			metadados[i+1]=idBloco[i];
		}
		
		metadados[4]=tipo;
		
		for (int i = 0; i < utilizado.length; i++) {
			metadados[4+i]=utilizado[i];
		}
		
		return metadados;
		
	}

	public static void armazenar(int ultimoI, byte conteudo2[], int n, ArrayList<byte[]> dadosAll, int contBlocos) {

		//id do container
		byte idContainer=0;
		//id do bloco
		byte id[] = new byte[3];
		String aux = Integer.toString(contBlocos);
		id=aux.getBytes();
		contBlocos++;
		
		byte dados[] = new byte[n];
		for (int i = 0; i < conteudo2.length; i++) {
			if (i > n - 1) {
				ultimoI = ultimoI + i;
				dadosAll.add(dados);
				break;
			}
			if (ultimoI + i < conteudo2.length) {
				dados[i] = conteudo2[ultimoI + i];
			}
		}

		if (ultimoI < conteudo2.length) {

			armazenar(ultimoI, conteudo2, n, dadosAll, contBlocos);

		}

	}

}