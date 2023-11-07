package boardgame;

public class Board {
    private int rows;
    private int columns;

    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Erro ao criar o tabuleiro: é necessário que haja uma linha e uma coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if(!isValidPosition(row,column)) {
            throw new BoardException("Posição fora dos limites do tabuleiro");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição fora dos limites do tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)) {
            throw new BoardException("já existe uma peça na posição");
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.positon = position;
    }

    public boolean isValidPosition(int row , int column) {
        return  row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position){
        return isValidPosition(position.getRow(),position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if(!positionExists(position)){
            throw new BoardException("Posição fora dos limites do tabuleiro");
        }
        return piece(position) != null;
    }




}
