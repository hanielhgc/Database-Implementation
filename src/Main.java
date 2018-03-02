import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {
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

			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		// inserir aqui

		int n = 20;

		int contContainer;
		int contBlocos=0;

		int contByte;

		// byte dados[] = new byte[n];
		byte controle[] = new byte[n];

		byte conteudo2[];

		// ArrayList<byte[]> dadosAll = new ArrayList();

		// dados[0]=0;

		// descobrir quantos bytes sao usados para cada caractere de string - 2
		// bytes
		// fazer a tabela para conversao binario-inteiro
		// metodo que recebe um array de bytes e retorna um inteiro
		//

		// diferença entre byte 0 para 1,2,3
		// byte 4?
		// bytes 5, 6 e 7 são para saber onde parei na gravação de um bloco de
		// dados certo? isso

		conteudo2 = conteudo.getBytes();
		int ultimoI = 0;
		/*
		 * int valorDeI=0; for (int i = 0; i < conteudo2.length; i++) {
		 * 
		 * 
		 * try { dados[i]=conteudo2[i]; } catch (ArrayIndexOutOfBoundsException
		 * e) { valorDeI=i;
		 * 
		 * 
		 * } }
		 * 
		 * byte dados2[] = new byte[n]; for (int i = 0; i < dados2.length; i++)
		 * { if(valorDeI+i>=n*2){ break; } dados2[i]=conteudo2[valorDeI+i]; }
		 * 
		 * 
		 */

		ArrayList<byte[]> dadosAll = new ArrayList();

		armazenar(ultimoI, conteudo2, n, dadosAll, contBlocos);

		for (int i = 0; i < dadosAll.get(1).length; i++) {
			System.out.println(dadosAll.get(1)[i]);
		}

		// System.out.println(dados[0]);
		// System.out.println(dados[1]);

		// String msgDecode = new String(dados, "UTF-8");

		for (int i = 0; i < dadosAll.size(); i++) {
			String msgDecode = new String(dadosAll.get(i), "UTF-8");
			System.out.println(msgDecode);

		}

		// System.out.println(msgDecode);

	}
	
	public static byte[] vectorMerge(byte vetor1[], byte vetor2[]){
		byte vetorFinal[] = new byte[vetor1.length+vetor2.length];
		
		for (int i = 0; i < vetor1.length; i++) {
			vetorFinal[i]=vetor1[i];
			
		}
		
		for (int i = vetor1.length; i < vetor1.length + vetor2.length; i++) {
			vetorFinal[i]=vetor2[i];
		}
		
		
		return vetorFinal;
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