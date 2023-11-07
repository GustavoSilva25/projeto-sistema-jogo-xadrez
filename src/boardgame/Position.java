package boardgame;

public class Position {
    private Integer row;
    private Integer column;

    public Position(){
    }

    public Position(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public void setRows(Integer rows) {
        this.row = rows;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public void setValue(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

}
