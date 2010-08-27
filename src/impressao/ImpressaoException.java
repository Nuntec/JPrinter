package impressao;

/**
 * Exceções relacionados com a impressão de comprovantes.
 * @author philipe
 */
public class ImpressaoException extends RuntimeException{

    public ImpressaoException(Throwable arg0) {
        super(arg0);
    }

    public ImpressaoException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ImpressaoException(String arg0) {
        super(arg0);
    }

    public ImpressaoException() {
    }

    

}
