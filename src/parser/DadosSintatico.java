
package parser;


import sintelo.reconhecedor.sintatico.EspecificacaoSintatica;


public class DadosSintatico implements EspecificacaoSintatica {


    private static final int[][] TABELA_PARSE = {
        {0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, -1},
        {-1, 1, 2, 2, 2, 1, -1, 1, -1, 1, 1, -1},
        {-1, 5, -1, -1, -1, 6, -1, 9, -1, 5, 12, -1},
        {-1, -1, 15, 16, 17, -1, -1, -1, -1, -1, -1, -1},
        {4, 3, 3, 3, 3, 3, -1, 3, -1, 3, 3, -1},
        {-1, 18, -1, -1, -1, -1, -1, -1, -1, 19, -1, -1},
        {-1, 7, -1, -1, -1, -1, 8, -1, -1, 7, -1, -1},
        {-1, 10, -1, -1, -1, -1, -1, -1, 11, 10, -1, -1},
        {-1, 13, -1, -1, -1, -1, -1, -1, -1, 13, -1, 14}
    };


    private static final int[][] PRODUCOES = {
        {16},
        {14},
        {15},
        {13, 16},
        {},
        {17},
        {5, 26, 18, 6, 27},
        {17, 18},
        {},
        {7, 26, 19, 8, 28},
        {17, 19},
        {},
        {10, 26, 20, 11, 30},
        {17, 20},
        {},
        {2, 24},
        {3, 29},
        {4, 25},
        {1, 22},
        {9, 23}
    };


    public int getDerivacao(int s, int t) {
        return TABELA_PARSE[s][t];
    }


    public int[] getProducao(int n) {
        return PRODUCOES[n];
    }


    public int getPrimeiroNaoTerminal() {
        return 12;
    }


    public int getPrimeiraAcao() {
        return 21;
    }


    public int getSimboloInicial() {
        return 12;
    }
}
