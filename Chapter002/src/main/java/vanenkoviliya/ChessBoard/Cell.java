package vanenkoviliya.ChessBoard;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 10.01.2017
 **/
public class Cell {
     int row, column;
    /**
     * Конструтор пристваивает клетке координаты.
     * @param row ряд.
     * @param column колонка.
     */
    public Cell (int row, int column) {
       this.row =row;
       this.column = column;
    }
}
