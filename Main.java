/*Você lança dois dados. Cada dado tem seis faces que contém os valores de 1 a 6.
Depois que os dados param de rolar, a soma dos pontos nas faces viradas para cima é calculada.
Se a soma for 7 ou 11 no primeiro lance, você ganha.
Se a soma for 2,3 ou 12 no primeiro lance (chamado "craps"), você perde.
Se a soma for 4,5,6,8,9 ou 10 no primeiro lance, essa soma torna-se sua pontuação.
Para ganhar, você deve continuar a rolas os dados até fazer o valor igual ao da sua pontuação.
Você perde se obtiver 7 antes de fazer a sua pontuação. */
public class Main {

    //método que lança os dados, calcula e exibe os resultados
    public static int JogarDados(){
        //seleciona valores aleatórios no dado
        int dado1 = 1 + Dado.randomNumbers.nextInt(6); //primeiro lançamento do dado
        int dado2 = 1 + Dado.randomNumbers.nextInt(6); //segundo lançamento do dado
        int soma = dado1 + dado2; //soma dos valores dos dados
        System.out.printf("Jogada: %d + %d = %d%n", dado1, dado2, soma); //exibe o resultado
        return soma;
    }

    //joga a partida
    public static void main(String[] args) {

       int pontuacao = 0; //pontuação inicial
       Status gameStatus; //instanciação da classe enum Status que contém os estados do jogo

       int somaDosDados = JogarDados(); //primeiro lançamento dos dados

       //determina o estado do jogo e a pontuação com base no primeiro lançamento
        switch (somaDosDados){
           case Status.SEVEN: //ganha com 7 no primeiro lançamento
           case Status.YO_LEVEN: // ganha com 11 no primeiro lançamento
               gameStatus = Status.VENCEDOR;
               break;
           case Status.SNAKE_EYES: //perde com 2 no primeiro lançamento
           case Status.TREY: // perde com 3 no primeiro lançamento
           case Status.BOX_CARS: // perde com 12 no primeiro lançamento
               gameStatus = Status.PERDEDOR;
               break;
           default://não ganhou, nem perdeu portanto, registra a pontuação
               gameStatus = Status.CONTINUAR;
               pontuacao = somaDosDados; //informa a pontuação
               System.out.println("Pontos: "+ pontuacao);
       }
       //enquanto o jogo não estiver completo
       while (gameStatus == Status.CONTINUAR){ //nem ganhador, nem perdedor
           somaDosDados = JogarDados();//lança os dados novamente
           //determina o estado do jogo
            if (somaDosDados == pontuacao){ //vitoria por pontuação
                gameStatus = Status.PERDEDOR;
            }else if (somaDosDados == Status.SEVEN){ //perde obtendo 7 antes de atingir a pontuação
                gameStatus = Status.PERDEDOR;
            }
            //exibe uma mensagem informando se ganhou ou perdeu
            if (gameStatus == Status.VENCEDOR){
                System.out.println("Ganhou!");
            } else {
                System.out.println("Perdeu!");
            }
       }
    }
}
