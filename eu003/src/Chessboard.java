import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by eschmar on 18/11/15.
 */
public class Chessboard {
    public static void main(String[] args) {
        System.out.println("CHESSBOARD:");
        Chessboard board = new Chessboard();
        board.run(args);
    }

    public void run(String[] args) {
        Pawn pawn = new Pawn('w');
        Rook rook = new Rook('b');
        Knight knight = new Knight('w');
        Bishop bishop = new Bishop('w');
        Queen queen = new Queen('b');
        King king = new King('w');

        try {
            pawn.moveTo('a', (byte)2);
            rook.moveTo('c', (byte)5);
            knight.moveTo('d', (byte)3);
            bishop.moveTo('g', (byte)4);
            queen.moveTo('a', (byte)7);
            king.moveTo('f', (byte)4);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        log();
    }

    private Random rand = new Random();

    /**
     * Moves every piece in the list on the board,
     * marks its possible next steps and finally
     * removes it again.
     * @param pieces
     */
    public void presentPieces(Chesspiece[] pieces) {
        for (Chesspiece piece : pieces) {
            try {
                char row = (char)(FIRST_ROW + rand.nextInt(NUMBER_OF_ROWS-1));
                byte column = (byte)(rand.nextInt(NUMBER_OF_COLUMNS-1)+1);
                piece.moveTo(row, column);
                piece.markReachableFields();
                log();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

            piece.unmarkReachableFields();
            piece.moveOut();
        }
    }

    public void log() {
        System.out.println(this);
    }

    public void log(String msg) {
        System.out.println(msg);
        log();
    }

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
            //return "" + row + column;
            String s = (marked) ? "xx" : "--";
            return (piece == null) ? s : piece.toString();
        }
    }

    public static final int NUMBER_OF_ROWS = 8;
    public static final int NUMBER_OF_COLUMNS = 8;

    public static final int FIRST_ROW = 'a';
    public static final int FIRST_COLUMN = 1;

    private Field[][] fields;

    public Chessboard() {
        fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        char row = 0;
        byte column = 0;

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
        String result = "\n ";
        for (int i = 1; i <= NUMBER_OF_COLUMNS; i++) {
            result += "  " + i;
        }

        result += "\n";

        char r = FIRST_ROW;
        for (Field[] row : fields) {
            result += r + "  ";
            for (Field column : row) {
                result += column.toString() + " ";
            }

            result += "\n";
            r = (char)(r+1);
        }

        return result;
    }

    public boolean isValidField(char row, byte column) {
        char lastRow = (char)(FIRST_ROW + (NUMBER_OF_ROWS - 1));
        if (row >= FIRST_ROW && row <= lastRow && column > 0 && column <= NUMBER_OF_COLUMNS) {
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
            int r = this.row - FIRST_ROW;
            int c = this.column - FIRST_COLUMN;
            Chessboard.this.fields[r][c].take();
            this.row = 0;
            this.column = -1;
        }

        public int getRowIndex(char row) {
            return row - FIRST_ROW;
        }

        public int getColIndex(byte column) {
            return column - FIRST_COLUMN;
        }

        public abstract void markReachableFields();
        public abstract void unmarkReachableFields();
    }

