package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.ChessMatch;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }


    /**
    * Retorna uma matriz booleana representando os movimentos possíveis para a peça.
    * Cada posição da matriz indica se a peça pode se mover para aquela posição no tabuleiro.
    *
    * @return Matriz booleana de movimentos possíveis.
    */
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        // Verifica os movimentos possíveis para uma peça branca.
        if(getColor() == Color.WHITE){
            // Mover para frente de uma casa.
            p.setValues(position.getRow() - 1 , position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            // Movimento inicial de duas casas.
            p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

            // Movimento diagonal para capturar peça adversária.
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

            p.setValues(position.getRow() - 1 , position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            specialEnPassantWhite(mat);


        }
        // Verifica os movimentos possíveis para uma peça preta.
        else {
            p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
            p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());

			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

           p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
            			
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

            specialEnPassantBlack(mat);
        }

        return mat;
    }

    public void specialEnPassantWhite(boolean[][] mat) {
        if (position.getRow() == 3) {
            Position left = new Position(position.getRow(), position.getColumn() - 1);
            if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                mat[left.getRow() - 1][left.getColumn()] = true;
            }
            Position right = new Position(position.getRow(), position.getColumn() + 1);
            if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                mat[right.getRow() - 1][right.getColumn()] = true;
            }
        }
    }

    public void specialEnPassantBlack(boolean[][] mat) {
        if (position.getRow() == 4) {
            Position left = new Position(position.getRow(), position.getColumn() - 1);
            if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                mat[left.getRow() + 1][left.getColumn()] = true;
            }
            Position right = new Position(position.getRow(), position.getColumn() + 1);
            if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                mat[right.getRow() + 1][right.getColumn()] = true;
            }
        }
    }

    @Override
    public String toString() {
        return "P";
    }
}
