package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.ChessMatch;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch; 
    }



    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        moveUp(mat, p);

        moveLeft(mat, p);

        moveRight(mat, p);

        moveDown(mat, p);

        // Movimento para o noroeste
        moveNW(mat, p);

        // Movimento para o nordeste
        moveNe(mat, p);

        // Movimento para o sudoeste
        moveSW(mat, p);

        // Movimento para o sudeste
        moveSe(mat, p);

        specialCastlingKingside(mat);

        specialCastlingQueenside(mat);

        return mat;
    }

    public void moveUp(boolean[][] mat, Position p) {
       p.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExists(p) && isValidMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    public void moveLeft(boolean[][] mat, Position p) {
            p.setValues(position.getRow(), position.getColumn() - 1);
        if(getBoard().positionExists(p) && isValidMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    public void moveRight(boolean[][] mat, Position p) {
        p.setValues(position.getRow(), position.getColumn() + 1);
        if(getBoard().positionExists(p) && isValidMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    public void moveDown(boolean[][] mat, Position p) {
        p.setValues(position.getRow() + 1, position.getColumn());
        if(getBoard().positionExists(p) && isValidMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    public void moveNW(boolean[][] mat, Position p) {
        p.setValues(position.getRow() - 1, position.getColumn() -1);
        if(getBoard().positionExists(p) && isValidMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    public void moveNe(boolean[][] mat, Position p) {
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().positionExists(p) && isValidMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    public void moveSW(boolean[][] mat, Position p) {
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().positionExists(p) && isValidMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    public void moveSe(boolean[][] mat, Position p) {
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if(getBoard().positionExists(p) && isValidMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    public boolean isValidMove(Position position){
        ChessPiece p  =  (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private void specialCastlingKingside(boolean[][] mat){
        if(getMoveCount() == 0 && !chessMatch.getCheck()) {

            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);

            if(testRookCastling(posT1)){
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
            }
        }

    }

    private void specialCastlingQueenside(boolean[][] mat){
        if(getMoveCount() == 0 && !chessMatch.getCheck()) {

            Position posT1 = new Position(position.getRow(), position.getColumn() - 4);

            if(testRookCastling(posT1)){
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);

				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
            }
        }

    }

    private boolean testRookCastling(Position position) {
        ChessPiece p  =  (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public String toString() {
        return "K";
    }

}
