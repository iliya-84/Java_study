package vanenkoviliya.Chess;

import org.junit.Test;
import vanenkoviliya.ChessBoard.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author ИЛЬЯ
 * @version 1
 * @since 12.12.2016
 */
public class ChessTest {
    @Test
    public void whenCorrectMobeThenMoveTrue() throws Exception {
        Board board = new Board();
        Cell sourcetest = new Cell(5, 5);
        Cell disttest = new Cell(1, 1);
        board.figures[5][5] = new Bishop(sourcetest);
        assertThat(board.move(sourcetest, disttest), is(true));
    }
     @Test(expected = FigureNotFoundException.class)
     public void whenFigureNotFoundThenFigureNotFoundException() throws Exception {
        Board board = new Board();
        Cell sourcetest = new Cell(5, 5);
        Cell disttest = new Cell(1, 1);
        board.move(sourcetest, disttest);
     }
    @Test(expected = ImpossibleMoveException.class)
    public void whenDestenationOverBoardThenImpossibleMoveException() throws Exception {
        Board board = new Board();
        Cell sourcetest = new Cell(5, 5);
        Cell disttest = new Cell(9, 9);
        board.figures[5][5] = new Bishop(sourcetest);
        board.move(sourcetest, disttest);
    }
    @Test (expected = ImpossibleMoveException.class)
    public void whenWrongMoveThenImpossibleMoveException() throws Exception {
        Board board = new Board();
        Cell sourcetest = new Cell(5, 5);
        Cell disttest = new Cell(3, 4);
        board.figures[5][5] = new Bishop(sourcetest);
        board.move(sourcetest, disttest);
    }
    @Test (expected = OccupiedWayException.class)
    public void whenWayOccupedThenOccupiedWayException() throws Exception {
        Board board = new Board();
        Cell sourcetest = new Cell(5, 5);
        Cell disttest = new Cell(8, 8);
        board.figures[5][5] = new Bishop(sourcetest);
        board.figures[6][6] = new Bishop(new Cell(6, 6));
        board.move(sourcetest, disttest);
    }
   @Test (expected = ImpossibleMoveException.class)
    public void whenDestenationEqualsSourceThenImpossibleMoveException() throws Exception {
        Board board = new Board();
        Cell sourcetest = new Cell(5, 5);
        Cell disttest = new Cell(5, 5);
        board.figures[5][5] = new Bishop(sourcetest);
        board.move(sourcetest, disttest);
        }
}
