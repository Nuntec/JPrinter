package impressoras;

import impressao.Impressora;

/**
 * Implementa a interface impressora, com elementos específicos para a impressora Daruma.
 * @author philipe
 */
public class ImpressoraDaruma implements Impressora{

    public static final int LARGURA_NORMAL = 48;
    public static final int LARGURA_EXPANDIDO = 24;
    public static final int LARGURA_CONDENSADO = 60;
    
    
    public static final char NOVA_LINHA = (char)0x0a;
    public static final char INICIA_EXPANDIDO = (char)0x0e;
    public static final char INICIA_NORMAL = (char)0x14;
    public static final char INICIA_CONDENSADO = (char)0x0f;

    public String centralizado(String s) {

        StringBuilder sb = new StringBuilder();

        int pos = posicaoCentro(s.length(), LARGURA_NORMAL);

        for(int i = 0; i < pos; ++i){
            sb.append(' ');
        }

        sb.append(s);        

        return sb.toString();
    }

    private static int posicaoCentro(int len, int largura){
        int dif = largura - len;

        if(dif > 0){
            return dif / 2;
        }
        else{
            return 0;
        }
    }

    public String titulo(String s) {
        StringBuilder sb = new StringBuilder();

        int pos = posicaoCentro(s.length(), LARGURA_EXPANDIDO);

        sb.append(INICIA_EXPANDIDO);

        for(int i = 0; i < pos; ++i){
            sb.append(' ');
        }

        sb.append(s);

        sb.append(INICIA_NORMAL);

        return sb.toString();
    }

    public String novaLinha() {
        return String.valueOf(NOVA_LINHA);
    }

    public String separador() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < LARGURA_NORMAL; ++i){
            sb.append('-');
        }
        return sb.toString();
    }


    public String negrito(String s) {
        return INICIA_EXPANDIDO + s + INICIA_NORMAL;
    }
    

}
