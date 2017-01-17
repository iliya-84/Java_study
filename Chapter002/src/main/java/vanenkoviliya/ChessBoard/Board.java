package vanenkoviliya.ChessBoard;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 10.01.2017
 **/
public class Board {
    public Figure[][] figures = new Figure[9][9];

    /** Метод возвращает массив клеток, которые должна пройти фигура.
     * @param source клетка, на которой стоит фигура.
     * @param dist клетка, на которую надо поставить фигуру.
     * @return true, если фигуру можно поставить на заданную клетку и false, если нельзя.
     */
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean answer = false;
        if (source.row < 1 || source.row > 8 || source.column < 1 || source.column > 8) {
            throw new ImpossibleMoveException("Клетка фигуры за пределами доски");
        }
        if (dist.row < 1 || dist.row > 8 || dist.column < 1 || dist.column > 8) {
            throw new ImpossibleMoveException("Клетка назначения за пределами доски");
        }
        if (figures[source.row][source.column] == null) {
            throw new FigureNotFoundException("На этой клетке нет фигур.");
        }
        if (source.row == dist.row && source.column == dist.column) {
            throw new ImpossibleMoveException("Фигура осталась на месте.");
        }
        Cell[] way = figures[source.row][source.column].way(dist);
        for (Cell cells : way) {
            if (cells != null && figures[cells.row][cells.column] != null)
                throw new OccupiedWayException("На пути стоят фигуры.");
        }
        figures[dist.row][dist.column] = figures[source.row][source.column].clone(dist);
        figures[source.row][source.column] = null;
        answer = true;
        return answer;
    }
}
