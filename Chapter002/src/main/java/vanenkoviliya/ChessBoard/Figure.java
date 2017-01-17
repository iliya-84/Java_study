package vanenkoviliya.ChessBoard;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 10.01.2017
 **/
abstract class Figure {
    final Cell position;
    public String typeOfFigure;
    /**
     * Конструтор пристваивает фигуре позицию.
     * @param position позиция фигуры.
     */
    public Figure(Cell position) {
        this.position = position;
    }
    /** Метод возвращает массив клеток, которые должна пройти фигура.
     * @param dist клетка, на которую надо поставить фигуру.
     * @return массив клеток, которые должна пройти фигура.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;
    public abstract Figure clone(Cell dist);

}
