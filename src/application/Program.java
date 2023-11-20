package application;


import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();
        while (!chessMatch.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Origem: ");
                ChessPosition source = UI.readChessPosition(scanner);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(),possibleMoves);
                System.out.println();
                System.out.print("Destino: ");
                ChessPosition target = UI.readChessPosition(scanner);

                ChessPiece capturedPiece = chessMatch.performChessMove(source,target);

                if(capturedPiece != null) {
                    captured.add(capturedPiece);
                }

                if(chessMatch.getPromoted() != null) {
                    System.out.println("Entre com o tipo da peça a ser promovida (B/N/R/Q): ");
                    String type = scanner.next().toUpperCase();
                    scanner.nextLine();
                    while(!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
                        System.out.println("Peça inválida! Entre com o tipo da peça a ser promovida (B/N/R/Q): ");
                        type = scanner.next().toUpperCase();
                        scanner.nextLine();
                    }
                    chessMatch.replacePromotedPiece(type);
                }
            }
            catch (ChessException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
            finally {
                if(scanner != null){
                    scanner.close();
                }
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
