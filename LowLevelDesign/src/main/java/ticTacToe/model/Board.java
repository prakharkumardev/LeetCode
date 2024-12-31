package ticTacToe.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private List<List<BoardCell>> boardCells;
    private int boardSize;
    public Board(int boardSize) {
        this.boardSize = boardSize;
        boardCells = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            List<BoardCell> row = new ArrayList<>();
            for (int j = 0; j < boardSize; j++) {
                row.add(BoardCell.builder().row(i).column(j).build());
            }
            boardCells.add(row);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<BoardCell> row : boardCells) {
            for (BoardCell cell : row) {
                sb.append(cell.getSymbol() == null ? " " : cell.getSymbol());
                sb.append(" | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
