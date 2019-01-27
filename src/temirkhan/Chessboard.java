package temirkhan;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Chessboard {
    private HashMap<String, Square> squares;
    private static Map<String, Pawn.PawnType> initialArrangement;

    static {
        Map<String, Pawn.PawnType> initialChessArrangement = new HashMap<>(32);
        for (char column = 'A'; column <= 'H'; column++) {
            initialChessArrangement.put(column + "2", Pawn.PawnType.WHITE_PAWN);
            initialChessArrangement.put(column + "7", Pawn.PawnType.BLACK_PAWN);
        }

        initialChessArrangement.put("A1", Pawn.PawnType.WHITE_ROOK);
        initialChessArrangement.put("B1", Pawn.PawnType.WHITE_KNIGHT);
        initialChessArrangement.put("C1", Pawn.PawnType.WHITE_BISHOP);
        initialChessArrangement.put("D1", Pawn.PawnType.WHITE_QUEEN);
        initialChessArrangement.put("E1", Pawn.PawnType.WHITE_KING);
        initialChessArrangement.put("F1", Pawn.PawnType.WHITE_BISHOP);
        initialChessArrangement.put("G1", Pawn.PawnType.WHITE_KNIGHT);
        initialChessArrangement.put("H1", Pawn.PawnType.WHITE_ROOK);

        initialChessArrangement.put("A8", Pawn.PawnType.BLACK_ROOK);
        initialChessArrangement.put("B8", Pawn.PawnType.BLACK_KNIGHT);
        initialChessArrangement.put("C8", Pawn.PawnType.BLACK_BISHOP);
        initialChessArrangement.put("D8", Pawn.PawnType.BLACK_QUEEN);
        initialChessArrangement.put("E8", Pawn.PawnType.BLACK_KING);
        initialChessArrangement.put("F8", Pawn.PawnType.BLACK_BISHOP);
        initialChessArrangement.put("G8", Pawn.PawnType.BLACK_KNIGHT);
        initialChessArrangement.put("H8", Pawn.PawnType.BLACK_ROOK);

        initialArrangement = Collections.unmodifiableMap(initialChessArrangement);
    }

    public Chessboard() {
        this(initialArrangement);
    }

    public Chessboard(Map<String, Pawn.PawnType> arrangement) {
        this.createSquares();

        for (Map.Entry<String, Pawn.PawnType> pawnInfo : arrangement.entrySet()) {
            this.placePawn(pawnInfo.getValue(), pawnInfo.getKey());
        }
    }

    public void render() {
        System.out.print("    ");
        for (char column = 'A'; column <= 'H'; column++) {
            System.out.print(column + "    ");
        }
        System.out.println();

        for (int row = 8; row >= 1; row--) {
            System.out.print(row + " ");
            for (char column = 'A'; column <= 'H'; column++) {
                Square square = squares.get("" + column + row);
                if (square.getPawn() == null) {
                    if (square.getColor() == Square.colors.WHITE) {
                        System.out.print("□   ");
                    } else {
                        System.out.print("■   ");
                    }
                } else {
                    System.out.print(square.getPawn().getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }

    private void createSquares() {
        this.squares = new HashMap<>(64);
        for (int row = 1; row <= 8; row++) {
            for (char column = 'A'; column <= 'H'; column++) {
                Square square = new Square(column, row);
                this.squares.put(square.getPosition(), square);
            }
        }
    }

    private void placePawn(Pawn.PawnType pawnName, String position) {
        try {
            Square pawnSquare = this.squares.get(position);
            pawnSquare.placePawn(new Pawn(pawnName));
        } catch (Exception e) {
            System.out.println("Well, something went wrong and such pawn doesn't exist");
        }
    }
}
