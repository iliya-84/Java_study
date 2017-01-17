package vanenkoviliya.ChessBoard;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 10.01.2017
 **/
public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
        this.typeOfFigure = "Слон";
    }
    /** Метод возвращает массив клеток, которые должна пройти фигура.
     * @param dist клетка, на которую надо поставить фигуру.
     * @return массив клеток, которые должна пройти фигура.
     */
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        Cell[] wayBishop = new Cell[10]; // массив клеток, которые должна пройти фигура.
        int i=0;
        int wayColumn=position.column;
        int wayRow=position.row;
        if (wayColumn>dist.column && wayColumn>dist.row) {
            while(wayColumn!=dist.column && wayRow!=dist.row && (wayColumn<9 && wayColumn>0 && wayRow>0 && wayRow<9)) {
                wayColumn--;
                wayRow--;
                wayBishop[i]= new Cell(wayRow,wayColumn);
                i++;
            }
        } else  if (position.column>dist.column && position.row<dist.row) {
            while(wayColumn!=dist.column && wayRow!=dist.row && (wayColumn<9 && wayColumn>0 && wayRow>0 && wayRow<9)) {
                wayColumn--;
                wayRow++;
                wayBishop[i]= new Cell(wayRow,wayColumn);
                i++;
            }
        } else  if (position.column<dist.column && position.row>dist.row) {
            while(wayColumn!=dist.column && wayRow!=dist.row && (wayColumn<9 && wayColumn>0 && wayRow>0 && wayRow<9)) {
                wayColumn++;
                wayRow--;
                wayBishop[i]= new Cell(wayRow,wayColumn);
                i++;
            }
        } else  if (position.column<dist.column && position.row<dist.row) {
            while(wayColumn!=dist.column && wayRow!=dist.row && (wayColumn<9 && wayColumn>0 && wayRow>0 && wayRow<9)) {
                wayColumn++;
                wayRow++;
                wayBishop[i]= new Cell(wayRow,wayColumn);
                i++;
            }
        }
        if (wayColumn!=dist.column || wayRow!=dist.row) {
           throw new ImpossibleMoveException("Нельзя переместить так фигуру.");
        }
        return wayBishop;
    }
    /** Метод возвращает новый объект Слон.
     * @param dist клетка, на которую надо поставить фигуру.
     * @return новый объект.
     */
    public Bishop clone(Cell dist) {
        return new Bishop(dist);
    }
}