
public class Teste {

	public static void main(String[] args) {

		byte teste;
		
		int numero=3;
		teste=(byte) numero;
		
		System.out.println(teste);
		
		byte vetor1[] = new byte[3];
		byte vetor2[] = new byte[4];
		
		for (int i = 0; i < vetor1.length; i++) {
			vetor1[i]=(byte) i;
		}
		
		for (int i = 0; i < vetor2.length; i++) {
			vetor2[i]=(byte) i;
		}
		
		byte vetor3[]=vectorMerge(vetor1, vetor2);
		
		for (int i = 0; i < vetor3.length; i++) {
			System.out.println(vetor3[i]);
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

}
