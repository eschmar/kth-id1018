import java.util.Arrays;

/**
 * Created by eschmar on 18/11/15.
 */
public class Chessboard {
    public static class Field {
        private char row;
        private byte column;
        private Chesspiece piece = null;
        private boolean marked = false;

        public Field(char row, byte column) {
            this.row = row;
            this.column = column;
        }

        public void put(Chesspiece piece) {
            this.piece = piece;
        }

        public Chesspiece take() {
            Chesspiece temp = this.piece;
            this.piece = null;
            return temp;
        }

        public void mark() {
            this.marked = true;
        }

        public void unmark(){
            this.marked = false;
        }

        @Override
        public String toString() {
            String s = (marked) ? "xx" : "--";
            return (piece == null) ? s : piece.toString();
        }
    }

    public static final int NUMBER_OF_ROWS = 8;
    public static final int NUMBER_OF_COLUMNS = 8;

    public static final int FIRST_ROW = 'a';
    public static final int FIRST_COLUMN = '1';

    private Field[][] fields;

    public Chessboard() {
        fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        char row = 0;byte column = 0;

        for (int r = 0; r < NUMBER_OF_ROWS; r++) {
            row = (char) (FIRST_ROW + r);
            column = FIRST_COLUMN;

            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                fields[r][c] = new Field(row, column);
                column++;
            }
        }
    }

    @Override
    public String toString() {
        String result = "";

        for (Field[] row : fields) {
            for (Field column : row) {
                result += column + " ";
            }

            result += "\n";
        }

        return result;
    }

    public boolean isValidField(char row, byte column) {
        if (row > 0 && row <= NUMBER_OF_ROWS && column > 0 && column <= NUMBER_OF_COLUMNS) {
            return true;
        }

        return false;
    }

    public abstract class Chesspiece {
        /**
         * w - white,
         * b - black
         */
        private char color;

        /**
         * K - King,
         * Q - Queen,
         * R - Rook,
         * B - Bishop,
         * N - Knight,
         * P - Pawn
         */
        private char name;

        protected char row = 0;
        protected byte column = -1;

        protected Chesspiece(char color, char name) {
            this.color = color;
            this.name = name;
        }

        @Override
        public String toString() {
            return "" + color + name;
        }

        public boolean isOnBoard() {
            return Chessboard.this.isValidField(row, column);
        }

        public void moveTo(char row, byte column) throws NotValidFieldException {
            if (!Chessboard.this.isValidField(row, column)) {
                throw new NotValidFieldException("bad field: " + row + column);
            }

            this.row = row;
            this.column = column;

            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;
            Chessboard.this.fields[r][c].put(this);
        }

        public void moveOut() {
            this.row = 0;
            this.column = -1;
        }

        public abstract void markReachableFields();
        public abstract void unmarkReachableFields();
    }

    public class Pawn extends Chesspiece {
        public Pawn(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].mark();
            }
        }

        public void unmarkReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].unmark();
            }
        }
    }
}
