package application;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    //https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println


    //reverter as configurações de cor ao padrão.
    public static final String ANSI_RESET = "\u001B[0m";

    //representa a cor branca.
    public static final String ANSI_WHITE = "\u001B[37m";

    // representa a cor preta.
    public static final String ANSI_BLACK = "\u001B[30m";

    // representa a cor de fundo.
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static ChessPosition readChessPosition(Scanner scanner){
        try {
            String s = scanner.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column,row);
        }
        catch (RuntimeException r){
            throw new InputMismatchException("Erro lendo posição do xadrez. Valores válidos são de a1 a h8");
        }
    }

    public static void printBoard(ChessPiece[][] pieces) {
        for(int i=0; i< pieces.length; i++){
            System.out.print((8 - i) + " ");
            for(int j=0; j< pieces.length; j++){
                printPiece(pieces[i][j],false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    // Imprime o tabuleiro de xadrez, destacando os movimentos possíveis.
    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for(int i=0; i< pieces.length; i++){
            System.out.print((8 - i) + " ");
            for(int j=0; j< pieces.length; j++){
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    public static void printPiece(ChessPiece piece, boolean background) {
        if(background){
            System.out.print(GREEN_BACKGROUND_BRIGHT);
        }
        if (piece == null) {
            System.out.print("-" + ANSI_RESET);// Representa um espaço vazio no tabuleiro.
        } else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_BLACK + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

}
