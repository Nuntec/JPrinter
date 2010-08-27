package impressao;

/**
 * Interface de geradores de conteúdo para a impressão de comprovantes.
 */
public interface GeradorImpressao {

    /**
     * Gera uma string que será enviada à impressora.
     * @return String que será enviada à impressora.
     */
    String geraImpressao();

}
