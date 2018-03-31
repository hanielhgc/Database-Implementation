
public class Buffer {
	
	int tamanhoBuffer;
	Bloco[] blocos = new Bloco[tamanhoBuffer];
	boolean cheio = false;
	boolean vazio=true;
	
	
	
	
	
	public boolean isVazio() {
		return vazio;
	}
	public void setVazio(boolean vazio) {
		this.vazio = vazio;
	}
	public Buffer(int tamanhoBuffer, Bloco[] blocos, boolean cheio, boolean vazio) {
		super();
		this.tamanhoBuffer = tamanhoBuffer;
		this.blocos = blocos;
		this.cheio = cheio;
		this.vazio= vazio;
	}
	public Buffer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTamanhoBuffer() {
		return tamanhoBuffer;
	}
	public void setTamanhoBuffer(int tamanhoBuffer) {
		this.tamanhoBuffer = tamanhoBuffer;
	}
	public Bloco[] getBlocos() {
		return blocos;
	}
	public void setBlocos(Bloco[] blocos) {
		this.blocos = blocos;
	}
	public boolean isCheio() {
		return cheio;
	}
	public void setCheio(boolean cheio) {
		this.cheio = cheio;
	}
	
	

}
