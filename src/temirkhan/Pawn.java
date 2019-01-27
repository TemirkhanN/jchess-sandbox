package temirkhan;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Pawn {
    public enum PawnType {
        BLACK_PAWN, BLACK_ROOK, BLACK_KNIGHT, BLACK_BISHOP, BLACK_QUEEN, BLACK_KING,
        WHITE_PAWN, WHITE_ROOK, WHITE_KNIGHT, WHITE_BISHOP, WHITE_QUEEN, WHITE_KING
    }

    private String symbol;

    private static final Map<PawnType, String> symbols;

    static {
        Map<PawnType, String> symbolsMap = new HashMap<>(18);
        symbolsMap.put(PawnType.BLACK_PAWN, "♟");
        symbolsMap.put(PawnType.BLACK_KNIGHT, "♞");
        symbolsMap.put(PawnType.BLACK_BISHOP, "♝");
        symbolsMap.put(PawnType.BLACK_ROOK, "♜");
        symbolsMap.put(PawnType.BLACK_QUEEN, "♛");
        symbolsMap.put(PawnType.BLACK_KING, "♚");
        symbolsMap.put(PawnType.WHITE_PAWN, "♙");
        symbolsMap.put(PawnType.WHITE_KNIGHT, "♘");
        symbolsMap.put(PawnType.WHITE_BISHOP, "♗");
        symbolsMap.put(PawnType.WHITE_ROOK, "♖");
        symbolsMap.put(PawnType.WHITE_QUEEN, "♕");
        symbolsMap.put(PawnType.WHITE_KING, "♔");
        symbols = Collections.unmodifiableMap(symbolsMap);
    }

    public Pawn(PawnType pawnType) throws Exception {
        if (!symbols.containsKey(pawnType)) {
            throw new Exception("There is no such chess pawn");
        }
        this.symbol = symbols.get(pawnType);
    }

    public String getSymbol() {
        return this.symbol;
    }
}
