import classes.ArquivoTextoLeitura;
import classes.Jogador;
import classes.Pilha;

import java.util.Scanner;

public class Main {

    private static final int MAX_PLAYERS = 4000;
    private static final String DATA_BASE_FILE_PATH = "tmp/jogadores.txt"; /*Para enviar ao VERDE, utilizar caminho /tmp/jogadores.txt*/

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Jogador[] jogadores = new Jogador[MAX_PLAYERS];
        ArquivoTextoLeitura arqLeitura = new ArquivoTextoLeitura(DATA_BASE_FILE_PATH);
        Pilha pilhaJogadores = new Pilha();
        
        int id, altura, peso, anoNascimento, i = 0;
        String nome, universidade, cidadeNascimento, estadoNascimento;
        String input;
        
        input = arqLeitura.ler();
        input = arqLeitura.ler();

        /*Criacao do arquivo referencia para a base de dados*/
        while (input != null) {
            String[] infoJogador = input.split(",", -1);

            id = Integer.parseInt(infoJogador[0]);
            nome = !infoJogador[1].isEmpty() ? infoJogador[1] : "nao informado";
            altura = Integer.parseInt(infoJogador[2]);
            peso = Integer.parseInt(infoJogador[3]);
            universidade = !infoJogador[4].isEmpty() ? infoJogador[4] : "nao informado";
            anoNascimento = Integer.parseInt(infoJogador[5]);
            cidadeNascimento = !infoJogador[6].isEmpty() ? infoJogador[6] : "nao informado";
            estadoNascimento = !infoJogador[7].isEmpty() ? infoJogador[7] : "nao informado";
            jogadores[i++] = new Jogador(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
            input = arqLeitura.ler();
        }

        /*Empilhando jogadores conforme entrada padrao*/
        input = scanner.nextLine();
        while (!input.equals("FIM")) {
            Jogador jogadorRef = jogadores[Integer.parseInt(input)];
            pilhaJogadores.empilhar(jogadorRef);
            input = scanner.nextLine();
        }

        /*Processamento da 2a parte da entrada*/
        int qtdeEntrada = Integer.parseInt(scanner.nextLine());
        input = scanner.nextLine();

        for (int j=0; j<qtdeEntrada; j++) {
            String[] comandos = input.split(" ");

            if (comandos.length == 2) {
                int indice = Integer.parseInt(comandos[1]);
                Jogador novoJogador = jogadores[indice];
                pilhaJogadores.empilhar(novoJogador);
            } else {
                Jogador desempilhado = pilhaJogadores.desempilhar();
                System.out.println("(R) " + desempilhado.getNome());
            }
            input = scanner.nextLine();
        }

        pilhaJogadores.mostrar();




    }
}