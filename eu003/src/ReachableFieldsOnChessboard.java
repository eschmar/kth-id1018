/**
 * Created by eschmar on 18/11/15.
 */
public class ReachableFieldsOnChessboard {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        System.out.println(chessboard + "\n");

        Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
        pieces[0] = chessboard.new Pawn('w');
        pieces[1] = chessboard.new Rook('b');
        pieces[2] = chessboard.new Queen('w');
        pieces[3] = chessboard.new Bishop('w');
        pieces[4] = chessboard.new King('b');
        pieces[5] = chessboard.new Knight('w');

        chessboard.presentPieces(pieces);
    }
}
