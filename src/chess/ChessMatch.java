package chess;

import boardgame.Board;
import boardgame.Position;
import chess.Pieces.King;
import chess.Pieces.Pawn;
import chess.Pieces.Queen;
import chess.Pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
    }

    public  ChessPiece[][] getPiece() {
        ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i=0; i< board.getRows(); i++){
            for(int j=0; j< board.getColumns(); j++){
                matrix[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return matrix;
    }
    private void setPieceAtPosition(char column, int row, ChessPiece piece){
        board.placePiece(piece,new ChessPosition(column,row).toPosition());
    }

    private void initialSetup() {
        setPieceAtPosition('c', 2, new Rook(board, Color.WHITE));
        setPieceAtPosition('d', 2, new Queen(board, Color.WHITE));
        setPieceAtPosition('e', 2, new Rook(board, Color.WHITE));
        setPieceAtPosition('e', 1, new Pawn(board, Color.WHITE));
        setPieceAtPosition('d', 1, new King(board, Color.WHITE));

        setPieceAtPosition('c', 7, new Rook(board, Color.BLACK));
        setPieceAtPosition('c', 8, new Pawn(board, Color.BLACK));
        setPieceAtPosition('d', 7, new Queen(board, Color.BLACK));
        setPieceAtPosition('e', 7, new Rook(board, Color.BLACK));
        setPieceAtPosition('e', 8, new Pawn(board, Color.BLACK));
        setPieceAtPosition('d', 8, new King(board, Color.BLACK));
    }
}