    /**
     * Pawn class
     */
    public class Pawn extends Chesspiece {
        public Pawn(char color) {
            super(color, 'P');
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

    /**
     * Rook/Tower class
     */
    public class Rook extends Chesspiece {
        public Rook(char color) {
            super(color, 'R');
        }

        public void markReachableFields() {
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;

            for (Field[] row : Chessboard.this.fields) {
                row[c].mark();
            }

            for (Field column : Chessboard.this.fields[r]) {
                column.mark();
            }
        }

        public void unmarkReachableFields() {
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;

            for (Field[] row : Chessboard.this.fields) {
                row[c].unmark();
            }

            for (Field column : Chessboard.this.fields[r]) {
                column.unmark();
            }
        }
    }

    public class Tuple {
        public final char x;
        public final byte y;
        public Tuple(char x, byte y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Knight class
     */
    public class Knight extends Chesspiece {
        public Knight(char color) {
            super(color, 'N');
        }

        private Tuple[] getReachableCoords() {
            char rTemp;
            Tuple[] coords = new Tuple[8];

            rTemp = (char)(this.row + 2);
            coords[0] = new Tuple(rTemp, (byte)(this.column - 1));
            coords[1] = new Tuple(rTemp, (byte)(this.column + 1));

            rTemp = (char)(this.row + 1);
            coords[2] = new Tuple(rTemp, (byte)(this.column - 2));
            coords[3] = new Tuple(rTemp, (byte)(this.column + 2));

            rTemp = (char)(this.row - 1);
            coords[4] = new Tuple(rTemp, (byte)(this.column - 2));
            coords[5] = new Tuple(rTemp, (byte)(this.column + 2));

            rTemp = (char)(this.row - 2);
            coords[6] = new Tuple(rTemp, (byte)(this.column - 1));
            coords[7] = new Tuple(rTemp, (byte)(this.column + 1));

            return coords;
        }

        public void markReachableFields() {
            Tuple[] coords = getReachableCoords();

            for (Tuple coord : coords) {
                if (Chessboard.this.isValidField(coord.x, coord.y)) {
                    Chessboard.this.fields[getRowIndex(coord.x)][getColIndex(coord.y)].mark();
                }
            }
        }

        public void unmarkReachableFields() {
            Tuple[] coords = getReachableCoords();

            for (Tuple coord : coords) {
                if (Chessboard.this.isValidField(coord.x, coord.y)) {
                    Chessboard.this.fields[getRowIndex(coord.x)][getColIndex(coord.y)].unmark();
                }
            }
        }
    }

    /**
     * Bishop class
     */
    public class Bishop extends Chesspiece {
        public Bishop(char color) {
            super(color, 'B');
        }

        private ArrayList<Tuple> getReachableCoords() {
            ArrayList<Tuple> coords = new ArrayList<Tuple>();

            for (int i = 1; i <= NUMBER_OF_COLUMNS; i++) {
                coords.add(new Tuple((char)(this.row + i), (byte)(this.column + i)));
                coords.add(new Tuple((char)(this.row - i), (byte)(this.column + i)));
            }

            for (int i = 1; i <= NUMBER_OF_COLUMNS; i++) {
                coords.add(new Tuple((char)(this.row - i), (byte)(this.column - i)));
                coords.add(new Tuple((char)(this.row + i), (byte)(this.column - i)));
            }

            return coords;
        }

        public void markReachableFields() {
            ArrayList<Tuple> coords = getReachableCoords();

            for (Tuple coord : coords) {
                if (Chessboard.this.isValidField(coord.x, coord.y)) {
                    Chessboard.this.fields[getRowIndex(coord.x)][getColIndex(coord.y)].mark();
                }
            }
        }

        public void unmarkReachableFields() {
            ArrayList<Tuple> coords = getReachableCoords();

            for (Tuple coord : coords) {
                if (Chessboard.this.isValidField(coord.x, coord.y)) {
                    Chessboard.this.fields[getRowIndex(coord.x)][getColIndex(coord.y)].unmark();
                }
            }
        }
    }

    /**
     * Queen class
     */
    public class Queen extends Chesspiece {
        public Queen(char color) {
            super(color, 'Q');
        }

        private ArrayList<Tuple> getReachableCoords() {
            ArrayList<Tuple> coords = new ArrayList<Tuple>();

            for (int i = 1; i <= NUMBER_OF_COLUMNS; i++) {
                coords.add(new Tuple((char)(this.row + i), (byte)(this.column + i)));
                coords.add(new Tuple((char)(this.row - i), (byte)(this.column + i)));
            }

            for (int i = 1; i <= NUMBER_OF_COLUMNS; i++) {
                coords.add(new Tuple((char)(this.row - i), (byte)(this.column - i)));
                coords.add(new Tuple((char)(this.row + i), (byte)(this.column - i)));
            }

            return coords;
        }

        public void markReachableFields() {
            ArrayList<Tuple> coords = getReachableCoords();

            for (Tuple coord : coords) {
                if (Chessboard.this.isValidField(coord.x, coord.y)) {
                    Chessboard.this.fields[getRowIndex(coord.x)][getColIndex(coord.y)].mark();
                }
            }

            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;

            for (Field[] row : Chessboard.this.fields) {
                row[c].mark();
            }

            for (Field column : Chessboard.this.fields[r]) {
                column.mark();
            }
        }

        public void unmarkReachableFields() {
            ArrayList<Tuple> coords = getReachableCoords();

            for (Tuple coord : coords) {
                if (Chessboard.this.isValidField(coord.x, coord.y)) {
                    Chessboard.this.fields[getRowIndex(coord.x)][getColIndex(coord.y)].unmark();
                }
            }

            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;

            for (Field[] row : Chessboard.this.fields) {
                row[c].unmark();
            }

            for (Field column : Chessboard.this.fields[r]) {
                column.unmark();
            }
        }
    }

    /**
     * King class
     */
    public class King extends Chesspiece {
        public King(char color) {
            super(color, 'K');
        }

        private Tuple[] getReachableCoords() {
            Tuple[] coords = new Tuple[4];
            coords[0] = new Tuple(this.row, (byte)(this.column - 1));
            coords[1] = new Tuple(this.row, (byte)(this.column + 1));
            coords[2] = new Tuple((char)(this.row + 1), this.column);
            coords[3] = new Tuple((char)(this.row - 1), this.column);
            return coords;
        }

        public void markReachableFields() {
            Tuple[] coords = getReachableCoords();

            for (Tuple coord : coords) {
                if (Chessboard.this.isValidField(coord.x, coord.y)) {
                    Chessboard.this.fields[getRowIndex(coord.x)][getColIndex(coord.y)].mark();
                }
            }
        }

        public void unmarkReachableFields() {
            Tuple[] coords = getReachableCoords();

            for (Tuple coord : coords) {
                if (Chessboard.this.isValidField(coord.x, coord.y)) {
                    Chessboard.this.fields[getRowIndex(coord.x)][getColIndex(coord.y)].unmark();
                }
            }
        }
    }
}
