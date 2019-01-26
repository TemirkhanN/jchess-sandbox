package temirkhan;

public class Square {
    public enum  colors {BLACK, WHITE};
    private Integer row;
    private char column;
    private Pawn pawn;

    public Square(char column, Integer row) {
        this.row    = row;
        this.column = column;
    }

    public String getPosition() {
        return "" + this.column + this.row;
    }

    public void placePawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public Pawn getPawn() {
        return this.pawn;
    }

    public colors getColor() {
        // Square color starts from black on even rows
        colors color = colors.BLACK;
        if (this.row % 2 == 0) {
            // And white on odd rows
            color = colors.WHITE;
        }

        for (char column = 'A'; column <= 'H'; column++) {
            if (this.column == column) {
                break;
            }

            if (color == colors.WHITE) {
                color = colors.BLACK;
            } else {
                color = colors.WHITE;
            }
        }

        return color;
    }
}
