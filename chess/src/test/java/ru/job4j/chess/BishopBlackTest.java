package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void whenPositionTrue() {
        BishopBlack pos = new BishopBlack(Cell.A3);
        Cell expected = pos.position();
        assertThat(expected, is(Cell.A3));
    }

    @Test
    public void whenCopyTrue() {
        BishopBlack cop = new BishopBlack(Cell.A3);
        Figure expected = cop.copy(Cell.C1);
        assertThat(expected.position(), is(Cell.C1));
    }

    @Test
    public void whenWayTrue() {
        BishopBlack run = new BishopBlack(Cell.C1);
        Cell[] steps = run.way(Cell.G5);
        Cell[] cell = new Cell[] {
                Cell.D2, Cell.E3, Cell.F4, Cell.G5
        };
        assertThat(steps, is(cell));
    }
}
