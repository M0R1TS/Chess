package DZ;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (line != toLine && column != toColumn && (chessBoard.board[toLine][toColumn] == null ||
                    !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                    chessBoard.board[line][column] != null) {
                if (!chessBoard.board[line][column].equals(this)) {
                    return false;
                }

                // all positions for horse
                int[][] positions = new int[][]{
                        {line - 2, column - 1}, {line - 2, column + 1},
                        {line + 2, column - 1}, {line + 2, column + 1},
                        {line - 1, column - 2}, {line - 1, column + 2},
                        {line + 1, column - 2}, {line + 1, column + 2}};

                for (int i = 0; i < positions.length; i++) {
                    if (positions[i][0] == toLine && positions[i][1] == toColumn)
                        return true;
                }
            }
        } else return false;
        return false;
    }

    public boolean checkPosition(int position) {
        if (position >= 0 && position <= 7) return true;
        else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}