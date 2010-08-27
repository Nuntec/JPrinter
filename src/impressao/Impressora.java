package impressao;

/**
 * Interface para diferenças de representação de elementos de impressão em diferentes impressoras.
 */
public interface Impressora {

    /**
     * Gera uma representação em negrito, ou expandido.
     * @param s String a ser transformada.
     * @return String após transformada.
     */
    String negrito(String s);

    /**
     * Gera uma representação de uma string centralizada.
     * @param s String a ser centralizada.
     * @return String centralizada.
     */
    String centralizado(String s);

    /**
     * Gera uma representação de título para uma string.
     * @param s String a ser representada como título.
     * @return Título correspondente à string.
     */
    String titulo(String s);

    /**
     * Retorna a representação de nova linha,  ou avanço de impressão.
     * @return Nova linha específico de impressora.
     */
    String novaLinha();


    /**
     * Retona um separador ou reta horizontal.
     * @return Representação de separador para a impressora atual.
     */
    String separador();

}
