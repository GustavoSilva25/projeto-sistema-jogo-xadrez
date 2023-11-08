package application;


import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        while (true) {
            UI.printBoard(chessMatch.getPiece());
            System.out.println();
            System.out.print("Origem: ");
            ChessPosition source = UI.readChessPosition(scanner);

            System.out.println();
            System.out.print("Destino: ");
            ChessPosition target = UI.readChessPosition(scanner);

            ChessPiece capturedPiece = chessMatch.performChessMove(source,target);

        }
    }

}
