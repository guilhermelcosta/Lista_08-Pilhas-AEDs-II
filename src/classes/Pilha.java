package classes;

public class Pilha {

    private Celula topo;
    private Celula fundo;

    public Pilha() {
        Celula sentinela = new Celula();
        topo = sentinela;
        fundo = sentinela;
    }

    public void empilhar(Jogador jogador) {
        Celula novaCelula = new Celula(jogador);
        novaCelula.setProximo(topo);
        topo = novaCelula;
    }

    public Jogador desempilhar() throws Exception {
        Celula desempilhado;

        if (!pilhaVazia()) {
            desempilhado = topo;
            topo = topo.getProximo();
            desempilhado.setProximo(null);
            return desempilhado.getJogador();
        } else
            throw new Exception("Não é possível desempilhar, a pilha está vazia.");
    }

    public void mostrar() {
        Pilha pilhaInvertida = inverterPilha();
        Celula celulaAtual = pilhaInvertida.getTopo();
        Celula proximaCelula = celulaAtual.getProximo();
        int indice = 0;

        /*Imprimir valores da pilha invertida*/
        while (proximaCelula != null) {
            Jogador jogador = celulaAtual.getJogador();
            System.out.printf("[%d] %d ## %s ## %d ## %d ## %d ## %s ## %s ## %s\n", indice++, jogador.getId(), jogador.getNome(),
                    jogador.getAltura(), jogador.getPeso(), jogador.getAnoNascimento(), jogador.getUniversidade(),
                    jogador.getCidadeNascimento(), jogador.getEstadoNascimento());

            celulaAtual = celulaAtual.getProximo();
            proximaCelula = proximaCelula.getProximo();
        }
    }

    public Pilha inverterPilha() {
        Pilha pilhaInvertida = new Pilha();
        Jogador jogadorAtual = topo.getJogador();
        Celula proximaCelula = topo.getProximo();
        int indice = 0;

        /*Criar pilha invertida*/
        while (proximaCelula != null) {
            pilhaInvertida.empilhar(jogadorAtual);
            jogadorAtual = proximaCelula.getJogador();
            proximaCelula = proximaCelula.getProximo();
        }

        return pilhaInvertida;
    }

    public boolean pilhaVazia() {
        return topo == fundo;
    }

    public Celula getFundo() {
        return fundo;
    }

    public void setFundo(Celula fundo) {
        this.fundo = fundo;
    }

    public Celula getTopo() {
        return topo;
    }

    public void setTopo(Celula topo) {
        this.topo = topo;
    }

}
