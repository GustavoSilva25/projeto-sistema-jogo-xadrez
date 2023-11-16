package chess.Pieces;
import boardgame.Position;
import boardgame.Board;
import boardgame.Piece;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // above
        moveUp(mat, p);
        // left
        moveLeft(mat, p);
        // right
        moveRight(mat, p);
        // below
        moveDown(mat, p);

        return mat;
    }

    private void moveUp(boolean[][] mat, Position p) {
        p.setValues(position.getRow() - 1, position.getColumn());
        while (isValidMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (getBoard().thereIsAPiece(p) && isThereOpponentPiece(p)) {
                break;
            }
            p.setRow(p.getRow() - 1);
        }
    }

    private void moveLeft(boolean[][] mat, Position p) {
        p.setValues(position.getRow(), position.getColumn() - 1);
        while (isValidMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (getBoard().thereIsAPiece(p) && isThereOpponentPiece(p)) {
                break; 
            }
            p.setColumn(p.getColumn() - 1);
        }
    }

    private void moveRight(boolean[][] mat, Position p) {
        p.setValues(position.getRow(), position.getColumn() + 1);
        while (isValidMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (getBoard().thereIsAPiece(p) && isThereOpponentPiece(p)) {
                break;
            }
            p.setColumn(p.getColumn() + 1);
        }
    }

    private void moveDown(boolean[][] mat, Position p) {
        p.setValues(position.getRow() + 1, position.getColumn());
        while (isValidMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (getBoard().thereIsAPiece(p) && isThereOpponentPiece(p)) {
                break; 
            }
            p.setRow(p.getRow() + 1);
        }
    }

    private boolean isValidMove(Position p) {
        return getBoard().positionExists(p) && 
            ( !getBoard().thereIsAPiece(p) || isThereOpponentPiece(p) );
    }

    protected boolean isThereOpponentPiece(Position p) {
        Piece piece = getBoard().piece(p);
        return piece != null && ((ChessPiece) piece).getColor() != getColor();
    }

    @Override
    public String toString() {
        return "R";
    }
}
