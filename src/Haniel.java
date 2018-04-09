import java.util.ArrayList;
import java.util.Scanner;

public class Haniel {

	public static void main(String[] args) {

		// teste

		Bloco bloco = new Bloco(0);
		Bloco bloco2 = new Bloco(1);
		Bloco bloco3 = new Bloco(2);
		Bloco bloco4 = new Bloco(3);
		Bloco bloco5 = new Bloco(4);

		Bloco[] blocos = new Bloco[5];

		blocos[0] = bloco;
		blocos[1] = bloco2;
		blocos[2] = bloco3;
		blocos[3] = bloco4;
		blocos[4] = bloco5;

		// fim do teste
		ArrayList<Bloco> MP = new ArrayList();
		MP.add(bloco);
		MP.add(bloco2);
		MP.add(bloco3);
		MP.add(bloco4);
		MP.add(bloco5);

		// Buffer buffer = new Buffer(5,blocos,false, true);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe o tamanho do buffer:");
		int tamanho;
		tamanho=scanner.nextInt();
		
		Buffer buffer = new Buffer(tamanho, new Bloco[tamanho], false, true);
		buffer.blocos[0]=bloco;
		
		int indice = 0;
		Bloco novoBloco = new Bloco(0);
		
		

		// antes de tudo, procurar no buffer a informação
		boolean encontrado = false;
		for (int i = 0; i < buffer.getBlocos().length; i++) {
			if(buffer.getBlocos()[i]!=null){
			if (buffer.getBlocos()[i].getNumero() == novoBloco.getNumero()) {
				Bloco blocoAux = new Bloco();
				blocoAux = buffer.getBlocos()[i];

				System.out.println("CACHE HIT!");
				encontrado = true;

				remove(blocoAux, buffer.blocos);
				buffer.blocos[0] = blocoAux;

				// fazer procedimento LRU para alterar as posições DONE
				// exibir o resultado? DONE

				System.out.println("Conteudo do buffer:");
				for (int j = 0; j < buffer.blocos.length; j++) {
					if(buffer.getBlocos()[j]!=null){
									System.out.print(buffer.getBlocos()[j].getNumero() + "		");
					}
					}

			}

		}
		}

		if (encontrado == false) {
			// procurar na memoria principal e chamar os metodos abaixo
			System.out.println("CACHE MISS!");
			System.out.println("Procurando na memória principal...");
			if (buffer.isCheio() == true) {

				for (int i = 0; i < MP.size(); i++) {
					if (MP.get(i).getNumero() == novoBloco.getNumero()) {
						System.out.println("Encontrado!");

						Bloco[] aux = new Bloco[buffer.getBlocos().length];

						for (int j = 0; j < buffer.getBlocos().length - 1; j++) {
							aux[j + 1] = buffer.getBlocos()[j];

						}
						buffer.setBlocos(aux);
						buffer.blocos[0] = MP.get(i);

					}

				}

			} else {
				for (int i = 0; i < MP.size(); i++) {
					if (MP.get(i).getNumero() == novoBloco.getNumero()) {
						buffer.blocos[indice] = MP.get(i);
						indice++;
						if(indice==buffer.getBlocos().length){
							buffer.setCheio(true);
						}
				
						System.out.println("Conteudo do buffer:");
						for (int j = 0; j < buffer.blocos.length; j++) {
							if(buffer.getBlocos()[j]!=null){
											System.out.print(buffer.getBlocos()[j].getNumero() + "		");
							}
							}
						
						
						
					}
				}

			}

		}
		
		
		
		
		

	}

	public static void remove(Bloco y, Bloco vetor[]) {
		Bloco[] vetorAux = new Bloco[vetor.length];
		int index = 1; // aparentemente isso soluciona o problema
		for (int i = 0; i < vetor.length; i++) {
			if(vetor[i]!=null){
				
			if (vetor[i].getNumero() != y.getNumero()) {
				vetorAux[index] = vetor[i];
				index++;
			}
			}
			
		}
		vetor = vetorAux;
	}

}
