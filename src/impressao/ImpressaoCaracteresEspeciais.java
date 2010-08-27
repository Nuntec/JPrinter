package impressao;

/**
 * Decorador de GeradorImpressão que convertem a string gerada de Unicode para ABICOMP.
 * @author philipe
 */
public class ImpressaoCaracteresEspeciais implements GeradorImpressao{


    private GeradorImpressao gerador;

    public ImpressaoCaracteresEspeciais(GeradorImpressao gerador) {
        this.gerador = gerador;
    }

    public String geraImpressao() {
        return MapeamentoABICOMP.converte(gerador.geraImpressao());
    }

}
