package temirkhan;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Pawn {
    private String symbol;

    private static final Map<String, String> symbols;
    static {
        Map<String, String> symbolsMap = new HashMap<>(18);
        symbolsMap.put("blackPawn", "♟");
        symbolsMap.put("blackKnight", "♞");
        symbolsMap.put("blackBishop", "♝");
        symbolsMap.put("blackRook", "♜");
        symbolsMap.put("blackQueen", "♛");
        symbolsMap.put("blackKing", "♚");
        symbolsMap.put("whitePawn", "♙");
        symbolsMap.put("whiteKnight", "♘");
        symbolsMap.put("whiteBishop", "♗");
        symbolsMap.put("whiteRook", "♖");
        symbolsMap.put("whiteQueen", "♕");
        symbolsMap.put("whiteKing", "♔");
        symbols = Collections.unmodifiableMap(symbolsMap);
    }

    public Pawn(String pawnName) throws Exception {
        if (!symbols.containsKey(pawnName)) {
            throw new Exception("There is no such chess pawn");
        }
        this.symbol = symbols.get(pawnName);
    }

    public String getSymbol() {
        return this.symbol;
    }
}
