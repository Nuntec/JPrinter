package parser;


import impressao.Impressora;
import java.util.Map;
import sintelo.reconhecedor.ErroSemantico;
import sintelo.reconhecedor.Semantico;
import sintelo.reconhecedor.Token;


/**
 * Classe que analisa a semântica de um modelo PML, e gera a saída correspondente.
 * @author philipe
 */
public class SemanticoPML implements Semantico{

    private StringBuilder texto;
    private StringBuilder atual;
    private Map<String, Object> valores;
    private Impressora impressora;
    private int linha;


    public SemanticoPML(Map<String, Object> valores, Impressora impressora) {
        this.texto = new StringBuilder();
        this.atual = this.texto;
        this.valores = valores;
        this.impressora = impressora;
        this.linha = 1;
    }


    public void executa(int acao, Token token) {
        switch(acao){
            case 1:{
                atual.append(token.getTexto());
                break;
            }
            case 2:{
                String tex = token.getTexto();
                String var = tex.substring(2, tex.length()-1);
                String val = valores.get(var) == null ? "" : valores.get(var).toString();
                if(val == null){
                    throw new ErroSemantico(var + " não encontrado!");
                }
                atual.append(val);
                break;
            }
            case 3:{
                atual.append(impressora.novaLinha());
                ++linha;
                break;
            }
            case 4:{
                atual.append(impressora.separador());
                break;
            }
            case 5:{
                atual = new StringBuilder();
                break;
            }
            case 6:{
                String s = atual.toString();
                atual = texto;
                texto.append(impressora.centralizado(s));
                break;
            }
            case 7:{
                String s = atual.toString();
                atual = texto;
                texto.append(impressora.titulo(s));
                break;
            }
            case 8:{
                atual.append(impressora.novaLinha());
                break;
            }
            case 9:{
                String s = atual.toString();
                atual = texto;
                texto.append(impressora.negrito(s));
                break;
            }
        }
    }

    /**
     * Retorna o texto gerado a partir de um modelo PML.
     * @return
     */
    public String getTexto() {
        return texto.toString();
    }

    /**
     * Retorna a última linha processada, no case de erro, a linha com erro.
     * @return Última linha processada.
     */
    public int getLinha() {
        return linha;
    }



}
