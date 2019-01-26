package temirkhan;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Chessboard {
    private HashMap<String, Square> squares;
    private static Map<String, String> initialArrangement;

    static {
        Map<String, String> initialChessArrangement = new HashMap<>(32);
        for (char column = 'A'; column <= 'H'; column++) {
            initialChessArrangement.put(column + "2", "whitePawn");
            initialChessArrangement.put(column + "7", "blackPawn");
        }

        initialChessArrangement.put("A1", "whiteRook");
        initialChessArrangement.put("B1", "whiteKnight");
        initialChessArrangement.put("C1", "whiteBishop");
        initialChessArrangement.put("D1", "whiteQueen");
        initialChessArrangement.put("E1", "whiteKing");
        initialChessArrangement.put("F1", "whiteBishop");
        initialChessArrangement.put("G1", "whiteKnight");
        initialChessArrangement.put("H1", "whiteRook");

        initialChessArrangement.put("A8", "blackRook");
        initialChessArrangement.put("B8", "blackKnight");
        initialChessArrangement.put("C8", "blackBishop");
        initialChessArrangement.put("D8", "blackQueen");
        initialChessArrangement.put("E8", "blackKing");
        initialChessArrangement.put("F8", "blackBishop");
        initialChessArrangement.put("G8", "blackKnight");
        initialChessArrangement.put("H8", "blackRook");

        initialArrangement = Collections.unmodifiableMap(initialChessArrangement);
    }

    public Chessboard() {
        this.squares = new HashMap<>(64);
        for (int row = 1; row <= 8; row++) {
            for (char column = 'A'; column <= 'H'; column++) {
                Square square = new Square(column, row);
                this.squares.put(square.getPosition(), square);
            }
        }
        try {
            for (Map.Entry<String, String> pawn: initialArrangement.entrySet()) {
                String pawnPosition = pawn.getKey();
                String pawnName     = pawn.getValue();
                Square pawnSquare   = this.squares.get(pawnPosition);
                pawnSquare.placePawn(new Pawn(pawnName));
            }
        } catch (Exception e) {
            System.out.println("Well, something went wrong and such pawn doesn't exist");
        }
    }

    public void render() {
        for (int row = 8; row >= 1; row--) {
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
}
