package vanenkoviliya.ChessBoard;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 10.01.2017
 **/
public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
