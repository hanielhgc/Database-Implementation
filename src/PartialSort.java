import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PartialSort<T extends Comparable<T>> {

	private T[] data;

	public PartialSort(T[] lst) {
		data = lst;		
	}

	public void printArray(T[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}
		System.out.print("\n");
	}

	private void swap(T[] lst, int p, int q) {
		T temp = lst[p];
		lst[p] = lst[q];
		lst[q] = temp;
	}

	private void swap(int[] lst, int p, int q) {
		int temp = lst[p];
		lst[p] = lst[q];
		lst[q] = temp;
	}

	public int partition(T[] lst, int start, int end) {
		T x;
		x = lst[start];
		int i = start;
		for (int j = start + 1; j <= end; j++) {
			if (lst[j].compareTo(x) > 0) { // compares lst[j] greater than x
				i = i + 1;
				swap(lst, i, j);
			}
		}
		swap(lst, start, i);
		return i;
	}

	public void quickSort(T[] lst, int start, int end) {
		if (start < end) {
			int index = partition(lst, start, end);
			quickSort(lst, start, index - 1);
			quickSort(lst, index + 1, end);
		}
	}

	public T[] partialSortTopK(int k) {
		T x;
		int index, rank;
		int start = 0;
		int end = data.length - 1;
		while (end > start) {
			x = data[start];
			index = partition(data, start, end);
			rank = index + 1;
			if (rank >= k) {
				end = index - 1;
			} else if ((index - start) > (end - index)) {
				quickSort(data, index + 1, end);
				end = index - 1;
			} else {
				quickSort(data, start, index - 1);
				start = index + 1;
			}
		}
		return data;
	}
	
	public static Bloco[] indexToVector(Double[] indices, Bloco[] blocos) {
		Bloco[] novosBlocos = new Bloco[blocos.length];

		for (int i = 0; i < blocos.length; i++) {
			for (int j = 0; j < indices.length; j++) {
				if ( indices[i] == (double)blocos[j].getNumero()) {
					novosBlocos[i] = blocos[j];
				}

			}
		}

		return novosBlocos;
	}

	public static int[] arrayToIndexes(ArrayList<Bloco> blocos) {
		int[] indices = new int[blocos.size()];

		for (int i = 0; i < blocos.size(); i++) {
			indices[i] = blocos.get(i).getNumero();

		}

		return indices;
	}

	public static Double[] vectorToIndexes(Bloco[] blocos) {
		Double[] indices = new Double[blocos.length];

		for (int i = 0; i < blocos.length; i++) {
			indices[i] = (double) blocos[i].getNumero();

		}

		return indices;
	}
	
	public static void remove(Bloco y, Bloco vetor[]) {
		Bloco[] vetorAux = new Bloco[vetor.length];
		int index = 0; // aparentemente isso soluciona o problema
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != null) {

				if (vetor[i].getNumero() != y.getNumero()) {
					vetorAux[index] = vetor[i];
					index++;
				}
			}
			
			}
		vetor = vetorAux;
		
	}
	
	public static ArrayList<Bloco> toArraylist(Bloco[] blocos) {
		ArrayList<Bloco> novosBlocos = new ArrayList<Bloco>();
		
		for (int i = 0; i < blocos.length; i++) {
			novosBlocos.add(blocos[i]);
		}
		
		return novosBlocos;
	}
	
	public static Bloco[] toVector(ArrayList<Bloco> blocos) {
		Bloco[] novosBlocos = new Bloco[blocos.size()];
		
		for (int i = 0; i < blocos.size(); i++) {
			novosBlocos[i]=blocos.get(i);
		}
		
		return novosBlocos;
	}


	public static void main(String[] args) {
		int n = 50;
		int k = 3;
	//	Double[] data = new Double[n];
	//	for (int i = 0; i < n; i++) {
	//		data[i] = i + 1.0;
	//	}
	//	Collections.shuffle(Arrays.asList(data));
	//	PartialSort<Double> partialSort = new PartialSort<Double>(data);
	//	System.out.print("Original Array: \n");
	//	partialSort.printArray(data);
	//	partialSort.partialSortTopK(k);

	//	System.out.print("Partially sorted Array: \n");
	//	for (int i = 0; i < data.length; i++) {
	//		System.out.print(data[i] + "\t");
	//	}
		
		
		//Criar um arraylist
		//fazer as duplicações
		//embaralhar
		//ordenar parcialmente
		//iniciar a leitura para o buffer
		
		
		
		
		
		// teste
/*
				Bloco bloco = new Bloco(0);
				Bloco bloco2 = new Bloco(1);
				Bloco bloco3 = new Bloco(2);
				Bloco bloco4 = new Bloco(3);
				Bloco bloco5 = new Bloco(4);

				Bloco bloco100 = new Bloco(1);

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
				
				*/
		//criação da memória principal
		ArrayList<Bloco> MP = new ArrayList();
		for (int i = 0; i < 100; i++) {
			Bloco bloco = new Bloco(i);
			MP.add(bloco);
		}
		
		//duplicação aleatória
		for (int i = 0; i < MP.size(); i++) {
			double aux = Math.random();
			if(aux > 0.5){
				MP.add(MP.get(i));
			}else{
				
		}
		}
		
		//shuffle
		Collections.shuffle(MP);
		
		//ordenação parcial
		Bloco[] MP2 = new Bloco[MP.size()];
		MP2=toVector(MP);
		Double[] data = new Double[MP2.length];
		data=vectorToIndexes(MP2);
		
		PartialSort<Double> partialSort = new PartialSort<Double>(data);
		partialSort.partialSortTopK(k);
		
		indexToVector(data, MP2);
		
		MP= new ArrayList<Bloco>();
		MP=toArraylist(MP2);
		
		
		//leitura para o buffer
		
		
		for (int i = 0; i < MP2.length; i++) {
			System.out.println(MP2[i].getNumero());
		}
		
		

				// Buffer buffer = new Buffer(5,blocos,false, true);
				Scanner scanner = new Scanner(System.in);

				System.out.println("Informe o tamanho do buffer:");
				int tamanho;
				tamanho = scanner.nextInt();

				Buffer buffer = new Buffer(tamanho, new Bloco[tamanho], false, true);

				int indice = 0;
				Bloco novoBloco = new Bloco(0);
				// buffer.blocos[0]=novoBloco;

				
				//isso é um teste
				for (int k1 = 0; k1 < MP2.length; k1++) {

					novoBloco = MP.get(k1);

					// antes de tudo, procurar no buffer a informação
					boolean encontrado = false;
					for (int i = 0; i < buffer.getBlocos().length; i++) {
						if (buffer.getBlocos()[i] != null) {
							if (buffer.getBlocos()[i].getNumero() == novoBloco.getNumero()) {
								Bloco blocoAux = new Bloco();
								blocoAux = buffer.getBlocos()[i];

								System.out.println("CACHE HIT!");
								encontrado = true;
								
								Bloco[] aux = new Bloco[buffer.getBlocos().length];

								for (int j = i; j >0 ; j--) {
									buffer.blocos[j]=buffer.blocos[j-1];

								}
								
								buffer.blocos[0]=blocoAux;
								
								

								
								/*
								remove(blocoAux, buffer.blocos);
								//
								Bloco[] aux = new Bloco[buffer.getBlocos().length];

								for (int j = 0; j < buffer.getBlocos().length - 1; j++) {
									aux[j + 1] = buffer.getBlocos()[j];

								}
								buffer.setBlocos(aux);
								//
								buffer.blocos[0] = blocoAux; */

								// fazer procedimento LRU para alterar as posições DONE
								// exibir o resultado? DONE

								System.out.println("Conteudo do buffer:");
								for (int j = 0; j < buffer.blocos.length; j++) {
									if (buffer.getBlocos()[j] != null) {
										System.out.print(buffer.getBlocos()[j].getNumero() + "		");
												System.out.println("");
									}
								}
break;
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
									
									System.out.println("Conteudo do buffer:");
									for (int j = 0; j < buffer.blocos.length; j++) {
										if (buffer.getBlocos()[j] != null) {
											System.out.print(buffer.getBlocos()[j].getNumero() + "		");
													System.out.println("");
										}
									}

									
break;
								}

							}

						} else {
							for (int i = 0; i < MP.size(); i++) {
								if (MP.get(i).getNumero() == novoBloco.getNumero()) {
									buffer.blocos[indice] = MP.get(i);
									indice++;
									if (indice == buffer.getBlocos().length) {
										buffer.setCheio(true);
									}

									System.out.println("Conteudo do buffer:");
									for (int j = 0; j < buffer.blocos.length; j++) {
										if (buffer.getBlocos()[j] != null) {
											System.out.print(buffer.getBlocos()[j].getNumero() + "		");
										System.out.println("");
										}
									}
break;
								}
							}

						}

					}

				}
		
		
		
		
		
		
		

	}
}