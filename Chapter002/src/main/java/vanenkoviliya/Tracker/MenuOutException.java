package vanenkoviliya.Tracker;

/**
 * @author ИЛЬЯ
 * @version 1
 * @since 26.12.2016
 */
public class MenuOutException extends RuntimeException {

    /**
     /** Бросает исключение с хаданным текстом.
     * @param msg исключение.
     * */
    public MenuOutException(String msg) {
      super(msg);
    }

}
