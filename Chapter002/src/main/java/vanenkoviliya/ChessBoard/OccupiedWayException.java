package vanenkoviliya.ChessBoard;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 10.01.2017
 **/
public class OccupiedWayException extends Exception {
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
