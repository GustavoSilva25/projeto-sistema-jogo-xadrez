package chess.Pieces;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        moveNW(mat, p);
   
        moveNE(mat, p);
   
        moveSE(mat, p);

        moveSW(mat, p);

        return mat;
    }

    private void moveNW(boolean[][] mat, Position p) {
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        while (isValidMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (getBoard().thereIsAPiece(p) && isThereOpponentPiece(p)) {
                break;
            }
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
    }


    private void moveNE(boolean[][] mat, Position p) {
        p.setValues(position.getRow() -1, position.getColumn() + 1);
        while (isValidMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (getBoard().thereIsAPiece(p) && isThereOpponentPiece(p)) {
                break; 
            }
            p.setValues(p.getRow() - 1, p.getColumn() + 1); 
        }
    }

    private void moveSE(boolean[][] mat, Position p) {
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (isValidMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (getBoard().thereIsAPiece(p) && isThereOpponentPiece(p)) {
                break;
            }
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }
    }

    private void moveSW(boolean[][] mat, Position p) {
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        while (isValidMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (getBoard().thereIsAPiece(p) && isThereOpponentPiece(p)) {
                break; 
            }
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
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
        return "B";
    }

}
