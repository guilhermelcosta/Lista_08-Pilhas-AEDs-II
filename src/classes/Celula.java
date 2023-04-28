package classes;

public class Celula {
	
	private Jogador jogador;
	private Celula proximo;
	
	public Celula() {
		jogador = new Jogador();
		proximo = null;
	}
	
	public Celula(Jogador novoJogador) {
		jogador = novoJogador;
		proximo = null;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Celula getProximo() {
		return proximo;
	}

	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
}
