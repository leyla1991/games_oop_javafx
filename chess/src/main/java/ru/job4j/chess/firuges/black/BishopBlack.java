package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.Math.abs;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = (dest.getX() - position.getX());
        Cell[] steps = new Cell[abs(size)];
        int deltaX = 1;
        int deltaY = 1;
        int x = position.getX();
        int y = position.getY();
        for (int index = 0; index < abs(size); index++) {
            if (x > dest.getX()) {
                x -= deltaX;
                y += deltaY;
            } else {
                x += deltaX;
                y -= deltaY;
            }
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        int x = (dest.getX() - source.getX());
        int y = (dest.getY() - source.getY());
        if (abs(x) == abs(y)) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

