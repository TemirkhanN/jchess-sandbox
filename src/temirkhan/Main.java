package temirkhan;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard(Map.of(
                "A1", Pawn.PawnType.WHITE_QUEEN,
                "B6", Pawn.PawnType.WHITE_QUEEN,
                "H4", Pawn.PawnType.BLACK_QUEEN,
                "C3", Pawn.PawnType.BLACK_QUEEN
        ));

        // Place N queens on chessboard so they can not attack each other

        chessboard.render();
    }
}
