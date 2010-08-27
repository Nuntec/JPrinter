package impressao;

import java.util.Map;
import parser.DadosLexico;
import parser.DadosSintatico;
import parser.SemanticoPML;
import sintelo.reconhecedor.ErroAnalise;
import sintelo.reconhecedor.lexico.AnalisadorLexico;
import sintelo.reconhecedor.sintatico.AnalisadorSintatico;

/**
 * Implementa a interface GeradorImpressao, gerando comprovantes a partir de modelos pml.
 * @author philipe
 */
public class ImpressaoPML implements GeradorImpressao{


    /**
     * Objeto que gera elementos específicos de cada impressoras.
     */
    private Impressora impressora;

    /**
     * Modelo pml de geração de comprovantes.
     */
    private String modelo;

    /**
     * Mapa de valores para substituir no modelo (nome => valor).
     */
    private Map<String, Object> valores;


    public ImpressaoPML(Impressora impressora, String modelo, Map<String, Object> valores) {
        this.impressora = impressora;
        this.modelo = modelo;
        this.valores = valores;
    }   


    /**
     * Gera uma string a partir do modelo, do mapa de valores específico para a impressora especificada.
     * @return String a ser enviada para uma impressora específica.
     */
    public String geraImpressao() {

        AnalisadorLexico lexico = new AnalisadorLexico(new DadosLexico());
        AnalisadorSintatico sintatico = new AnalisadorSintatico(new DadosSintatico());
        SemanticoPML semantico = new SemanticoPML(valores, impressora);


        try{
            lexico.setEntrada(modelo);
            sintatico.reconhece(lexico, semantico);
            return semantico.getTexto();

        } catch(ErroAnalise e){
            throw new ImpressaoException(e.getMessage() +  "=>linha " + semantico.getLinha());
        }

    }


}
