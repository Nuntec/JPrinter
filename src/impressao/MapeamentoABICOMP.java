package impressao;

import java.util.HashMap;
import java.util.Map;


/**
 * Mapeia os caracteres especiais de impressoras que utilizam o padrão de codificação ABICOMP.
 * @author philipe
 */
public class MapeamentoABICOMP {


    /**
     * Mapa de caracteres (Unicode => ABICOMP)
     */
    private static Map<Character, Character> mapaCaracteres;


    static{
        mapaCaracteres = new HashMap<Character, Character>();

        mapaCaracteres.put('À', (char)161);
        mapaCaracteres.put('Á', (char)162);
        mapaCaracteres.put('Â', (char)163);
        mapaCaracteres.put('Ã', (char)164);
        mapaCaracteres.put('Ä', (char)165);
        mapaCaracteres.put('Ç', (char)166);
        mapaCaracteres.put('È', (char)167);
        mapaCaracteres.put('É', (char)168);
        mapaCaracteres.put('Ê', (char)169);
        mapaCaracteres.put('Ë', (char)170);
        mapaCaracteres.put('Ì', (char)171);
        mapaCaracteres.put('Í', (char)172);
        mapaCaracteres.put('Î', (char)173);
        mapaCaracteres.put('Ï', (char)174);
        mapaCaracteres.put('Ñ', (char)175);
        mapaCaracteres.put('Ò', (char)176);
        mapaCaracteres.put('Ó', (char)177);
        mapaCaracteres.put('Ô', (char)178);
        mapaCaracteres.put('Õ', (char)179);
        mapaCaracteres.put('Ö', (char)180);
        mapaCaracteres.put('Œ', (char)181);
        mapaCaracteres.put('Ù', (char)182);
        mapaCaracteres.put('Ú', (char)183);
        mapaCaracteres.put('Û', (char)184);
        mapaCaracteres.put('Ü', (char)185);
        mapaCaracteres.put('Ÿ', (char)186);
        mapaCaracteres.put('”', (char)187);
        mapaCaracteres.put('£', (char)188);
        mapaCaracteres.put('’', (char)189);
        mapaCaracteres.put('§', (char)190);
        mapaCaracteres.put('°', (char)191);
        mapaCaracteres.put('¡', (char)192);
        mapaCaracteres.put('à', (char)193);
        mapaCaracteres.put('á', (char)194);
        mapaCaracteres.put('â', (char)195);
        mapaCaracteres.put('ã', (char)196);
        mapaCaracteres.put('ä', (char)197);
        mapaCaracteres.put('ç', (char)198);
        mapaCaracteres.put('è', (char)199);
        mapaCaracteres.put('é', (char)200);
        mapaCaracteres.put('ê', (char)201);
        mapaCaracteres.put('ë', (char)202);
        mapaCaracteres.put('ì', (char)203);
        mapaCaracteres.put('í', (char)204);
        mapaCaracteres.put('î', (char)205);
        mapaCaracteres.put('ï', (char)206);
        mapaCaracteres.put('ñ', (char)207);
        mapaCaracteres.put('ò', (char)208);
        mapaCaracteres.put('ó', (char)209);
        mapaCaracteres.put('ô', (char)210);
        mapaCaracteres.put('õ', (char)211);
        mapaCaracteres.put('ö', (char)212);
        mapaCaracteres.put('œ', (char)213);
        mapaCaracteres.put('ù', (char)214);
        mapaCaracteres.put('ú', (char)215);
        mapaCaracteres.put('û', (char)216);
        mapaCaracteres.put('ü', (char)217);
        mapaCaracteres.put('ÿ', (char)218);
        mapaCaracteres.put('ß', (char)219);
        mapaCaracteres.put('ª', (char)220);
        mapaCaracteres.put('º', (char)221);
        mapaCaracteres.put('¿', (char)222);
        mapaCaracteres.put('±', (char)223);

    }


    /**
     * Converte um string de Unicode para ABICOMP.
     * @param s String a ser convertida.
     * @return Resultado da conversão.
     */
    public static String converte(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            Character ch = mapaCaracteres.get(c);
            if(ch == null){
                ch = c;
            }
            sb.append(ch);
        }
        return sb.toString();
    }



}
