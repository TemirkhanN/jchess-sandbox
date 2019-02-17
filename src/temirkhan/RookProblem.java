package temirkhan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RookProblem {
    private ArrayList<Character> lockedColumns;
    private ArrayList<Integer> lockedRows;

    public static void main(String[] args) {
        new RookProblem(8);
    }

    public RookProblem(int rookCount) {
        lockedColumns = new ArrayList<>(8);
        lockedRows    = new ArrayList<>(8);

        Chessboard chessboard = new Chessboard(Collections.emptyMap());

        for (int i=0; i<rookCount; i++) {
            placeRook(chessboard);
        }

        chessboard.render();
    }

    private void placeRook(Chessboard board) {
        try {
            char column = getFreeColumn();
            int row     = getFreeRow();

            lockedColumns.add(column);
            lockedRows.add(row);
            String position = "" + column + row;

            board.placePawn(Pawn.PawnType.WHITE_ROOK, position);
        } catch (Exception error) {
            // TODO
        }
    }

    private char getFreeColumn() throws Exception {
        ArrayList<Character> availableColumns = new ArrayList<>(8);
        for (char column = 'A'; column <= 'H'; column++) {
            if (!lockedColumns.contains(column)) {
                availableColumns.add(column);
            }
        }

        if (availableColumns.isEmpty()) {
            throw new Exception("No more columns left");
        }

        return availableColumns.get(new Random().nextInt(availableColumns.size()));
    }

    private int getFreeRow() throws Exception {
        for (int row = 1; row <= 8; row++) {
            if (!lockedRows.contains(row)) {
                return row;
            }
        }

        throw new Exception("No more rows left");
    }
}
