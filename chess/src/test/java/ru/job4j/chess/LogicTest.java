package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.RookBlack;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFoundException()
            throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.E2, Cell.G5);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenOccupiedCellException()
            throws OccupiedCellException, FigureNotFoundException {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.C1));
            logic.move(Cell.C1, Cell.G5);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveException()
            throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.C2);
    }
}