package chess.Pieces;
import boardgame.Position;
import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        checkPossibleMovesInDirection(mat, -1, 0); // above
        checkPossibleMovesInDirection(mat, 0, -1); // left
        checkPossibleMovesInDirection(mat, 0, 1);  // right
        checkPossibleMovesInDirection(mat, 1, 0);  // below

        return mat;
    }

    private void checkPossibleMovesInDirection(boolean[][] mat, int rowChange, int colChange) {
        Position p = new Position(position.getRow() + rowChange, position.getColumn() + colChange);

        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + rowChange, p.getColumn() + colChange);
        }

        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    @Override
    public String toString() {
        return "R";
    }
}
