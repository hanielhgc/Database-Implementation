
public class Haniel {
	
	public static void main(String[] args) {
		
		
		//teste
		
				Bloco bloco = new Bloco(0);
				Bloco bloco2 = new Bloco(1);
				Bloco bloco3 = new Bloco(2);
				Bloco bloco4 = new Bloco(3);
				Bloco bloco5 = new Bloco(4);
				
				Bloco[] blocos = new Bloco[5];
				
				blocos[0]=bloco;
				blocos[1]=bloco2;
				blocos[2]=bloco3;
				blocos[3]=bloco4;
				blocos[4]=bloco5;
				
				
				//fim do teste
		
		Buffer buffer = new Buffer(5,blocos,false, true);
		Bloco novoBloco = new Bloco(10);
		
		
		//antes de tudo, procurar no buffer a informação
		boolean encontrado=false;
		for (int i = 0; i < buffer.getBlocos().length; i++) {
			if(buffer.getBlocos()[i]==novoBloco){
				System.out.println("CACHE HIT!");
				encontrado=true;
				//fazer procedimento LRU para alterar as posições
				//exibir o resultado?
				
			}
			
		}
		
		if(encontrado==false){
			//chamar procedimentos abaixo
		}
		
		
		if(buffer.isVazio()==true){
			buffer.blocos[0]=novoBloco;
			
			
		}
		
		
		if(buffer.isCheio()==false){
			
			Bloco[] aux = new Bloco[buffer.getBlocos().length];
			
			for (int i = 0; i < buffer.getBlocos().length-1; i++) {
				aux[i+1]=buffer.getBlocos()[i];
				
				
			}
		
			for (int i = 0; i < aux.length; i++) {
				System.out.println("aux:"+aux[i].numero);
				System.out.println("buffer:"+buffer.getBlocos()[i].numero);
			}
			//receber novo bloco em aux[0]
			aux[0]=novoBloco;
			
			buffer.setBlocos(aux);
			//checar se o buffer está cheio e se estiver, setá-lo
			
			
			
		}else{
			//em caso de buffer cheio
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}

}
