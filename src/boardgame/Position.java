package boardgame;

public class Position {
    private Integer rows;
    private Integer column;

    public Position(){
    }

    public Position(Integer row, Integer column) {
        this.rows = rows;
        this.column = column;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public void setValue(Integer row, Integer column) {
        this.rows = row;
        this.column = column;
    }

}
