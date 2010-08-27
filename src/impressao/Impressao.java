package impressao;

import impressoras.ImpressoraDaruma;
import java.io.Closeable;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Thread de geação de comprovantes de abastecimento.
 */
public class Impressao{

    /**
     * Gerador de impressão.
     */
    private GeradorImpressao impressao;
    public  String localDispositivo = "";

    /**
     * Cria um gerador de comprovante de abastecimento de veículo.
     * @param nome Nome da thread.
     * @param abs Abastecimento de veículo.
     * @param postoAbasteceu Posto que realizou o abastecimento.
     * @param bicos Coleção debicos utilizados.
     */
    public Impressao(String dispositivo) {
        this.localDispositivo = dispositivo;
    }

    public void imprime(final String nomeModelo, final Map<String, Object> valores) {
        new Thread(new Runnable() {
            public void run() {
                FileOutputStream out = null;
                try {
                    Impressora imp = new ImpressoraDaruma();
                    String modelo = leArquivoUtf8("modelos/" + nomeModelo + ".pml");
                    impressao = new ImpressaoCaracteresEspeciais(new ImpressaoPML(imp, modelo, valores));

                    String s = impressao.geraImpressao();
                    System.out.println("S: " + s);
                    out = new FileOutputStream(localDispositivo);
                    for (int i = 0; i < s.length(); ++i) {
                        out.write(s.charAt(i));
                    }
                } catch (Exception ex) {
                    throw new ImpressaoException(ex);
                } finally {
                    fecha(out);
                }
            }
        }).start();        
    }

    private static String leArquivoUtf8(String arquivo) {
        StringBuilder buf = new StringBuilder();
        FileInputStream file = null;
        try {
            file = new FileInputStream(arquivo);
            InputStreamReader reader = new InputStreamReader(file, "UTF8");
            int ch;
            while ((ch = reader.read()) != -1) {
                char c = (char) ch;
                buf.append(c);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        return buf.toString();
    }   

    
    
    /**
     * Fecha um elemento Closeable.
     */
    private static void fecha(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
