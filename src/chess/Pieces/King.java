package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }



    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        // above
        moveUp(mat, p);
        // left
        moveLeft(mat, p);
        // right
        moveRight(mat, p);
        // below
        moveDown(mat, p);
        //Northwest
        moveNW(mat,p);
        //Northeeast
        moveNe(mat,p);
        //Southwest
        moveSW(mat,p);
        //Southeast
        moveSe(mat,p);

        return mat;
    }

    public void moveUp(boolean[][] mat, Position p) {
        p.setValues(position.getRow() -1, position.getColumn());
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

    @Override
    public String toString() {
        return "K";
    }

}
